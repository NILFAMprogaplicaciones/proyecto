
package Logica;

import org.junit.Test;
import static org.junit.Assert.*;


public class EstadoTest {
    
    
    @Test
    public void testValueOf() {
        Estado PREPARCION=Estado.valueOf("PREPARCION");
        Estado ENVIADO=Estado.valueOf("ENVIADO");
        Estado RECIBIDO=Estado.valueOf("RECIBIDO");
        assertEquals(PREPARCION, Estado.PREPARCION);
        assertEquals(ENVIADO, Estado.ENVIADO);
        assertEquals(RECIBIDO, Estado.RECIBIDO);
    }
    
}
