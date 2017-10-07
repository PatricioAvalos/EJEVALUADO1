package estacionamiento;

// Clase Multa
public class Multa {
    
    // Atributos
    private String PatenteVehiculo;
    private int ValorMulta;
    
    // Constructor
    public Multa(String PatenteVehiculo, int ValorDeuda){
        this.PatenteVehiculo=PatenteVehiculo;
        this.ValorMulta=ValorDeuda;
    }
    
    // Gets y Sets
    public String getPatenteVehiculo() {
        return PatenteVehiculo;
    }

    public void setPatenteVehiculo(String PatenteVehiculo) {
        this.PatenteVehiculo = PatenteVehiculo;
    }

    public int getValorMulta() {
        return ValorMulta;
    }

    public void setValorMulta(int ValorDeuda) {
        this.ValorMulta = ValorDeuda;
    }
    
    
}
