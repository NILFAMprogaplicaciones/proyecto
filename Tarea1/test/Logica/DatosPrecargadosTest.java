
package Logica;

import org.junit.Test;


public class DatosPrecargadosTest {
    
    Fabrica fabrica = Fabrica.getInstance();
    IDatosPrecargados ICDP = fabrica.getIDatosPrecargados();
    
    @Test
    public void testGetinstance() {
        DatosPrecargados dp=DatosPrecargados.getinstance();
        ICDP.DatosPrecargado();
    }

}
