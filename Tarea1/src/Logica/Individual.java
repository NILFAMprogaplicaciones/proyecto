
package Logica;


public class Individual extends Producto{
    private double precio; 
    
    public Individual(Restaurante restaurante,String nombre, String descripcion,  double precio){
        //SUPER LLAMA AL CONSTRUCTOR DE PRODUCTO
        super(nombre, descripcion, restaurante);
        this.precio = precio;
    }  
    
    public double getPrecio(){
        return precio;   
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
}
