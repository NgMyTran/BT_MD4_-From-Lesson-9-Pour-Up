package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.IProductDao;
import ra.dao.ProductDao;
import ra.model.Product;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService implements IProductService {
    // tiêm phụ thuộc vào (quét Bean của dao )
    private final IProductDao productDao;

    @Autowired
    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void save(Product product) {
        if (product == null) {
            productDao.create(product);
        } else {
            productDao.update(product);
        }
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }
}
