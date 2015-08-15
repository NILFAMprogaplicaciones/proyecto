
package Logica;


public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    //imagen
    public Producto(String nombre, String descripcion, double precio){
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
    public double getprecio(){
        return precio;
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setdescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setprecio(double precio){
        this.precio=precio;
    }
}
