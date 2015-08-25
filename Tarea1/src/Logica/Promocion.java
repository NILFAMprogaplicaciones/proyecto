
package Logica;

import java.util.HashMap;
import java.util.Map;


public class Promocion extends Producto {
    private boolean activa;
    private double  descuento;
    private double  precioTotal;
    private Map<String,Producto>     ColeccionProducto=new HashMap<String,Producto>();
    
    public Promocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map coleccionProducto){
        super(nombre, descripcion,res);
        this.activa=activa;
        this.descuento=descuento;
        this.precioTotal=precioTotal;
        //copia una coleccion entera de una a otra
        this.ColeccionProducto.putAll(coleccionProducto);
    
    }
    
    public void addProducto(String nombre, Producto producto){
        ColeccionProducto.put(nombre, producto);
    }
    public boolean getactiva(){
        return activa;
    }
    
    public double getdescuento(){
        return descuento;
    }
    
    public void setactiva(boolean activa){
        this.activa=activa;
    }
   
    public void setdescuento(double descuento){
        this.descuento=descuento;
    }
        
}
