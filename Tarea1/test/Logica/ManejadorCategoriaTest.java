
package Logica;

import org.junit.Test;
import static org.junit.Assert.*;


public class ManejadorCategoriaTest {
   
    
    ManejadorCategoria MC= new ManejadorCategoria();
    String nombre = "Categoria";
    Categoria cat = new Categoria(nombre);

   
    @Test
    public void testAddCategoria() {
        MC.addCategoria(nombre, cat);
    }

   
    @Test
    public void testVerificoCat() {
        testAddCategoria();
        boolean result = MC.verificoCat(nombre);
        assertTrue(result);  
    }
    
    @Test
    public void testCantidad() {
        testAddCategoria();
        int expResult = 1;
        int result = MC.cantidad();
        assertEquals(expResult, result);
    }
    
   
    @Test
    public void testExcepcionCategoria() throws Exception {
        testAddCategoria();
        try{
            MC.ExcepcionCategoria(nombre);
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            MC.ExcepcionCategoria("");}
        catch(ExcepcionesPersonalizadas ep){}
    }
}
