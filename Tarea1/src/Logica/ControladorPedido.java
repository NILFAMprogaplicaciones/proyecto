
package Logica;

import java.util.Map;
import javax.swing.JOptionPane;
import Logica.FechaHora;


public class ControladorPedido implements IControladorPedido {
    
    public void Caso_Generar_Pedido(DataPedido datapedido){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido pedido=new Pedido(datapedido);
        MP.addPedido(datapedido.getId(), pedido);
        JOptionPane.showMessageDialog(null,"Pedido Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public DataPedido Caso_Ver_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido p=MP.getPedido(id);
        DataPedido datapedido=new DataPedido(p.getnum(),p.getfecha(),p.getPrecioTotal(),p.getEstado(),p.getCliente(),p.getColeccionProductos(),p.getRestaurante(),p.getTipoAP());
        return datapedido;
    } 
    
    public void Caso_Cancelar_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Estado estado=MP.getPedido(id).getEstado();
        if(estado.equals(Estado.PREPARCION)){
            MP.getColeccionPedido().remove(id);
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
