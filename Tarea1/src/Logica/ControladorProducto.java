
package Logica;

import javax.swing.JOptionPane;


public class ControladorProducto implements IControladorProducto {
    
       
    public void prueba(){
        JOptionPane.showMessageDialog(null,"Interactuo con funcion de la interfaz", "PRUEBA",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void AltaProducto(String Restaurante,String nombre, String descripcion, String precio) {
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Producto prod = new Producto(nombre, descripcion, precio);
        MU.addProducto(Restaurante,prod);
    }
}

