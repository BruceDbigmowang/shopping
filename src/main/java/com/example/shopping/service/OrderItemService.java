package com.example.shopping.service;

import com.example.shopping.dao.OrderItemDao;
import com.example.shopping.pojo.Order;
import com.example.shopping.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ProductImageService productImageService;

    public void fill(List<Order> orders){
        for(Order order : orders){
            fill(order);
        }
    }

    public void fill(Order order){
        List<OrderItem> orderItems = listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for(OrderItem orderItem : orderItems){
            total += orderItem.getNumber()*orderItem.getProduct().getPromoteprice();
            totalNumber+=orderItem.getNumber();
            productImageService.setFirstProductImage(orderItem.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    public List<OrderItem> listByOrder(Order order){
        return orderItemDao.findByOrderOrderByIdDesc(order);
    }
}
