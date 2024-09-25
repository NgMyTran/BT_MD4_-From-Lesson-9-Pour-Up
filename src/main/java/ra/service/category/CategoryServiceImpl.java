package ra.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.category.ICategoryDao;
import ra.dao.product.IProductDao;
import ra.model.entity.Category;
import ra.model.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
    @Override
    public List<Category> findActiveCategories() {
        return categoryDao.findActiveCategories();
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Category category) {
        if (category.getId() == null) {
            categoryDao.create(category);
        } else {
            categoryDao.update(category);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        categoryDao.delete(id);
    }
//
//@Override
//@Transactional
//public void deleteCategory(Integer id, boolean confirm) {
//    Category cateDel = categoryDao.findById(id);
//    if (cateDel != null) {
//        //có sp thuộc category
//        if (!cateDel.getProducts().isEmpty() && confirm) {
//            for (Product pro : cateDel.getProducts()) {
//                pro.setStatus(false);
//                productDao.update(pro); // Cập nhật sản phẩm
//            }
//        }
//        categoryDao.delete(id);
//    }
//}

}
