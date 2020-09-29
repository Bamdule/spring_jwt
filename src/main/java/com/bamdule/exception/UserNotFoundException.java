package com.bamdule.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userEmail) {
        super(userEmail + " NotFoundException");
    }

}
