
package Logica;

import org.junit.Test;
import static org.junit.Assert.*;


public class DataCategoriaTest {
    
    DataCategoria dc=new DataCategoria();
    
    DataCategoria datac=new DataCategoria("datacategoria");
    @Test
    public void testgetNombre() {
        assertEquals(datac.getNombre(), "datacategoria");
    }
    
}
