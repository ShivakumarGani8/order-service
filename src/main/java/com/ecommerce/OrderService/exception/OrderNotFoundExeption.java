package com.ecommerce.OrderService.exception;

import com.ecommerce.OrderService.model.ErrorCode;
import lombok.Data;

@Data
public class OrderNotFoundExeption extends RuntimeException{
    private ErrorCode errorCode;

    public OrderNotFoundExeption(String message,ErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
