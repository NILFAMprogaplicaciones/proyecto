package Datos_Cargados;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import servidor.PublicadorService;

public class CargaDeDatos extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        servidor.PublicadorService service = new PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        port.datosCargados();
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
