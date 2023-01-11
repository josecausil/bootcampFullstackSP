package com.sophos.challenge.data;

import com.sophos.challenge.entity.Product;

public class MovingProcesses {
    
    public  static int consignMoney(int amount, Product product) {
        int updatedBalance= product.getAvailableBalance() ;
        if(product.getTypeAccount().equals("Ahorros")){
            updatedBalance = product.getAvailableBalance()+amount;
           return updatedBalance;
        }else if(product.getTypeAccount().equals("Corriente")){
            if((product.getAvailableBalance()+amount)<=0 ){
                updatedBalance= product.getAvailableBalance()+amount;
                }
                return updatedBalance;
        }

        return updatedBalance;
    }

    public static int winthdrawMoney(int amount, Product product){
        int updatedBalance= product.getAvailableBalance() ;
        if(product.getTypeAccount().equals("Ahorros")){ 
            if(amount<=product.getAvailableBalance()  && product.getAccountStatus().equals("Activa")){
                updatedBalance= product.getAvailableBalance()-amount;
                return updatedBalance;
            
            }
        
        }else if(product.getTypeAccount().equals("Corriente" )){
            if((product.getAvailableBalance()-amount) >=(-3000000) && product.getAccountStatus().equals("Activa")){
                updatedBalance= product.getAvailableBalance()-amount;
                }
                return updatedBalance;
        }

        return updatedBalance;
    }


    public static boolean statusChange(Product product){
        if(product.getBalance()==0){
            return true;
        }else{
            return false;

        }
        
    }

}
