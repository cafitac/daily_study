package com.fastcampus.helloecommeradmin.exception;

public class NotFoundOrderException extends RuntimeException {

    public NotFoundOrderException(String message) {
        super(message);
    }
}