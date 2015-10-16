
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Promocion extends Producto {
    private boolean activa;
    private int  descuento;
    private double  precioTotal;
    private File    foto;
    private Map<String,DataCantidad>     ColeccionProducto=new HashMap<String,DataCantidad>();
    
    public Promocion(DataPromocion datapromocion){
        super(datapromocion.getNombre(),datapromocion.getDescripcion(),datapromocion.getRestaurante(),datapromocion.getDireccionFoto());
        this.activa=datapromocion.getActiva();
        this.descuento=datapromocion.getDescuento();
        this.precioTotal=datapromocion.getPrecioTotal();
        this.foto=datapromocion.getImagen();
        //copia una coleccion entera de una a otra
        this.ColeccionProducto.putAll(datapromocion.getColeccionProducto());
    
    }
    
    public void addProducto(String nombre, DataCantidad producto){
        ColeccionProducto.put(nombre, producto);
    }
    public boolean getactiva(){
        return activa;
    }
    
    public int getdescuento(){
        return descuento;
    }
    
    public void setactiva(boolean activa){
        this.activa=activa;
    }
   
    public void setdescuento(int descuento){
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
    public File getImagen(){
        return foto;
    }
        
}
