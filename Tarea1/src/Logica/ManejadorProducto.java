
package Logica;

import java.util.HashMap;
import java.util.Iterator;
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
        Map<String,Producto> ColeccionProd = new HashMap<String,Producto>();
        Iterator<Producto> it = ColeccionProducto.values().iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.nombreRestaurante().equals(nickname))
                ColeccionProd.put(objeto.getnombre(),objeto);
        }
        return ColeccionProd;
    }
    
    public void addProductoIndividual(String nombre, Individual prod) {
        ColeccionProducto.put(nombre,prod);
    }
    public void addProductoPromocion(String nombre, Promocion prod) {
        ColeccionProducto.put(nombre,prod);
    }
    public int cantidadProductos(){
        return ColeccionProducto.size();
    }
    public Map getColeccion(){
        return ColeccionProducto;
    }
    
    public Individual findIndividual(String nombre){
        return ((Individual)ColeccionProducto.get(nombre));
    }
    public Promocion findPromocion(String nombre){
        return ((Promocion)ColeccionProducto.get(nombre));
    }
    public Producto findProducto(String nombre){
        return ColeccionProducto.get(nombre);
    }
}
