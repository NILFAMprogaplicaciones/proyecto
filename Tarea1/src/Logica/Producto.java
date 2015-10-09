
package Logica;


public class Producto {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    private String direccionFoto;
    
    public Producto(String nombre, String descripcion, Restaurante restaurante, String direccion){
        this.setnombre(nombre);
        this.setdescripcion(descripcion);
        this.restaurante=restaurante;
        this.direccionFoto=direccion;
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
    
    public String getDireccionFoto(){
        return direccionFoto;
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setdescripcion(String descripcion){
        this.descripcion=descripcion;
    }
 
}
