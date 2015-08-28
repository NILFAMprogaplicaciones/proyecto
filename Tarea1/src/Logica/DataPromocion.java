
package Logica;

import java.util.HashMap;
import java.util.Map;

public class DataPromocion {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    private boolean activa;
    private double  descuento;
    private double  precioTotal;
    private Map<String,Producto>     ColeccionProducto=new HashMap<String,Producto>();
    
    public DataPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map coleccionProducto){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.restaurante=res;
        this.activa=activa;
        this.descuento=descuento;
        this.precioTotal=precioTotal;
        //copia una coleccion entera de una a otra
        this.ColeccionProducto.putAll(coleccionProducto);
    
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Restaurante getRestaurante(){
        return this.restaurante;
    }
    public boolean getActiva(){
        return activa;
    }
    public double getDescuento(){
        return descuento;
    }
    public double getPrecioTotal(){
        return precioTotal;
    }
    public Map getColeccionProducto(){
        return ColeccionProducto;
    }
}
