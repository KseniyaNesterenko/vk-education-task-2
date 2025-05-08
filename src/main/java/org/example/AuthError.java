package org.example;

public class AuthError extends Throwable {

    private final String message;

    public AuthError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
