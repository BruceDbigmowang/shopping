package com.example.shopping.service;

import com.example.shopping.dao.OrderDao;
import com.example.shopping.pojo.Order;
import com.example.shopping.pojo.OrderItem;
import com.example.shopping.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

    @Autowired
    private OrderDao orderDao;

    public Page4Navigator<Order> list(int start , int size , int navigatePages){
        Sort sort = new Sort(Sort.Direction.ASC , "id");
        Pageable pageable = PageRequest.of(start , size , sort);
        Page pageFromJpa = orderDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJpa,navigatePages);
    }

    public void update(Order order){
        orderDao.save(order);
    }

    public Order get(int oid){
        return orderDao.getOne(oid);
    }

    private void removeOrderFromOrderItem(Order order){
        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem orderItem:orderItems){
            orderItem.setOrder(null);
        }
    }

    public void removeOrderFromOrderItem(List<Order> orders){
        for(Order order:orders){
            removeOrderFromOrderItem(order);
        }
    }
}
