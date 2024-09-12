package rikkei.academy.controler;

import ra.mvc.configOrUtil.ConnectionDB;
import rikkei.academy.model.User;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMPL;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private IUserService userService;


    public void init() {
        userService = new UserServiceIMPL();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       Connection conn =ConnectionDB.getOpenConnection();
       String action=request.getParameter("action");
        if (action != null) {
            try {
                switch (action) {
                    case "create":
                        showNewForm(request,response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteUser(request, response);
                        break;
                    default:
                        listUser(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }finally {
                ConnectionDB.getClosedConnection(conn);
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn =ConnectionDB.getOpenConnection();
        String action=req.getParameter("action");
        if (action != null) {
            try {
                switch (action) {
                    case "create":
                        insertUser(req, resp);
                        break;
                    case "edit":
                        updateUser(req, resp);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }finally {
                ConnectionDB.getClosedConnection(conn);
            }
        }


    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userService.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("th_bt/list-user.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("th_bt/create-user.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userService.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit-user.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(0,name, email, country);
        userService.insert(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/th_bt/create-user.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userService.update(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit-user.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);

        List<User> listUser = userService.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list-user.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}