package com.personal.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.function.Function;
import java.util.function.Predicate;

public class BaseValidator<T extends Annotation,A, F> implements ConstraintValidator<T,A> {

    private Predicate<F> check;
    private Function<A,F> mapper;
    private String errorMessage;

    public BaseValidator(Predicate<F> check, Function<A,F> mapper, String errorMessage) {
        this.check = check;
        this.mapper = mapper;
        this.errorMessage = errorMessage;
    }

    public BaseValidator() {
    }

    @Override
    public boolean isValid(A a, ConstraintValidatorContext context) {
        F mapped = mapper.apply(a);
        boolean isValid = this.check.test(mapped);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage)
                    .addConstraintViolation();
        }

        return isValid;
    }
}
