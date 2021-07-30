package com.crudtest.demo.validation;

import com.crudtest.demo.model.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, String> {

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String age, ConstraintValidatorContext constraintValidatorContext) {
        try {
            int ageInt = Integer.parseInt(age);
            return (ageInt > 0 && ageInt  < 200);
        } catch (Exception e) {
            return false;
        }
    }
}
