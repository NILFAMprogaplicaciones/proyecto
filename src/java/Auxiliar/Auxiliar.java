
package Auxiliar;

import Logica.Cliente;
import Logica.Comentario;
import Logica.DataCliente;
import Logica.DataComentario;
import Logica.DataIndividual;
import Logica.DataPedido;
import Logica.DataPromocion;
import Logica.DataRestaurante;
import Logica.Fabrica;
import Logica.Fecha;
import Logica.IControladorPedido;
import Logica.IControladorProducto;
import Logica.IControladorUsuario;
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
                coleccionDevolucion=ICU.obtenercoleccion();
                break;
            case "productos":
                coleccionDevolucion=ICPRO.getColeccion();
                break;
            case "pedidos":
                coleccionDevolucion=ICP.getColeccionPedido();
                break;
            case "categorias":
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
        colDevo=ICP.getPedidos_Producto(nombre);
        return colDevo;
    }
    
    static public Map getColeccionProductos(String nombre){
        Map colDevo;
        IControladorProducto ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorProducto();
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
    static public DataPedido getDataPedido(String id){
        
        Pedido p=getPedido(Integer.parseInt(id));
        DataPedido dp=new DataPedido(p.getnum(), p.getfecha(), p.getPrecioTotal(), p.getEstado(), p.getCliente(),
                p.getColeccionProductos(), p.getRestaurante(), p.getTipoAP());
        return dp;
    }
    static public Pedido getPedido(int id){
        IControladorPedido ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
        return ICP.getPedido(id);
    }
    static public DataComentario getComentario(int id){
        IControladorPedido ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();  
        Pedido pedido=ICP.getPedido(id);
        Comentario comentario=pedido.getComentario();
        DataComentario dc=new DataComentario(comentario.getPedido(),comentario.getFecha(),comentario.getInfoPedido(),comentario.getTexto(),comentario.getPuntaje(),comentario.getCliente());
        return dc;
    }
    static public int getPromedio(String nickname){
        IControladorPedido ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();  
        
        Iterator<Pedido> ite = ICP.getColeccionPedido().values().iterator();
        Pedido dp;
        int puntaje=0,divisor=0;
        
        while (ite.hasNext()) {
            dp=ite.next();

            if(dp.getRestaurante().getnickname().equals(nickname)){
                if(dp.getComentario()!=null){
                    puntaje=puntaje+dp.getComentario().getPuntaje();
                    divisor++;
                }
            }
        }
        if(divisor==0)
            return 0;
        else
            return puntaje/divisor;
    }
    
}
