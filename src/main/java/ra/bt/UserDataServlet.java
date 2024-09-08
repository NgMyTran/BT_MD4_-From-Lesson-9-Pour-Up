package ra.bt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData(1, "Tuấn", "huanrose@gmail.com", 18);
        // Đặt UserData vào request object
        resp.setContentType("text/html;charset=UTF-8");

        // PrintWriter để in ra HTML
        PrintWriter out = resp.getWriter();

        // In ra nội dung HTML
        out.println("<html>" +
        "<head><title>User Data</title></head>"+
        "<body>"+
        "<div style='border: 1px solid black; padding: 10px; width: 300px;'>"+
        "<h2>User Data</h2>"+
        "<p><strong>ID:</strong> " + userData.getId() + "</p>"+
        "<p><strong>Name:</strong> " + userData.getName() + "</p>"+
        "<p><strong>Email:</strong> " + userData.getEmail() + "</p>"+
        "<p><strong>Age:</strong> " + userData.getAge() + "</p>"+
        "</div>"+
        "</body>"+
        "</html>");
    }
}
