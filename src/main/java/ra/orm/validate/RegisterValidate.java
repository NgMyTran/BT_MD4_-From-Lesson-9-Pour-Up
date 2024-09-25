package ra.orm.validate;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.model.User;

@Component
public class RegisterValidate implements Validator {

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
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", null, "Không được để trống email");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            errors.rejectValue("password", null, "Không được để trống mật khẩu");
        }
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            errors.rejectValue("phone", null, "Không được để trống số điện thoại");
        }

        // Kiểm tra định dạng email
        if (!user.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}$")) {
            errors.rejectValue("email", null, "Email không đúng định dạng");
        }

        // Kiểm tra định dạng số điện thoại Việt Nam
        if (!user.getPhone().matches("^(0\\d{9}|\\+84\\d{9})$")) {
            errors.rejectValue("phone", null, "Số điện thoại không đúng định dạng");
        }

        // Kiểm tra mật khẩu
        if (!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")) {
            errors.rejectValue("password", null, "Mật khẩu phải có ít nhất 6 ký tự, có cả chữ và số, không có dấu cách");
        }
    }
}

