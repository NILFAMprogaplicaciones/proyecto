
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataCantidadTest {
    
    Map<Integer,File> coleccionimagenes = new TreeMap<Integer, File>();
    Map<String,DataCantidad> CantidadProductos = new HashMap<String, DataCantidad>();
    Map<String,Categoria> coleccioncategoria = new HashMap<String,Categoria>();
   
    Categoria cate = new Categoria("Categoria");
    DataRestaurante DR= new DataRestaurante("contraseña","Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
    Restaurante res= new Restaurante(DR);
    File fichero = new File("src/Imagenes/usuario.png");
    Producto prod = new Producto("nombre","descripcion",res,"");
    DataCantidad DC = new DataCantidad(1,prod);
    
    
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        
        int resultado = DC.getCantidad();
        int esperado = 1;
        assertEquals(esperado, resultado);
   }

    /**
     * Test of getProducto method, of class DataCantidad.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
       
        Producto esperado = prod;
        Producto resultado = DC.getProducto();
        assertEquals(esperado.getnombre(), resultado.getnombre());
        assertEquals(esperado.getdescripcion(), resultado.getdescripcion());
    }   
}
