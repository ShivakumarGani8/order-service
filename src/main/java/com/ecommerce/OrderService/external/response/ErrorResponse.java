package com.ecommerce.OrderService.external.response;

import com.ecommerce.OrderService.model.ErrorCode;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private ErrorCode errorCode;
}
