package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.PaymentCategory;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Payment {
    private final String id;
    private final PaymentType paymentType;
    private final PaymentCategory category;
    private final BigDecimal amount;
    private final String description;
    private PaymentStatus status = PaymentStatus.PENDING;
    private final LocalDate paymentDate;
    private final String createdBy;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
