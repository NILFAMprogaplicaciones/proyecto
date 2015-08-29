
package Logica;

import java.util.HashMap;
import java.util.Map;

public class ProductosPedido {
    private Pedido pedido;
    private Map<Integer,DataProductosPedido> ColeccionProductosPedido=new HashMap<Integer,DataProductosPedido>();
    
    public ProductosPedido(Pedido pedido, Map coleccionproductospedido){
        this.pedido=pedido;
        this.ColeccionProductosPedido=coleccionproductospedido;
    }
    public void addColeccion(Map coleccionproductospedido){
        this.ColeccionProductosPedido.putAll(coleccionproductospedido);
    }
    public Pedido getPedido(){
        return pedido;
    }
    public Map getColeccionProductosPedido(){
        return ColeccionProductosPedido;
    }
    public int getCantidadColeccionProductosPedido(){
        return ColeccionProductosPedido.size();
    }
}
