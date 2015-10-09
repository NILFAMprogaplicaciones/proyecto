
package Logica;

import java.io.File;


public class DataIndividual {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    private double precio;
    private File imagen;
    private String direccionFoto;
    
    public DataIndividual(String nombre, String descripcion, Restaurante restaurante, double precio, File imagen, String direccionFoto){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.restaurante=restaurante;
        this.precio=precio;
        this.imagen=imagen;
        this.direccionFoto=direccionFoto;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }    
    public Restaurante getRestaurante(){
        return restaurante;
    }
    public double getPrecio(){
        return precio;
    }
    public File getImagen(){
        return imagen;
    }
    public String getDireccionFoto(){
        return direccionFoto;
    }
}


