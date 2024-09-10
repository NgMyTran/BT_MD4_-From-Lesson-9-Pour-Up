package ra.bt.service.product;

import ra.bt.model.Category;
import ra.bt.model.Product;
import ra.bt.service.IGenericService;

import java.util.List;

public interface IProductService extends IGenericService<Product, Integer> {
    List<Product> findByCategory(Category category);
}
