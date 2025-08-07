package org.example.model.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public class NewPaymentResponse {
    private String paymentId;
    private BigDecimal amount;
    private String status;
    private String message;
    private LocalDateTime createdAt;
    private String createdBy;

}
