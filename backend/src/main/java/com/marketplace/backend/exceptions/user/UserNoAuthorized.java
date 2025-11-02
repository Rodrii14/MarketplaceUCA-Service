package com.marketplace.backend.exceptions.user;

public class UserNoAuthorized extends RuntimeException {
    public UserNoAuthorized() {
        super("Bad credentials");
    }
}
