package com.crudtest.demo.validation;

import com.crudtest.demo.model.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidation implements ConstraintValidator<Age, Student> {

    @Override
    public void initialize(Age constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
        return student.getAge() > 150 || student.getAge() < 1; // 1 to 150 only. :D
    }
}
