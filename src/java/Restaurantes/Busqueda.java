package Restaurantes;


import Logica.*;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class Busqueda extends HttpServlet {
   
    private IControladorUsuario     ICU;
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        ArrayList<Restaurante> ListaRestaurante = new ArrayList<Restaurante>();
        Iterator<Restaurante> it = MU.getColeccionRestaurante().values().iterator();
        Restaurante res;
        
        String filtro = request.getParameter("filtro");
        
        while (it.hasNext()) {
            res=it.next();//en cat tenemos el valor
            if(res.ExisteCategoria(filtro) | res.verificarproducto(filtro) | res.getnombre().equals(filtro)){
                ListaRestaurante.add(res);   
            }
        }
       request.setAttribute("ListaRestaurante", ListaRestaurante);
       request.getRequestDispatcher("/ResultadoBusqueda.jsp").forward(request, response);
    }  
    
    static public List Buscar(String filtro){
            ManejadorUsuario MU=ManejadorUsuario.getinstance();
            List<Restaurante> ListaRestaurante = new ArrayList<Restaurante>();
            Iterator<Restaurante> it = MU.getColeccionRestaurante().values().iterator();
            Restaurante res;
            //String filtro = request.getParameter("filtro");

            while (it.hasNext()) {
                res=it.next();//en cat tenemos el valor
                if(res.ExisteCategoria(filtro) | res.verificarproducto(filtro) | res.getnombre().equals(filtro)){
                    ListaRestaurante.add(res);   
                }
            }
        return ListaRestaurante;
    }
    
}

