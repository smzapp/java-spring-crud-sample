package com.crudtest.demo.validation.impl;

import com.crudtest.demo.validation.AgeConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidation implements ConstraintValidator<AgeConstraint, Integer> {

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return (age > 0 && age <= 200);
    }
}
