package estacionamiento;

import java.io.*;

public class EVIVO {

    public static void main(String[] args)throws IOException{
                   
    App app = new App();
    app.rellenoLista();
    app.LeerResumenDiario();  
        
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("=========================================");
    System.out.println("     Control de Estacionamiento v1.0     ");
    System.out.println("=========================================");
    System.out.println(" (1) - Ingreso Vehiculo");
    System.out.println(" (2) - Salida Vehiculo" );
    System.out.println(" (3) - Cierre Operaciones " );    
        
    int op;
        do{  
            System.out.println("\nIngrese una opción del menú: " );
            op = Integer.parseInt(bf.readLine()); 
            switch(op){
                
                case 1: 
                    app.IngresoVehiculo();
                    System.out.println("");
                    System.out.println(" (1) - Ingreso Vehiculo");
                    System.out.println(" (2) - Salida Vehiculo" );
                    System.out.println(" (3) - Cierre Operaciones " ); 
                    break;
                case 2:
                    app.SalidaVehiculo();
                    System.out.println("");
                    System.out.println(" (1) - Ingreso Vehiculo");
                    System.out.println(" (2) - Salida Vehiculo" );
                    System.out.println(" (3) - Cierre Operaciones " ); 
                    break;
                case 3:
                    app.CierreOperaciones();
                    System.out.println("Usted está saliendo del menú..." );
                    break;    
                default:
                    System.out.println("OPCION NO VALIDA" );
                    break;               
            }
        }while( op != 3 );
     }
}