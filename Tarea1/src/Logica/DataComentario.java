
package Logica;


public class DataComentario {
    private Pedido IdPedido;
    private Fecha FechaRealizacion;
    private String InfoPedido;
    private String Texto;
    private Cliente Nickname;
    private int Puntaje;
    
    public DataComentario(Pedido idpedido,Fecha fecharealizacion, String infopedido, String texto, Cliente nickname,int puntaje){
        this.IdPedido=idpedido;
        this.FechaRealizacion=fecharealizacion;
        this.InfoPedido=infopedido;
        this.Texto=texto;
        this.Nickname=nickname;
        this.Puntaje=puntaje;
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
    public Cliente getCliente(){
        return Nickname;
    }
    public int getPuntaje(){
        return Puntaje;
    }
}