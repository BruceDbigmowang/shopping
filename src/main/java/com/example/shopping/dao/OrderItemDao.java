package com.example.shopping.dao;

import com.example.shopping.pojo.Order;
import com.example.shopping.pojo.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDao extends JpaRepository<OrderItem , Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
}
