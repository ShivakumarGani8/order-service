package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.enitity.Order;
import com.ecommerce.OrderService.external.client.IProductService;
import com.ecommerce.OrderService.model.OrderRequest;
import com.ecommerce.OrderService.model.OrderStatus;
import com.ecommerce.OrderService.model.PaymentMode;
import com.ecommerce.OrderService.repository.IOrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IProductService productService;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        System.out.println(orderRequest.toString()+orderRequest.getQuantity());
        log.info("Ordering product with Id : {}", orderRequest.getProductId());
        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        log.info("Creating order with status created..");
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
