package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.enitity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
