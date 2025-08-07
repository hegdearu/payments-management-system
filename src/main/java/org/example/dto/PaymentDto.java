package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.PaymentCategory;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private Long id;
    private PaymentType paymentType;
    private PaymentCategory category;
    private BigDecimal amount;
    private String currency;
    private String description;
    private PaymentStatus status;
    private LocalDate paymentDate;
    private String createdByUsername;
}
