
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

public class ControladorUsuario implements IControladorUsuario  {
    
    private static ControladorUsuario instancia=null;
    private Map<String,Usuario> ColeccionUsuario = new HashMap<String,Usuario>();
    //private Vector<Usuario> Cole;    
      
    //Funciones para el manejo de la ColeccionUsuario
    public void addUsuario(String nickname, Usuario usuario){
        ColeccionUsuario.put(nickname, usuario);
    }
    public Usuario findUsuario(String nickname){
        return ((Usuario)ColeccionUsuario.get(nickname));
    }
    public static ControladorUsuario getinstance(){
        if (instancia==null)
            instancia = new ControladorUsuario();
        return instancia;
    }
    
    public boolean verificarnickname(String nickname){
        return ColeccionUsuario.containsKey(nickname);
    }
    public boolean verificarcorreo(String correo){
        Iterator<Usuario> it = ColeccionUsuario.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getcorreo()==correo)
                return true;
        }
        return false;
    }
    public void Caso_Registro_Cliente(String nombre, String nickname, String correo,  String direccion, String apellido, Fecha fecha){
        
        Cliente c=new Cliente(nombre, nickname,correo,direccion,apellido,fecha);
        addUsuario(nickname,c);
        JOptionPane.showMessageDialog(null,"Cliente Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);            
    
    }
    
    public void Caso_Registro_Restaurante(String nickname, String correo, String nombre, String direccion, Categoria categoria){
        
        JOptionPane.showMessageDialog(null,"Funcion Registro Restaurante");
    }
    public void Caso_Ver_Cliente(String nickname, String correo){
       
        JOptionPane.showMessageDialog(null,"Funcion Ver Cliente"); 
    }
    public void Caso_Ver_Restaurante(String nickname, String correo){
       
        JOptionPane.showMessageDialog(null,"Funcion Ver Restaurante"); 
    }
}
