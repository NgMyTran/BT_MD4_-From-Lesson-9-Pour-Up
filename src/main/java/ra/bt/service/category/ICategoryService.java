package ra.bt.service.category;

import ra.bt.model.Category;
import ra.bt.service.IGenericService;

public interface ICategoryService extends IGenericService<Category, Integer> {
    boolean hasProducts(Category category);
    void updateProductStatusForCategory(Category categoryToDeleteConfirm, boolean b);
}
