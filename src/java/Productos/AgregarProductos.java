
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class AgregarProductos extends HttpServlet {
    
    private IControladorProducto        ICP;
    private ManejadorUsuario            MU;
    private ManejadorProducto           MP;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //JOptionPane.showMessageDialog(null, MU);
        String individual = request.getParameter("tipo_individual");
        //String promocion = request.getParameter("tipo_promocion");
        if (individual!=null){
            
            String inputName=request.getParameter("inputNombre");
            String inputDescripcion=request.getParameter("inputDescripcion");
            String inputPrecio=request.getParameter("inputPrecio");
            String selectRestaurante=request.getParameter("selectRestaurante");
            
            Fabrica fabrica = Fabrica.getInstance();
            ICP = fabrica.getIControladorProducto();
            MU = ManejadorUsuario.getinstance();

            Restaurante restaurante = MU.findRestaurante(selectRestaurante);
            double precio = Double.parseDouble(inputPrecio);
            File imagen=new File("images/producto.jpg");
            
            DataIndividual DI = new DataIndividual(inputName,inputDescripcion,restaurante,precio,imagen);

            ICP.AltaProductoIndividual(DI);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            
            String selectRestaurante=request.getParameter("selectRestaurante");
            Restaurante restaurante = MU.findRestaurante(selectRestaurante);
            String inputName=request.getParameter("inputNombre");
            String inputDescripcion=request.getParameter("inputDescripcion");
            String inputPrecio=request.getParameter("inputPrecio");
            double precioTotal = 200;
            String act=request.getParameter("inputActiva");
            boolean activa= true;
            String des=request.getParameter("inputDescuento");
            int descuento = Integer.parseInt(des);
            Map CantidadProductos=null;
            File foto=null;
            
            DataPromocion DP=new DataPromocion(restaurante,inputName,inputDescripcion,precioTotal, activa,descuento,CantidadProductos,foto);
            
            ICP.AltaProductoPromocion(DP);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MP = ManejadorProducto.getinstance();
        Map<String, String> options = new LinkedHashMap<String, String>();
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
