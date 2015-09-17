package Logica;

public class Comentario {
    private Pedido IdPedido;    
    private Fecha FechaRealizacion;
    private String InfoPedido;
    private String Texto;
    private Cliente Nickname;
    private int Puntaje;
    
    public Comentario(DataComentario dc){
        IdPedido=dc.getPedido();
        FechaRealizacion=dc.getFecha();
        InfoPedido=dc.getInfoPedido();
        Texto=dc.getTexto();
        Nickname=dc.getCliente();
        Puntaje=dc.getPuntaje();
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
