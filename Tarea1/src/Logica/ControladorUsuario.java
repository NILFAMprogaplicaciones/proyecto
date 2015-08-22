
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

public class ControladorUsuario implements IControladorUsuario  {
    
    
    
    public void Caso_Registro_Cliente(String nombre, String nickname, String correo,  String direccion, String apellido, Fecha fecha){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
        Cliente c=new Cliente(nombre, nickname,correo,direccion,apellido,fecha);
        mc.addUsuario(nickname,c);
        JOptionPane.showMessageDialog(null,"Cliente Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);            
    
    }
    public DataUsuario Caso_Ver_Cliente(String nickname){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
        Cliente c= mc.findCliente(nickname);
        DataUsuario du=new DataUsuario(c.getnombre(),c.getnickname(),c.getcorreo(),c.getdireccion(),c.getapellido(),c.getfecha());
        return du;
    }
    
    public void Caso_Registro_Restaurante(String nickname,String correo, String nombre,  String direccion, Map categoria){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
      
       Restaurante res=new Restaurante(nombre,nickname,correo,direccion,categoria);
       mc.addUsuario(nickname, res);
       JOptionPane.showMessageDialog(null,"Restaurante Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);
    }
    public void Caso_Ver_Restaurante(String nickname, String correo){
       
        JOptionPane.showMessageDialog(null,"Funcion Ver Restaurante"); 
    }
    
    public void AltaCategoria(String nombre) {
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        Categoria cat = new Categoria(nombre);
        mc.addCategoria(nombre, cat);
    }
    
}
