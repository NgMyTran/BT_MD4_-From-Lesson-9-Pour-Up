package ra.orm.validate;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.model.User;

@Component
public class LoginValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Kiểm tra không để trống các trường
        if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
            errors.rejectValue("fullName", null, "Không được để trống họ tên");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            errors.rejectValue("password", null, "Họ và tên không được để trống mật khẩu");
        }

        // Kiểm tra mật khẩu
        if (!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")) {
            errors.rejectValue("password", null, "Mật khẩu phải có ít nhất 6 ký tự, có cả chữ và số, không có dấu cách");
        }
    }
}
