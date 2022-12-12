package com.sophos.challenge.data;

import java.time.LocalDate;
import java.time.Period;

import com.sophos.challenge.entity.Customer;

public class DateCalculator {
    

    public static boolean adult(Customer customer){
        int year =customer.getBirthDate().getYear();
        int month = customer.getBirthDate().getMonthValue();
        int day = customer.getBirthDate().getDayOfMonth();
        Period edad= Period.between(LocalDate.of(year,month, day), LocalDate.now());
        if(edad.getYears()>17){
            return true;
        }else{
            return false;
        }
     }
}
