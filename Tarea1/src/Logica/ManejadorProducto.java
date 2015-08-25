
package Logica;

import java.util.HashMap;
import java.util.Map;


public class ManejadorProducto {
    private Map<String, Producto> ColeccionProducto = new HashMap<String,Producto>();
    
    //SINGLENTON
    private static ManejadorProducto instancia = null;
    
    public static ManejadorProducto getinstance() {
        if (instancia == null) {
            instancia = new ManejadorProducto();
        }
        return instancia;
    }
    //FUNCIONES COLECCION PRODUCTOS
    public Map getColeccionProductos(String nickname){
       ManejadorUsuario MU = ManejadorUsuario.getinstance();
       return MU.findRestaurante(nickname).getProductos();
    }
    
    public void addProducto(String nombre, Producto prod) {
        ColeccionProducto.put(nombre,prod);
    }
    

}
