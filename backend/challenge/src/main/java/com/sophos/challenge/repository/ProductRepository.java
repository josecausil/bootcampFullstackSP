package com.sophos.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sophos.challenge.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    
}
