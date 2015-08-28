
package Logica;


public class Individual extends Producto{
    private double precio; 
    private String nombre;
    private String descripcion;
    
    public Individual(Restaurante restaurante,String nombre, String descripcion,  double precio){
        //SUPER LLAMA AL CONSTRUCTOR DE PRODUCTO
        super(nombre, descripcion, restaurante);
        this.precio = precio;
    }  
    
    public double getPrecio(){
        return precio;   
    }
    
   
    public void setprecio(double precio){
       this.precio = precio;
    }
    
    
    public void setnombre(String nombre){
      this.setNombre(nombre);
    }
    
   
    public void setdescripcion(String descripcion){
        this.setDescripcion(descripcion);
    }
    public void setdescripcion(Restaurante res){
        this.setRestaurante(res);
    }
}
