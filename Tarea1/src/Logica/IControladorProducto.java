
package Logica;

import java.util.Map;


public abstract interface IControladorProducto {
    
    public abstract void AltaProductoIndividual(DataIndividual dataindividual);
    
    
    public abstract void AltaProductoPromocion(DataPromocion datapromocion);
    
    
    public abstract DataIndividual Caso_Ver_Individual(String nombre);
    
    public abstract DataPromocion Caso_Ver_Promocion(String nombre);

    
}
