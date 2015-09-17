


package Logica;

import Logica.Categoria;
import Logica.Producto;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Restaurante extends Usuario {
    
    private Map<String,Categoria> ColeccionCategoria = new HashMap<String,Categoria>();
    private Map<String,Producto> ColeccionProducto = new HashMap<String,Producto>();
    private Map<Integer,File> ColeccionImagenes = new TreeMap<Integer,File>();
    
    
    public Restaurante(DataRestaurante datarestaurante){
        super(datarestaurante.getContraseña(),datarestaurante.getnickname(), datarestaurante.getcorreo(), datarestaurante.getnombre(),datarestaurante.getdireccion());
        this.ColeccionCategoria.putAll(datarestaurante.getColeccionCategoria());
        this.ColeccionImagenes.putAll(datarestaurante.getColeccionImagenes());
    }
    
    public String getcontraseña(){
        return getContraseña();
       
    }
    public double buscarprecio(String nombreproducto){
        Producto objeto=ColeccionProducto.get(nombreproducto);
        double precio=0;
        if(objeto.getClass().getSimpleName().equals("Individual")){
            Individual ind=(Individual) objeto;
            precio=ind.getPrecio();
        }
        else{
            Promocion pro=(Promocion) objeto;
            precio=pro.getPrecioTotal();
        }
        
        return precio;
    }    
    public Producto getProducto(String nombreproducto){
        Producto prod=null;
        Iterator<Producto> it = ColeccionProducto.values().iterator();
        Producto objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombreproducto)){
                   
                   prod=objeto;
                }
        }
        return prod;
    }
    public boolean verificarproducto(String nombreproducto){
        return ColeccionProducto.containsKey(nombreproducto);
    }
    public  Map getProductos(){
        return this.ColeccionProducto;
    }
    public void addProducto(Producto prod){
        this.ColeccionProducto.put(prod.getnombre(), prod);
    }
    public int getCantidadDeImagenes(){
        return ColeccionImagenes.size();
    }
    public Map getColeccionImagenes(){
        return ColeccionImagenes;
    }
    public  Map getCategorias(){
        return this.ColeccionCategoria;
    }
    public boolean ExisteCategoria(String nombrecategoria){
        boolean resultado=false;
        Iterator<Categoria> it = ColeccionCategoria.values().iterator();
        Categoria objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getnombre().equals(nombrecategoria)){
                resultado=true;
            }
            
        }
        return resultado;   
    }
    
}
