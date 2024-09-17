package ra.service.book;

import ra.dao.book.BookDaoImpl;
import ra.dao.book.IBookDao;
import ra.model.Book;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDao bookDao = new BookDaoImpl();


    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public void save(Book book) {
        if (findById(book.getId()) != null) {
            bookDao.update(book);
        } else {
            bookDao.create(book);
        }
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
    }


    @Override
    public List<Book> findByCategoryId(int categoryId) {
        return bookDao.findByCategoryId(categoryId);
    }
}
