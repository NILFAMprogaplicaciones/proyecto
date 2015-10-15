package Restaurantes;


import Logica.*;
import com.google.gson.Gson;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class Categorias extends HttpServlet {

    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        IControladorUsuario ICU;
        Fabrica fabrica=Fabrica.getInstance();
        ICU=fabrica.getIControladorUsuario();
        //ManejadorCategoria mc=ManejadorCategoria.getinstance();
        Map<String, String> options = new LinkedHashMap<String, String>();
        options.put("Seleccione Categoria", "Seleccione Categoria");
        
        Iterator<Categoria> it = ICU.coleccion().values().iterator();
        Categoria cat;
        while (it.hasNext()) {
            cat=it.next();//en cat tenemos el valor
            options.put(cat.getnombre(),cat.getnombre());
           
        }   
        String json = new Gson().toJson(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
}
