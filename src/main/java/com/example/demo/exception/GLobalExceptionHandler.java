package com.example.demo.exception;

public class GlobalException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
