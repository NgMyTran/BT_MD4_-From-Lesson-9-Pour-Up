package ra.dao.book;

import ra.dao.IGenericDao;
import ra.model.Book;

import java.util.List;

public interface IBookDao extends IGenericDao<Book, Integer> {
    List<Book> findByCategoryId(Integer categoryId);
}
