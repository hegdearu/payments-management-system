package org.example.service;
import org.example.model.Payment;
import org.example.model.request.PaymentCreateRequest;
import org.example.model.request.PaymentUpdateRequest;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentCreateRequest request);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    Payment updatePayment(Long id, PaymentUpdateRequest request);
    void deletePayment(Long id);
}
