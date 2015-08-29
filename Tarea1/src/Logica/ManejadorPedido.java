
package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class ManejadorPedido {
    private Map<Integer, Pedido> ColeccionPedido = new TreeMap<Integer, Pedido>();
    private Map<Integer,ProductosPedido> ColeccionProductosPedido = new TreeMap<Integer,ProductosPedido>();
    //SINGLENTON
    private static ManejadorPedido instancia = null;
    
    public static ManejadorPedido getinstance() {
        if (instancia == null) {
            instancia = new ManejadorPedido();
        }
        return instancia;
    }
    //FUNCIONES COLECCION PEDIDOS
    public void addPedido(int id,Pedido pedido){
        ColeccionPedido.put(id, pedido);
    }
    public void addProductoPedido(int id, ProductosPedido pp){
        ColeccionProductosPedido.put(id,pp);
    }
    public int getCantidadEnColeccion(){
        return ColeccionPedido.size();
    }
    public int getCantidadColeccionProductosPedido(){
        return ColeccionProductosPedido.size();
    }
}
