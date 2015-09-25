package Restaurantes;

import Logica.*;
import com.google.gson.Gson;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class AgregarRestaurante extends HttpServlet {
    
     private IControladorUsuario    ICU;
     private Map<String,Categoria>  ColeccionCategoria = new HashMap<String,Categoria>();
     private Map<Integer,File>      ColeccionImagenes = new TreeMap<Integer,File>();
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String inputNickname    =request.getParameter("inputNickname");
        String inputEmail       =request.getParameter("inputEmail");
        String inputNombre      =request.getParameter("inputNombre");
        String inputDireccion   =request.getParameter("inputDireccion");
        String inputContrasena  =request.getParameter("inputContrasena");
        //String selectCategoria  =request.getParameter("selectCategoria");
        
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        
        DataRestaurante DR = new DataRestaurante(inputContrasena,inputNombre,inputNickname,inputEmail,inputDireccion,ColeccionCategoria,ColeccionImagenes);
        ICU.Caso_Registro_Restaurante(DR);
        
        request.getRequestDispatcher("index.jsp").
        forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Map<String, String> options = new LinkedHashMap<String, String>();
        
        Iterator<Usuario> it = MU.getColeccionRestaurante().values().iterator();
        Usuario rest;
        while (it.hasNext()) {
            rest=it.next();
            options.put(rest.getnickname(),rest.getnickname());                  
        }   
        
        String json = new Gson().toJson(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
