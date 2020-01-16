package com.example.shopping.controller;

import com.example.shopping.pojo.Product;
import com.example.shopping.service.ProductImageService;
import com.example.shopping.service.ProductService;
import com.example.shopping.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductImageService productImageService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> get(@PathVariable("cid")int cid , @RequestParam(value="start" , defaultValue = "0")int start ,
                                       @RequestParam(value="size" , defaultValue = "5")int size)throws  Exception{
        start = start < 0 ? 0:start;
        Page4Navigator<Product> page = productService.list(cid , start , size , 5);
        productImageService.setFirstProdutImages(page.getContent());
        return page;
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id")int id)throws Exception{
        Product product = productService.get(id);
        return product;
    }

    @PostMapping("/products")
    public Object add(@RequestBody Product bean) throws Exception{
        bean.setCreateDate(new Date());
        productService.add(bean);
        return bean;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id")int id , HttpServletRequest request)throws Exception{
        productService.delete(id);
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product bean)throws Exception{
        productService.update(bean);
        return bean;
    }

}
