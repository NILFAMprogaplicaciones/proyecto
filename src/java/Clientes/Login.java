package Clientes;

import Logica.ManejadorUsuario;
import Logica.Usuario;
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
        Estado_Clientes nuevoEstado;

		// chequea contraseña
		try {
			Usuario usr = ManejadorUsuario.getinstance().findCliente(login);
			if(!usr.getContraseña().equals(password)){
				nuevoEstado = Estado_Clientes.LOGIN_INCORRECTO;
                        }else {
				nuevoEstado = Estado_Clientes.LOGIN_CORRECTO;
				// setea el usuario logueado
				request.getSession().setAttribute("usuario_logueado", usr.getcorreo());
			}
		} catch(Usuario_NoEncontrado ex){
	           nuevoEstado = Estado_Clientes.LOGIN_INCORRECTO;
                   
		}
               	
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws Usuario_NoEncontrado 
	 */
	static public Usuario getUsuarioLogueado(HttpServletRequest request)
			throws Usuario_NoEncontrado
	{
		return ManejadorUsuario.getinstance().findCliente(
				(String) request.getSession().getAttribute("usuario_logueado")
			);
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
