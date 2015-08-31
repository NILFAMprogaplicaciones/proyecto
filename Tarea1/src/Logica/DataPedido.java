
package Logica;

import java.util.HashMap;
import java.util.Map;

public class DataPedido {
    private int id;
    private FechaHora fechahora;
    private double preciototal;
    private Estado estado;
    private Cliente cliente;
    private Map<String,Producto> ColeccionProductos=new HashMap<String,Producto>();
    private Restaurante restaurante;
    private Map<String,DataProductosPedido> ColeccionProductosPedido=new HashMap<String,DataProductosPedido>();
    
    public DataPedido(int id, FechaHora fechahora, double preciototal, Estado estado, Cliente cliente, Map coleccionproductos, Restaurante restaurante, Map coledataprodpedido){
        this.id=id;
        this.fechahora=fechahora;
        this.preciototal=preciototal;
        this.estado=estado;
        this.cliente=cliente;
        this.ColeccionProductos.putAll(coleccionproductos);
        this.restaurante=restaurante;
        this.ColeccionProductosPedido.putAll(coledataprodpedido);
    }
    public int getId(){
        return id;
    }
    public FechaHora getFechaHora(){
        return fechahora;
    }
    public double getPrecioTotal(){
        return preciototal;
    }
    public Estado getEstado(){
        return estado;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public Map getColeccionProductos(){
        return ColeccionProductos;
    }
    public Restaurante getRestaurante(){
        return restaurante;
    }
    public Map getColeccionProductosPedido(){
        return ColeccionProductosPedido;
    }
}


