package com.techelevator.exception;

public class DuplicatePetException extends RuntimeException {
    public DuplicatePetException() { super();}
    public DuplicatePetException(String message) {super(message);}
    public DuplicatePetException(String message, Exception cause) {
        super(message, cause);
    }
}
