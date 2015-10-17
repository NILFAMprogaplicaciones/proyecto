
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataCantidadTest {
    
    Map<Integer,File> coleccionimagenes = new TreeMap<>();
    Map<String,DataCantidad> CantidadProductos = new HashMap<>();
    Map<String,Categoria> coleccioncategoria = new HashMap<>();
   
    Categoria cate = new Categoria("Categoria");
    DataRestaurante DR= new DataRestaurante("contraseña","Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
    Restaurante res= new Restaurante(DR);
    File fichero = new File("src/Imagenes/usuario.png");
    Producto prod = new Producto("nombre","descripcion",res,"");
    DataCantidad DC = new DataCantidad(1,prod);
    
    
    @Test
    public void testGetCantidad() {
        int resultado = DC.getCantidad();
        int esperado = 1;
        assertEquals(esperado, resultado);
    }

    
    @Test
    public void testGetProducto() {
        Producto esperado = prod;
        Producto resultado = DC.getProducto();
        assertEquals(esperado.getnombre(), resultado.getnombre());
        assertEquals(esperado.getdescripcion(), resultado.getdescripcion());
    }   
}
