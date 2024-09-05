package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.model.OrderRequest;
import com.ecommerce.OrderService.model.OrderResponse;
import org.springframework.http.ResponseEntity;

public interface IOrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long id);
}
