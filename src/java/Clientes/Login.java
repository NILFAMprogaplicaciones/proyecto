package Clientes;

import Logica.EstadoSesion;
import Logica.ManejadorUsuario;
import Logica.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("inputNicknameEmail");
        String password = request.getParameter("inputPassword");
        EstadoSesion nuevoEstado;

		// chequea contraseña
		
			Cliente cli = ManejadorUsuario.getinstance().findCliente(login);
                    if (cli==null){
                       RequestDispatcher dispatcher = request.getRequestDispatcher("inicioErroneo.jsp");
                       dispatcher.forward(request, response); 
                    }else{    
			if(!cli.getContraseña().equals(password)){
                            nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
                            RequestDispatcher dispatcher = request.getRequestDispatcher("inicioErroneo.jsp");
                            dispatcher.forward(request, response); 
                        }else {
                            nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
                            // setea el usuario logueado
                            objSesion.setAttribute("usuario_logueado", cli.getnickname());
			}                           
                        objSesion.setAttribute("estado_sesion", nuevoEstado);

                                // redirige a la página principal para que luego rediriga a la página
                                // que corresponde
                        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                        dispatcher.forward(request, response);
                    }
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws Usuario_NoEncontrado 
	 */
	static public Cliente getUsuarioLogueado(HttpServletRequest request) {
		
            return ManejadorUsuario.getinstance().findCliente((String) request.getSession().getAttribute("usuario_logueado"));
	}

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
