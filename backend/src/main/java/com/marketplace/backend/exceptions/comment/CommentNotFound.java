package com.marketplace.backend.exceptions.comment;

public class CommentNotFound extends RuntimeException {
    public CommentNotFound() {
        super("No comments yet :(");
    }
}
