
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
    
    private IControladorProducto        ICP;
    private ManejadorUsuario            MU;
    private ManejadorProducto           MP;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //JOptionPane.showMessageDialog(null, MU);
        String individual = request.getParameter("tipo_individual");
        
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
            
            DataIndividual DI = new DataIndividual(inputName,inputDescripcion,restaurante,precio,imagen,"images/Productos/"+inputName+".png");

            ICP.AltaProductoIndividual(DI);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            
            String rest=request.getParameter("selectRestaurante");
            
            MU = ManejadorUsuario.getinstance();
            Restaurante restaurante = MU.findRestaurante(rest);
            
            String Name=request.getParameter("inputNombrePromo");
            
            String Descripcion=request.getParameter("inputDescripcionPromo");
            
            double precioTotal = 200;
            
            boolean activa=true;
            String inputActiva=request.getParameter("inputActiva");
            if((inputActiva)==(null))
                activa=false;
            
            
            String inputDescuento=request.getParameter("inputDescuento");
            int descuento = Integer.parseInt(inputDescuento);
                        
            Map<String,Producto> ColProducto = new HashMap<String,Producto>();
            
            File foto=new File("images/producto.jpg");
            
            DataPromocion DP=new DataPromocion(restaurante,Name,Descripcion,precioTotal, activa,descuento,ColProducto,foto,"images/Productos/"+Name+".png");
            
            Fabrica fabrica = Fabrica.getInstance();
            ICP = fabrica.getIControladorProducto();
            ICP.AltaProductoPromocion(DP);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        MP = ManejadorProducto.getinstance();
        Map<String, String> options = new LinkedHashMap<String, String>();
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
