package com.ecommerce.OrderService.exception;

import com.ecommerce.OrderService.external.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getStatus()));
    }

    @ExceptionHandler(OrderNotFoundExeption.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundExeption exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
}
