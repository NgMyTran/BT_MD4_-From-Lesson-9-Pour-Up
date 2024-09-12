package ra.mvc.controller;

import ra.mvc.model.Account;
import ra.mvc.service.account.AccountServiceImpl;
import ra.mvc.service.account.IAccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private IAccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action!=null){
            switch (action){
                case "LOGIN":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    try {
                        Account account = accountService.login(username, password);
                        request.setAttribute("user", account);
                        request.getRequestDispatcher("/views/account/home.jsp").forward(request, response);
                    }catch (Exception e){
                        request.setAttribute("error", e.getMessage());
                        request.getRequestDispatcher("/views/account/login.jsp").forward(request, response);
                    }
                    break;
                    case "SEND":
                        int idReceiver = Integer.parseInt(request.getParameter("idReceiver"));
                        int amount = Integer.parseInt(request.getParameter("amount"));
                        try {
                            accountService.sendMoney(idReceiver, amount);
                            request.setAttribute("user",accountService.getUserLogin());
                            request.setAttribute("success", true);
                            request.getRequestDispatcher("/views/account/home.jsp").forward(request, response);
                        }catch (Exception e){
                            request.setAttribute("error", "Số dư không đủ");
                            request.getRequestDispatcher("/views/account/sendMoney.jsp").forward(request, response);
                        }

            }
        }
    }
}