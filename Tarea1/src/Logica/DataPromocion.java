
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataPromocion {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    private boolean activa;
    private int  descuento;
    private double  precioTotal;
    private File    foto;
    private String direccionFoto;
    private Map<String,DataCantidad>     CantidadProductos=new HashMap<String,DataCantidad>();
    
    
    public DataPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, int descuento, Map CantidadProductos,File foto, String direccionFoto){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.restaurante=res;
        this.activa=activa;
        this.descuento=descuento;
        this.precioTotal=precioTotal;
        this.foto=foto;
        //copia una coleccion entera de una a otra
        this.CantidadProductos.putAll(CantidadProductos);
        this.direccionFoto=direccionFoto;
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
    public int getDescuento(){
        return descuento;
    }
    public double getPrecioTotal(){
        return precioTotal;
    }
    public Map getColeccionProducto(){
        return CantidadProductos;
    }
    public File getImagen(){
        return foto;
    }
    public String getDireccionFoto(){
        return direccionFoto;
    }
}