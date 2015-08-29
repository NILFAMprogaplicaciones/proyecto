
package Logica;


public abstract interface IControladorPedido {
    
    public abstract void Caso_Generar_Pedido(DataPedido datapedido);
    
    
    public abstract DataPedido Caso_Ver_Pedido(int id);
    
}
