package ra.controller;

import ra.model.Book;
import ra.model.Category;
import ra.service.book.BookServiceImpl;
import ra.service.book.IBookService;
import ra.service.category.CategoryServiceImpl;
import ra.service.category.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet{
 private ICategoryService categoryService;

    @Override
    public void init() throws ServletException {
        categoryService = new CategoryServiceImpl();
    }

    private IBookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("categories", categoryService.findAll());
                    request.getRequestDispatcher("/views/category.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
//                    System.out.println("Attempting to delete category with ID: " + idDel);
//                    // Tìm các sách thuộc danh mục
//                    List<Book> books = bookService.findByCategoryId(idDel);
//                    System.out.println("Books found for category ID " + idDel + ": " + books.size());
//                    if (books.isEmpty()) {
//                        // Nếu không có sách, xóa danh mục ngay lập tức
//                        categoryService.delete(idDel);
//                        response.sendRedirect("/CategoryServlet?action=GETALL");
//                    } else {
//                        // Nếu có sách, cập nhật status sách trước khi xóa danh mục
//                        try {
//                            // Đặt trạng thái của tất cả các sách thành "Inactive"
//                            for (Book book : books) {
//                                book.setStatus(false);
//                                bookService.save(book);
//                            }
//                            // Sau khi cập nhật trạng thái sách, xóa danh mục
//                            categoryService.delete(idDel);
//                            response.sendRedirect("/CategoryServlet?action=GETALL");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            response.sendRedirect("/CategoryServlet?action=ERROR&message=An%20error%20occurred%20while%20deleting%20the%20category.");
//                        }
//                    }
//                    break;
                    categoryService.delete(idDel);
                    response.sendRedirect("/CategoryServlet?action=GETALL");
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("category", categoryService.findById(idEdit));
                    request.getRequestDispatcher("/views/edit-category.jsp").forward(request, response);
                    break;
                case "ADD":
                    request.getRequestDispatcher("/views/add-category.jsp").forward(request, response);
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
                    Category newCategory = new Category(
                            0,
                            request.getParameter("name"),
                            Boolean.parseBoolean(request.getParameter("status")));
                    categoryService.save(newCategory);
                    response.sendRedirect("/CategoryServlet?action=GETALL");
                    break;
                case "UPDATE":
                    Category updateCategory = new Category(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("name"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    categoryService.save(updateCategory);
                    response.sendRedirect("/CategoryServlet?action=GETALL");
                    break;
            }
        }
    }
}
