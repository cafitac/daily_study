package com.fastcampus.helloecommeradmin.exception;

public class NotFoundCustomerException extends RuntimeException {

    public NotFoundCustomerException(String message) {
        super(message);
    }
}