package com.crudtest.demo.validation;

import com.crudtest.demo.validation.validators.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface AgeConstraint{

    String message() default "Age must be an integer and not greater than 200.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
