package estacionamiento;

// Importación Librerias
import ucn.*;
import java.io.*;

public class App implements IApp{
    
    // Inicialización Lista Estacionamientos
    private ListaEstacionamientos ListaE;

    public App(){
        ListaE = new ListaEstacionamientos(150);
    }
    
    // Inicializacion relleno de lista
    public void rellenoLista() {
    int i;
    for(i=0;i<150;i++){
        Estacionamiento estacionamiento = new Estacionamiento(i,0,"Disponible",null);
        ListaE.RellenarEstacionamientoI(i, estacionamiento);
    }
    }
    
    // Inicialización Procedimiento para leer archivo resumenDiario.txt
    public void LeerResumenDiario(){
        try{
            FileReader f = new FileReader("resumenDiario.txt");
            BufferedReader  br = new BufferedReader(f);
            String linea;
            boolean x=true;
            int ind =0;
            int i;
            while((linea=br.readLine())!=null){
                String[] campos = linea.split(" ");
   
                String TipoEstacionamiento = campos[0];
                int Tipo = Integer.parseInt(TipoEstacionamiento);
                
                String NumEstacionamiento  = campos[1];
                int Num = Integer.parseInt(NumEstacionamiento);
           
                String Patente             = campos[2];
                String HoraIngreso         = campos[3];
                
                // Tipo Lento
                if(Tipo==1){
                    if(ListaE.setCantELento()==true){
                       Vehiculo V = new Vehiculo(Patente,HoraIngreso,"D1");
                       Estacionamiento E = new Estacionamiento(Num, Tipo,"Ocupado", V);
                       ListaE.ingresarEstacionamientoI(Num-1, E);
                       ind++; 
                    }
                }
                
                // Tipo Medio
                if(Tipo==2){
                    if(ListaE.setCantEMedio()==true){
                       Vehiculo V = new Vehiculo(Patente,HoraIngreso,"D1");
                       Estacionamiento E = new Estacionamiento(Num, Tipo,"Ocupado", V);
                       ListaE.ingresarEstacionamientoI(Num-1, E);
                       ind++; 
                    }
                }
                
                // Tipo Rápido
                if(Tipo==3){
                    if(ListaE.setCantERapido()==true){
                       Vehiculo V = new Vehiculo(Patente,HoraIngreso,"D1");
                       Estacionamiento E = new Estacionamiento(Num, Tipo,"Ocupado", V);
                       ListaE.ingresarEstacionamientoI(Num-1, E);
                       ind++; 
                    }
                }
            }
       
            System.out.println("");
            }
            // En caso de que no encuentre un archivo existente de resumen
            catch (IOException ex) {
            System.out.println("Nota: No se encontró archivo, se asume primer uso.");
        }   
        
    }
    
    // Función que evalua el tiempo de estacionamiento
    // y retorna el tipo de estacionamiento como int
    public static int EvaluarTiempoEstacionamiento(int TiempoE){
        if(TiempoE<=20){
          return 3; // Rápido
        }
        if((TiempoE>20)&&(TiempoE<=40)){
          return 2; // Medio
        }
        if((TiempoE>40)){
          return 1; // Lento
        }
        return -1;}
    
    // Función que retorna el tipo de estacionamiento como palabra String
    // usando el tipo de estacionamiento como int
    public static String TipoEstacionamientoString(int TEstacionamiento){
        String A = "";
        if(TEstacionamiento==1){
            A = "Lento";
        }
        if(TEstacionamiento==2){
            A = "Medio";
        }
        if(TEstacionamiento==3){
            A = "Rápido";
        }
        return A;}
    
    // Función que retorna la hora de la parte de un string con formato (HHmm)
    public static int getStringHora(String Hora){
        int len  = Hora.length();
        String a = Hora.substring(0, Hora.length()/ 2);
        len      = Integer.parseInt(a);
        return len;
    }
    
    // Función que retorna los minutos de la parte de un string con formato (HHmm)
    public static int getStringMinutos(String Hora){
        int len  = Hora.length();
        String b = Hora.substring(Hora.length()/ 2);
        len      = Integer.parseInt(b);
        return len;
    }
    
