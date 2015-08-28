
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.Icon;
        
public class ControladorUsuario implements IControladorUsuario  {
    
    
    
    public void Caso_Registro_Cliente(DataCliente datacliente){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
        Cliente c=new Cliente(datacliente);
        mc.addUsuario(datacliente.getnickname(),c);
        JOptionPane.showMessageDialog(null,"Cliente Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);            
    
    }
    public DataCliente Caso_Ver_Cliente(String nickname){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
        Cliente c= mc.findCliente(nickname);
        DataCliente du=new DataCliente(c.getnombre(),c.getnickname(),c.getcorreo(),c.getdireccion(),c.getapellido(),c.getfecha(),c.getFoto());
        return du;
    }
    
    public void Caso_Registro_Restaurante(DataRestaurante datarestaurante){
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        
        Restaurante res=new Restaurante(datarestaurante);
        mu.addUsuario(datarestaurante.getnickname(), res);
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
