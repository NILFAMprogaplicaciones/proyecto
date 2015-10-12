
package Productos;

import Logica.DataIndividual;
import Logica.DataPromocion;
import Logica.Fabrica;
import Logica.IControladorProducto;
import Logica.ManejadorProducto;
import Logica.ManejadorUsuario;
import Logica.Producto;
import Logica.Restaurante;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgregarProductos extends HttpServlet {
    
    
    private ManejadorProducto           MP;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MP = ManejadorProducto.getinstance();
        Map<String, String> options = new LinkedHashMap<>();
        options.put("Seleccione Producto", "Seleccione Producto");
        Iterator<Producto> it = MP.getColeccion().values().iterator();
        Producto prod;
        while (it.hasNext()) {
            prod=it.next();//en cat tenemos el valor
            options.put(prod.getnombre(),prod.getnombre());
        }   
        String json = new Gson().toJson(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
