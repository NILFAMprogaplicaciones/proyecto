
package Logica;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class TipoAsosiativoPedidoTest {
    
    Map<String,DataProductosPedido> ColeccionProductosPedido=new HashMap<>();
    TipoAsosiativoPedido TAP=new TipoAsosiativoPedido(ColeccionProductosPedido);
    Restaurante res;
    Producto prod=new Producto("producto","descripcion",res,"");
    DataProductosPedido dpp=new DataProductosPedido(prod, 1, 100);
    
    @Test
    public void testAddColeccion() {
    
        ColeccionProductosPedido.put(dpp.getProducto().getnombre(), dpp);
        TAP.addColeccion(ColeccionProductosPedido);
        
        Map<String,DataProductosPedido> col=new HashMap<>();
        col.put(dpp.getProducto().getnombre(), dpp);
        
        assertEquals(TAP.getColeccionProductosPedido(), col);
        assertEquals(TAP.getCantidadColeccionProductosPedido(), 1);
        assertEquals(TAP.getDataProductoPedido("producto"), dpp);
    }

    
}
