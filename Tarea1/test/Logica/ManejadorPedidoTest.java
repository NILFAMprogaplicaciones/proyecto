
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class ManejadorPedidoTest {

    //CLIENTE
    Fecha fecha1=new Fecha(15,11,1983);
    File foto1 = new File("src/Imagenes/co.jpg");
    DataCliente datacliente1=new DataCliente("contraseña","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,""); 
    Cliente cliente1=new Cliente(datacliente1);
    //RESTAURANTE  
    Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
    Map<Integer,File> colfoto1=new HashMap<Integer,File>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
    Restaurante res1=new Restaurante(datarestaurante);
    //PEDIDO
    FechaHora fecha=new FechaHora(12,8,2015,0,0);
    Producto prod=new Producto("producto","descripcion",res1,"");
    Map<String,Producto> col1=new HashMap<String,Producto>();
        
        //TIPO ASOSIATIVO
    Map<String,DataProductosPedido> colpp1=new HashMap<String,DataProductosPedido>();
    TipoAsosiativoPedido tap1=new TipoAsosiativoPedido(colpp1);
    DataPedido datapedido=new DataPedido(1, fecha, 220, Estado.PREPARCION, cliente1, col1,  res1, tap1);
    Pedido pedido1=new Pedido(datapedido);
    
    ManejadorPedido MP=new ManejadorPedido();
    
    @Test
    public void testGetCantidadEnColeccion() {
        
        Pedido p1=pedido1,p2=pedido1,p3=pedido1,p4=pedido1;
        ManejadorPedido MP=new ManejadorPedido();
        MP.addPedido(1, p1);
        MP.addPedido(2, p2);
        MP.addPedido(3, p3);
        MP.addPedido(4, p4);
        assertEquals(MP.getCantidadEnColeccion(), 4);
    }

    
    @Test
    public void testGetPedidos_Producto() {
        
        //CLIENTE
        Fecha fecha1=new Fecha(15,11,1983);
        File foto1 = new File("src/Imagenes/co.jpg");
        DataCliente datacliente1=new DataCliente("contraseña","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,""); 
        Cliente cliente1=new Cliente(datacliente1);
        //RESTAURANTE  
        Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
        Map<Integer,File> colfoto1=new HashMap<Integer,File>();
        DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        Restaurante res1=new Restaurante(datarestaurante);
        //PEDIDO
        FechaHora fecha=new FechaHora(12,8,2015,0,0);
        Producto prod=new Producto("producto","descripcion",res1,"");
        Map<String,Producto> col1=new HashMap<String,Producto>();
        col1.put(prod.getnombre(), prod);
        //TIPO ASOSIATIVO
        Map<String,DataProductosPedido> colpp1=new HashMap<String,DataProductosPedido>();
        TipoAsosiativoPedido tap1=new TipoAsosiativoPedido(colpp1);
        DataPedido datapedido=new DataPedido(1, fecha, 220, Estado.PREPARCION, cliente1, col1,  res1, tap1);
        Pedido pedido1=new Pedido(datapedido);
        ManejadorPedido MP=new ManejadorPedido();
        MP.addPedido(1, pedido1);
        
        assertEquals(MP.getPedidos_Producto(prod.getnombre()).size(),1);
    }

    @Test
    public void testGetCantidadColeccionCliente() {
        MP.addPedido(1, pedido1);
        assertEquals(MP.getCantidadColeccionCliente("costas"),1);
    }
    
}
