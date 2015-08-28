
package Logica;

import java.util.HashMap;
import java.util.Map;


public class Promocion extends Producto {
    private boolean activa;
    private double  descuento;
    private double  precioTotal;
    private Map<String,Producto>     ColeccionProducto=new HashMap<String,Producto>();
    
    public Promocion(DataPromocion datapromocion){
        super(datapromocion.getNombre(),datapromocion.getDescripcion(),datapromocion.getRestaurante());
        this.activa=datapromocion.getActiva();
        this.descuento=datapromocion.getDescuento();
        this.precioTotal=datapromocion.getPrecioTotal();
        //copia una coleccion entera de una a otra
        this.ColeccionProducto.putAll(datapromocion.getColeccionProducto());
    
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
