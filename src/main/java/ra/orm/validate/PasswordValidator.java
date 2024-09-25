//package ra.orm.validate;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.regex.Pattern;
//
//public class PasswordValidator implements ConstraintValidator<Password, String> {
//   private final String REGEX = "^[A-Za-z0-9]{6,}$";
//
//    @Override
//    public void initialize(Password password) {
//
//    }
//
//    @Override
//    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return Pattern.matches(REGEX, s);
//    }
//}
