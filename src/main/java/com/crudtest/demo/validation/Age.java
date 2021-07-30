package com.crudtest.demo.validation;

import com.crudtest.demo.validation.impl.AgeValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(ElementType.TYPE) // inside class
@Target(ElementType.FIELD) // inside field
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidation.class)
public @interface Age {
    String message() default "Age must be a number and not greater than 200.";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
}
