
package Logica;

import java.util.Map;


public interface IControladorProducto {
    
    public abstract void AltaProductoIndividual(DataIndividual dataindividual);
    
    
    
    public abstract void AltaProductoPromocion(DataPromocion datapromocion);
    public abstract DataIndividual Caso_Ver_Individual(String nombre);
}
