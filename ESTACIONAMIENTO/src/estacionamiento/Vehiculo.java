package estacionamiento;

// Clase Vehiculo
public class Vehiculo {
    
    // Atributos
    private String Patente;
    private String HoraIngreso;
    private String TiempoPermanencia;
    
    // Constructor
    public Vehiculo(String Patente,String HoraIngreso,String TiempoPermanencia){
        this.Patente           = Patente;
        this.HoraIngreso       = HoraIngreso;
        this.TiempoPermanencia = TiempoPermanencia;
    }
    
    // Gets
    public String getPatente(){
        return Patente;
    }
    
    public String getHoraIngreso(){
        return HoraIngreso;
    }
    
    public String getTiempoPermanencia(){
        return TiempoPermanencia;
    }
    
    
}
