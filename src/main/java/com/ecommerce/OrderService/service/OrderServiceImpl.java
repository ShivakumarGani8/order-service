package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.enitity.Order;
import com.ecommerce.OrderService.exception.OrderNotFoundExeption;
import com.ecommerce.OrderService.external.client.IPaymentService;
import com.ecommerce.OrderService.external.client.IProductService;
import com.ecommerce.OrderService.external.request.PaymentRequest;
import com.ecommerce.OrderService.external.response.PaymentDetails;
import com.ecommerce.OrderService.external.response.ProductDetails;
import com.ecommerce.OrderService.model.ErrorCode;
import com.ecommerce.OrderService.model.OrderRequest;
import com.ecommerce.OrderService.model.OrderResponse;
import com.ecommerce.OrderService.model.OrderStatus;
import com.ecommerce.OrderService.repository.IOrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IProductService productService;
    @Autowired
    private IPaymentService paymentService;
    @Autowired
    private RestTemplate restTemplate;

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
                .paymentMode(orderRequest.getPaymentMode())
                .orderDate(Instant.now()).build();

        orderRepository.save(order);

        log.info("Calling payment service with orderId : {}", order.getOrderId());
        PaymentRequest paymentRequest= PaymentRequest
                .builder()
                .orderId(order.getOrderId())
                .amount(order.getAmount())
                .paymentMode(order.getPaymentMode())
                .build();
        paymentService.doPayment(paymentRequest);

        return order.getOrderId();
    }

    @Override
    public OrderResponse getOrderDetails(long id) {
        log.info("Getting order from order table: {}",id);
        Order order=orderRepository.findById(id).orElseThrow(()->
                new OrderNotFoundExeption("Order not found for id : "+id,ErrorCode.ORDER_NOT_FOUND));

        ProductDetails productDetails= restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+order.getProductId(), ProductDetails.class);
        PaymentDetails paymentDetails= restTemplate.getForObject("http://PAYMENT-SERVICE/payment/order/"+order.getOrderId(),PaymentDetails.class);

        OrderResponse orderResponse= OrderResponse.builder()
                .orderId(order.getOrderId())
                .quantity(order.getQuantity())
                .orderStatus(order.getOrderStatus())
                .productDetails(productDetails)
                .paymentDetails(paymentDetails)
                .build();

        return orderResponse;
    }
}
