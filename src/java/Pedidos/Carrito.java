
package Pedidos;

import Logica.Cliente;
import Logica.DataProductosPedido;
import Logica.Fabrica;
import Logica.IControladorProducto;
import Logica.IControladorUsuario;
import Logica.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
