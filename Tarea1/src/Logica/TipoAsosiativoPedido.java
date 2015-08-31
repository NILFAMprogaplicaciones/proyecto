
package Logica;

import java.util.HashMap;
import java.util.Map;

public class TipoAsosiativoPedido {
    private Pedido pedido;
    private Map<String,DataProductosPedido> ColeccionProductosPedido=new HashMap<String,DataProductosPedido>();
    
    public TipoAsosiativoPedido(Pedido pedido, Map coleccionproductospedido){
        this.pedido=pedido;
        this.ColeccionProductosPedido.putAll(coleccionproductospedido);
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
    public DataProductosPedido getProducto(String nombreproducto){
        return ColeccionProductosPedido.get(nombreproducto);
        
    }
}
