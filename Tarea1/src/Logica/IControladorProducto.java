
package Logica;

import java.util.Map;


public abstract interface IControladorProducto {
    
    public abstract void AltaProductoIndividual(Restaurante res,String nombre, String descripcion, double precio);
    public abstract void AltaProductoPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map coleccionProducto);
    public abstract DataIndividual Caso_Ver_Individual(String nombre);
    public abstract void Caso_Editar_Individual(String nombre, String descripcion, double precio);
}
