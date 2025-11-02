package com.marketplace.backend.exceptions.product;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("The product is not here... :(");
    }
}
