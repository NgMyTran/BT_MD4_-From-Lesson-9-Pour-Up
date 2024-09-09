package ra.bt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");
        double result = 0;
        String operation = "";
        switch (operator) {
            case "addition":
                result = firstOperand + secondOperand;
                operation = "Addition";
                break;
            case "subtraction":
                result = firstOperand - secondOperand;
                operation = "Subtraction";
                break;
            case "multiplication":
                result = firstOperand * secondOperand;
                operation = "Multiplication";
                break;
            case "division":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    operation = "Division";
                } else {
                    request.setAttribute("error", "Once of them is zero");
                    request.getRequestDispatcher("/bt/bt2.jsp").forward(request, response);
                    return;
                }
                break;
        }
        request.setAttribute("result", result);
        request.setAttribute("operation", operation);
        request.getRequestDispatcher("/bt/resultBt2.jsp").forward(request, response);
    }
}