package com.sophos.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.challenge.data.MovingProcesses;
import com.sophos.challenge.entity.Product;
import com.sophos.challenge.entity.Transaction;
import com.sophos.challenge.service.ProductService;
import com.sophos.challenge.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ProductService productservice;



    @GetMapping("{id_Product}")
    public ResponseEntity<List<Transaction>> getAllTransactionByIdProduct (@PathVariable("id_Product")int id_Product){
        return ResponseEntity.ok(transactionService.findAllByProduct(id_Product));
    }

    
    @PostMapping
    public ResponseEntity<Transaction> createProduct(@RequestBody Transaction transaction){   
         try {                  
              Optional<Product> ProductData =  productservice.getProductById(transaction.getProduct().getIdAccount());
               if(ProductData.isPresent()){
                Product _product = ProductData.get();
             
                if(transaction.getMovementType().equals("Consignacion")){
                   int updatedBalance =  MovingProcesses.consignMoney(transaction.getValueTransfer(), _product);
                    if (updatedBalance != _product.getAvailableBalance()) {
                        transaction.setTypeTransaction("Credito");  
                        transaction.setBalance(_product.getBalance());
                        transaction.setAvailableBalance(_product.getAvailableBalance());              
                        _product.setAvailableBalance(updatedBalance);
                        _product.setBalance(_product.getAvailableBalance());
                        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED); 
                    }else{
                        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
                    }
               
                }else if(transaction.getMovementType().equals("Retiro")){
                    int updatedBalance =  MovingProcesses.winthdrawMoney(transaction.getValueTransfer(), _product);
                    if (updatedBalance != _product.getAvailableBalance()) {
                        transaction.setTypeTransaction("Debito");   
                        transaction.setBalance(_product.getBalance());
                        transaction.setAvailableBalance(_product.getAvailableBalance());    
                        _product.setAvailableBalance(updatedBalance);
                        _product.setBalance(_product.getAvailableBalance());
                        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED); 

                    }else{
                        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 

                    }

                }else if(transaction.getMovementType().equals("Transferencia")){
                    Optional<Product> ProductData2 =  productservice.getProductById(transaction.getIdReceptionAccount());
                    if(ProductData2.isPresent()){
                    Product _product2 = ProductData2.get();
                    int updatedBalanceAccountOrigin =  MovingProcesses.winthdrawMoney(transaction.getValueTransfer(), _product);
                    int updatedBalanceAccountDestiny =  MovingProcesses.consignMoney(transaction.getValueTransfer(), _product2);
                    if (updatedBalanceAccountOrigin != _product.getAvailableBalance() && updatedBalanceAccountDestiny!= _product2.getAvailableBalance()) {

                        
                        //Origin
                        transaction.setTypeTransaction("Debito");   
                        transaction.setBalance(_product.getBalance());
                        transaction.setAvailableBalance(_product.getAvailableBalance());    
                        _product.setAvailableBalance(updatedBalanceAccountOrigin);
                        _product.setBalance(_product.getAvailableBalance());
                     
                        //destiny   
                              
                        _product2.setAvailableBalance(updatedBalanceAccountDestiny);
                        _product2.setBalance(_product2.getAvailableBalance());

                        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED); 
    

                    }else{
                        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
                    }
                                 
                }
             
              }     
                
             }

               return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED); 
               
         } catch (Exception e) {
               return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
         }              
    }


 @PostMapping("/reception")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){  

        try {                  
            Optional<Product> ProductData =  productservice.getProductById(transaction.getIdReceptionAccount());
             if(ProductData.isPresent()){
              Product _product = ProductData.get();

              transaction.setTypeTransaction("Credito");   
              transaction.setBalance(_product.getBalance()-transaction.getValueTransfer());
              transaction.setAvailableBalance(_product.getAvailableBalance()-transaction.getValueTransfer());    
              transaction.setDescription("Transferencia desde: "+transaction.getProduct().getAccountNumber());
              transaction.setProduct(_product);
            
            }

            return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED); 
            
      } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
      }              
    }


    
}
