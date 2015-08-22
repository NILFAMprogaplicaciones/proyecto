
package Logica;

public class Categoria {
    
    private String nombre;
    
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
}
