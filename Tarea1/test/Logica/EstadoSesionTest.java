
package Logica;

import org.junit.Test;
import static org.junit.Assert.*;


public class EstadoSesionTest {
    
    
    @Test
    public void testValueOf() {
        EstadoSesion LOGIN_CORRECTO = EstadoSesion.valueOf("LOGIN_CORRECTO");
        EstadoSesion LOGIN_INCORRECTO = EstadoSesion.valueOf("LOGIN_INCORRECTO");
        EstadoSesion NO_LOGIN = EstadoSesion.valueOf("NO_LOGIN");
        assertEquals(LOGIN_CORRECTO, EstadoSesion.LOGIN_CORRECTO);
        assertEquals(LOGIN_INCORRECTO, EstadoSesion.LOGIN_INCORRECTO);
        assertEquals(NO_LOGIN, EstadoSesion.NO_LOGIN);
    }
    
}
