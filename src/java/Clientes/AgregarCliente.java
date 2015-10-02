
package Clientes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Logica.*;
import javax.swing.JOptionPane;

public class AgregarCliente extends HttpServlet {

    private IControladorUsuario ICU;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       ManejadorUsuario MP=ManejadorUsuario.getinstance();
       String nombre =request.getParameter("nombre");
       JOptionPane.showMessageDialog(null, nombre);
       boolean usuario=MP.verificarnickname(nombre);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            String nickname  = request.getParameter("inputNickname");
            String email = request.getParameter("inputEmail");
            String nombre = request.getParameter("inputNombre");
            String direccion = request.getParameter("inputDireccion");
            String contraseña = request.getParameter("inputContrasena");
            String apellido = request.getParameter("inputApellido");
            
            String nacimiento = request.getParameter("inputFecha_nacimiento");
            String[] arrayfecha = nacimiento.split("/");
            int dia=Integer.parseInt(arrayfecha[0]), mes=Integer.parseInt(arrayfecha[1]),año=Integer.parseInt(arrayfecha[2]) ;
            
            Fecha fecha=new Fecha(dia,mes,año);
            File foto1 = new File("images/usuario.png");

            DataCliente DC = new DataCliente(contraseña,nombre,nickname,email,direccion,apellido,fecha,foto1);

            Fabrica fabrica = Fabrica.getInstance();
            ICU = fabrica .getIControladorUsuario();

            ICU.Caso_Registro_Cliente(DC);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
    }

    
}
