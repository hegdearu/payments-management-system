package org.example.exception;

import lombok.Getter;

@Getter
public class SecurityException extends Exception {
    private final String errorCode;

    public SecurityException(String message) {
        super(message);
        this.errorCode = "SECURITY_ERROR";
    }

    public SecurityException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
