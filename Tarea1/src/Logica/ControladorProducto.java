
package Logica;

import java.util.Map;
import javax.swing.JOptionPane;


public class ControladorProducto implements IControladorProducto {   
          
    public void AltaProductoIndividual(Restaurante res,String nombre, String descripcion, double precio) {
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Individual prod = new Individual(res,nombre, descripcion, precio);
        MU.addProductoIndividual(res.getnickname(),prod);
        MP.addProductoIndividual(res.getnickname(), prod);
    }
    
     public void AltaProductoPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map coleccionProducto) {
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Promocion prod = new Promocion(res,nombre,descripcion,precioTotal,activa,descuento,coleccionProducto);
        MU.addProductoPromocion(res.getnickname(),prod);
        MP.addProductoPromocion(res.getnickname(), prod);
    }
}

