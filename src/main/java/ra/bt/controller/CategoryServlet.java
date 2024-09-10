package ra.bt.controller;

import ra.bt.model.Category;
import ra.bt.service.category.CategoryService;
import ra.bt.service.category.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    public ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("categories", categoryService.findAll());
                    request.getRequestDispatcher("/views_bt/category/list-category.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    Category categoryToDelete = categoryService.findById(idDel);

                    if (categoryToDelete != null && categoryService.hasProducts(categoryToDelete)) {
                        // Hiển thị thông báo cho người dùng
                        request.setAttribute("categoryToDelete", categoryToDelete);
                        request.getRequestDispatcher("/views_bt/category/confirm-delete.jsp").forward(request, response);
                    } else {
                        categoryService.delete(idDel);
                        response.sendRedirect("/CategoryServlet?action=GETALL");
                    }
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("category", categoryService.findById(idEdit));
                    request.getRequestDispatcher("/views_bt/category/edit-category.jsp").forward(request, response);
                    break;
                case "CONFIRMDELETE":
                    Integer idConfirmDelete = Integer.valueOf(request.getParameter("id"));
                    String confirm = request.getParameter("confirm");
                    if ("yes".equals(confirm)) {
                        Category categoryToDeleteConfirm = categoryService.findById(idConfirmDelete);
                        if (categoryToDeleteConfirm != null) {
                            // Đổi trạng thái của tất cả sản phẩm thuộc danh mục này thành false
                            categoryService.updateProductStatusForCategory(categoryToDeleteConfirm, false);
                            categoryService.delete(idConfirmDelete);
                        }
                    }
                    response.sendRedirect("/CategoryServlet?action=GETALL");
                    break;
            }
        }
    }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "ADD":
                        Category newCategory = new Category(
                                0,
                                request.getParameter("name"),
                               Boolean.parseBoolean( request.getParameter("status")));
                        categoryService.save(newCategory);
                        response.sendRedirect("/CategoryServlet?action=GETALL");
                        break;
                    case "UPDATE":
                        Category updateCategory = new Category(
                                Integer.parseInt(request.getParameter("id")),
                                request.getParameter("name"),
                                Boolean.parseBoolean( request.getParameter("status")));
                        categoryService.save(updateCategory);
                        response.sendRedirect("/CategoryServlet?action=GETALL");
                        break;
                }
            }
        }
}