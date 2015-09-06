
package Logica;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ClienteTest {
    
    Fecha fecha1=new Fecha(15,11,1983);
    File foto1 = new File("src/Imagenes/co.jpg");
    DataCliente datacliente1=new DataCliente("Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1); 
    Cliente cliente=new Cliente(datacliente1);
    
    @Test
    public void testSetapellido() {
        cliente.setapellido("apellido");
        assertEquals(cliente.getapellido(), "apellido");
    }

    @Test
    public void testSetfecha() {
        Fecha fecha=new Fecha(1,2,3);
        cliente.setfecha(fecha);
        assertEquals(cliente.getfecha().getdia(), 1);
        assertEquals(cliente.getfecha().getmes(), 2);
        assertEquals(cliente.getfecha().getaño(), 3);
    }
    
}
