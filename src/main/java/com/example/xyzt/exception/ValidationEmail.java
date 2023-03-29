package com.example.xyzt.exception;


//import jakarta.validation.Constraint;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import jakarta.validation.Payload;

import com.example.xyzt.constans.ErrorMessageConstans;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

//import static org.up.finance.constant.FinanceConstant.ValidationMessage.INVALID_EMAIL;

@Constraint(validatedBy = ValidationEmail.EmailValidation.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
public @interface ValidationEmail {
    // trường message là bắt buộc, khai báo nội dung sẽ trả về khi field k hợp lệ
    String message() default ErrorMessageConstans.WRONG_EMAIL;
    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<?>[] groups() default {};
    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<? extends Payload>[] payload() default {};

    class EmailValidation implements ConstraintValidator<ValidationEmail, String> {

        @Override
        public void initialize(ValidationEmail constraintAnnotation) {
        }

        @Override
        public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
            String regexEmail ="^[a-zA-Z]+[a-z0-9]*@{1}[A-Za-z]{1}+mail.com$";
//                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            return email.matches(regexEmail);
        }
    }
}