
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Categoria {
    
    private String nombre;
       
    public Categoria(String nombre){
        this.nombre=nombre;
    }
   
    public String getnombre(){
        return nombre;
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    
}
