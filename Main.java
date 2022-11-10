import java.util.ArrayList;

import java.util.Scanner;

public class Main {
 
 public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    ArrayList<Cliente> listaNumber ;
    String numero;
    boolean value;
    int opcion=0;
    listaNumber = new ArrayList<Cliente>();

    do{
    System.out.println("*****Menu*****");
    System.out.println("1) Generar numero tipo A (54)");
    System.out.println("2) Generar numero tipo B (08)");
    System.out.println("3) Mostrar en pantalla numeros existentes");
    System.out.println("4) salir");
    System.out.println("  Eliga una opcion");
    opcion = entrada.nextInt();
   
    switch (opcion) {

        case 1:
        numero = Challenge1.generateCliente("A").toString();
        value = Challenge1.assign(numero, listaNumber);
       
        if(value==false){
            Cliente c = new Cliente(numero);
            listaNumber.add(c);
            System.out.println("numero asignado exitosamente ");
            System.out.println("su linea es: "+numero);

        }else{
            System.out.println("lo sentimos, linea ya existente ");
        }
        break;
        case 2:
        numero = Challenge1.generateCliente("B").toString(); 
        value = Challenge1.assign(numero, listaNumber);
      
        if(value==false){
            Cliente c = new Cliente(numero);
            listaNumber.add(c);
            System.out.println("numero asignado exitosamente ");
            System.out.println("su linea es: "+numero);
        }else{
            System.out.println("lo sentimos, linea ya existente ");
        }
        break;
        case 3:

        for(int i =0; i< listaNumber.size();i++){
            System.out.println(listaNumber.get(i).toString());
        }
        
        break;

        default:
        System.out.println("Lo sentimos esta opcion no es validad");
    }
    entrada.nextLine();
    System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR..."); 
    entrada.nextLine(); 
  
}while(opcion !=4 );

 }

}