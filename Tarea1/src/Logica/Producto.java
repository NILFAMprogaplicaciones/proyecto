
package Logica;


public class Producto {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    
    public Producto(String nombre, String descripcion, Restaurante restaurante){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.restaurante=restaurante;
    }
    
    public String getnombre(){
        return nombre;
    }
    public String getdescripcion(){
        return descripcion;
    }
    
    public Restaurante getRestaurante(){
        return this.restaurante;
    }
    
    public String nombreRestaurante(){
        return this.restaurante.getnickname();
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setdescripcion(String descripcion){
        this.descripcion=descripcion;
    }
 
}
