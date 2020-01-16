package com.example.shopping.dao;

import com.example.shopping.pojo.Product;
import com.example.shopping.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage , Integer> {
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product , String type);
}
