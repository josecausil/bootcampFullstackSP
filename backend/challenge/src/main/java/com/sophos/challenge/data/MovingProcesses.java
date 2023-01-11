package com.sophos.challenge.data;

import com.sophos.challenge.entity.Product;

public class MovingProcesses {
    
    public  static Product consignMoney(int amount, Product product) {
        if(product.getTypeAccount().equals("Ahorros")){
            product.setAvailableBalance(product.getAvailableBalance()+amount);
           return product;
        }else if(product.getTypeAccount().equals("Corriente")){
            if((product.getAvailableBalance()+amount)<=0 ){
                product.setAvailableBalance(product.getAvailableBalance()+amount);
                }
                return product;
        }

        return product;
    }

    public static Product winthdrawMoney(int amount, Product product){


        if(product.getTypeAccount().equals("Ahorros")){ 
            if(amount<=product.getAvailableBalance()){
                product.setAvailableBalance(product.getAvailableBalance()-amount);
                return product;
            }
        
        }else if(product.getTypeAccount().equals("Corriente")){
            if((product.getAvailableBalance()-amount) <=(-3000000)){
                product.setAvailableBalance(product.getAvailableBalance()-amount);
                }
                return product;
        }


        return product;
    }

}
