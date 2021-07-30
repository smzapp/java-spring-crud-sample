package com.crudtest.demo.validation.impl;

import com.crudtest.demo.model.Student;
import com.crudtest.demo.validation.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidation implements ConstraintValidator<Age, Integer> {

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
//        int ageNum = Integer.parseInt(age);
//        return ageNum > 0 && ageNum < 200;
//        System.out.println("type ni: " + student.getAge());
        return true;
    }
}
