
package Auxiliar;

import Logica.Cliente;
import Logica.DataCliente;
import Logica.DataIndividual;
import Logica.DataPedido;
import Logica.DataPromocion;
import Logica.DataRestaurante;
import Logica.Estado;
import Logica.Fabrica;
import Logica.Fecha;
import Logica.IControladorPedido;
import Logica.IControladorProducto;
import Logica.IControladorUsuario;
import Logica.ManejadorCategoria;
import Logica.ManejadorPedido;
import Logica.ManejadorProducto;
import Logica.ManejadorUsuario;
import Logica.Pedido;
import Logica.Restaurante;
import Logica.Usuario;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.*;


public class Auxiliar extends HttpServlet {

    static public Map getColeccionDataCliente() {
        Map<String,DataCliente> colDataCliente=new HashMap<>();
        IControladorUsuario ICU;
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        //ManejadorUsuario mu=ManejadorUsuario.getinstance();
        Iterator<Usuario> it = ICU.getColeccionClientes().values().iterator();
        Cliente c;
        Usuario u;
        while (it.hasNext()){
                    u=it.next();
                    c=(Cliente)u;
                    DataCliente dc=new DataCliente(c.getContraseña(), c.getnombre(), c.getnickname(), c.getcorreo(), 
                            c.getdireccion(),c.getapellido(), c.getfecha(),c.getFoto(), c.getDireccionFoto());
                    
                    colDataCliente.put(dc.getnickname(), dc);
        }
        return colDataCliente;
        
    }
    
    static public DataCliente getCliente(String cliente) {
        IControladorUsuario ICU;
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica .getIControladorUsuario();
        DataCliente dc=ICU.Caso_Ver_Cliente(cliente);
        return dc;
        
    }
    static public Map getColeccionDataRestaurante() {
        Map<String,DataRestaurante> colDataRestaurante=new HashMap<>();
        IControladorUsuario ICU;
        Fabrica fabrica =Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        //ManejadorUsuario mu=ManejadorUsuario.getinstance();
        Iterator<Usuario> it = ICU.getColeccionRestaurante().values().iterator();
        Restaurante r;
        Usuario u;
        while (it.hasNext()){
                    u=it.next();
                    r=(Restaurante)u;
                    DataRestaurante dr=new DataRestaurante(r.getcontraseña(), r.getnombre(), r.getnickname(), r.getcorreo(), 
                            r.getdireccion(), r.getCategorias(), r.getColeccionImagenes());
                    
                    colDataRestaurante.put(dr.getnickname(), dr);
        }
        return colDataRestaurante;
        
    }
    
    static public DataRestaurante getRestaurante(String restaurante) {
        IControladorUsuario ICU;
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica .getIControladorUsuario();
        DataRestaurante dc=ICU.Caso_Ver_Restaurante(restaurante);
        return dc;
        
    }
    
    static public Map getColeccionesSistema(String col){
        //SEGUN LA PALABRA CLAVE HAGO ALGO,CLAVE(usuarios,productos,pedidos,categorias)
        Map coleccionDevolucion=null;
        IControladorUsuario ICU;
        IControladorPedido ICP;
        IControladorProducto ICPRO;
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica .getIControladorUsuario();
        ICP = fabrica.getIControladorPedido();
        ICPRO = fabrica.getIControladorProducto();
        switch (col){
            case "usuarios":
                //ManejadorUsuario mu=ManejadorUsuario.getinstance();
                coleccionDevolucion=ICU.obtenercoleccion();
                break;
            case "productos":
                //ManejadorProducto mp=ManejadorProducto.getinstance();
                coleccionDevolucion=ICPRO.getColeccion();
                break;
            case "pedidos":
                //ManejadorPedido mpp=ManejadorPedido.getinstance();
                coleccionDevolucion=ICP.getColeccionPedido();
                break;
            case "categorias":
                //ManejadorCategoria mc=ManejadorCategoria.getinstance();
                coleccionDevolucion=ICU.coleccion();
                break;
        }
        return coleccionDevolucion;
    }
    
    static public void Grupo3(){
        IControladorUsuario ICU;
        Fecha fecha=new Fecha(1,1,1);
        File foto1 = new File("images/usuario.png");

        DataCliente DC = new DataCliente("Grupo3","Grupo3","Grupo3","Grupo3@Grupo3.com.uy","Grupo3","Grupo3",fecha,foto1,"images/usuario.png");

        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();

        ICU.Caso_Registro_Cliente(DC);
    }
    
    static public DataIndividual getIndividual(String individual) {
        IControladorProducto ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica .getIControladorProducto();
        DataIndividual di=ICP.Caso_Ver_Individual(individual);
        return di;
        
    }
    
    static public DataPromocion getPromocion(String promocion) {
        IControladorProducto ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica .getIControladorProducto();
        DataPromocion dp=ICP.Caso_Ver_Promocion(promocion);
        return dp;
        
    }
    
    static public Map getPedidosProductos(String nombre){
        Map colDevo;
        IControladorPedido ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
        //ManejadorPedido MP=ManejadorPedido.getinstance();
        colDevo=ICP.getPedidos_Producto(nombre);
        return colDevo;
    }
    
    static public Map getColeccionProductos(String nombre){
        Map colDevo;
        IControladorProducto ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorProducto();
       // ManejadorProducto MP=ManejadorProducto.getinstance();
        colDevo=ICP.getColeccionProductos(nombre);
        return colDevo;
    }
    static public Map getColeccionPedido(){
        IControladorPedido ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
        Map<Integer,DataPedido> colDataPedido=new HashMap<>();
        
        Iterator<Pedido> it = ICP.getColeccionPedido().values().iterator();
        Pedido p;
        while (it.hasNext()){
                    p=it.next();
                    DataPedido dp=new DataPedido(p.getnum(), p.getfecha(), p.getPrecioTotal(), p.getEstado(), p.getCliente(), 
                            p.getColeccionProductos(), p.getRestaurante(), p.getTipoAP());
                    
                    colDataPedido.put(dp.getId(), dp);
        }
        return colDataPedido;
        
    }
}
