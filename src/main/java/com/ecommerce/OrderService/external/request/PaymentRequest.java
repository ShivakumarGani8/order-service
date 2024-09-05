package com.ecommerce.OrderService.external.request;


import com.ecommerce.OrderService.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private long orderId;
    private PaymentMode paymentMode;
    private String referenceNumber;
    private double amount;

}
