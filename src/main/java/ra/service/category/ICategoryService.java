package ra.service.category;

import ra.model.entity.Category;
import ra.service.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Category, Integer> {
    void deleteCategory(Integer id, boolean confirm);
   List<Category> findActiveCategories();
}
