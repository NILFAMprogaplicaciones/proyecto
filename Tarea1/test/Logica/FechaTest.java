
package Logica;

import org.junit.Test;
import static org.junit.Assert.*;


public class FechaTest {
    Fecha fecha = new Fecha(1,1,1);
 
    @Test
    public void testSetdia() {
        int dia = 0;
        
        fecha.setdia(dia);
        assertEquals(fecha.getdia(), dia);
    }

    
    @Test
    public void testSetmes() {
        int mes = 0;
        
        fecha.setmes(mes);
        assertEquals(fecha.getmes(), mes);
    }

    
    @Test
    public void testSetaño() {
        int anio = 0;
        
        fecha.setaño(anio);
        assertEquals(fecha.getaño(), anio);
    }
    
}
