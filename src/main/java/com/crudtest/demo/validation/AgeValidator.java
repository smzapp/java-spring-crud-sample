package com.crudtest.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, String> {

    @Override
    public boolean isValid(String age, ConstraintValidatorContext constraintValidatorContext) {
        try {
            int ageInt = Integer.parseInt(age);
            return (ageInt > 0 && ageInt  < 200);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
