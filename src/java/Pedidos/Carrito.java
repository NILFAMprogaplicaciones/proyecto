/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

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
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
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
        Cliente Cli=ICU.findCliente((String)sesion.getAttribute("usuario_logueado"));

        //Si se creo la sesion con el atributo de carrito
        if(sesion.getAttribute("carrito")!=null){
         //Si existe una sesion con ese atributo, se obtiene los datos de esa sesion
            carritoCompra=(List<DataProductosPedido>)sesion.getAttribute("carrito");
        }else{
         //Si no existe esa sesion se crea el DataProductosPedido (Carrito)
         carritoCompra=new ArrayList<DataProductosPedido>();
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
