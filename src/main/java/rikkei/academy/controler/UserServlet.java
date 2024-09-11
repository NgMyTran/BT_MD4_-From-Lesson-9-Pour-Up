//package rikkei.academy.controler;
//import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
//
//import rikkei.academy.model.User;
//import rikkei.academy.service.user.IUserService;
//import rikkei.academy.service.user.UserServiceIMPL;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(name = "UserServlet", value = "/UserServlet")
//public class UserServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private IUserService userService;
//
//
//    public void init() {
//        userService = new UserServiceIMPL();
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        String action = request.getParameter("action");
//
//        String searchCountry = request.getParameter("searchCountry"); // Khai báo biến searchCountry
//        String sortOrder = request.getParameter("sortOrder");
//        if (action == null) {
//            action = "";
//        }
//
//        try {
//            switch (action) {
//                case "create":
//                    showNewForm(request, response);
//                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
//                default:
//                    listUser(request, response, searchCountry, sortOrder);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    insertUser(request, response);
//                    break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//    }
//
//    private void listUser(HttpServletRequest request, HttpServletResponse response, String searchCountry, String sortOrder)
//            throws SQLException, IOException, ServletException {
//        List<User> listUser;
//
//        if (searchCountry != null && !searchCountry.isEmpty()) {
//            listUser = userService.searchByCountry(searchCountry);
//        } else {
//            if ("nameAsc".equals(sortOrder)) {
//                listUser = userService.selectAllSortedByName(true); // true for ascending
//            } else if ("nameDesc".equals(sortOrder)) {
//                listUser = userService.selectAllSortedByName(false); // false for descending
//            } else {
//                listUser = userService.selectAll(); // Default sort order
//            }
//        }
//
//        request.setAttribute("listUser", listUser);
//        request.setAttribute("searchCountry", searchCountry); // Để hiển thị giá trị tìm kiếm trong JSP
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userService.select(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
//    }
//
//    private void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(0,name, email, country);
//        userService.insert(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        User book = new User(id, name, email, country);
//        userService.update(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
//        dispatcher.forward(request, response);
//    }
//
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userService.delete(id);
//        List<User> listUser = userService.selectAll();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
//    }
//}


package rikkei.academy.controler;

import rikkei.academy.model.User;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService;

    @Override
    public void init() {
        userService = new UserServiceIMPL();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        String searchCountry = request.getParameter("searchCountry");
        String sortOrder = request.getParameter("sortOrder");

        if (action != null) {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    try {
                        showEditForm(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "delete":
                    try {
                        deleteUser(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    try {
                        listUser(request, response, searchCountry, sortOrder);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    try {
                        insertUser(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "edit":
                    try {
                        updateUser(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response, String searchCountry, String sortOrder)
            throws SQLException, IOException, ServletException {
        List<User> listUser;

        if (searchCountry != null && !searchCountry.isEmpty()) {
            listUser = userService.searchByCountry(searchCountry);
        } else {
            if ("nameAsc".equals(sortOrder)) {
                listUser = userService.selectAllSortedByName(true); // true for ascending
            } else if ("nameDesc".equals(sortOrder)) {
                listUser = userService.selectAllSortedByName(false); // false for descending
            } else {
                listUser = userService.selectAll(); // Default sort order
            }
        }

        request.setAttribute("listUser", listUser);
        request.setAttribute("searchCountry", searchCountry); // Để hiển thị giá trị tìm kiếm trong JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userService.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(0, name, email, country);
        userService.insert(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User updatedUser = new User(id, name, email, country);
        userService.update(updatedUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        List<User> listUser = userService.selectAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
}
