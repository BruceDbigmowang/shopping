package com.example.shopping.dao;

import com.example.shopping.pojo.Product;
import com.example.shopping.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review , Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);
}
