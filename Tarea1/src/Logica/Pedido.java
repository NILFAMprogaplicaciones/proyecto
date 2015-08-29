
package Logica;

import java.util.HashMap;
import java.util.Map;


public class Pedido {
    
    private int     num;
    private FechaHora   fecha;
    private double  precio_total;
    private Estado  estado;
    private Cliente  cliente;
    private Map<String,Producto> ColeccionProductos=new HashMap<String,Producto>();
    private Restaurante restaurante;
   
    public Pedido(DataPedido datapedido){
        this.num=datapedido.getId();
        this.fecha=datapedido.getFechaHora();
        this.precio_total=datapedido.getPrecioTotal();
        this.estado=datapedido.getEstado();
        this.cliente=datapedido.getCliente();
        this.ColeccionProductos.putAll(datapedido.getColeccionProductos());
        this.restaurante=datapedido.getRestaurante();
    }
    
    public int getnum(){
        return num;
    }
    public FechaHora getfecha(){
        return fecha;
    }
    public double getPrecioTotal(){
        return precio_total;
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
    
    public void setNum(int num){
        this.num=num;
    }
    public void setFecha(FechaHora fecha){
        this.fecha=fecha;
    }
    public void setPrecioTotal(double precio_total){
        this.precio_total=precio_total;
    }
    public void setEstado(Estado estado){
        this.estado=estado;
    }
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public void setColeccionProductos(Map coleccionproductos){
        this.ColeccionProductos.putAll(coleccionproductos);
    }
    public void setRestaurante(Restaurante restaurante){
        this.restaurante=restaurante;
    }
    
}
