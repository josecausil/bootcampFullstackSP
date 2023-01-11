package com.sophos.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.challenge.entity.Product;
import com.sophos.challenge.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> findAllByCustomer(int idCustomer){
        List<Product> productResponse =new ArrayList<>();
        List<Product> product = productRepository.findAll();
        for(int i=0;i<product.size();i++){
            if(product.get(i).getCustomer().getIdCustomer()==idCustomer){
                productResponse.add(product.get(i));
            }
        }
        return productResponse;
    }

    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }


    @Override
    public Optional<Product> getProductById(int idAccount) {
        return productRepository.findById(idAccount);
    }

 

  


    
}
