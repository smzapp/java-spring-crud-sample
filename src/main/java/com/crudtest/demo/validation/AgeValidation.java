package com.crudtest.demo.validation;

import com.crudtest.demo.model.Student;
import com.crudtest.demo.validation.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidation implements ConstraintValidator<Age, Student> {

    @Override
    public void initialize(Age constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
//        int ageNum = Integer.parseInt(age);
//        return ageNum > 0 && ageNum < 200;
//        System.out.println("type ni: " + student.getAge());
        return true;
    }
}
