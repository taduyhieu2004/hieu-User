package com.example.xyzt.exception;

import com.example.xyzt.constans.ErrorMessageConstans;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValidationPhoneNumber.PhoneNumberValidation.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
public @interface ValidationPhoneNumber {
    // trường message là bắt buộc, khai báo nội dung sẽ trả về khi field k hợp lệ
    String message() default ErrorMessageConstans.WRONG_PHONE_NUMBER;

    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<?>[] groups() default {};

    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<? extends Payload>[] payload() default {};

    class PhoneNumberValidation implements ConstraintValidator<ValidationPhoneNumber, String> {

        @Override
        public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
            String regexPhoneNumber = "^0\\d{9}$";
            return phoneNumber.matches(regexPhoneNumber);
        }
    }


};


