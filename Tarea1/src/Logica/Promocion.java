
package Logica;

import java.util.HashMap;
import java.util.Map;


public class Promocion extends Producto {
    private boolean activa;
    private double  descuento;
    private double  precioTotal;
    private Map<String,DataCantidad>     ColeccionProducto=new HashMap<String,DataCantidad>();
    
    public Promocion(DataPromocion datapromocion){
        super(datapromocion.getNombre(),datapromocion.getDescripcion(),datapromocion.getRestaurante());
        this.activa=datapromocion.getActiva();
        this.descuento=datapromocion.getDescuento();
        this.precioTotal=datapromocion.getPrecioTotal();
        //copia una coleccion entera de una a otra
        this.ColeccionProducto.putAll(datapromocion.getColeccionProducto());
    
    }
    
    public void addProducto(String nombre, DataCantidad producto){
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
    
    public double getPrecioTotal (){
        return precioTotal;
    }
    
    public int CantidadProductos(){
        return ColeccionProducto.size();
    }
    
    public Map getColeccionProductos(){
        return ColeccionProducto;
    }
    
        
}
