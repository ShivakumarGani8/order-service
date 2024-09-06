package com.ecommerce.OrderService.external.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
    private long productId;
    private String productName;
    private double productPrice;
}
