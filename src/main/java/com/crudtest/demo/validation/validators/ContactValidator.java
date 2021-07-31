package com.crudtest.demo.validation.validators;

import com.crudtest.demo.validation.ContactConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactValidator implements ConstraintValidator<ContactConstraint, String> {

    @Override
    public void initialize(ContactConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Area Code:            1-4 digits
     * Subscriber Number:    5-7 digits
     * Therefore, min is 5 and maximum is 11.
     */
    @Override
    public boolean isValid(String contact, ConstraintValidatorContext constraintValidatorContext) {
        int max = 11;
        int min = 5;
        try {
            Double.parseDouble(contact);
            return (contact.length() >= min && contact.length()  <= max);
        } catch (Exception e) {
            System.out.println("Contact error");
        }
        return false;
    }
}
