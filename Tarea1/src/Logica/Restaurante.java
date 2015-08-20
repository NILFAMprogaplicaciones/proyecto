


package Logica;

import Logica.Categoria;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Restaurante extends Usuario {
    
    private Map<String,Categoria> ColeccionCategoria = new HashMap<String,Categoria>();
    private File imagen;
    public Restaurante(String nickname, String correo, String nombre, String direccion, Map categoria){
        super(nickname, correo, nombre, direccion);
        this.ColeccionCategoria=categoria;
    }
    
}
