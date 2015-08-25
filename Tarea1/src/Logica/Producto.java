
package Logica;


public class Producto {
    private String nombre;
    private String descripcion;
    private Restaurante restaruante;
    //private File imagen;
   
    //imagen
    public Producto(String nombre, String descripcion, Restaurante restaurante){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.restaruante=restaurante;
    }
    
    public String getnombre(){
        return nombre;
    }
    public String getdescripcion(){
        return descripcion;
    }
    
    public String nombreRestaurante(){
        return this.restaruante.getnickname();
    }

    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setdescripcion(String descripcion){
        this.descripcion=descripcion;
    }
 
}
