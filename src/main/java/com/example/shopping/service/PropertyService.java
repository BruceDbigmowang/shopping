package com.example.shopping.service;

import com.example.shopping.dao.CategoryDAO;
import com.example.shopping.dao.PropertyDAO;
import com.example.shopping.pojo.Category;
import com.example.shopping.pojo.Property;
import com.example.shopping.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyDAO propertyDAO;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.deleteById(id);
    }

    public Property findOne(int id){
        return propertyDAO.getOne(id);
    }

    public void update(Property bean){
        propertyDAO.save(bean);
    }

    public Page4Navigator<Property> list(int cid , int start , int size , int navigatePages){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC , "id");
        Pageable pageable = PageRequest.of(start , size , sort);
        Page<Property> pageFromJPA = propertyDAO.findByCategory(category , pageable);
        return new Page4Navigator<>(pageFromJPA , navigatePages);
    }

    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }

}
