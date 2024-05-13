package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.enitity.Order;
import com.ecommerce.OrderService.model.OrderRequest;
import com.ecommerce.OrderService.model.OrderStatus;
import com.ecommerce.OrderService.model.PaymentMode;
import com.ecommerce.OrderService.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        Order order= Order.builder()
                .productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .amount(orderRequest.getTotalAmount())
                .orderStatus(OrderStatus.valueOf(OrderStatus.CREATED.name()))
                .paymentMode(PaymentMode.valueOf(PaymentMode.CASH.name()))
                .orderDate(Instant.now()).build();

        orderRepository.save(order);

        return order.getOrderId();
    }
}
