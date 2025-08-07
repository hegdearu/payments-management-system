package org.example.controller;

import org.example.dto.PaymentDto;
import org.example.model.Payment;
import org.example.model.response.NewPaymentResponse;
import org.example.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<Payment> addPayment(@RequestBody PaymentDto paymentDto) {
        Payment newpaymentResponse = paymentService.processPayment(paymentDto);
        System.out.println("Processing payment request: " + paymentDto);
        System.out.println("Processing payment response: " + newpaymentResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(newpaymentResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto) {
        // Logic to update the payment
        System.out.println("Updating payment: " + paymentDto);
        return ResponseEntity.ok(paymentDto);
    }

    @PostMapping("/delete/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        // Logic to delete the payment
        System.out.println("Deleting payment with ID: " + paymentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable Long paymentId) {
        // Logic to retrieve the payment
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(paymentId);
        System.out.println("Retrieving payment with ID: " + paymentId);
        return ResponseEntity.ok(paymentDto);
    }
}
