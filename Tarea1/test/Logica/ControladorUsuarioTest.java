
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControladorUsuarioTest {
    
    
    
    //CLIENTE
    Fecha fecha1=new Fecha(15,11,1983);
    File foto1 = new File("src/Imagenes/co.jpg");
    DataCliente datacliente1=new DataCliente("contraseña","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,""); 
        
    //RESTAURANTE
    Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
    Map<Integer,File> colfoto1=new HashMap<Integer,File>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        
    Fabrica fabrica = Fabrica.getInstance();
    IControladorUsuario ICU = fabrica.getIControladorUsuario();
    ManejadorCategoria MC=new ManejadorCategoria();
    
    @Test
    public void testCaso_Registro_Cliente() {
        System.out.println("Caso_Registro_Cliente");
        
        ICU.Caso_Registro_Cliente(datacliente1);
    }

    @Test
    public void testCaso_Ver_Cliente() {
        System.out.println("Caso_Ver_Cliente");
        
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
        System.out.println("Caso_Registro_Restaurante");
        
        ICU.Caso_Registro_Restaurante(datarestaurante);
    }

    @Test
    public void testCaso_Ver_Restaurante() {
        System.out.println("Caso_Ver_Restaurante");
        
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
        System.out.println("AltaCategoria");
        ICU.AltaCategoria("Categoria");
        
    }
    
}
