
package Logica;


public class Individual extends Producto{
    private double precio; 
    
    public Individual(DataIndividual dataindividual){
        //SUPER LLAMA AL CONSTRUCTOR DE PRODUCTO
        super(dataindividual.getNombre(),dataindividual.getDescripcion(), dataindividual.getRestaurante());
        this.precio = dataindividual.getPrecio();
    }  
    
    public double getPrecio(){
        return precio;   
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
}
