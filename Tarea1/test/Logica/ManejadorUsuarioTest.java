
package Logica;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;


public class ManejadorUsuarioTest {
    
    Map<String,Usuario> ColeccionUsuarios = new HashMap<>();
    Map<String,DataCantidad> CantidadProductos = new HashMap<>();
    //CLIENTE
    Fecha fecha1;
    File foto1;
    DataCliente datacliente1=new DataCliente("contraseña","Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1,""); 
    Cliente cli=new Cliente(datacliente1);
    //RESTAURANTE
    Map<String,Categoria> colcat1=new HashMap<>();
    Map<Integer,File> colfoto1=new HashMap<>();
    DataRestaurante datarestaurante=new DataRestaurante("contraseña","Pizzeria Mera","mera","mera@hotmail.com","Av 8 de octubre 2704",colcat1,colfoto1);
    Restaurante res=new Restaurante(datarestaurante);
    //INDIVIDUAL
    DataIndividual di=new DataIndividual("nombre", "descripcion", res, 100, foto1,"");
    Individual ind=new Individual(di);
    //PROMOCION
    DataPromocion DP= new DataPromocion(res,"Promo1", "Promocion",20, true, 10,CantidadProductos,foto1,"");
    Promocion pro=new Promocion(DP);
    ManejadorUsuario MU=new ManejadorUsuario();

    
    
    public void agregar(){
        MU.addUsuario(cli.getnickname(), cli);
        MU.addUsuario(res.getnickname(), res);
    }
    @Test
    public void testVerificarnickname() {
        
        agregar();
        assertEquals(MU.verificarnickname("costas"), true);
    }

    @Test
    public void testVerificarcorreo() {
        
        agregar();
        assertEquals(MU.verificarcorreo("gcostas@gmail.com"), true);
    }

    @Test
    public void testCantUsuarios() {
        
        agregar();
        assertEquals(MU.CantUsuarios(), 2);
    }

    @Test
    public void testCantClientes() {
        
        agregar();
        assertEquals(MU.CantClientes(), 1);
    }

    @Test
    public void testObtenercoleccion() {
        
        agregar();
        ColeccionUsuarios.put(cli.getnickname(), cli);
        ColeccionUsuarios.put(res.getnickname(), res);
        assertEquals(MU.obtenercoleccion(), ColeccionUsuarios);
    }

    @Test
    public void testGetColeccionRestaurante() {
        
        agregar();
        ColeccionUsuarios.put(res.getnickname(), res);
        assertEquals(MU.getColeccionRestaurante(), ColeccionUsuarios);
        
    }

    @Test
    public void testGetColeccionProductosRestaurantes() {
        
        agregar();
        MU.addProductoIndividual("mera", ind);
        Map<String,Producto> ColProducto = new HashMap<>();
        ColProducto.put(ind.getnombre(), ind);
        assertEquals(MU.getColeccionProductosRestaurantes("mera"), ColProducto);
        
    }

    @Test
    public void testBuscarprecioproducto() {
        
        agregar();
        MU.addProductoIndividual("mera", ind);
        
        assertEquals((int) MU.buscarprecioproducto("mera", ind.getnombre()), 100);
        MU.addProductoPromocion("mera", pro);
        assertEquals((int)MU.buscarprecioproducto("mera", pro.getnombre()), 20);
    }

    @Test
    public void testGetCategoriasRestaurantes() {
       
        agregar();
        assertEquals(MU.getCategoriasRestaurantes("mera"), colcat1);
    }

    
    @Test
    public void testExcepcionDatosCliente_String_String() throws Exception {
        agregar();
        try{
            MU.ExcepcionDatosCliente("costas", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            MU.ExcepcionDatosCliente("L", "gcostas@gmail.com");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            MU.ExcepcionDatosCliente("L", "L@");
        }catch(ExcepcionesPersonalizadas ep){}
    }

    
    
    @Test
    public void testExcepcionDatosRestaurante_String_String() throws Exception {
        agregar();
        try{
            MU.ExcepcionDatosRestaurante("mera", "L");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            MU.ExcepcionDatosRestaurante("L", "mera@hotmail.com");
        }catch(ExcepcionesPersonalizadas ep){}
        
        try{
            MU.ExcepcionDatosRestaurante("L", "L@");
        }catch(ExcepcionesPersonalizadas ep){}
    }
    
}
