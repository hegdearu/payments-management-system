package org.example.exception;

import lombok.Getter;

@Getter
public class PaymentException extends Exception {
    private final String errorCode;

    public PaymentException(String message) {
        super(message);
        this.errorCode = "PAYMENT_ERROR";
    }

    public PaymentException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "PAYMENT_ERROR";
    }

    public PaymentException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
