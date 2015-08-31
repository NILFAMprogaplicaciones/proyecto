
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class ManejadorPedido {
    private Map<Integer, Pedido> ColeccionPedido = new TreeMap<Integer, Pedido>();
    private Map<Integer,TipoAsosiativoPedido> ColeccionTipoAsosiativoPedido = new TreeMap<Integer,TipoAsosiativoPedido>();
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
    public void addProductoPedido(int id, TipoAsosiativoPedido pp){
        ColeccionTipoAsosiativoPedido.put(id,pp);
    }
    public int getCantidadEnColeccion(){
        return ColeccionPedido.size();
    }
    public int getCantidadColeccionProductosPedido(){
        return ColeccionTipoAsosiativoPedido.size();
    }
    public Map getColeccionPedido(){
        return ColeccionPedido;
    }
    public Map getColeccionTipoAsosiativoPedido(){
        return ColeccionTipoAsosiativoPedido;
    }
    public Map getPedidos_Producto(String producto){
        Map<Integer,Pedido> Pedidos_Producto =  new TreeMap<Integer,Pedido>();
        Map coleccion = getColeccionPedido();
        Iterator<Pedido> it = coleccion.values().iterator();
        Pedido ped=null;
        while (it.hasNext()) {
              ped=it.next();
                if (ped.ExisteProducto(producto)){
                    Pedidos_Producto.put(ped.getnum(), ped);
                }    
        }
    return Pedidos_Producto;
    }
    public Pedido getPedido(int id){
        return ColeccionPedido.get(id);
    }
    public TipoAsosiativoPedido getTipoAsosiativoPedido(int id){
        return ColeccionTipoAsosiativoPedido.get(id);
    }
}
