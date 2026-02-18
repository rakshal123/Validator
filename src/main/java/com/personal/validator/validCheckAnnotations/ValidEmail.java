package com.personal.validator.validCheckAnnotations;

import com.personal.validator.BaseValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = {ValidEmail.EmailValidator.class})
public @interface ValidEmail {
    String message() default "Invalid email format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class EmailValidator extends BaseValidator<ValidEmail, String, String>{

        private static final Pattern EMAIL_PATTERN =
                Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        EmailValidator() {
            super(
                    s -> s != null && EMAIL_PATTERN.matcher(s).matches(),
                    s -> s,
                    "Invalid Email Id"
            );
        }
    }
}
