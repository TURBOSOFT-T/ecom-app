package com.ipsas.gi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ipsas.gi.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;



}