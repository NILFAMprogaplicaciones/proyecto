
package Logica;

import java.util.HashMap;
import java.util.Map;


public final class Pedido {
    
    private int                     num;
    private FechaHora               fechahora;
    private double                  precio_total;
    private Estado                  estado;
    private Cliente                 cliente;
    private Map<String,Producto>    ColeccionProductos=new HashMap<String,Producto>();
    private Restaurante             restaurante;
    private TipoAsosiativoPedido    tipoAP;
   
    public Pedido(DataPedido datapedido){
        
        
        this.num=datapedido.getId();
        this.fechahora=datapedido.getFechaHora();
        this.precio_total=datapedido.getPrecioTotal();
        this.estado=datapedido.getEstado();
        this.cliente=datapedido.getCliente();
        this.ColeccionProductos.putAll(datapedido.getColeccionProductos());
        this.restaurante=datapedido.getRestaurante();
        this.tipoAP=datapedido.getTipoAP();
        
    }
    
    public int getnum(){
        return num;
    }
    public FechaHora getfecha(){
        return fechahora;
    }
    public String verfechastring(){
        int dia=fechahora.getDia(),mes=fechahora.getMes(),año=fechahora.getAño(),hora=fechahora.getHora(),minutos=fechahora.getMinuto();
        String fecha=Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año)+"-"+Integer.toString(hora)+":"+Integer.toString(minutos);
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
    public TipoAsosiativoPedido getTipoAP(){
        return tipoAP;
    }
    
    public void setNum(int num){
        this.num=num;
    }
    public void setFecha(FechaHora fechahora){
        this.fechahora=fechahora;
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
    
    public boolean ExisteProducto(String producto){
        return ColeccionProductos.containsKey(producto);
    }
    
    
    
}
