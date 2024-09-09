package ra.bt;

import ra.jsp.Todo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 5,  // 5 MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class ProductServlet extends HttpServlet {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bim bim", "https://placehold.co/50x50.png?text=Lay%27s", 1200, 12));
        productList.add(new Product(2, "Coca cola", "https://placehold.co/50x50.png?text=Coca+Cola", 1500, 5));
        productList.add(new Product(3, "Khoai tây", "https://placehold.co/50x50.png?text=Potato", 2000, 9));
    }

    protected int getNewId() {
        int idMax = productList.stream()
                .mapToInt(Product::getId)
                .max()
                .orElse(0);
        return idMax + 1;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "getProducts":
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("/bt/bt3GetProducts.jsp").forward(request, response);
                    break;
                case "addProduct":
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("/bt/bt4AddProduct.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "addProduct":
                    int id = getNewId();
                    String name = request.getParameter("name");

//                    file upload
                    Part filePart = request.getPart("image");
                    String image = "";
                    if (filePart != null && filePart.getSize() > 0) {
                        String uploadPath = getServletContext().getRealPath("/uploads");
                        File uploadFolder = new File(uploadPath);
                        if (!uploadFolder.exists()) {
                            uploadFolder.mkdirs();
                        }

                        String fileName = new Date().getTime() + "_" + filePart.getSubmittedFileName();
                        filePart.write(uploadPath + File.separator + fileName);
                        image = "/uploads/" + fileName;
                    }

                    float price = 0;
                    String priceParam = request.getParameter("price");
                    if (priceParam != null && !priceParam.isEmpty()) {
                        price = Float.parseFloat(priceParam);
                    }
                    int stock = 0;
                    String stockParam = request.getParameter("stock");
                    if (stockParam != null && !stockParam.isEmpty()) {
                        stock = Integer.parseInt(stockParam);
                    }
                    System.out.println("Name: " + name);
                    System.out.println("Image Path: " + image);
                    System.out.println("Price: " + price);
                    System.out.println("Stock: " + stock);
                    productList.add(new Product(id, name, image, price, stock));

                    // Chuyển hướng đến trang danh sách sp sau khi thêm
                    response.sendRedirect("/ProductServlet?action=getProducts");
                    break;
            }
        }
    }
}