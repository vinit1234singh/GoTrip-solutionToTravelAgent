package com.intellect.crm.exception;

import lombok.Getter;

@Getter
class ErrorResponse {

    public ErrorResponse(String message, String details, int status) {

    }

}

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(new ErrorResponse(message, "The user is not found in the db", 404).toString());
    }
}
