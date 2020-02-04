package com.httpc.network.exception;

public class InvalidResponseException extends Exception {
    public InvalidResponseException() {
        super("Invalid response.");
    }

    public InvalidResponseException(String message) {
        super("Invalid response: " + message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
