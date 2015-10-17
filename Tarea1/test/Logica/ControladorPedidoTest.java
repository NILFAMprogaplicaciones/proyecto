
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
    Map<String,Categoria> colcat1=new HashMap<>();
    Map<Integer,File> colfoto1=new HashMap<>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
    Restaurante res1=new Restaurante(datarestaurante);
    //PEDIDO
    FechaHora fecha=new FechaHora(12,8,2015,0,0);
    Map<String,Producto> col1=new HashMap<>();
        //TIPO ASOSIATIVO
    Map<String,DataProductosPedido> colpp1=new HashMap<>();
    TipoAsosiativoPedido tap1=new TipoAsosiativoPedido(colpp1);
    DataPedido datapedido=new DataPedido(1, fecha, 220, Estado.PREPARCION, cliente1, col1,  res1, tap1);
    DataPedido datapedido2=new DataPedido(2, fecha, 220, Estado.ENVIADO, cliente1, col1,  res1, tap1);
    Pedido pedido1=new Pedido(datapedido);
    
    Fabrica fabrica = Fabrica.getInstance();
    IControladorPedido ICP = fabrica.getIControladorPedido();

    @Test
    public void testCaso_Generar_Pedido() {
        ICP.Caso_Generar_Pedido(datapedido);
    }

    @Test
    public void testCaso_Ver_Pedido() {
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
        testCaso_Generar_Pedido();
        
        ICP.Caso_Actualizar_Estado_Pedido(1, Estado.ENVIADO);
        DataPedido ResultadoEsperado=ICP.Caso_Ver_Pedido(1);
        
        assertEquals(ResultadoEsperado.getEstado(), Estado.ENVIADO);
    }
   
    @Test
    public void testCaso_Cancelar_Pedido() {
        testCaso_Generar_Pedido();
        
        ICP.Caso_Cancelar_Pedido(datapedido.getId());
        
    }

    @Test
    public void testCaso_Cancelar_Pedido2() {
        ICP.Caso_Generar_Pedido(datapedido2);
        ICP.Caso_Cancelar_Pedido(datapedido2.getId());
    }

    
    @Test
    public void testCaso_Ingresar_Comentario() {
        testCaso_Generar_Pedido();
        DataComentario dc=new DataComentario(pedido1, fecha1, "info", "texto", 100, cliente1);
        ICP.Caso_Ingresar_Comentario(dc);
    }

    
    @Test
    public void testGetCantidadEnColeccion() {
        testCaso_Generar_Pedido();
        ManejadorPedido mp=ManejadorPedido.getinstance();
        assertEquals(ICP.getCantidadEnColeccion(), mp.getCantidadEnColeccion());
    }

    
    @Test
    public void testGetColeccionPedido() {
        testCaso_Generar_Pedido();
        ManejadorPedido mp=ManejadorPedido.getinstance();
        assertEquals(ICP.getColeccionPedido(), mp.getColeccionPedido());
    }

    
    @Test
    public void testGetPedido() {
        testCaso_Generar_Pedido();
        ManejadorPedido mp=ManejadorPedido.getinstance();
        assertEquals(ICP.getPedido(1), mp.getPedido(1));
    }

    
    @Test
    public void testGetCantidadColeccionCliente() {
        testCaso_Generar_Pedido();
        ManejadorPedido mp=ManejadorPedido.getinstance();
        assertEquals(ICP.getCantidadColeccionCliente("costas"), mp.getCantidadColeccionCliente("costas"));
    }

    
    @Test
    public void testExcepcionEliminacion() throws Exception {
        try{
            testCaso_Generar_Pedido();
            ICP.ExcepcionEliminacion(1);
        }catch(ExcepcionesPersonalizadas ep){}
    }

    
    @Test
    public void testGetPedidos_Producto() {
        
        ManejadorPedido mp=ManejadorPedido.getinstance();
        
        Producto p=new Producto("prod", "desc", res1, "");
        col1.put(p.getnombre(), p);
        testCaso_Generar_Pedido();
        
        assertEquals(ICP.getPedidos_Producto("prod"), mp.getPedidos_Producto("prod"));
    }
    
}
