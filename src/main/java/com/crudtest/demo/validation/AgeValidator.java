package com.crudtest.demo.validation;

import com.crudtest.demo.model.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, Student> {

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
        try {
            int ageInt = Integer.parseInt(student.getAge());
            return (ageInt > 0 && ageInt  < 200);
        } catch (Exception e) {
            return false;
        }
    }
}
