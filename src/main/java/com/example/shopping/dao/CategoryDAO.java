package com.example.shopping.dao;

import com.example.shopping.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category , Integer> {
}
