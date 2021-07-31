package com.crudtest.demo.validation;

import com.crudtest.demo.validation.validators.ContactValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ContactValidator.class)
public @interface ContactConstraint{

    String message() default "Contact number should be valid. It should range from 5 to 11 digits.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
