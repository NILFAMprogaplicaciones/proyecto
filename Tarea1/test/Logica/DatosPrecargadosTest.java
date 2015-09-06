
package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DatosPrecargadosTest {
    
    Fabrica fabrica = Fabrica.getInstance();
    IDatosPrecargados ICDP = fabrica.getIDatosPrecargados();
    
    @Test
    public void testGetinstance() {
        ICDP.DatosPrecargado();
    }

}
