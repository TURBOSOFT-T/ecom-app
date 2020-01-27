package com.ipsas.gi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipsas.gi.entities.ProductRepository;



@RestController
class ProductController{
	@Autowired
	private ProductRepository productRepository;
	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}
	
	
	@GetMapping(path = "/")
	public String index() {
	    return "external";
	}

	@GetMapping(path = "/products")
	public String products(Model model) {
	    //addproductss();
	    model.addAttribute("products", productRepository.findAll());
	    return "products";
	}
	
	
}