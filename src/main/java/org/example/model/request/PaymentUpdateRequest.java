package org.example.model.request;

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
public class PaymentUpdateRequest {
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    private PaymentType paymentType;
    private PaymentCategory category;
    private PaymentStatus status;
    private LocalDateTime date;

}
