
package Logica;

import java.util.Map;
import javax.swing.JOptionPane;
import Logica.FechaHora;


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
        DataPedido a=null;
        return a;
    } 
    
    public void Caso_Cancelar_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Estado estado=MP.getPedido(id).getEstado();
        if(estado.equals(Estado.PREPARCION)){
            MP.getColeccionPedido().remove(id);
            MP.getColeccionTipoAsosiativoPedido().remove(id);
            JOptionPane.showMessageDialog(null,"Pedido Eliminado","PEDIDO",JOptionPane.INFORMATION_MESSAGE); 
        }
        else{
            JOptionPane.showMessageDialog(null,"Imposible Cancelar Pedido, Verifique su Estado","PEDIDO",JOptionPane.ERROR_MESSAGE); 

        }
    }
    
    public void Caso_Actualizar_Estado_Pedido(int id, Estado estado){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        MP.getPedido(id).setEstado(estado);
        JOptionPane.showMessageDialog(null, "Estado Modificado","ACTUALIZACION",JOptionPane.INFORMATION_MESSAGE);

    }

}
