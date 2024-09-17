package ra.service.book;

import ra.model.Book;
import ra.service.IGenericService;

import java.util.List;


public interface IBookService extends IGenericService<Book, Integer> {
    List<Book> findByCategoryId(int categoryId);
}
