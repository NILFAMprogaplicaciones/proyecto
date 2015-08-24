
package Logica;


public class Producto {
    private String nombre;
    private String descripcion;
    private String precio;
   
    //imagen
    public Producto(String nombre, String descripcion, String precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
    }
    
    public String getnombre(){
        return nombre;
    }
    public String getdescripcion(){
        return descripcion;
    }
    public String getprecio(){
        return precio;
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setdescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setprecio(String precio){
        this.precio=precio;
    }
}
