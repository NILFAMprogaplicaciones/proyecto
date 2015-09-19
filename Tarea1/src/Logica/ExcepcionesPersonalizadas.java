
package Logica;

import javax.swing.JOptionPane;


public class ExcepcionesPersonalizadas extends Exception{
    
    public static final long serialVersionUID = 700L;
    
    public ExcepcionesPersonalizadas(String mensaje){
        super(mensaje);
    }
}
