
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class PedidoTest {
    
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
    Map<String,Producto> col1=new HashMap<String,Producto>();
    //TIPO ASOSIATIVO
    Map<String,DataProductosPedido> colpp1=new HashMap<String,DataProductosPedido>();
    TipoAsosiativoPedido tap1=new TipoAsosiativoPedido(colpp1);
    DataPedido datapedido=new DataPedido(1, fecha, 220, Estado.PREPARCION, cliente1, col1,  res1, tap1);
    
    Pedido pedido=new Pedido(datapedido);

    
    @Test
    public void testVerificarSets() {
        //CLIENTE
        Fecha fechacli=null;
        File fotocli=null;
        DataCliente datacliente1=new DataCliente("contraseña","cliente", "cli", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fechacli, fotocli,""); 
        Cliente cli=new Cliente(datacliente1);
        
        //RESTAURANTE
        Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
        Map<Integer,File> colfoto1=new HashMap<Integer,File>();
        DataRestaurante datarestaurante=new DataRestaurante("contraseña","restaurante","res","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        Restaurante res=new Restaurante(datarestaurante);
        
        FechaHora fecha=new FechaHora(1,1,1,1,1);
        Map<String,Producto> col=new HashMap<String,Producto>();
        pedido.setColeccionProductos(col);
        pedido.setNum(2);
        pedido.setFecha(fecha);
        pedido.setPrecioTotal(100);
        pedido.setCliente(cli);
        pedido.setRestaurante(res);
        
        assertEquals(pedido.verfechastring(), "1/1/1-1:1");
        assertEquals(pedido.getColeccionProductos(), col);
        assertEquals(pedido.getnum(), 2);
        assertEquals((int)pedido.getPrecioTotal(), 100);
        assertEquals(pedido.getCliente().getnickname(), "cli");
        assertEquals(pedido.getRestaurante().getnickname(), "res");
        
        
    }

    @Test
    public void testGetComentario() {
        
        DataComentario dc=new DataComentario(pedido, fecha1, "info", "comentario", 4, cliente1);
        Comentario c=new Comentario(dc);
        pedido.setComentario(c);
        assertEquals(pedido.getComentario(), c);
        
    }
}
