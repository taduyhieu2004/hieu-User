package com.example.xyzt.exception;

import com.example.xyzt.constans.ErrorMessageConstans;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Constraint(validatedBy = ValidationUsername.UsernameValidation.class)

public @interface ValidationUsername {
    // trường message là bắt buộc, khai báo nội dung sẽ trả về khi field k hợp lệ
    String message() default ErrorMessageConstans.WRONG_USERNAME;

    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<?>[] groups() default {};

    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<? extends Payload>[] payload() default {};

    class UsernameValidation implements ConstraintValidator<ValidationUsername, String> {


        @Override
        public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
            String regexUsername = "^[\\S]+$";
            return userName.matches(regexUsername);
        }
    }
}
