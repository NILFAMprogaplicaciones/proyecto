
package Logica;

import java.util.Map;
import javax.swing.JOptionPane;
import Logica.FechaHora;


public class ControladorPedido implements IControladorPedido {
    
    public void Caso_Generar_Pedido(DataPedido datapedido){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido pedido=new Pedido(datapedido);
        MP.addPedido(datapedido.getId(), pedido);
    }
    
    public DataPedido Caso_Ver_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido p=MP.getPedido(id);
        DataPedido datapedido=new DataPedido(p.getnum(),p.getfecha(),p.getPrecioTotal(),p.getEstado(),p.getCliente(),p.getColeccionProductos(),p.getRestaurante(),p.getTipoAP());
        return datapedido;
    } 
    
    public void Caso_Cancelar_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        MP.getColeccionPedido().remove(id);
    }
    
    public void Caso_Actualizar_Estado_Pedido(int id, Estado estado){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        MP.getPedido(id).setEstado(estado);
        

    }

    public void Caso_Ingresar_Comentario(DataComentario dc){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Comentario com=new Comentario(dc);
        MP.getPedido(dc.getPedido().getnum()).setComentario(com);
    }
}
