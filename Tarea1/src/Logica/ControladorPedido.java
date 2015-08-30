
package Logica;

import javax.swing.JOptionPane;


public class ControladorPedido implements IControladorPedido {
    
    public void Caso_Generar_Pedido(DataPedido datapedido){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido pedido=new Pedido(datapedido);
        TipoAsosiativoPedido pp=new TipoAsosiativoPedido(pedido,datapedido.getColeccionProductosPedido());
        MP.addPedido(datapedido.getId(), pedido);
        MP.addProductoPedido(pp.getPedido().getnum(), pp);
        JOptionPane.showMessageDialog(null,"Pedido Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public DataPedido Caso_Ver_Pedido(int id){
        DataPedido p=null;
        return p;
    }
    
}
