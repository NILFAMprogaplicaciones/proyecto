
package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class FechaTest {
    Fecha fecha = new Fecha(1,1,1);
 
    @Test
    public void testSetdia() {
        System.out.println("setdia");
        int dia = 0;
        
        fecha.setdia(dia);
        assertEquals(fecha.getdia(), dia);
    }

    
    @Test
    public void testSetmes() {
        System.out.println("setmes");
        int mes = 0;
        
        fecha.setmes(mes);
        assertEquals(fecha.getmes(), mes);
    }

    
    @Test
    public void testSetaño() {
        System.out.println("seta\u00f1o");
        int anio = 0;
        
        fecha.setaño(anio);
        assertEquals(fecha.getaño(), anio);
    }
    
}
