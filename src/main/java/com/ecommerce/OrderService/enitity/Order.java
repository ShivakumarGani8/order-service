package com.ecommerce.OrderService.enitity;

import com.ecommerce.OrderService.model.OrderStatus;
import com.ecommerce.OrderService.model.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_TABLE")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ORDER_ID")
    private long orderId;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "ORDER_DATE")
    private Instant orderDate;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "PAYMENT_MODE")
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}
