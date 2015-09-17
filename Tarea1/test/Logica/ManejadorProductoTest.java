
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ManejadorProductoTest {
    
    Map<String,Producto> ColProducto = new HashMap<String,Producto>();
    Map<String,Categoria> colcat1=new HashMap<String,Categoria>();
    Map<Integer,File> colfoto1=new HashMap<Integer,File>();
    File foto1;
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
    Restaurante res=new Restaurante(datarestaurante);
    DataIndividual di=new DataIndividual("nombre", "descripcion", res, 100, foto1);
    Individual ind=new Individual(di);
    ManejadorProducto MP=new ManejadorProducto();
    
    Map<Integer,File> coleccionimagenes = new TreeMap<Integer, File>();
    Map<String,DataCantidad> CantidadProductos = new HashMap<String, DataCantidad>();
    Map<String,Categoria> coleccioncategoria = new HashMap<String,Categoria>();
   
    Categoria cate = new Categoria("Categoria");
    DataRestaurante DR= new DataRestaurante("contraseña","Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
    Restaurante res2= new Restaurante(DR);
    File fichero = new File("src/Imagenes/usuario.png");
    DataPromocion DP= new DataPromocion(res2,"Promo1", "Promocion",20, true, 10,CantidadProductos,fichero);
    Promocion pro=new Promocion(DP);
    
    @Test
    public void testGetColeccionProductos() {
        MP.addProductoIndividual(ind);
        assertEquals(MP.getColeccionProductos(res.getnickname()).size(),1);
    }

    @Test
    public void testCantidadProductos() {
        testGetColeccionProductos();
        assertEquals(MP.cantidadProductos(),1);
    }

    
    @Test
    public void testGetColeccion() {
        assertEquals(MP.getColeccion(),ColProducto);
    }

    
    @Test
    public void testCantidadProductosPromo() {
        
        //RESTAURANTE
        Map<Integer,File> coleccionimagenes = new TreeMap<Integer, File>();
        Map<String,DataCantidad> CantidadProductos = new HashMap<String, DataCantidad>();
        Map<String,Categoria> coleccioncategoria = new HashMap<String,Categoria>();
        Categoria cate = new Categoria("Categoria");
        DataRestaurante DR= new DataRestaurante("contraseña","Restaurante","res1", "res@res", "direccion",  coleccioncategoria,  coleccionimagenes);
        Restaurante res2= new Restaurante(DR);
        //PROMOCION
        DataCantidad data=new DataCantidad(1,pro);
        CantidadProductos.put(pro.getnombre(),data);
        File fichero = new File("src/Imagenes/usuario.png");
        DataPromocion DP= new DataPromocion(res2,"Promo1", "Promocion",20, true, 10,CantidadProductos,fichero);
        Promocion pro=new Promocion(DP);
        
        
        ManejadorProducto MP=new ManejadorProducto();
        MP.addProductoPromocion(pro);
        assertEquals(MP.CantidadProductosPromo(pro.getnombre()),1);
    }

    
      
}
