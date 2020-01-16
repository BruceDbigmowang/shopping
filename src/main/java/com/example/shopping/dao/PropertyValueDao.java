package com.example.shopping.dao;

import com.example.shopping.pojo.Product;
import com.example.shopping.pojo.Property;
import com.example.shopping.pojo.PropertyValue;
import org.elasticsearch.common.settings.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDao extends JpaRepository<PropertyValue,Integer>{

    List<PropertyValue> findByProductOrderByIdDesc(Product product);
    PropertyValue getByPropertyAndProduct(Property property, Product product);

}
