package com.example.shopping.dao;

import com.example.shopping.pojo.Category;
import com.example.shopping.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDAO extends JpaRepository<Property , Integer> {
    Page<Property> findByCategory(Category category , Pageable pageable);
}
