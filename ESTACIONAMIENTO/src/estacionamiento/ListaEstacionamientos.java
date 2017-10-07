package estacionamiento;

// Clase Lista Estacionamientos
public class ListaEstacionamientos {
    // Atributos
    private Estacionamiento LE[];
    private ListaMultas LD;                 // Contiene una lista de multas
    private int cantidadEstacionamientos;
    private int cantidadELento;
    private int cantidadEMedio;
    private int cantidadERapido;
    private int max;
    
    // Constructor
    public ListaEstacionamientos(int max) {
        LE = new Estacionamiento[max];
        LD = new ListaMultas(max);
        cantidadEstacionamientos = 0;
        this.max = max;
    }
    
    // Gets y Sets
    public int getCantidadEstacionamientos() {
        return cantidadEstacionamientos;
    }
    
    public int getCantELento(){
        return cantidadELento;
    }
    
    public int getCantEMedio(){
        return cantidadEMedio;
    }
    
    public int getCantERapido(){
        return cantidadERapido;
    }
    
    public ListaMultas getListaMultas() {
        return LD;
    }

    public void setListaMultas(ListaMultas LD) {
        this.LD = LD;
    }

    public int getMax() {
        return max;
    }
    
    public boolean setCantELento(){
        boolean x;
        if(cantidadELento<=50){
           cantidadELento++;
           return true;
        }
        else{return false;}
    }
    
    public boolean setCantEMedio(){
        boolean x;
        if(cantidadEMedio<=50){
           cantidadEMedio++;
           return true;
        }
        else{return false;}
    }
    
    public boolean setCantERapido(){
        boolean x;
        if(cantidadERapido<=50){
           cantidadERapido++;
           return true;
        }
        else{return false;}
    }
    
    // Procedimiento que inserta un estacionamiento null en la lista
    public void setEstacionamientonullI(int i){
        LE[i] = null;
    }
    
    // Procedimiento que rellena con un estacionamiento específico
    // en una posición i
    public void RellenarEstacionamientoI(int i, Estacionamiento E){
        LE[i] = E;
    }
    
    // Procedimiento que ingresa un estacionamiento en una posición i
    // y además se le adiciona 1 unidad a la cantidad de estacionamientos
    public void ingresarEstacionamientoI(int i, Estacionamiento E){
        LE[i] = E;
        cantidadEstacionamientos++;
    }
    
    // Función que retorna un estacionamiento ubicado en una posición i
    public Estacionamiento getEstacionamientoI(int i){
       return LE[i];
    }
    
    // Funcion que ingresa un estacionamiento con un vehículo y un tipo.
    // Retorna la posiciónn en que se ingreso ese estacionamiento.
    public int ingresarEstacionamiento(Vehiculo V,int Tipo){
        //for para buscar un disponible
        int i;
        for(i=0;i<max;i++){
            if(LE[i].getEstado().equals("Disponible"))
                break;
        }
        //retornar posicion
        //siguiente la inserta, considerando no sobrepasar max (151)
        Estacionamiento E;
        
        // Tipo Lento
        if(Tipo == 1){
            if (cantidadEstacionamientos < max){
                if(cantidadELento<=50){
                    E = new Estacionamiento(i+1,1,"Ocupado",V);
                    LE[i] = E;
                    cantidadEstacionamientos++;
                    cantidadELento++;
                }
            }
            else{
                System.out.println("¡Estacionamiento Tipo Lento Lleno!");
            }
        }
        
        // Tipo Medio
        if(Tipo == 2){
            if (cantidadEstacionamientos < max){
                if(cantidadEMedio<=50){
                    E = new Estacionamiento(i+1,2,"Ocupado",V);
                    LE[i] = E;
                    cantidadEstacionamientos++;
                    cantidadEMedio++;
                }
            }
            else{
                System.out.println("¡Estacionamiento Tipo Medio Lleno!");
                
            }
        }
        
        // Tipo Rápido
        if(Tipo == 3){
            if (cantidadEstacionamientos < max){
                if(cantidadERapido<=50){
                    E = new Estacionamiento(i+1,3,"Ocupado",V);
                    LE[i] = E;
                    cantidadEstacionamientos++;
                    cantidadERapido++;
                }
            }
            else{
                System.out.println("¡Estacionamiento Tipo Rápido Lleno!");
            }
        }
        
        return i;
    }
    
    // Funcion que busca un vehículo en una posición i usando la patente
    // retorna un valor i si lo encontró, o un -1 si no
    public int BuscarVehiculoI(String Patente){
        int i;
        for(i=0;i<150;i++){
            if(LE[i].getVehiculo().getPatente().equals(Patente)){
                return i;
            }
        }
        return -1;
    }

}
