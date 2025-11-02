package com.marketplace.backend.exceptions.category;

public class CategoryAlreadyExists extends RuntimeException {
    public CategoryAlreadyExists() {
        super("Category already exists");
    }
}
