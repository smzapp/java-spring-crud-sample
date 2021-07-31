package com.crudtest.demo.exception;

public class DuplicateEntryException extends RuntimeException {

    private String field;

    public DuplicateEntryException(String field, String message){
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
