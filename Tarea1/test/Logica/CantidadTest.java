
package Logica;

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
