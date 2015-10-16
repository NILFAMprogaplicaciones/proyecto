package Logica;

public class Comentario {
    private Pedido IdPedido;    
    private Fecha FechaRealizacion;
    private String InfoPedido;
    private String Texto;
    private int Puntaje;
    private Cliente cliente;
    
    public Comentario(DataComentario dc){
        IdPedido=dc.getPedido();
        FechaRealizacion=dc.getFecha();
        InfoPedido=dc.getInfoPedido();
        Texto=dc.getTexto();
        Puntaje=dc.getPuntaje();
        cliente=dc.getCliente();
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
    
    
    
   
    
    
    
