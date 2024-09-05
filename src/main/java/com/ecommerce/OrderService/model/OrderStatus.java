package com.ecommerce.OrderService.model;

public enum OrderStatus {
    CREATED("CREATED"),SUCCESSFUL("SUCCESSFUL");
    String status;
    OrderStatus(String status){
        this.status=status;
    }
}
