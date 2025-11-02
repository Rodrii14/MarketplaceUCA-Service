package com.marketplace.backend.exceptions.product;

public class FailedToSaveImage extends RuntimeException {
    public FailedToSaveImage() {
        super("Failed to save image... try again later");
    }
}
