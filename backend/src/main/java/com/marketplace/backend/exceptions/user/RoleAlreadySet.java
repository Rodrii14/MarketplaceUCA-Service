package com.marketplace.backend.exceptions.user;

public class RoleAlreadySet extends RuntimeException {
    public RoleAlreadySet() {
        super("Role already set!");
    }
}
