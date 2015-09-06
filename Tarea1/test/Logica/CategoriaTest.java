
package Logica;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CategoriaTest {
    
    Categoria cate=new Categoria("cat1");
    
    @Test
    public void testGetnombre() {
        
       assertEquals(cate.getnombre(), "cat1");
    }

    @Test
    public void testSetnombre() {
        cate.setnombre("categoria1");
        assertEquals(cate.getnombre(), "categoria1");
    }
    
}
