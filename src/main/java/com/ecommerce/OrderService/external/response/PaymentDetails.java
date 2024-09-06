package com.ecommerce.OrderService.external.response;

import com.ecommerce.OrderService.model.PaymentMode;
import lombok.Data;

@Data
public class PaymentDetails {
    private PaymentMode paymentMode;
    private String referenceNumber;
    private double amount;
}
