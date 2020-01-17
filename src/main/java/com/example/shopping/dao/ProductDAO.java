package com.example.shopping.dao;

import com.example.shopping.pojo.Category;
import com.example.shopping.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    Page<Product> findByCategory(Category category , Pageable pageable);
    Page<Product> findByCategoryOrderById(Category category);
}
