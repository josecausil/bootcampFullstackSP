package com.sophos.challenge.data;

public class AccountGenerator {
    private static String[] digits = {"0","1","2","3","4","5","6","7","8","9"}; 
        
    public static String generateNumber(String type ){
    String string = "";
    if(type.equals("Ahorro")){
        string="56";
        for(int i =0; i<8; i++){
            string += digits[(int)(Math.random()*digits.length)];       
        }
    }else if(type.equals("Corriente")){
        string ="23";
        for(int i =0; i<8; i++){
            string += digits[(int)(Math.random()*digits.length)];       
        }
    }
   
    return string;
    }
}
