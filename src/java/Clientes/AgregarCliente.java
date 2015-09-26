
package Clientes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Logica.*;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class AgregarCliente extends HttpServlet {

    private IControladorUsuario ICU;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       
        
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            String nickname  = request.getParameter("inputNickname");
            String email = request.getParameter("inputEmail");
            String nombre = request.getParameter("inputNombre");
            String direccion = request.getParameter("inputDireccion");
            String contraseña = request.getParameter("inputContrasena");
            String apellido = request.getParameter("inputApellido");
            String nacimiento = request.getParameter("inputFecha_nacimiento");
            Fecha fecha=new Fecha(1,1,1);
            File foto1 = new File("images/usuario.png");

            DataCliente DC = new DataCliente(contraseña,nombre,nickname,email,direccion,apellido,fecha,foto1);

            Fabrica fabrica = Fabrica.getInstance();
            ICU = fabrica .getIControladorUsuario();

            ICU.Caso_Registro_Cliente(DC);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
    }

    
}
