
package Logica;

import java.util.Map;


public interface IControladorProducto {
    
    public abstract void AltaProductoIndividual(Restaurante res,String nombre, String descripcion, double precio);
    public abstract void AltaProductoPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map coleccionProducto);
    
}
