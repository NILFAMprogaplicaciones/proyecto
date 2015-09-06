
package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CantidadTest {
    Promocion promo;
    Individual individual;
    
    Cantidad cantidad=new Cantidad(1,promo,individual);
    
    @Test
    public void testGetcantidad() {
        assertEquals(cantidad.getcantidad(), 1);
    }
    
}
