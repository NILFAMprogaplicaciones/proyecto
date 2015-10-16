
package Logica;

import java.util.Map;


public class ControladorPedido implements IControladorPedido {
    
    @Override
    public void Caso_Generar_Pedido(DataPedido datapedido){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido pedido=new Pedido(datapedido);
        MP.addPedido(datapedido.getId(), pedido);
    }
    
    
    @Override
    public DataPedido Caso_Ver_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Pedido p=MP.getPedido(id);
        DataPedido datapedido=new DataPedido(p.getnum(),p.getfecha(),p.getPrecioTotal(),p.getEstado(),p.getCliente(),p.getColeccionProductos(),p.getRestaurante(),p.getTipoAP());
        return datapedido;
    } 
    
    @Override
    public void Caso_Cancelar_Pedido(int id){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        MP.getColeccionPedido().remove(id);
    }
    
    @Override
    public void Caso_Actualizar_Estado_Pedido(int id, Estado estado){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        MP.getPedido(id).setEstado(estado);
        

    }

    @Override
    public void Caso_Ingresar_Comentario(DataComentario dc){
        ManejadorPedido MP=ManejadorPedido.getinstance();
        Comentario com=new Comentario(dc);
        MP.getPedido(dc.getPedido().getnum()).setComentario(com);
    }
    
    //FUNCIONES AUXILIARES
    ////////////////////////////////////////////////////////
    
    @Override
    public int getCantidadEnColeccion(){
        ManejadorPedido MP = ManejadorPedido.getinstance();
        return MP.getCantidadEnColeccion();
    }
    @Override
    public Map getColeccionPedido(){
        ManejadorPedido MP = ManejadorPedido.getinstance();
        return MP.getColeccionPedido();
    }
    @Override
    public Pedido getPedido(int ID){
        ManejadorPedido MP = ManejadorPedido.getinstance();
        return MP.getPedido(ID);
    }
    @Override
    public int getCantidadColeccionCliente(String nickname){
        ManejadorPedido MP = ManejadorPedido.getinstance();
        return MP.getCantidadColeccionCliente(nickname);
    }
    @Override
     public void ExcepcionEliminacion(int id) throws ExcepcionesPersonalizadas{
        ManejadorPedido MP = ManejadorPedido.getinstance();
        MP.ExcepcionEliminacion(id);
    }
    @Override
    public Map getPedidos_Producto(String nombre) {
        ManejadorPedido MP = ManejadorPedido.getinstance();
        return MP.getPedidos_Producto(nombre);
    }
}
