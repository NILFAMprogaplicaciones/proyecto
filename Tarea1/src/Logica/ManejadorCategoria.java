
package Logica;

import java.util.HashMap;
import java.util.Map;


public class ManejadorCategoria {
    private Map<String, Categoria> ColeccionCategoria = new HashMap<String, Categoria>();
//SINGLENTON
    private static ManejadorCategoria instancia = null;
    
    public static ManejadorCategoria getinstance() {
        if (instancia == null) {
            instancia = new ManejadorCategoria();
        }
        return instancia;
    }    
    
//FUNCIONES DE COLECCION CATEGORIAS
    public void addCategoria(String nombre, Categoria cat) {
        ColeccionCategoria.put(nombre, cat);
    }

    public boolean verificoCat(String nombre) {
        return ColeccionCategoria.containsKey(nombre);
    }
    public Map coleccion(){
        return ColeccionCategoria;
    }
    public int cantidad(){
        return ColeccionCategoria.size();
    }
    public Categoria getCategoria(String nombrecategoria){
        return ColeccionCategoria.get(nombrecategoria);
    }
    
//EXCEPCIONES
    public void ExcepcionCategoria(String Categoria)throws ExcepcionesPersonalizadas{
        if(verificoCat(Categoria)==true){
            throw new ExcepcionesPersonalizadas("Categoria ya Ingresada");
        } 
        else {
            if (Categoria.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese Categoria");
            }
        }
    }
}
