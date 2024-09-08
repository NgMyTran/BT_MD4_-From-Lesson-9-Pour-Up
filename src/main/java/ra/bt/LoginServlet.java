package ra.bt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String USERNAME = "admin";
    private final String PASSWORD = "12345";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // So sánh username và password với dữ liệu fake
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            out.println("<html>"+
           "<head><title>Login Success</title></head>"+
           "<body>"+
           "<h2>Đăng nhập thành công!</h2>"+
           "</body>"+
           "</html>");
        } else {
            // Nếu sai, hiển thị thông báo lỗi và giữ người dùng lại trang đăng nhập
            out.println("<html>"+
            "<head><title>Login Failed</title></head>"+
            "<body>"+
            "<h2>Tài khoản hoặc mật khẩu không chính xác!</h2>"+
            "<a href='login.html'>Thử lại</a>"+
            "</body>"+
            "</html>");
        }
    }
}

