package Restaurantes;


import Logica.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class Busqueda extends HttpServlet {
   
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        IControladorUsuario ICU;
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
                
        
        List<Restaurante> ListaRestaurante = new ArrayList<>();
        Iterator<Restaurante> it = ICU.getColeccionRestaurante().values().iterator();
        Restaurante res;
        
        String filtro = request.getParameter("filtro");
        if(filtro==null){
            while (it.hasNext()) {
              res=it.next();//en cat tenemos el valor
              ListaRestaurante.add(res);
            }
        }else{
            while (it.hasNext()) {
                res=it.next();//en cat tenemos el valor
                if(res.BusquedaCategoria(filtro) | res.BusquedaProducto(filtro) | res.BusquedaRestaurante(filtro)){
                    ListaRestaurante.add(res);   
                }
            }
       
        }   
        request.setAttribute("ListaRestaurante", ListaRestaurante);
        request.getRequestDispatcher("/ResultadoBusqueda.jsp").forward(request, response);
    }  
    
    static public List Buscar(String filtro){
            IControladorUsuario ICU;
            Fabrica fabrica = Fabrica.getInstance();
            ICU = fabrica.getIControladorUsuario();
            
            List<Restaurante> ListaRestaurante = new ArrayList<>();
            Iterator<Restaurante> it = ICU.getColeccionRestaurante().values().iterator();
            Restaurante res;
            //String filtro = request.getParameter("filtro");

            while (it.hasNext()) {
                res=it.next();//en cat tenemos el valor
                if(res.BusquedaCategoria(filtro) | res.BusquedaProducto(filtro) | res.BusquedaRestaurante(filtro)){
                    ListaRestaurante.add(res);   
                }
            }
        return ListaRestaurante;
    }
    
}

