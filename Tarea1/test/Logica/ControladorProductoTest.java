
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import static org.eclipse.persistence.sdo.helper.extension.Token.DI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControladorProductoTest {
    
//  **** Aca defino todas las variables que preciso para los construnctores ****
    
    Map<Integer,File> coleccionimagenes = new TreeMap<Integer, File>();
    Map<String,DataCantidad> CantidadProductos = new HashMap<String, DataCantidad>();
    Map<String,Categoria> coleccioncategoria = new HashMap<String,Categoria>();
   
    Categoria cate = new Categoria("Categoria");
    DataRestaurante DR= new DataRestaurante("Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
    Restaurante res= new Restaurante(DR);
    File fichero = new File("src/Imagenes/usuario.png");
    DataPromocion DP= new DataPromocion(res,"Promo1", "Promocion",20, true, 10,CantidadProductos,fichero);
    DataIndividual DI = new DataIndividual("Individual","descripcion individual", res, 10, fichero);
    Individual individual = new Individual(DI);
    
    Fabrica fabrica = Fabrica.getInstance();
    IControladorProducto ICP = fabrica.getIControladorProducto();
    IControladorUsuario ICU = fabrica.getIControladorUsuario();
    ManejadorCategoria MJ = new ManejadorCategoria();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
//  **** Aca empiezan los test de los métodos de la clase ControladorProducto ****
    
    @Test
    public void testAltaProductoIndividual() {
        System.out.println("AltaProductoIndividual");
        MJ.coleccion().put(cate.getnombre(), cate);                         //Para dar de alta un restaurante, preciso una categoria.
        ICU.Caso_Registro_Restaurante(DR);
        ICP.AltaProductoIndividual(DI);
  
    }
    
    @Test
    public void testAltaProductoPromocion() {
        System.out.println("AltaProductoPromocion");
        MJ.coleccion().put(cate.getnombre(), cate);                         //Para dar de alta un restaurante, preciso una categoria.
        ICU.Caso_Registro_Restaurante(DR);                                  //Para dar de alta un producto, preciso un restaurante.
        ICP.AltaProductoPromocion(DP);
        
    }

    @Test
    public void testCaso_Ver_Individual() {
        System.out.println("Caso_Ver_Individual");
       
        testAltaProductoIndividual();                                       //esto llama al caso de uso AltaProductoIndividual.
        
        DataIndividual expResult = DI;                                      //el resultado esperado, es el DataIndividual que cree arriba.
        DataIndividual result = ICP.Caso_Ver_Individual(DI.getNombre());    //el resultado del caso de uso, es el DataIndividual que retonta el Caso_Ver_Individual
        
//      **** Comparo los campos del resultado esperado con los campos del resultado obtenido ****
       
        //assertEquals compara que ambos tengan el mismo valor
        assertEquals(expResult.getDescripcion(), result.getDescripcion());  
        assertEquals(expResult.getImagen(), result.getImagen());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getPrecio(), result.getPrecio(), 0);
        assertEquals(expResult.getRestaurante().getCantidadDeImagenes(), result.getRestaurante().getCantidadDeImagenes());
        assertEquals(expResult.getRestaurante().getcorreo(), result.getRestaurante().getcorreo());
        assertEquals(expResult.getRestaurante().getdireccion(), result.getRestaurante().getdireccion());
        assertEquals(expResult.getRestaurante().getnickname(), result.getRestaurante().getnickname());
        assertEquals(expResult.getRestaurante().getnombre(), result.getRestaurante().getnombre());

        //assertTrue, retorna TRUE si la expresion de adentro sea TRUE (existe tambien assertFalse idem assertTrue)
        assertTrue(result.getRestaurante().ExisteCategoria(cate.getnombre())== expResult.getRestaurante().ExisteCategoria(cate.getnombre()));
        assertTrue((expResult.getRestaurante().verificarproducto(expResult.getNombre())) == (result.getRestaurante().verificarproducto(result.getNombre())) );
         
//      **** Capas hay mas campos para comparar... pero a modo de prueba creo que es suficiente, algunos de los campos que
//           faltan comparar, pueden llegar a testearse en otras clases...        
    }

    
    @Test
    public void testCaso_Ver_Promocion() {              // ****IDEM testCaso_Ver_Individual() ****
        System.out.println("Caso_Ver_Promocion");             
                                  
        testAltaProductoPromocion();                                      
        
        DataPromocion expResult = DP;                                     
        DataPromocion result = ICP.Caso_Ver_Promocion(DP.getNombre());
        
        assertEquals(expResult.getDescripcion(), result.getDescripcion());  
        assertEquals(expResult.getImagen(), result.getImagen());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(result.getPrecioTotal(),expResult.getPrecioTotal(),0);
        assertEquals(expResult.getDescuento(),result.getDescuento(),0);
        assertEquals(expResult.getRestaurante().getcorreo(), result.getRestaurante().getcorreo());
        assertEquals(expResult.getRestaurante().getdireccion(), result.getRestaurante().getdireccion());
        assertEquals(expResult.getRestaurante().getnickname(), result.getRestaurante().getnickname());
        assertEquals(expResult.getRestaurante().getnombre(), result.getRestaurante().getnombre());
        
        assertTrue(expResult.getActiva()==result.getActiva());
    }
    
}
