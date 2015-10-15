
package Pedidos;

import Logica.Cliente;
import Logica.DataComentario;
import Logica.Fabrica;
import Logica.Fecha;
import Logica.IControladorPedido;
import Logica.Pedido;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgregarComentario extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        IControladorPedido ICP;
        
        Fabrica fabrica=Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
        
        String pedido = request.getParameter("idpedido");
        Pedido ped = ICP.getPedido(Integer.parseInt(pedido));
        
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DATE);
        int mes = 1+calendario.get(Calendar.MONTH);
        int año = calendario.get(Calendar.YEAR);
        Fecha fecha=new Fecha(dia,mes,año);
        
        String infoPedido = "Informacion del pedido "+pedido;
        
        String comentario = request.getParameter("inputComentario");
        
        Cliente cliente = ped.getCliente();
        
        String puntaje = request.getParameter("inputPuntaje");
        int puntajeInt = Integer.parseInt(puntaje);
        
        DataComentario dc=new DataComentario(ped, fecha, infoPedido, comentario, puntajeInt, cliente);
        ICP.Caso_Ingresar_Comentario(dc);
                
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
