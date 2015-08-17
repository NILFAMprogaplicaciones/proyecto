
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuario implements IControladorUsuario  {
    
    private static ControladorUsuario instancia=null;
    public Map<String,Usuario> ColeccionUsuario = new HashMap<String,Usuario>();
    //private Vector<Usuario> Coleccion;    
    
    //SINGLENTON
    public static ControladorUsuario getinstance(){
        if (instancia==null)
            instancia = new ControladorUsuario();
        return instancia;
    }
    
    //Funciones para el manejo de la ColeccionUsuario
    public void addUsuario(String nickname, Usuario usuario){
        ColeccionUsuario.put(nickname, usuario);
    }
    public Cliente findCliente(String nickname){
        return ((Cliente)ColeccionUsuario.get(nickname));
    }
    public Restaurante findRestaurante(String nickname){
        return ((Restaurante)ColeccionUsuario.get(nickname));
    }
    public int cantidadeelementoscoleccion(){
        return this.ColeccionUsuario.size();
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
    
    //CASOS DE USOS
    public void Caso_Registro_Cliente(String nombre, String nickname, String correo,  String direccion, String apellido, Fecha fecha){
        
        Cliente c=new Cliente(nombre, nickname,correo,direccion,apellido,fecha);
        addUsuario(nickname,c);
        JOptionPane.showMessageDialog(null,"Cliente Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);            
    
    }
    
    public void Caso_Registro_Restaurante(String nickname, String correo, String nombre, String direccion, Categoria categoria){
       
    
        JOptionPane.showMessageDialog(null,"Prueba");
    }
    public DataUsuario Caso_Ver_Cliente(String nickname, String correo){
        
        
        Cliente c= findCliente(nickname);
        DataUsuario du=new DataUsuario(c.getnombre(),c.getnickname(),c.getcorreo(),c.getdireccion(),c.getapellido(),c.getfecha());
        return du;
    }
    public void Caso_Ver_Restaurante(String nickname, String correo){
        int a=cantidadeelementoscoleccion();
    
        JOptionPane.showMessageDialog(null,a);
        JOptionPane.showMessageDialog(null,"Funcion Ver Restaurante"); 
    }
}
