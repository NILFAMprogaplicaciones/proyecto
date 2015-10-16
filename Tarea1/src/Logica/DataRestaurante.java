
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class DataRestaurante {
    private String contraseña;
    private String nombre;
    private String nickname;
    private String correo;
    private String direccion;
    private Map<String,Categoria> ColeccionCategoria = new HashMap<String,Categoria>();
    private Map<Integer,File> ColeccionImagenes = new TreeMap<Integer,File>();
    
    public DataRestaurante(String contraseña,String nombre, String nickname, String correo, String direccion, Map coleccioncategoria, Map coleccionimagenes){
        this.contraseña=contraseña;
        this.nombre=nombre;
        this.nickname=nickname;
        this.correo=correo;
        this.direccion=direccion;
        this.ColeccionCategoria.putAll(coleccioncategoria);
        this.ColeccionImagenes.putAll(coleccionimagenes);
    }
    
    public String getContraseña(){
        return contraseña;
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
    public File getFoto(int numero){
        return ColeccionImagenes.get(numero);
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
