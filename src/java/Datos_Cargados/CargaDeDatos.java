package Datos_Cargados;

import Logica.Fabrica;
import Logica.IDatosPrecargados;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CargaDeDatos extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        IDatosPrecargados IDP;
        Fabrica fabrica=Fabrica.getInstance();
        IDP=fabrica.getIDatosPrecargados();
        IDP.DatosPrecargado();
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
