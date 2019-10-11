package com.example.shopping.controller;

import com.example.shopping.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

}
