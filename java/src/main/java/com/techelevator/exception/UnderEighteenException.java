package com.techelevator.exception;

public class UnderEighteenException extends RuntimeException {
    public UnderEighteenException() { super();}
    public UnderEighteenException(String message) {super(message);}
    public UnderEighteenException(String message, Exception cause) {
        super(message, cause);
    }
}
