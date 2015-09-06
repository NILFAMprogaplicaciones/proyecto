
package Logica;


public class DataProductosPedido {
    private Producto    producto;
    private int         cantidad;
    private double      subtotal;
    
    public DataProductosPedido(Producto producto, int cantidad, double subtotal){
        this.producto=producto;
        this.cantidad=cantidad;
        this.subtotal=subtotal;
    }
    public Producto getProducto(){
        return producto;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getSubTotal(){
        return subtotal;
    }
}
