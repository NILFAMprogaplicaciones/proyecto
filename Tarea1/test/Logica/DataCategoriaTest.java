
package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
