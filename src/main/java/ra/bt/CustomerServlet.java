package ra.bt;

import ra.jsp.Todo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList = new ArrayList<>();
  static {
      customerList.add(new Customer(1, "Mai Văn Hoàn", LocalDate.of(1983, 8, 20), "Hà Nội", "https://placehold.co/50x50?text=👤"));
      customerList.add(new Customer(2, "Nguyễn Văn Nam", LocalDate.of(1983, 8, 21), "Bắc Giang", "https://placehold.co/50x50?text=👤"));
      customerList.add(new Customer(3, "Nguyễn Thái Hòa", LocalDate.of(1983, 8, 22), "Nam Định", "https://placehold.co/50x50?text=👤"));
      customerList.add(new Customer(4, "Trần Đăng Khoa", LocalDate.of(1983, 8, 17), "Hà Tây", "https://placehold.co/50x50?text=👤"));
      customerList.add(new Customer(5, "Nguyễn Đình Thi", LocalDate.of(1983, 8, 19), "Hà Nội", "https://placehold.co/50x50?text=👤"));
  }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("getCustomer")) {
            request.setAttribute("customers", customerList);
            request.getRequestDispatcher("/bt/bt1.jsp").forward(request, response);
        }
    }

}
