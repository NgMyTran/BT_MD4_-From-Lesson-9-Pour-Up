package ra.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.category.ICategoryDao;
import ra.model.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
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

//    @Override
//    public void create(Category category) {
//        categoryDao.create(category);
//    }
//
//    @Override
//    public void update(Category category) {
//        categoryDao.update(category);
//    }
}
