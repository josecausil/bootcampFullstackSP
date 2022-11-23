import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Challenge1 {
    private static String[] phone = {"0","1","2","3","4","5","6","7","8","9"}; 
    
    
    public static String generateNumber(String type ){
    String string = "";
    if(type.equals("A")){
        string="54";
        for(int i =0; i<8; i++){
            string += phone[(int)(Math.random()*phone.length)];       
        }
    }else if(type.equals("B")){
        string ="08";
        for(int i =0; i<8; i++){
            string += phone[(int)(Math.random()*phone.length)];       
        }
    }
   
    return string;
    }

    
    public static boolean assignNumber (String num,List <Cliente> listaNumber){
        boolean available=false;
        
        for(int i=0;i < listaNumber.size();i++){

            if(num.equals(listaNumber.get(i).toString())){
                available =true;
                break;
            }else{
                available=false;
            }
        }
       

        return available;


    }

    public static Cliente generateCliente(String type){
        Cliente objClient = new Cliente(generateNumber(type));

        return objClient;

    }

}


