package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.model.OrderRequest;

public interface IOrderService {
    long placeOrder(OrderRequest orderRequest);
}
