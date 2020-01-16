package com.example.shopping.dao;

import com.example.shopping.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
