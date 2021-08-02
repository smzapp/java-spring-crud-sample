package com.crudtest.demo.exception;

public class SearchEntryException  extends  Exception{

    private String field;
    private String message;

    public SearchEntryException(String field, String message){
        super(message);
        this.field = field;
    }

    public SearchEntryException() {
    }

    public SearchEntryException(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }
}
