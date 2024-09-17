package ra.controller;

import ra.model.Book;
import ra.service.book.BookServiceImpl;
import ra.service.book.IBookService;
import ra.service.category.CategoryServiceImpl;
import ra.service.category.ICategoryService;

import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;

@WebServlet(value = "/BookServlet")
public class BookServlet extends HttpServlet {

private IBookService bookService=new BookServiceImpl();
    private ICategoryService categoryService= new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("books", bookService.findAll());
                    request.setAttribute("categories", categoryService.findAll());
                    request.getRequestDispatcher("/views/book.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    bookService.delete(idDel);
                    response.sendRedirect("/BookServlet?action=GETALL");
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("book", bookService.findById(idEdit));
                    request.getRequestDispatcher("/views/edit-book.jsp").forward(request, response);
                    break;
                case "ADD":
                    request.setAttribute("categories", categoryService.findAll());
                    request.getRequestDispatcher("/views/add-book.jsp").forward(request, response);
                    break;
                case "DETAIL":
                    Integer idDetail = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("book", bookService.findById(idDetail));
                    request.getRequestDispatcher("/views/detail-book.jsp").forward(request, response);
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
                    Book newBook = new Book(
                            0,
                            Integer.parseInt(request.getParameter("category_id")),
                            request.getParameter("name"),
                            Double.parseDouble(request.getParameter("price")),
                            Integer.parseInt(request.getParameter("stock")),
                            Integer.parseInt(request.getParameter("totalPages")),
                            Integer.parseInt(request.getParameter("yearCreated")),
                            request.getParameter("author"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    bookService.save(newBook);
                    response.sendRedirect("/BookServlet?action=GETALL");
                    break;
                case "UPDATE":
                    Book updateBook = new Book(
                            Integer.parseInt(request.getParameter("id")),
                            Integer.parseInt(request.getParameter("categoryId")),
                            request.getParameter("name"),
                            Double.parseDouble(request.getParameter("price")),
                            Integer.parseInt(request.getParameter("stock")),
                            Integer.parseInt(request.getParameter("totalPages")),
                            Integer.parseInt(request.getParameter("yearCreated")),
                            request.getParameter("author"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    bookService.save(updateBook);
                    response.sendRedirect("/BookServlet?action=GETALL");
                    break;
            }
        }
    }
}
