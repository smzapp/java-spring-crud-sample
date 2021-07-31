package com.crudtest.demo.exception;

public class DuplicateEntryException extends RuntimeException {

    public DuplicateEntryException(String message){
        super(message);
    }

    public DuplicateEntryException() {}
}
