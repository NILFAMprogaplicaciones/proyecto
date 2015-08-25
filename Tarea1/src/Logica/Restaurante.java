


package Logica;

import Logica.Categoria;
import Logica.Producto;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
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
    }    


