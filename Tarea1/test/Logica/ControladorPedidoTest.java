
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControladorPedidoTest {
    
    
    
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
    DataPedido datapedido2=new DataPedido(2, fecha, 220, Estado.ENVIADO, cliente1, col1,  res1, tap1);
    Pedido pedido1=new Pedido(datapedido);
    
    Fabrica fabrica = Fabrica.getInstance();
    IControladorPedido ICP = fabrica.getIControladorPedido();
        
    @Test
    public void testCaso_Generar_Pedido() {
        System.out.println("Caso_Generar_Pedido");
        ICP.Caso_Generar_Pedido(datapedido);
        
    }

    @Test
    public void testCaso_Ver_Pedido() {
        System.out.println("Caso_Ver_Pedido");
        
        testCaso_Generar_Pedido();
        
        DataPedido ResultadoEsperado = datapedido;   
        DataPedido Resultado = ICP.Caso_Ver_Pedido(datapedido.getId());
            //NO PUEDO COMPARAR DOUBLE, ENTONCES LO PARSEO
        int precioesperado=(int) datapedido.getPrecioTotal(),precio=(int) Resultado.getPrecioTotal();
        // Estado.PREPARCION, cliente1, col1,  res1, tap1);
        assertEquals(ResultadoEsperado.getId(), Resultado.getId()); 
        assertEquals(ResultadoEsperado.getFechaHora().getDia(), Resultado.getFechaHora().getDia()); 
        assertEquals(ResultadoEsperado.getFechaHora().getMes(), Resultado.getFechaHora().getMes()); 
        assertEquals(ResultadoEsperado.getFechaHora().getAño(), Resultado.getFechaHora().getAño()); 
        assertEquals(ResultadoEsperado.getFechaHora().getHora(), Resultado.getFechaHora().getHora());
        assertEquals(ResultadoEsperado.getFechaHora().getMinuto(), Resultado.getFechaHora().getMinuto());
        assertEquals(precioesperado, precio);
        assertEquals(ResultadoEsperado.getId(), Resultado.getId()); 
        assertEquals(ResultadoEsperado.getEstado(), Resultado.getEstado()); 
        assertEquals(ResultadoEsperado.getCliente().getnickname(), Resultado.getCliente().getnickname());
        assertEquals(ResultadoEsperado.getColeccionProductos(), Resultado.getColeccionProductos()); 
        assertEquals(ResultadoEsperado.getRestaurante().getnickname(), Resultado.getRestaurante().getnickname());
        assertEquals(ResultadoEsperado.getTipoAP(), Resultado.getTipoAP());
             
    }
    @Test
    public void testCaso_Actualizar_Estado_Pedido() {
        System.out.println("Caso_Actualizar_Estado_Pedido");
        
        testCaso_Generar_Pedido();
        
        ICP.Caso_Actualizar_Estado_Pedido(1, Estado.ENVIADO);
        DataPedido ResultadoEsperado=ICP.Caso_Ver_Pedido(1);
        
        assertEquals(ResultadoEsperado.getEstado(), Estado.ENVIADO);
    }
   
    @Test
    public void testCaso_Cancelar_Pedido() {
        System.out.println("Caso_Cancelar_Pedido");
        
        testCaso_Generar_Pedido();
        
        ICP.Caso_Cancelar_Pedido(datapedido.getId());
        
    }

    @Test
    public void testCaso_Cancelar_Pedido2() {
        System.out.println("Caso_Cancelar_Pedido");
        
        ICP.Caso_Generar_Pedido(datapedido2);
        ICP.Caso_Cancelar_Pedido(datapedido2.getId());
        
    }
    
}
