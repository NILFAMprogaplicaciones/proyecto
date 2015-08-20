
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

public class ControladorUsuario implements IControladorUsuario  {
    
    ManejadorColecciones mc=ManejadorColecciones.getinstance();
    
    public void Caso_Registro_Cliente(String nombre, String nickname, String correo,  String direccion, String apellido, Fecha fecha){
        
        Cliente c=new Cliente(nombre, nickname,correo,direccion,apellido,fecha);
        mc.addUsuario(nickname,c);
        JOptionPane.showMessageDialog(null,"Cliente Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);            
    
    }
    public DataUsuario Caso_Ver_Cliente(String nickname, String correo){
        
        Cliente c= mc.findCliente(nickname);
        DataUsuario du=new DataUsuario(c.getnombre(),c.getnickname(),c.getcorreo(),c.getdireccion(),c.getapellido(),c.getfecha());
        return du;
    }
    
    public void Caso_Registro_Restaurante(String nickname,String correo, String nombre,  String direccion, Map categoria){
        
      
       Restaurante res=new Restaurante(nombre,nickname,correo,direccion,categoria);
       mc.addUsuario(nickname, res);
       JOptionPane.showMessageDialog(null,"Restaurante Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);
    }
    public void Caso_Ver_Restaurante(String nickname, String correo){
       
        JOptionPane.showMessageDialog(null,"Funcion Ver Restaurante"); 
    }
    
}
