package com.crudtest.demo.validation.validators;

import com.crudtest.demo.model.Student;
import com.crudtest.demo.validation.AgeConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, String> {

    private String message;

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
            System.out.println("Has Error");
        }
        return false;
    }
}
