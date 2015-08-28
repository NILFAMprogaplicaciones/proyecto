
package Logica;

import java.util.Map;
import javax.swing.JOptionPane;



public class ControladorProducto implements IControladorProducto {   
          
    public void AltaProductoIndividual(Restaurante res,String nombre, String descripcion, double precio) {
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Individual prod = new Individual(res,nombre, descripcion, precio);
        MU.addProductoIndividual(res.getnickname(),prod);
        MP.addProductoIndividual(prod.getnombre(), prod);
    }
    
    public void AltaProductoPromocion(Restaurante res,String nombre, String descripcion, double precioTotal, boolean activa, double descuento, Map coleccionProducto) {
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Promocion prod = new Promocion(res,nombre,descripcion,precioTotal,activa,descuento,coleccionProducto);
        MU.addProductoPromocion(res.getnickname(),prod);
        MP.addProductoPromocion(prod.getnombre(), prod);
    }
    
    public DataIndividual Caso_Ver_Individual(String nombre){
        ManejadorProducto mp = ManejadorProducto.getinstance();
        Individual i= mp.findIndividual(nombre);
        DataIndividual di = new DataIndividual(i.getnombre(),i.getdescripcion(),i.getRestaurante(),i.getPrecio());
        return di;
    }
    
    @Override
    public void Caso_Editar_Individual(String nombre, String descripcion, double precio){
        ManejadorProducto mp = ManejadorProducto.getinstance();
        Individual i= mp.findIndividual(nombre);
        i.setnombre(nombre);
        i.setdescripcion(descripcion);
        i.setprecio(precio);
    }
}

