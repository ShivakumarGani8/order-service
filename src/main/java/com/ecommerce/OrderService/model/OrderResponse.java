package com.ecommerce.OrderService.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {
    private long orderId;
    private long quantity;
    private OrderStatus orderStatus;
    private double amount;
    private PaymentMode paymentMode;
}
