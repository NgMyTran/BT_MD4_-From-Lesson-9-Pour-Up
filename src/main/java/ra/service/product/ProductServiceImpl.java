package ra.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.product.IProductDao;
import ra.model.entity.Product;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
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
