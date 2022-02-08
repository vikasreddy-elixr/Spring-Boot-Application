package com.elixr.springbootapplication.exceptionhandler;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
