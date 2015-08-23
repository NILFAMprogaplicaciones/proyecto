
package Logica;

import java.util.HashMap;
import java.util.Map;


public class ManejadorProducto {
    private Map<String, Producto> ColeccionProducto = new HashMap<String, Producto>();
    
    //SINGLENTON
    private static ManejadorProducto instancia = null;
    
    public static ManejadorProducto getinstance() {
        if (instancia == null) {
            instancia = new ManejadorProducto();
        }
        return instancia;
    }
    //FUNCIONES COLECCION PRODUCTOS
    
}
