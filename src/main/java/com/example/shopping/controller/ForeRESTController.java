package com.example.shopping.controller;

import com.example.shopping.pojo.Category;
import com.example.shopping.pojo.User;
import com.example.shopping.service.CategoryService;
import com.example.shopping.service.ProductService;
import com.example.shopping.service.UserService;
import com.example.shopping.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ForeRESTController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/forehome")
    public Object home() {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        categoryService.removeCategoryFromProduct(cs);
        return cs;
    }

    @PostMapping("/foreRegister")
    public Object register(@RequestBody User user){
        String name =  user.getName();
        String password = user.getPassword();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);

        if(exist){
            String message ="用户名已经被使用,不能使用";
            return Result.fail(message);
        }
        user.setPassword(password);
        userService.add(user);
        return Result.success();
    }

    @PostMapping("/foreLogin")
    public Object login(@RequestBody User user , HttpSession session){
        String name = user.getName();
        name = HtmlUtils.htmlEscape(name);
        String password = user.getPassword();
        User user1 = userService.get(name , password);
        if(null == user1){
            String message ="账号密码错误";
            return Result.fail(message);
        }else{
            session.setAttribute("user", user);
            return Result.success();
        }

    }

}