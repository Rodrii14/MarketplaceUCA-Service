package com.marketplace.backend.exceptions.category;

public class CategoryNotFound extends RuntimeException {
    public CategoryNotFound() {
        super("Category not found");
    }
}
