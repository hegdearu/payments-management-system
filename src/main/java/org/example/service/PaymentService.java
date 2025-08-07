package org.example.service;

import org.example.dto.PaymentDto;
import org.example.model.Payment;
import org.example.model.response.NewPaymentResponse;
import org.example.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(PaymentDto paymentDto) {
        Payment payemntBuilder = Payment.builder()
                .id(UUID.randomUUID().toString())
                .paymentType(paymentDto.getPaymentType())
                .status(paymentDto.getStatus())
                .category(paymentDto.getCategory())
                .amount(paymentDto.getAmount())
                .description(paymentDto.getDescription())
                .createdBy("ADMIN_1") //needs to come from the auth service
                .build();

        return paymentRepository.save(payemntBuilder);
    }
}
