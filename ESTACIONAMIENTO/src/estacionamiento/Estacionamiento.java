package estacionamiento;

// Clase Estacionamiento
public class Estacionamiento {
    private int nEstacionamiento;
    private int Categoria;
    private String Estado;
    private Vehiculo vehiculo;
    
    // Constructor
    public Estacionamiento(int n,int Categoria,String Estado,Vehiculo vehiculo){
        nEstacionamiento = n;
        this.Categoria   = Categoria;
        this.Estado      = Estado;
        this.vehiculo    = vehiculo;
    }
    
    // Gets y Sets
    public int getnEstacionamiento() {
        return nEstacionamiento;
    }

    public int getCategoria() {
        return Categoria;
    }

    public String getEstado() {
        return Estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
