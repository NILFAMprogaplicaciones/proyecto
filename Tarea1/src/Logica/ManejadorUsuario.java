
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import Logica.Restaurante;

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
    public int CantClientes(){
        int cantidad=0;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            String tipo=objeto.getClass().getSimpleName();
            
            if(tipo.equals("Cliente"))
                cantidad=cantidad+1;
        }
        return cantidad;
    }
    public Map obtenercoleccion(){
       Map cu;
       return cu=this.ColeccionUsuarios;   
    }
    
    
}
