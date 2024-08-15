package com.intellect.crm.exception;



class ErrorResponseAdmin {
    public ErrorResponseAdmin(String message, String details, int status) {
        
    }

}
public class AdminNotFoundException extends RuntimeException{
	public AdminNotFoundException(String message) {
        super(new ErrorResponseAdmin(message, "The admin is not found in the db", 404).toString());
    }

}
