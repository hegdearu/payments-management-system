package org.example.exception;

import lombok.Getter;

@Getter
public class ValidationException extends Exception {
    private final String fieldName;
    private final String errorCode;

    public ValidationException(String message) {
        super(message);
        this.fieldName = null;
        this.errorCode = "VALIDATION_ERROR";
    }

    public ValidationException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
        this.errorCode = "VALIDATION_ERROR";
    }
}
