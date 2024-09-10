package ra.bt.service.category;

import ra.bt.model.Category;
import ra.bt.model.Product;
import ra.bt.service.product.IProductService;
import ra.bt.service.product.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CategoryService implements ICategoryService{
    private List<Category> categoryList = new ArrayList<>();
    private IProductService productService = new ProductService();


    public CategoryService() {
        // khơi tao giá trị ban dau
        categoryList.add(new Category(1,"Category 1",true));
        categoryList.add(new Category(2,"Category 2",true));
        categoryList.add(new Category(3,"Category 3",true));
    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public Category findById(Integer id) {
         return categoryList.stream().filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Category category) {
        if (findById(category.getId()) == null) {
            //k ton tai, them moi
            category.setId(getNewId());
            categoryList.add(category);
        } else {
            categoryList.set(
                    categoryList.indexOf(
                            findById(
                                    category.getId()
                            )
                    ), category
            );
        }
    }

    @Override
    public void delete(Integer id) {
        Category cDel = findById(id);
        if (cDel != null) {
            cDel.setStatus(false);
            save(cDel);
        }
    }

    private int getNewId() {
        return categoryList.stream()
                .map(Category::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }

    @Override
    public boolean hasProducts(Category category) {
        // Kiểm tra sản phẩm liên kết với danh mục
        return productService.findAll().stream()
                .anyMatch(p -> p.getCategoryId().equals(category.getId()));
    }

    @Override
    public void updateProductStatusForCategory(Category category, boolean status) {
        List<Product> products = productService.findByCategory(category);
        System.out.println("Products found: " + products);
        for (Product product : products) {
            product.setStatus(status);
            productService.save(product);
            System.out.println("Updated Product: " + product);
        }

    }

}

