
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
    
    @Test
    public void testBusquedaCPR() {
        Fabrica fabrica=Fabrica.getInstance();
        IControladorProducto ICP=fabrica.getIControladorProducto();
        IControladorUsuario ICU=fabrica.getIControladorUsuario();
        
        //RESTAURANTE
        Map<String,Categoria> colcat=new HashMap<>();
        Categoria cat=new Categoria("cat1");
        colcat.put(cat.getnombre(), cat);
        Map<Integer,File> colfoto=new HashMap<>();
        DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat,colfoto);
        ICU.Caso_Registro_Restaurante(datarestaurante);
        
        Restaurante res=ICU.findRestaurante("mera");
        File foto=new File("src/Imagenes/producto.jpg");
        DataIndividual di=new  DataIndividual("producto", "", res,150, foto, "");
        ICP.AltaProductoIndividual(di);
        
        assertEquals(res.BusquedaCategoria("ca"),true);
        assertEquals(res.BusquedaProducto("prod"),true);
        assertEquals(res.BusquedaRestaurante("mera"),true);
        assertEquals(res.ExisteCategoria("cat1"),true);
        assertEquals(res.ExisteCategoria("cat"),false);
        assertEquals(res.getcontraseña(),"contraseña");
    }
}
