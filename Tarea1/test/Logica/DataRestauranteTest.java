
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DataRestauranteTest {
    
    public DataRestaurante valor(){
        //RESTAURANTE
        Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
        Map<Integer,File> colfoto1=new HashMap<Integer,File>();
        File foto1 = new File("src/Imagenes/co.jpg");
        colfoto1.put(1, foto1);
        DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
        
        return datarestaurante;
    }
    @Test
    public void testGetFoto() {
        
        File foto1 = new File("src/Imagenes/co.jpg");
        assertEquals(valor().getFoto(1),foto1);
                
    }
    
}
