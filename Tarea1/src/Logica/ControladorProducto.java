
package Logica;

import javax.swing.JOptionPane;


public class ControladorProducto implements IControladorProducto {
    
    private static ControladorProducto instancia=null;
    
    public static ControladorProducto getinstance(){
        if (instancia==null)
            instancia = new ControladorProducto();
        return instancia;
    }
    
     public void prueba(){
        
        JOptionPane.showMessageDialog(null,"Interactuo con funcion de la interfaz", "PRUEBA",JOptionPane.INFORMATION_MESSAGE);
    }
}
