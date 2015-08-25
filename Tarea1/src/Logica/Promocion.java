
package Logica;

import java.util.HashMap;
import java.util.Map;


public class Promocion extends Producto {
    private boolean activa;
    private int     cantidad;
    private double  descuento;
    private Map<String,Producto>     ColeccionProducto=new HashMap<String,Producto>();
    
    public Promocion(String nombre, String descripcion, String precio, boolean activa, int cantidad, double descuento){
        super(nombre, descripcion, precio);
        this.activa=activa;
        this.cantidad=cantidad;
        this.descuento=descuento;
    
    }
    
    public void addProducto(String nombre, Producto producto){
        ColeccionProducto.put(nombre, producto);
    }
    public boolean getactiva(){
        return activa;
    }
    public int getcantidad(){
        return cantidad;
    }
    public double getdescuento(){
        return descuento;
    }
    
    public void setactiva(boolean activa){
        this.activa=activa;
    }
    public void setcantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public void setdescuento(double descuento){
        this.descuento=descuento;
    }
        
}
