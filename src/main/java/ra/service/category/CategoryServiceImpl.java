package ra.service.category;

import ra.dao.category.CategoryDaoImpl;
import ra.dao.category.ICategoryDao;
import ra.model.Book;
import ra.model.Category;
import ra.service.book.BookServiceImpl;
import ra.service.book.IBookService;

import java.util.Collections;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public void save(Category category) {
        if (findById(category.getId()) != null) {
            categoryDao.update(category);
        } else {
            categoryDao.create(category);
        }
    }

    @Override
    public void delete(Integer id) {
        IBookService bookService = new BookServiceImpl();
        List<Book> books = bookService.findByCategoryId(id);

        if (!books.isEmpty()) {
            // Cập nhật trạng thái của các sách thành không hoạt động
            for (Book book : books) {
                book.setStatus(false);
                bookService.save(book);
            }
        }
        // Sau khi cập nhật trạng thái của sách, xóa danh mục
        categoryDao.delete(id);
    }
}
