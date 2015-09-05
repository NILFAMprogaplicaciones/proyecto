
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ManejadorProducto {
    private Map<String, Producto> ColeccionProducto = new HashMap<String,Producto>();
    private Set<Producto> ColProducto = new LinkedHashSet<Producto>();
    
    //SINGLENTON
    private static ManejadorProducto instancia = null;
    
    public static ManejadorProducto getinstance() {
        if (instancia == null) {
            instancia = new ManejadorProducto();
        }
        return instancia;
    }
    //FUNCIONES COLECCION PRODUCTOS
    public Set getColeccionProductos(String nickname){
        Set<Producto> ColeccionProd = new LinkedHashSet<Producto>();
        Iterator<Producto> it = ColProducto.iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.nombreRestaurante().equals(nickname))
                ColeccionProd.add(objeto);
        }
        return ColeccionProd;
    }
        
    public void addProductoIndividual(Individual prod) {
        ColProducto.add(prod);
    }
    public void addProductoPromocion(Promocion prod) {
        ColProducto.add(prod);
    }
    public int cantidadProductos(){
        return ColProducto.size();
    }
    public Set getColeccion(){
        return ColProducto;
    }
    
    public Individual findIndividual(String nombre){
        Individual ind=null;
        Iterator<Producto> it = ColProducto.iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombre))
                return ind=(Individual) objeto;
        }
        return ind;
    }
    public Promocion findPromocion(String nombre){
        Promocion pro=null;
        Iterator<Producto> it = ColProducto.iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombre))
                return pro=(Promocion) objeto;
        }
        return pro;
    }
    public Producto findProducto(String nombre){
        Producto pro=null;
        Iterator<Producto> it = ColProducto.iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombre))
                return objeto;
        }
        return pro;
    }
    
    public int CantidadProductosPromo(String nombre){
        return findPromocion(nombre).CantidadProductos();
    }
     
    public void remove(String nombreproducto){
        Iterator<Producto> it = ColProducto.iterator();
        Producto objeto=null;
        int borrar=0;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombreproducto))
                 ColProducto.remove(borrar);
            else
                borrar++;
        }
        
    }
}
