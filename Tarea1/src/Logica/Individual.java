
package Logica;

import java.io.File;


public class Individual extends Producto{
    private double precio;
    private File imagen;
    
    public Individual(DataIndividual dataindividual){
        //SUPER LLAMA AL CONSTRUCTOR DE PRODUCTO
        super(dataindividual.getNombre(),dataindividual.getDescripcion(), dataindividual.getRestaurante());
        this.precio = dataindividual.getPrecio();
        this.imagen = dataindividual.getImagen();
    }  
    
    public double getPrecio(){
        return precio;   
    }
    public File getImagen(){
        return imagen;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setImagen(File imagen){
        this.imagen=imagen;
    }
    
}
