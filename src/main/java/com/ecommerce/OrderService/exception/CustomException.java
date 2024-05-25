package com.ecommerce.OrderService.exception;

import com.ecommerce.OrderService.model.ErrorCode;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
    private int status;

    public CustomException(String messsge, ErrorCode errorCode, int status){
        super(messsge);
        this.errorCode=errorCode;
        this.status=status;
    }
}
