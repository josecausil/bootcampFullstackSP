package com.sophos.challenge.service;

import java.util.List;
import java.util.Optional;

import com.sophos.challenge.entity.Product;

public interface ProductService {
   
    
    public List<Product> findAllByCustomer(int id_Customer);
    public Product createProduct(Product product);
    public Optional<Product> getProductById(int idAccount);
    public boolean deleteProductById(int id);
}
