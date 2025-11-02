package com.marketplace.backend.exceptions.faculty;

public class FacultyNotFound extends RuntimeException {
    public FacultyNotFound() {
        super("Faculty not found");
    }
}
