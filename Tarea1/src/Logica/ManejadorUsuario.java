
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class ManejadorUsuario {
    
    private Map<String,Usuario> ColeccionUsuarios = new HashMap<String,Usuario>();
    //SINGLENTON
    private static ManejadorUsuario instancia = null;
    
    public static ManejadorUsuario getinstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }
    
    //FUNCIONES DE COLECCION USUARIOS
    public void addUsuario(String nickname, Usuario usuario){
        ColeccionUsuarios.put(nickname, usuario);
    }
    public Cliente findCliente(String nickname){
        return ((Cliente)ColeccionUsuarios.get(nickname));
    }
    public Restaurante findRestaurante(String nickname){
        return ((Restaurante)ColeccionUsuarios.get(nickname));
    }
    public boolean verificarnickname(String nickname){
        return ColeccionUsuarios.containsKey(nickname);
    }
    public boolean verificarcorreo(String correo){
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getcorreo()==correo)
                return true;
        }
        return false;
    }
    
    public int CantUsuarios(){
        int size;
        return size=ColeccionUsuarios.size();
    }
    
    
   public Map obtenercoleccion(){
       Map cu;
       return cu=this.ColeccionUsuarios;   
   }
   
   public SortedSet getColeccionRestaurante() {
        SortedSet<Usuario> cr = new TreeSet();
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
           // if((objeto.getClass().getSimpleName())== "Restaurante")
                cr.add(objeto);
        }
        return cr;
   }
}
