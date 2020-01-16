package com.example.shopping.dao;

import com.example.shopping.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User , Integer> {
}
