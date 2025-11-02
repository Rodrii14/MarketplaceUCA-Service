package com.marketplace.backend.exceptions.user;

public class ImpossibleAction extends RuntimeException {
    public ImpossibleAction() {
        super("Impossible Action");
    }
}
