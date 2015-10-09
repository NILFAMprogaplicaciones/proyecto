
package Logica;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;


public class ManejadorProducto {
    //private Map<String, Producto> ColeccionProducto = new HashMap<String,Producto>();
    private Map<String,Producto> ColProducto = new HashMap<String,Producto>();
    
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
        Iterator<Producto> it = ColProducto.values().iterator();
        Producto objeto;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.nombreRestaurante().equals(nickname))
                ColeccionProd.put(objeto.getnombre(),objeto);
        }
        return ColeccionProd;
    }
        
    public Map getColeccionIndividual(){
        Map<String,Individual> ColeccionProd = new HashMap<String,Individual>();
        Iterator<Producto> it = ColProducto.values().iterator();
        Producto objeto;
        Individual individual;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Individual")){
                individual=(Individual) objeto;
                ColeccionProd.put(individual.getnombre(),individual);
            }
        }
        return ColeccionProd;
    }
    public void addProductoIndividual(Individual prod) {
        ColProducto.put(prod.getnombre(),prod);
    }
    public void addProductoPromocion(Promocion prod) {
        ColProducto.put(prod.getnombre(),prod);
    }
    public int cantidadProductos(){
        return ColProducto.size();
    }
    public Map getColeccion(){
        return ColProducto;
    }
    
    public Individual findIndividual(String nombre){
        return (Individual) ColProducto.get(nombre);
    }
    public Promocion findPromocion(String nombre){
        return (Promocion) ColProducto.get(nombre);
    }
    public Producto findProducto(String nombre){
       return ColProducto.get(nombre);
    }
    
    public int CantidadProductosPromo(String nombre){
        return findPromocion(nombre).CantidadProductos();
    }
     
    public void remove(String nombreproducto){
        ColProducto.remove(nombreproducto);   
    }
    
}
