package shopcoffee.controller;

import shopcoffee.model.Product;
import shopcoffee.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig()
@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService;

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        productService =new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
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
                deleteProduct(request,response);
                break;
            case "home":
                homeProduct(request,response);
                break;
            case "search":
                searchName(request, response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void homeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.selectAll();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(request,response);
    }

//    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> productList = productService.selectAll();
//        request.setAttribute("productList",productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/list.jsp");
//        dispatcher.forward(request,response);
//    }
//    Phân trang
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = productService.getTotalProduct();
        int endPage = count/3;
        if (count % 3 != 0){
            endPage ++;
        }
        request.setAttribute("endPage", endPage) ;

        String indexPage = request.getParameter("index");
        if (indexPage == null){
            indexPage ="1";
        }
        int index = Integer.parseInt(indexPage);
        List<Product> productList = productService.pageProduct(index);
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/list.jsp");
        dispatcher.forward(request,response);
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        listProduct(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.selectById(id);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/product/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/create.jsp");
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
                insertProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "search":
                searchName(request, response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchName");

        int count =productService.getCountProductSearch(name);
        int endPage = count/3;
        if (count % 3 != 0){
            endPage ++;
        }
        request.setAttribute("endPage", endPage);
        request.setAttribute("search",name);

        if (name.isEmpty()){
            listProduct(request,response);
        } else {
            String indexPage = request.getParameter("index");
            if (indexPage == null){
                indexPage ="1";
            }
            int index = Integer.parseInt(indexPage);
            List<Product> productList = productService.pageProductSearch(index,name);

            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/search.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        //        Upload file
        Part part =request.getPart("image");
        String realPath = request.getServletContext().getRealPath("/image");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write("C:\\codegym\\Case Study Module 3\\CaseStudyModule_ShopCoffee\\Coffee_Shop\\src\\main\\webapp\\assets\\image\\" + filename);
        String image = "/assets/image/" + filename;

        Product product = new Product(idProduct,nameProduct,price,amount,image);

        // Check err
        List<String> err = new ArrayList<>();
        if(price < 0) {
            err.add("price greater than zero");
        }
        if (amount < 0) {
            err.add("Amount greater than zero");
        }
        if(!err.isEmpty()) {
            request.setAttribute("err",err);
            request.setAttribute("product",product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/product/edit.jsp");
            requestDispatcher.forward(request, response);
        } else {
            productService.update(product);
            String message = "successful update";
            request.setAttribute("message",message);
            request.setAttribute("product",product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/product/edit.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProduct = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));

//        Upload file
        Part part =request.getPart("image");
        String realPath = request.getServletContext().getRealPath("/image");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write("C:\\codegym\\Case Study Module 3\\CaseStudyModule_ShopCoffee\\Coffee_Shop\\src\\main\\webapp\\assets\\image\\" + filename);
        String image = "/assets/image/" + filename;

        Product product = new Product(nameProduct,price,amount,image);

        // Check err
        List<String> err = new ArrayList<>();
        if(price < 0) {
            err.add("Price greater than zero");
        }
        if (amount < 0) {
            err.add("Amount greater than zero");
        }
        if(!err.isEmpty()) {
            request.setAttribute("err", err);
            request.setAttribute("product", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/product/create.jsp");
            requestDispatcher.forward(request, response);
        }else {
            productService.insert(product);
            String message = "Successful Create";
            request.setAttribute("message",message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/product/create.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
