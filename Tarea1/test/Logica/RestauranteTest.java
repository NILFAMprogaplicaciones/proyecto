
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class RestauranteTest {
    
    
    @Test
    public void testExisteCategoria() {
        
        //RESTAURANTE
        Map<String,Categoria> colcat=new HashMap<>();
        Categoria cat=new Categoria("cat1");
        colcat.put(cat.getnombre(), cat);
        Map<Integer,File> colfoto=new HashMap<>();
        DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat,colfoto);
        Restaurante res=new Restaurante(datarestaurante);
        
        assertEquals(res.ExisteCategoria("cat1"),true);
        assertEquals(res.ExisteCategoria("cat"),false);
        assertEquals(res.getcontraseña(),"contraseña");
    }
    
}
