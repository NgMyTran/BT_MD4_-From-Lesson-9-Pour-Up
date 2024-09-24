package ra.dao.category;

import ra.dao.IGenericDao;
import ra.model.entity.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category, Integer> {
    List<Category> findActiveCategories();
}
