package org.example.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.PaymentCategory;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class PaymentCreateRequest {
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotNull(message = "Payment type cannot be null")
    private PaymentType paymentType;

    @NotNull(message = "Category cannot be null")
    private PaymentCategory category;

    @NotNull(message = "Status cannot be null")
    private PaymentStatus status;

    @NotNull(message = "Date cannot be null")
    private LocalDateTime date;

    @NotNull(message = "Created by cannot be null")
    private Long createdBy;
}
