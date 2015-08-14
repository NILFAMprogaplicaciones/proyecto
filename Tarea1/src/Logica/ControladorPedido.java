
package Logica;

import javax.swing.JOptionPane;


public class ControladorPedido implements IControladorPedido {
    
    private static ControladorPedido instancia=null;
    
    public static ControladorPedido getinstance(){
        if (instancia==null)
            instancia = new ControladorPedido();
        return instancia;
    }
    
     public void prueba(){
        
        JOptionPane.showMessageDialog(null,"Interactuo con funcion de la interfaz", "PRUEBA",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
