package com.marketplace.backend.exceptions.user;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super("User not found");
    }
}
