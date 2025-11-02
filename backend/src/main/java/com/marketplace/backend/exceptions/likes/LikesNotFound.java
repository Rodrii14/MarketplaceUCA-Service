package com.marketplace.backend.exceptions.likes;

public class LikesNotFound extends RuntimeException {
    public LikesNotFound() {
        super("There are no likes yet");
    }
}
