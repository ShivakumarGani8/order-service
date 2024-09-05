package com.ecommerce.OrderService.controller;

import com.ecommerce.OrderService.model.OrderRequest;
import com.ecommerce.OrderService.model.OrderResponse;
import com.ecommerce.OrderService.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        long orderId= orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long id){
        OrderResponse orderResponse=  orderService.getOrderDetails(id);
        return  new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }
}
