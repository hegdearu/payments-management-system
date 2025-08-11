package org.example.service;

import org.example.exception.PaymentNotFoundException;
import org.example.exception.UserNotFoundException;
import org.example.model.Payment;
import org.example.model.request.PaymentCreateRequest;
import org.example.model.request.PaymentUpdateRequest;
import org.example.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserService userService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, UserService userService) {
        this.paymentRepository = paymentRepository;
        this.userService = userService;
    }

    @Override
    public Payment createPayment(PaymentCreateRequest request) {
        validateUserExists(request.getCreatedBy());

        Payment payment = Payment.builder()
                .amount(request.getAmount())
                .paymentType(request.getPaymentType())
                .category(request.getCategory())
                .status(request.getStatus())
                .date(request.getDate())
                .createdBy(request.getCreatedBy())
                .build();

        return paymentRepository.save(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));
    }

    @Override
    public Payment updatePayment(Long id, PaymentUpdateRequest request) {
        Payment existingPayment = getPaymentById(id);

        updatePaymentFields(existingPayment, request);

        return paymentRepository.save(existingPayment);
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = getPaymentById(id);
        paymentRepository.delete(payment);
    }

    private void validateUserExists(Long userId) {
        try {
            userService.getUserById(userId);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Creator user not found with id: " + userId);
        }
    }

    private void updatePaymentFields(Payment payment, PaymentUpdateRequest request) {
        if (request.getAmount() != null) {
            payment.setAmount(request.getAmount());
        }
        if (request.getPaymentType() != null) {
            payment.setPaymentType(request.getPaymentType());
        }
        if (request.getCategory() != null) {
            payment.setCategory(request.getCategory());
        }
        if (request.getStatus() != null) {
            payment.setStatus(request.getStatus());
        }
        if (request.getDate() != null) {
            payment.setDate(request.getDate());
        }
    }
}
