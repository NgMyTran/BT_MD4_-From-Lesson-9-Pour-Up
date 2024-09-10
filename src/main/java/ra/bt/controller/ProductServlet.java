package ra.bt.controller;

import ra.bt.model.Product;
import ra.bt.service.category.CategoryService;
import ra.bt.service.category.ICategoryService;
import ra.bt.service.product.IProductService;
import ra.bt.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("products", productService.findAll());
                    request.getRequestDispatcher("/views_bt/product/list-product.jsp").forward(request, response);
                    break;

                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    productService.delete(idDel);
                    response.sendRedirect("/ProductServlet?action=GETALL");
                    break;

                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    Product product = productService.findById(idEdit);
                    if (product != null) {
                        request.setAttribute("product", product);
                        request.setAttribute("categories", categoryService.findAll());
                        request.getRequestDispatcher("/views_bt/product/edit-product.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("/ProductServlet?action=GETALL");
                    }
                    break;

                case "DETAIL":
                    Integer idDetail = Integer.valueOf(request.getParameter("id"));
                    Product productDetail = productService.findById(idDetail);
                    if (productDetail != null) {
                        request.setAttribute("pro", productDetail);
                        request.getRequestDispatcher("/views_bt/product/detail-product.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("/ProductServlet?action=GETALL");
                    }
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
                case "ADD":
                    Product newProduct = new Product(
                            0,
                            request.getParameter("name"),
                            Double.parseDouble(request.getParameter("price")),
                            Integer.parseInt(request.getParameter("stock")),
                            Boolean.parseBoolean(request.getParameter("status")),
                            categoryService.findById(Integer.parseInt(request.getParameter("categoryId")))
                    );
                    productService.save(newProduct);
                    response.sendRedirect("/ProductServlet?action=GETALL");
                    break;

                case "UPDATE":
                    Product updateProduct = new Product(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("name"),
                            Double.parseDouble(request.getParameter("price")),
                            Integer.parseInt(request.getParameter("stock")),
                            Boolean.parseBoolean(request.getParameter("status")),
                            categoryService.findById(Integer.parseInt(request.getParameter("categoryId")))
                    );
                    productService.save(updateProduct);
                    response.sendRedirect("/ProductServlet?action=GETALL");
                    break;
            }
        }
    }
}
