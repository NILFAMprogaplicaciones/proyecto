
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class DataProductosPedidoTest {
    
    //RESTAURANTE
    Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
    Map<Integer,File> colfoto1=new HashMap<Integer,File>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
    Restaurante res=new Restaurante(datarestaurante);
    
    Producto prod=new Producto("nombre","descripcion",res,"");
    DataProductosPedido datapp=new DataProductosPedido(prod, 1, 100);
    
    @Test
    public void testGetProducto() {
        
        assertEquals(datapp.getProducto().getnombre(), "nombre");
    }

    @Test
    public void testGetCantidad() {
        assertEquals(datapp.getCantidad(), 1);
    }

    @Test
    public void testGetSubTotal() {
        int comparar=(int) datapp.getSubTotal();
        assertEquals(comparar, 100);
    }
    
}
