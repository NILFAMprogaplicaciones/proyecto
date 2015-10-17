
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControladorUsuarioTest {
    
    
    
    //CLIENTE
    Fecha fecha1=new Fecha(15,11,1983);
    File foto1 = new File("src/Imagenes/co.jpg");
    DataCliente datacliente1=new DataCliente("contraseña","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,""); 
        
    //RESTAURANTE
    Map<String,Categoria> colcat1=new HashMap<>();
    Map<Integer,File> colfoto1=new HashMap<>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        
    Fabrica fabrica = Fabrica.getInstance();
    IControladorUsuario ICU = fabrica.getIControladorUsuario();
    ManejadorCategoria MC=new ManejadorCategoria();

    @Test
    public void testCaso_Registro_Cliente() {
        ICU.Caso_Registro_Cliente(datacliente1);
    }

    @Test
    public void testCaso_Ver_Cliente() {
        testCaso_Registro_Cliente();
        
        DataCliente ResultadoEsperado = datacliente1;                                      //el resultado esperado, es el DataIndividual que cree arriba.
        DataCliente Resultado = ICU.Caso_Ver_Cliente(datacliente1.getnickname());
        
        assertEquals(ResultadoEsperado.getnombre(), Resultado.getnombre()); 
        assertEquals(ResultadoEsperado.getnickname(), Resultado.getnickname());
        assertEquals(ResultadoEsperado.getcorreo(), Resultado.getcorreo());
        assertEquals(ResultadoEsperado.getdireccion(), Resultado.getdireccion());
        assertEquals(ResultadoEsperado.getapellido(), Resultado.getapellido());
        assertEquals(ResultadoEsperado.getfechastring(), Resultado.getfechastring());
        assertEquals(ResultadoEsperado.getFoto(), Resultado.getFoto());
         
    }

    @Test
    public void testCaso_Registro_Restaurante() {
        ICU.Caso_Registro_Restaurante(datarestaurante);
    }

    @Test
    public void testCaso_Ver_Restaurante() {
        testCaso_Registro_Restaurante();
        
        DataRestaurante ResultadoEsperado = datarestaurante;                                      //el resultado esperado, es el DataIndividual que cree arriba.
        DataRestaurante Resultado = ICU.Caso_Ver_Restaurante(datarestaurante.getnickname());
        
        assertEquals(ResultadoEsperado.getnombre(), Resultado.getnombre()); 
        assertEquals(ResultadoEsperado.getnickname(), Resultado.getnickname());
        assertEquals(ResultadoEsperado.getcorreo(), Resultado.getcorreo());
        assertEquals(ResultadoEsperado.getdireccion(), Resultado.getdireccion());
        assertEquals(ResultadoEsperado.getColeccionCategoria(), Resultado.getColeccionCategoria());
        assertEquals(ResultadoEsperado.getColeccionImagenes(), Resultado.getColeccionImagenes());
        
    }

    @Test
    public void testAltaCategoria() {
        ICU.AltaCategoria("Categoria");
    }

    @Test
    public void testCantClientes() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.CantClientes(), mu.CantClientes());
    }

    
    @Test
    public void testObtenercoleccion() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.obtenercoleccion(), mu.obtenercoleccion());
    }

    
    @Test
    public void testColeccion() {
        testCaso_Registro_Cliente();
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        assertEquals(ICU.coleccion(),mc.coleccion() );
    }

    
    @Test
    public void testGetColeccionRestaurante() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.getColeccionRestaurante(), mu.getColeccionRestaurante());
    }

    
    @Test
    public void testGetColeccionClientes() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.getColeccionClientes(), mu.getColeccionClientes());
    }

    
    @Test
    public void testGetColeccionProductosRestaurantes() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.getColeccionProductosRestaurantes("mera"), mu.getColeccionProductosRestaurantes("mera"));
    }

    
    @Test
    public void testFindRestaurante() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.findRestaurante("mera"), mu.findRestaurante("mera"));
    }

    
    @Test
    public void testFindCliente() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();       
        assertEquals(ICU.findCliente("costas"), mu.findCliente("costas"));
    }

    
    @Test
    public void testGetCategoriasRestaurantes() {
        testCaso_Registro_Cliente();
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        assertEquals(ICU.getCategoriasRestaurantes("mera"), mu.getCategoriasRestaurantes("mera"));
    }

    
    @Test
    public void testExcepcionCategoria() throws Exception {
        testCaso_Registro_Cliente();
        try{
            Categoria c=new Categoria("cate");
            colcat1.put(c.getnombre(), c);
            ICU.ExcepcionCategoria("cate");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            Categoria c=new Categoria("jjjj");
            colcat1.put(c.getnombre(), c);
            ICU.ExcepcionCategoria("cate");
        }catch(ExcepcionesPersonalizadas ep){}
    }

    
    @Test
    public void testExcepcionDatosCliente() throws Exception {
        testCaso_Registro_Cliente();
        try{
            ICU.ExcepcionDatosCliente("costas", "L", "L", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "gcostas@gmail.com", "L", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("", "L@", "L", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "", "L", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "L", "", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "L", "L", "", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "L", "L", "L", "DIA", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "L", "L", "L", "L", "MES", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "L", "L", "L", "L", "L", "AÑO");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L", "L", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosCliente("L", "L@", "L", "L", "L", "L", "L", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
    }

    
    @Test
    public void testExcepcionDatosRestaurante() throws Exception {
        testCaso_Ver_Restaurante();
        Map<String,Categoria> coleccion=new HashMap<>(); 
        
        try{
            ICU.ExcepcionDatosRestaurante("mera", "L", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosRestaurante("L", "mera@hotmail.com", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosRestaurante("", "L@", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosRestaurante("L", "", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosRestaurante("L", "L@", "", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosRestaurante("L", "L@", "L", "", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            ICU.ExcepcionDatosRestaurante("L", "L@", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            Categoria c=new Categoria("cate");
            coleccion.put(c.getnombre(), c);
            ICU.ExcepcionDatosRestaurante("L", "L", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            Categoria c=new Categoria("cate");
            coleccion.put(c.getnombre(), c);
            ICU.ExcepcionDatosRestaurante("L", "L@", "L", "L", coleccion);
        }catch(ExcepcionesPersonalizadas ep){}
    }

    
    @Test
    public void testGetCategoria() {
        Categoria c=new Categoria("cate");
        colcat1.put(c.getnombre(), c);
        ICU.Caso_Registro_Restaurante(datarestaurante);
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        assertEquals(ICU.getCategoria("cate"),mc.getCategoria("cate") );
    }

    
    @Test
    public void testGetProductoRestaurante() {
        testCaso_Registro_Restaurante();
        DataIndividual di=new DataIndividual("prod", "desc", ICU.findRestaurante("mera") , 100, foto1, "");
        
        Fabrica fabrica=Fabrica.getInstance();
        IControladorProducto ICP=fabrica.getIControladorProducto();
        ICP.AltaProductoIndividual(di);
        
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        
        assertEquals(ICU.getProductoRestaurante("mera", "prod"), mu.getProductoRestaurante("mera", "prod"));
    }
    
}
