
package Logica;

import javax.swing.JOptionPane;


public class ControladorPedido implements IControladorPedido {
    
    public void Caso_Generar_Pedido(DataPedido datapedido){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido pedido=new Pedido(datapedido);
        MP.addPedido(datapedido.getId(), pedido);
        JOptionPane.showMessageDialog(null,"Pedido Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE); 
    }
    
}
