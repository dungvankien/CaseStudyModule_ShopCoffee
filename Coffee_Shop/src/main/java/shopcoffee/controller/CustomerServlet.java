package shopcoffee.controller;

import shopcoffee.model.Customer;
import shopcoffee.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerServiceImpl customerService;

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
        }

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAll();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        List<Customer> customerList = customerService.selectAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/customer/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.selectById(id);
        request.setAttribute("customer",customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/customer/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "search":
                searchName(request, response);
                break;
        }
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchName");
        List<Customer> customerList = customerService.selectByCondition(name);
        if (customerList.isEmpty()){
            try {
                int id = Integer.parseInt(request.getParameter("searchName"));
                customerList = customerService.selectByConditionID(id);
            } catch (NumberFormatException numberFormatException){
                customerList = null;
            }
        }
        if (name.isEmpty()){
            listCustomer(request,response);
        } else {
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer/search.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        int id = Integer.parseInt(request.getParameter("id"));
        customer.setIdCustomer(id);
        String name = request.getParameter("name");
        customer.setNameCustomer(name);
        String email = request.getParameter("email");
        customer.setEmail(email);
        String phone = request.getParameter("phone");
        customer.setPhone(phone);
        String address = request.getParameter("address");
        customer.setAddress(address);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
        List<String> err = new ArrayList<>();
        if(customerService.checkPhoneEdit(id,phone)){
            err.add("The phone number has existed");
        }
        if (customerService.checkEmailEdit(id,email)){
            err.add("Email has existed");
        }
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<Customer> item : constraintViolations) {
                err.add(item.getMessage());
            }
        }
        if(!err.isEmpty()){
            request.setAttribute("err",err);
            request.setAttribute("customer",customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/customer/edit.jsp");
            requestDispatcher.forward(request, response);

        } else {
            request.setAttribute("successful","Successful!");
            customerService.update(customer);
            request.setAttribute("customer",customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/customer/edit.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        String nameCustomer = request.getParameter("name");
        customer.setNameCustomer(nameCustomer);
        String email = request.getParameter("email");
        customer.setEmail(email);
        String phone = request.getParameter("phone");
        customer.setPhone(phone);
        String address = request.getParameter("address");
        customer.setAddress(address);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        List<String> err = new ArrayList<>();
        if(customerService.checkEmail(email)){
            err.add("Email has existed");
        }
        if (customerService.checkPhone(phone)){
            err.add("The phone number has existed");
        }
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<Customer> item : constraintViolations) {
                err.add(item.getMessage());
            }
        }
        if (!err.isEmpty()){
            request.setAttribute("customer", customer);
            request.setAttribute("err",err);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("successful","Successful!");
            customerService.insert(customer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
