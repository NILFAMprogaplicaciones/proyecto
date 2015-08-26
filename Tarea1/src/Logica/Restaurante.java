


package Logica;

import Logica.Categoria;
import Logica.Producto;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Restaurante extends Usuario {
    
    private Map<String,Categoria> ColeccionCategoria = new HashMap<String,Categoria>();
    private Map<String,Producto> ColeccionProducto = new HashMap<String,Producto>();
    private File imagen;
    
    public  Map getProductos(){
        return this.ColeccionProducto;
    }
    public void addProducto(Producto prod){
        this.ColeccionProducto.put(prod.getnombre(), prod);
    }
    public Restaurante(String nickname, String correo, String nombre, String direccion, Map categoria){
        super(nickname, correo, nombre, direccion);
        this.ColeccionCategoria.putAll(categoria);
    }
    public double buscarprecio(String nombreproducto){
        double precio=0;
        Iterator<Producto> it = ColeccionProducto.values().iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Individual")){
                
                if(objeto.getnombre().equals(nombreproducto)){
                   Individual ind=(Individual) objeto;
                   precio=ind.getPrecio();
                }
            }
        }
        return precio;
    }    
    public Producto getProducto(String nombreproducto){
        
        Iterator<Producto> it = ColeccionProducto.values().iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombreproducto)){
                   
                   return objeto;
                }
            
        }
        return objeto;
    }
    public boolean verificarproducto(String nombreproducto){
        boolean resultado=false;
        Iterator<Producto> it = ColeccionProducto.values().iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombreproducto)){
                resultado=true;
            }
            
        }
        return resultado;
    }

}
