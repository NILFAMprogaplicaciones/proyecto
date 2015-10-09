
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;


public class PromocionTest {
    
 
    Map<Integer,File> coleccionimagenes = new TreeMap<Integer, File>();
    Map<String,DataCantidad> CantidadProductos = new HashMap<String, DataCantidad>();
    Map<String,Categoria> coleccioncategoria = new HashMap<String,Categoria>();
   
    Categoria cate = new Categoria("Categoria");
    DataRestaurante DR= new DataRestaurante("contraseña","Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
    Restaurante res= new Restaurante(DR);
    File fichero = new File("src/Imagenes/usuario.png");
    DataPromocion DP= new DataPromocion(res,"Promo1", "Promocion",20, false, 10,CantidadProductos,fichero,"");
    Promocion promo = new Promocion (DP);
    Producto prod = new Producto("nombre","descripcion",res,"");
    DataCantidad DC = new DataCantidad(1,prod);
    
    
    @Test
    public void testAddProducto() {
        System.out.println("addProducto");
        
        promo.addProducto(prod.getnombre(),DC);
                
    }
    
    @Test
    public void testsetactiva(){
        
        boolean esperado = true;
        promo.setactiva(esperado);
        boolean res = promo.getactiva();
        assertTrue(res);
    }
    
    @Test
      public void testsetdescuento(){
        
        int esperado = 5;
        promo.setdescuento(esperado);
        
       assertEquals(esperado,promo.getdescuento());
    }
       
    @Test       
    public void testCantidadProductos(){
          
        testAddProducto();
        int esperado = 1;
        int res = promo.CantidadProductos();
        assertEquals(esperado, res);
       
    }
    
}
