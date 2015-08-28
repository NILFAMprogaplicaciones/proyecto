
package Logica;


/*abstract*/ public class Producto {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    //private File imagen;
   
    //imagen
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
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDescripcion(String nombre){
        this.descripcion=nombre;
    } 
    public void setRestaurante(Restaurante res){
        this.restaurante=res;
    }/*
    public void setNombre(String nombre){
        this.nombre=nombre;
    }abstract public void setnombre(String nombre);//{
        //this.nombre=nombre;
    //}
    abstract public void setdescripcion(String descripcion);//{
        //this.descripcion=descripcion;
   // }
    abstract public void setprecio(double precio);
    */
    
}
