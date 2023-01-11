package com.sophos.challenge.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.challenge.data.AccountGenerator;

import com.sophos.challenge.entity.Product;

import com.sophos.challenge.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productservice;

    @GetMapping("{id_Customer}")
    public ResponseEntity<List<Product>> getAllProdctByIdCustumer (@PathVariable("id_Customer")int id_Customer){
        return ResponseEntity.ok(productservice.findAllByCustomer(id_Customer));
    }

    @GetMapping("account/{id_Account}")
    public ResponseEntity<Product> getProductById(@PathVariable("id_Account")int id_Account){
        return productservice.getProductById(id_Account)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        boolean condition=true;
         String typeaccount= product.getTypeAccount();
   
         try {
            do{
                if(typeaccount.equals("Ahorros")){
                    String AccountNumber= AccountGenerator.generateNumber("Ahorros");
                    String setAccount = "4"+AccountNumber;
                    product.setAccountStatus("Activa");
                    product.setAccountNumber(setAccount);
                    product.setIdAccount(Integer.parseInt(AccountNumber));

                 }else if(typeaccount.equals("Corriente")){
                    String AccountNumber= AccountGenerator.generateNumber("Corriente");
                    String setAccount = "2"+AccountNumber;
                    product.setAccountStatus("Inactiva");
                    product.setAccountNumber(setAccount);
                    product.setIdAccount(Integer.parseInt(AccountNumber));
                }
               Optional<Product> ProductData =  productservice.getProductById(product.getIdAccount());
               if(ProductData.isPresent()){
                   condition=true;           
                   } else  {
                       condition=false; 
                   }  
               }while(condition==true);  
               return new ResponseEntity<>(productservice.createProduct(product), HttpStatus.CREATED); 
         } catch (Exception e) {
               return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
         }

               
    }

    @PutMapping("{idAccount}")
    public ResponseEntity<Product> updateProduct(@PathVariable ("idAccount") int idAccount, @RequestBody Product item){
     Optional<Product> ProductData =  productservice.getProductById(idAccount);
     if(ProductData.isPresent()){
        Product _product = ProductData.get();
        _product.setAccountStatus(item.getAccountStatus());
        _product.setBalance(item.getBalance());
        _product.setAvailableBalance(item.getAvailableBalance());
             return new ResponseEntity<>(productservice.createProduct(_product), HttpStatus.OK);
     }else{
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
     }
  
   
  }

}
