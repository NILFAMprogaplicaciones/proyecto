
package Logica;

import java.util.Map;


public abstract interface IControladorProducto {
    
    public abstract void AltaProductoIndividual(DataIndividual dataindividual);
    
    
    public abstract void AltaProductoPromocion(DataPromocion datapromocion);
    
    
    public abstract DataIndividual Caso_Ver_Individual(String nombre);
    
    
    public abstract DataPromocion Caso_Ver_Promocion(String nombre);
    
    
    public abstract void Caso_Actualizar_Individual(String nombreproducto,DataIndividual dataindividual);
    
    
    public abstract void Caso_Actualizar_Promocion(String nombreproducto,DataPromocion datapromocion);

    
    //FUNCIONES AUXILIARES
    ///////////////////////////////////////////////////////
    public abstract int cantidadProductos();
    public abstract Map getColeccion();
    public abstract Map getColeccionProductos(String nickname);
    public abstract Promocion findPromocion(String nombre);
    public abstract int CantidadProductosPromo(String nombre);
    public abstract Producto findProducto(String nombre);
}
