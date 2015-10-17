
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class ComentarioTest {
    
    //CLIENTE
    Fecha fecha1=new Fecha(15,11,1983);
    File foto1 = new File("src/Imagenes/co.jpg");
    DataCliente datacliente1=new DataCliente("contraseña","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,""); 
    Cliente cliente1=new Cliente(datacliente1);
    //RESTAURANTE  
    Map<String,Categoria> colcat1=new HashMap<>();
    Map<Integer,File> colfoto1=new HashMap<>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
    Restaurante res1=new Restaurante(datarestaurante);
    //PEDIDO
    FechaHora fecha=new FechaHora(12,8,2015,0,0);
    Producto prod=new Producto("producto","descripcion",res1,"");
    Map<String,Producto> col1=new HashMap<>();
        
        //TIPO ASOSIATIVO
    Map<String,DataProductosPedido> colpp1=new HashMap<>();
    TipoAsosiativoPedido tap1=new TipoAsosiativoPedido(colpp1);
    DataPedido datapedido=new DataPedido(1, fecha, 220, Estado.ENVIADO, cliente1, col1,  res1, tap1);
    Pedido pedido1=new Pedido(datapedido);
    
    DataComentario dc=new DataComentario(pedido1, fecha1, "info", "descripcion", 4, cliente1);
    Comentario c=new Comentario(dc);
    
    @Test
    public void testGetPedido() {
        assertEquals(c.getPedido(), pedido1);
        assertEquals(c.getFecha(), fecha1);
        assertEquals(c.getInfoPedido(), "info");
        assertEquals(c.getTexto(), "descripcion");
        assertEquals(c.getPuntaje(), 4);
        assertEquals(c.getCliente(), cliente1);
    }
}
