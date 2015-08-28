
package Logica;

import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;

public class DataRestaurante {
    private String nombre;
    private String nickname;
    private String correo;
    private String direccion;
    private Icon   foto;
    private Map<String,Categoria> ColeccionCategoria = new HashMap<String,Categoria>();
    
    
    public DataRestaurante(String nombre, String nickname, String correo, String direccion, Map coleccioncategoria){
        this.nombre=nombre;
        this.nickname=nickname;
        this.correo=correo;
        this.direccion=direccion;
        //this.foto=foto;
        this.ColeccionCategoria.putAll(coleccioncategoria);
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
    public Icon getFoto(){
        return foto;
    }
    public Map getColeccionCategoria(){
        return ColeccionCategoria;
    }
}