    // Función que calcula los minutos de una hora
    public static int cantMinutosHora(int Horas, int Minutos){
        int minutos = ((Horas*60)+(Minutos));
        return minutos;
    }
    
    // Función que calcula la deuda de un vehículo del estacionamiento
    public static int CalculoDeudaVehiculo(int minutosInicio, int minutosFin, Estacionamiento E){
        
        // Tipo Rápido
        if(E.getCategoria()==3){
            if(E.getVehiculo().getTiempoPermanencia().equals("D1")){
                return (25000);
            }
            else{
                if((minutosFin-minutosInicio)<=20){
                    return 0;
                }
                if(((minutosFin-minutosInicio)>=21)&&((minutosFin-minutosInicio)<=40)){
                    return 500;
                }
                if(((minutosFin-minutosInicio)>=41)){
                    return 1500;
                }
            }
        }
        
        // Tipo Medio
        if(E.getCategoria()==2){
            if(E.getVehiculo().getTiempoPermanencia().equals("D1")){
                return (25000);
            }
            else{
                if(((minutosFin-minutosInicio)>=21)&&((minutosFin-minutosInicio)<=40)){
                    return 0;
                }
                if(((minutosFin-minutosInicio)>=41)){
                    return 1000;
                }
            }
        }
        
        // Tipo Lento
        if(E.getCategoria()==1){
            if(E.getVehiculo().getTiempoPermanencia().equals("D1")){
                return (25000);
            }
            else{
                if((minutosFin-minutosInicio)>=120){
                    return 5000;
                }
                else{
                    return 0;
                }
            }
        }
        return -1;
    }
    
    // Procedimiento que permite ingresar un vehículo a la lista de estacionamientos
    public void IngresoVehiculo(){
        int i;
        System.out.println("");
        System.out.println("Ingrese Patente: ");
        String Patente = StdIn.readString();

        System.out.println("Hora de Ingreso: ");
        String HoraIngreso = StdIn.readString();
        
        
        System.out.println("Tiempo Estimado: ");
        int TEstimado = StdIn.readInt();
        String TiempoEstimado = Integer.toString(TEstimado);
        
        System.out.println("");
        System.out.println("Nota: Estacionamiento "+TipoEstacionamientoString(EvaluarTiempoEstacionamiento(TEstimado)));
        Vehiculo V = new Vehiculo(Patente, HoraIngreso, TiempoEstimado);
        int x = ListaE.ingresarEstacionamiento(V,EvaluarTiempoEstacionamiento(TEstimado));
        System.out.println("Nota: Asignado estacionamiento número "+(x+1));

        
    }
    
