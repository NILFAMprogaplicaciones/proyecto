
package Logica;

import java.util.HashMap;
import java.util.Map;

public class TipoAsosiativoPedido {
    
    private Map<String,DataProductosPedido> ColeccionProductosPedido=new HashMap<String,DataProductosPedido>();
    
    public TipoAsosiativoPedido( Map coleccionproductospedido){
        
        this.ColeccionProductosPedido.putAll(coleccionproductospedido);
    }
    public void addColeccion(Map coleccionproductospedido){
        this.ColeccionProductosPedido.putAll(coleccionproductospedido);
    }
    
    public Map getColeccionProductosPedido(){
        return ColeccionProductosPedido;
    }
    public int getCantidadColeccionProductosPedido(){
        return ColeccionProductosPedido.size();
    }
    public DataProductosPedido getDataProductoPedido(String nombreproducto){
        return ColeccionProductosPedido.get(nombreproducto);
        
    }
}
