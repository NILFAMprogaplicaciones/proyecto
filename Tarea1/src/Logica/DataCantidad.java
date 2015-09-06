
package Logica;


public class DataCantidad {
    int Cantidad;
    Producto Producto;
    
    public DataCantidad(int cantidad, Producto producto){
        Cantidad= cantidad;
        Producto= producto;
    }  
    public int getCantidad(){
        return Cantidad;
    }
    
    public Producto getProducto(){
        return Producto;
    }
}
