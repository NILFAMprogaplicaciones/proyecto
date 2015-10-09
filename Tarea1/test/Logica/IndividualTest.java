
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;



public class IndividualTest {
    
Map<Integer,File> coleccionimagenes = new TreeMap<Integer, File>();
Map<String,DataCantidad> CantidadProductos = new HashMap<String, DataCantidad>();
Map<String,Categoria> coleccioncategoria = new HashMap<String,Categoria>();

DataRestaurante DR= new DataRestaurante("contraseña","Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
Restaurante res= new Restaurante(DR);
File fichero = new File("src/Imagenes/usuario.png");
File fichero1 = new File("src/Imagenes/co.jpeg");

DataIndividual Individual = new DataIndividual("nombre","desc",res, 10,fichero,"");
Individual Indi = new Individual(Individual);
   

@Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 0.0;
        Indi.setPrecio(precio);
        assertEquals(precio,Indi.getPrecio(),0);
        
    }

    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
       
        Indi.setImagen(fichero1);
        File esperado = new File("src/Imagenes/co.jpeg");
// TODO review the generated test code and remove the default call to fail.
        assertEquals(esperado,Indi.getImagen());
    }
    
}
