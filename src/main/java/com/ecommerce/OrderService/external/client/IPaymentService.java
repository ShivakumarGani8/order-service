package com.ecommerce.OrderService.external.client;

import com.ecommerce.OrderService.external.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "PAYMENT-SERVICE/payment")
public interface IPaymentService {
    @PostMapping("/doPayment")
    ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
