package shopcoffee.controller;

import shopcoffee.model.Account;
import shopcoffee.service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/logins")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AccountService accountService = new AccountService();
        Account account = accountService.login(username,password);
        if (account == null) {
            req.setAttribute("check",account);
            req.setAttribute("message","Wrong user or pass");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        } else if(account.getLimitAccount() == 1){
            resp.sendRedirect("/products");
        } else {
            resp.sendRedirect("/customers");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
