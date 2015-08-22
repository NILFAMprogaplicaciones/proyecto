
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
    
}
