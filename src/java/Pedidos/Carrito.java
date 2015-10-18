
package Pedidos;

import Clientes.Login;
import Logica.Cliente;
import Logica.DataPedido;
import Logica.DataProductosPedido;
import Logica.Estado;
import Logica.Fabrica;
import Logica.FechaHora;
import Logica.IControladorPedido;
import Logica.IControladorProducto;
import Logica.IControladorUsuario;
import Logica.Pedido;
import Logica.Producto;
import Logica.Restaurante;
import Logica.TipoAsosiativoPedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Carrito extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<DataProductosPedido> carritoCompra=null;
        
        IControladorPedido ICPED;
        Fabrica fabrica = Fabrica.getInstance();
        ICPED=fabrica.getIControladorPedido();
        
        if(sesion.getAttribute("carrito")!=null){
         //Si existe una sesion con ese atributo, se obtiene los datos de esa sesion
            carritoCompra=(List<DataProductosPedido>)sesion.getAttribute("carrito");
        }else{
         //Si no existe esa sesion se crea el DataProductosPedido (Carrito)
         carritoCompra=new ArrayList<>();
        }
        
        //OBTENGO EL ULTIMO ID
        Pedido p;
        Iterator<Pedido> ite = ICPED.getColeccionPedido().values().iterator(); 
        int id=0;
        while(ite.hasNext()){
            p=ite.next();
            id=p.getnum();
        }
        
        //FECHAHORA DEL SISTEMA
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DATE);
        int mes = 1+calendario.get(Calendar.MONTH);
        int año = calendario.get(Calendar.YEAR);
        int hora = calendario.get(Calendar.HOUR);
        int min = calendario.get(Calendar.MINUTE);
        FechaHora fecha=new FechaHora(dia,mes,año,hora,min);
        
        //PRECIO TOTAL
        DataProductosPedido dpp=null;
        Map<String, Producto> coleccionProductos=new HashMap<>();
        Map<String,DataProductosPedido> colDPP=new HashMap<>();
        Producto pro;
        double precioTotal=0;
        Iterator<DataProductosPedido> it = carritoCompra.iterator(); 
        while(it.hasNext()){
            dpp=it.next();
            precioTotal=precioTotal+dpp.getSubTotal();
            coleccionProductos.put(dpp.getProducto().getnombre(),dpp.getProducto());
            colDPP.put(dpp.getProducto().getnombre(), dpp);
        }
        
        //CLIENTE
        Cliente cliente=Login.getUsuarioLogueado(request);
        
        //RESTAURANTE
        Restaurante res=dpp.getProducto().getRestaurante();
        
        //TIPOASOSIATIVO
        TipoAsosiativoPedido TAP=new TipoAsosiativoPedido(colDPP);
        
        DataPedido pedido = new DataPedido((id+1),fecha,precioTotal,Estado.PREPARCION,cliente,coleccionProductos,res,TAP);
       
        ICPED.Caso_Generar_Pedido(pedido);
        sesion.removeAttribute("carrito");
        RequestDispatcher dispatcher = request.getRequestDispatcher("info_restaurante.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<DataProductosPedido> carritoCompra=null;
        IControladorUsuario ICU;
        IControladorProducto ICP;
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        ICP = fabrica.getIControladorProducto();

        //Si se creo la sesion con el atributo de carrito
        if(sesion.getAttribute("carrito")!=null){
         //Si existe una sesion con ese atributo, se obtiene los datos de esa sesion
            carritoCompra=(List<DataProductosPedido>)sesion.getAttribute("carrito");
        }else{
         //Si no existe esa sesion se crea el DataProductosPedido (Carrito)
         carritoCompra=new ArrayList<>();
        }
        //Obtenemos los valores 
        String producto = request.getParameter("inputNombre");
        
        double precio=Double.parseDouble(request.getParameter("inputPrecio"));
        int cantidad=Integer.parseInt(request.getParameter("cantidad"));
        double subTotal=cantidad * precio;
        Producto prod = ICP.findProducto(producto);
        //Creo el elemento carrito     
        DataProductosPedido carro=new DataProductosPedido(prod, cantidad, subTotal);
   
        //Agrego el carrito a mi vector
        carritoCompra.add(carro);
        sesion.setAttribute("carrito",carritoCompra);
      
        RequestDispatcher dispatcher = request.getRequestDispatcher("ver_restaurante.jsp?nicknamerestaurante="+prod.getRestaurante().getnickname());
        dispatcher.forward(request, response);
    }


}
