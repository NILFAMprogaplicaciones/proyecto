
package Logica;

import javax.swing.JOptionPane;


public class ControladorCategoria implements IControladorCategoria {
    
    private static ControladorCategoria instancia=null;
    
    public static ControladorCategoria getinstance(){
        if (instancia==null)
            instancia = new ControladorCategoria();
        return instancia;
    }
    
    public void prueba(){
        
        JOptionPane.showMessageDialog(null,"Interactuo con funcion de la interfaz", "PRUEBA",JOptionPane.INFORMATION_MESSAGE);
    }
            
}
