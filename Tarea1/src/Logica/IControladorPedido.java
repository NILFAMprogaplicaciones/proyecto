
package Logica;


public abstract interface IControladorPedido {
    
    public abstract void Caso_Generar_Pedido(DataPedido datapedido);
    
    
    public abstract DataPedido Caso_Ver_Pedido(int id);
    
    
    public abstract void Caso_Cancelar_Pedido(int id);
    
    
    public abstract void Caso_Actualizar_Estado_Pedido(int id, Estado estado);
    
    
    public abstract void Caso_Ingresar_Comentario(DataComentario datacomentario);
}
