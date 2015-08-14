
package Logica;

import javax.swing.*;

public class ControladorUsuario implements IControladorUsuario  {
    
    private static ControladorUsuario instancia=null;
    
    public static ControladorUsuario getinstance(){
        if (instancia==null)
            instancia = new ControladorUsuario();
        return instancia;
    }
    
    public void Caso_Registro_Cliente(String nickname, String correo, String nombre, String direccion, String apellido, Fecha fecha){
        
        JOptionPane.showMessageDialog(null,"Funcion Registro Cliente");
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
