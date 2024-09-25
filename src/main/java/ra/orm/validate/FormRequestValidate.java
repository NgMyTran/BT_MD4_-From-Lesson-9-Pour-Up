package ra.orm.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.model.FormRequest;

@Component
public class FormRequestValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(FormRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormRequest formRequest = (FormRequest) target;//đổi về kiểu obj formrequest để lấy thuộc tính cuả nó
        if(formRequest.getCheckboxValue()==null){
            errors.rejectValue("checkboxValue", null, "khong dc null");
        }
        if(formRequest.getSelectedValues()==null || formRequest.getSelectedValues().isEmpty()){
            errors.rejectValue("selectedValues", null, "khong dc trong");
        }
        if(formRequest.getName().trim().isEmpty()){
            errors.rejectValue("name", null, "khong dc de trong");
        }
        if(formRequest.getPassword().matches("^[A-Za-z0-9]{6,}$")){
            errors.rejectValue("password", null, "pass co it nhat 6 ky tu, k co ky tu dac biet");
        }
    }
}
