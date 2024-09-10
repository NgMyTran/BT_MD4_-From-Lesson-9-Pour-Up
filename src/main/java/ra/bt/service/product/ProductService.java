package ra.bt.service.product;

import ra.bt.model.Product;
import ra.bt.model.Category;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {

    private List<Product> productList = new ArrayList<>();

    public ProductService() {
        // Khởi tạo giá trị ban đầu
        productList.add(new Product(1, "Product 1", 100.0, 10, true, new Category(1, "Category 1", true)));
        productList.add(new Product(2, "Product 2", 200.0, 20, true, new Category(2, "Category 2", true)));
        productList.add(new Product(3, "Product 3", 300.0, 30, true, new Category(3, "Category 3", true)));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        return productList.stream().filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productList.stream()
                .filter(p -> p.getCategory().getId()==category.getId())
                .collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) == null) {
            // Không tồn tại, thêm mới
            product.setId(getNewId());
            productList.add(product);
        } else {
            productList.set(
                    productList.indexOf(
                            findById(
                                    product.getId()
                            )
                    ), product
            );
        }
    }

    @Override
    public void delete(Integer id) {
        Product productToDelete = findById(id);
        if (productToDelete != null) {
            productToDelete.setStatus(false);
            save(productToDelete);
        }
    }

    private int getNewId() {
        return productList.stream()
                .map(Product::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