    // Procedimiento que permite realizar el retiro de un vehículo
    // de la lista de estacionamientos
    public void SalidaVehiculo(){
        int i;
        System.out.println("");
        System.out.println("Ingrese Patente '-1 para cancelar': ");
        
        String Patente = StdIn.readString();
        if(!Patente.equals("-1")){
        System.out.println("Ingrese Hora de Salida: ");
        String HoraSalida = StdIn.readString();
        
        int horasSalida  = getStringHora(HoraSalida);
        int minutoSalida = getStringMinutos(HoraSalida); 
        int hSalida = cantMinutosHora(horasSalida, minutoSalida);
        
        int Posicion = ListaE.BuscarVehiculoI(Patente);
        
        if(Posicion!=(-1)){
            int TipoEstacionamiento = ListaE.getEstacionamientoI(Posicion).getCategoria();
            System.out.println("");
            System.out.println("Nota: Tipo Estacionamiento   : "+TipoEstacionamientoString(TipoEstacionamiento));
            System.out.println("Nota: Numero Estacionamiento : "+(ListaE.getEstacionamientoI(Posicion).getnEstacionamiento()));
            String HoraIngreso =  ListaE.getEstacionamientoI(Posicion).getVehiculo().getHoraIngreso();
            int horasIngreso  = getStringHora(HoraIngreso);
            int minutoIngreso = getStringMinutos(HoraIngreso);
            int hIngreso = cantMinutosHora(horasIngreso, minutoIngreso);
            int DeudaVehiculo = CalculoDeudaVehiculo(hIngreso, hSalida, ListaE.getEstacionamientoI(Posicion));
            
            // Si el tipo de estacionamiento es:
            
            // Tipo de Estacionamiento Rápido
            if(TipoEstacionamiento==3){
                if(DeudaVehiculo==0){
                    System.out.println("Nota: Hora Ingreso: "+HoraIngreso);
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==500){
                    System.out.println("Nota: Multa Rápido a Medio (Hora Ingreso: "+HoraIngreso+")");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==1500){
                    System.out.println("Nota: Multa Rápido a Lento (Hora Ingreso: "+HoraIngreso+")");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==25000){
                    System.out.println("Nota: Multa Estadía Dia Anterior");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
            }
            
            // Tipo de Estacionamiento Medio
            if(TipoEstacionamiento==2){
                if(DeudaVehiculo==0){
                    System.out.println("Nota: Hora Ingreso: "+HoraIngreso);
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==1000){
                    System.out.println("Nota: Multa Medio a Lento (Hora Ingreso: "+HoraIngreso+")");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==25000){
                    System.out.println("Nota: Multa Estadía Dia Anterior");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
            }
            
            // Tipo de Estacionamiento Lento
            if(TipoEstacionamiento==1){
                if(DeudaVehiculo==0){
                    System.out.println("Nota: Hora Ingreso: "+HoraIngreso);
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda); 
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==5000){
                    System.out.println("Nota: Multa Abuso Estacionamiento Lento");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
                if(DeudaVehiculo==25000){
                    System.out.println("Nota: Multa Estadía Dia Anterior");
                    System.out.println("Nota: Valor Multa : "+DeudaVehiculo);
                    Multa deuda = new Multa(Patente,DeudaVehiculo);
                    // Registra la multa
                    ListaE.getListaMultas().InsertarMulta(deuda);
                    // Deja el estacionamiento disponible
                    ListaE.getEstacionamientoI(Posicion).setEstado("Disponible");
                    ListaE.getEstacionamientoI(Posicion).setVehiculo(null);
                }
            }
        }
        else{System.out.println("No existe Vehículo");}
        }
        else{System.out.println("Salida Cancelada");}
    }
    
    // Funcion que imprime en pantalla los vehículos que aun permanecen en el estacionamiento y
    // las multas cobradas.
    // Además actualiza el archivo resumenDiario.txt
    public void CierreOperaciones(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        int i;
            int VehiculosEstacionados = ListaE.getCantidadEstacionamientos();
            int MultasCobradas = ListaE.getListaMultas().getCantMultas();
            System.out.println("");
            System.out.println("Nota: Vehículos Estacionados: "+ VehiculosEstacionados);
            System.out.println("Nota: Multas Cobradas       : "+ MultasCobradas);
            for(i=0;i<ListaE.getListaMultas().getMax();i++){
                if(ListaE.getListaMultas().getMulta(i)!=null){
                    String Patente = ListaE.getListaMultas().getMulta(i).getPatenteVehiculo();
                    int Deuda = ListaE.getListaMultas().getMulta(i).getValorMulta();
                    System.out.println("Nota: "+Patente+" = "+"$"+Deuda+".");
                }
            }
        try {
            fichero = new FileWriter("resumenDiario.txt");
            pw = new PrintWriter(fichero);  
            for(i=0;i<ListaE.getMax();i++){
                if(ListaE.getEstacionamientoI(i).getEstado().equals("Ocupado")){
                    String Cadena = (ListaE.getEstacionamientoI(i).getCategoria()+" "+(ListaE.getEstacionamientoI(i).getnEstacionamiento())+" "
                                    +ListaE.getEstacionamientoI(i).getVehiculo().getPatente()+" "+ListaE.getEstacionamientoI(i).getVehiculo().getHoraIngreso());
                    pw.println(Cadena);} 
            }
            pw.close();
            
        } catch (Exception e) {
            System.out.println("No se pudo generar resumenDiario.txt");            
        }
    }  
}
