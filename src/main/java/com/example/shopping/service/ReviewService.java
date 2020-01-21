package com.example.shopping.service;

import com.example.shopping.dao.ReviewDao;
import com.example.shopping.pojo.Product;
import com.example.shopping.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewDao reviewDao;
    @Autowired ProductService productService;

    public void add(Review review) {
        reviewDao.save(review);
    }

    public List<Review> list(Product product){
        List<Review> result =  reviewDao.findByProductOrderByIdDesc(product);
        return result;
    }

    public int getCount(Product product) {
        return reviewDao.countByProduct(product);
    }
}
