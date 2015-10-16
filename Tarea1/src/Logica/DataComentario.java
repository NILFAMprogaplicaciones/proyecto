
package Logica;


public class DataComentario {
    private Pedido IdPedido;
    private Fecha FechaRealizacion;
    private String InfoPedido;
    private String Texto;
    private int Puntaje;
    private Cliente cliente;
    
    public DataComentario(Pedido idpedido,Fecha fecharealizacion, String infopedido, String texto, int puntaje, Cliente cliente){
        this.IdPedido=idpedido;
        this.FechaRealizacion=fecharealizacion;
        this.InfoPedido=infopedido;
        this.Texto=texto;
        this.Puntaje=puntaje;
        this.cliente=cliente;
    }
    
    public Pedido getPedido(){
        return IdPedido;
    }
    public Fecha getFecha(){
        return FechaRealizacion;
    }
    public String getInfoPedido(){
        return InfoPedido;
    }
    public String getTexto(){
        return Texto;
    }
    public int getPuntaje(){
        return Puntaje;
    }
    public Cliente getCliente(){
        return cliente;
    }
}