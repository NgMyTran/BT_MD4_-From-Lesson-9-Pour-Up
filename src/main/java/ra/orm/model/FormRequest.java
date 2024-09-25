package ra.orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
//import ra.orm.validate.Password;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormRequest {
//    @NotNull
    private String checkboxValue;
//    @NotEmpty
    private List<String> selectedValues;
//    @NotBlank
    private String name;
//    @Password(message = "Mật khẩu phải có ít nhát 6 ký tự và không có ký tự đặc biệt")

    private String password;
}
