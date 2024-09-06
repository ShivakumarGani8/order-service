package com.ecommerce.OrderService.model;

import com.ecommerce.OrderService.external.response.PaymentDetails;
import com.ecommerce.OrderService.external.response.ProductDetails;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {
    private long orderId;
    private long quantity;
    private OrderStatus orderStatus;
    private ProductDetails productDetails;
    private PaymentDetails paymentDetails;
}
