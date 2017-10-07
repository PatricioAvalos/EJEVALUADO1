package estacionamiento;

// Clase Lista Multas
public class ListaMultas {
    
    // Atributos
    public Multa[] LMulta;
    public int cantMultas;
    public int max;
    
    // Constructor
    public ListaMultas(int max) {
        LMulta = new Multa[max];
        this.cantMultas = 0;
        this.max = max;
    }
    
    // Gets y Sets
    public Multa[] getLMulta() {
        return LMulta;
    }

    public void setLMulta(Multa[] LMulta) {
        this.LMulta = LMulta;
    }

    public int getCantMultas() {
        return cantMultas;
    }

    public void setCantMultas(int cantMultas) {
        this.cantMultas = cantMultas;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    // Procedimiento que inserta una multa en la lista multas
    public void InsertarMulta(Multa multa){
        if(cantMultas<max){
            LMulta[cantMultas] = multa;
            cantMultas++;
        }
        else{
            System.out.println("No se pudo ingresar deuda.");
        }
    }
    
    // Función que retorna un objeto multa usando una posición i
    public Multa getMulta(int i){
        return LMulta[i];
    }
    
}
