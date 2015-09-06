
package Logica;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ManejadorCategoriaTest {
   
    
    ManejadorCategoria MC= new ManejadorCategoria();
    String nombre = "Categoria";
    Categoria cat = new Categoria(nombre);

    @Test
    public void testAddCategoria() {
        System.out.println("addCategoria");
        MC.addCategoria(nombre, cat);
    }

   
    @Test
    public void testVerificoCat() {
        System.out.println("verificoCat");
        testAddCategoria();
        boolean expResult = true;
        boolean result = MC.verificoCat(nombre);
        assertTrue(result);  
    }
    
    @Test
    public void testCantidad() {
        System.out.println("cantidad");
        testAddCategoria();
        int expResult = 1;
        int result = MC.cantidad();
        assertEquals(expResult, result);
    }
    
   /* @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        testAddCategoria();
        Categoria result = MC.getCategoria(nombre);
        assertEquals(nombre, result.getnombre());
    }
   */
}
