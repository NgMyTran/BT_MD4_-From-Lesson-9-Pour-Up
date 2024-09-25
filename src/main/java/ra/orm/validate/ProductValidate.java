package ra.orm.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.model.Product;

@Component
public class ProductValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        // Kiểm tra tên sản phẩm
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            errors.rejectValue("productName", null, "Tên sản phẩm không được để trống");
        } else if (!product.getProductName().matches("^[A-Za-z0-9 ]+$")) {
            errors.rejectValue("productName", null, "Tên sản phẩm không được chứa ký tự đặc biệt");
        }

        // Kiểm tra giá
        if (product.getPrice() <= 0) {
            errors.rejectValue("price", null, "Giá sản phẩm không được bỏ trống và phải lớn hơn 0");
        } else if (!String.valueOf(product.getPrice()).matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
            errors.rejectValue("price", null, "Giá không chứa ký tự đặc biệt và phải là số hợp lệ");
        }

        // Kiểm tra số lượng trong kho
        if (product.getStock() < 0) {
            errors.rejectValue("stock", null, "Số lượng trong kho không được âm");
        } else if (product.getStock() == 0) {
            errors.rejectValue("stock", null, "Số lượng không được bỏ trống và phải lớn hơn 0");
        } else if (!String.valueOf(product.getStock()).matches("^[0-9]+$")) {
            errors.rejectValue("stock", null, "Số lượng không chứa ký tự đặc biệt và phải là số hợp lệ");
        }

    }
}

