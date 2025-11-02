package com.marketplace.backend.exceptions.user;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist() {
        super("User already exists");
    }
}
