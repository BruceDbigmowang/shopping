package com.example.shopping.service;

import com.example.shopping.dao.UserDao;
import com.example.shopping.pojo.User;
import com.example.shopping.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Page4Navigator<User> list(int start , int size , int navigatePages){
        Sort sort = new Sort(Sort.Direction.ASC , "id");
        Pageable pageable = PageRequest.of(start , size , sort);
        Page pageFromJpa = userDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJpa , navigatePages);
    }

}
