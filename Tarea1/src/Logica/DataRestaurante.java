
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.Icon;

public class DataRestaurante {
    private String nombre;
    private String nickname;
    private String correo;
    private String direccion;
    private Map<String,Categoria> ColeccionCategoria = new HashMap<String,Categoria>();
    private Map<Integer,File> ColeccionImagenes = new TreeMap<Integer,File>();
    
    public DataRestaurante(String nombre, String nickname, String correo, String direccion, Map coleccioncategoria, Map coleccionimagenes){
        this.nombre=nombre;
        this.nickname=nickname;
        this.correo=correo;
        this.direccion=direccion;
        this.ColeccionCategoria.putAll(coleccioncategoria);
        this.ColeccionImagenes.putAll(coleccionimagenes);
    }
    
    public String getnombre(){
        return nombre;
    }
    public String getnickname(){
        return nickname;
    }
    public String getcorreo(){
        return correo;
    }
    public String getdireccion(){
        return direccion;
    }
    public Map getColeccionImagenes(){
        return ColeccionImagenes;
    }
    public Map getColeccionCategoria(){
        return ColeccionCategoria;
    }
}
