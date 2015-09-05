
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Categoria {
    
    private String nombre;
    private Map<String,Restaurante> ColeccionRestaurante =new HashMap<String,Restaurante>();
    
    public Categoria(){
        
    }
    public Categoria(String nombre){
        this.nombre=nombre;
    }
   
    public String getnombre(){
        return nombre;
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setColeccionRestaurante(String nombrerestaurante,Restaurante restaurante){
        ColeccionRestaurante.put(nombrerestaurante, restaurante);
    }
    public Map getcoleccionrestaurante(){
           return ColeccionRestaurante;
                
    }
}
