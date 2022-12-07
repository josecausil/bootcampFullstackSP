package com.sophos.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.challenge.entity.Product;
import com.sophos.challenge.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    ProductService productoservice;

    @GetMapping("{id_Customer}")
    public ResponseEntity<List<Product>> getAllProdctByIdCustumer (@PathVariable("id_Customer")int id_Customer){
        return ResponseEntity.ok(productoservice.findAllByCustomer(id_Customer));
    }

    
}
