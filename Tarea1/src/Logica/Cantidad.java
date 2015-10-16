
package Logica;


public class Cantidad {
    private int cantidad;
    private Promocion promocion;
    private Individual individual;
    
    public Cantidad(int cantidad, Promocion promocion, Individual individual){
        this.cantidad=cantidad;
        this.promocion=promocion;
        this.individual=individual;
    }
    public int getcantidad(){
        return cantidad;
    }
    
}
