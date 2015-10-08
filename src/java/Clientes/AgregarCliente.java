
package Clientes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Logica.*;
import java.util.StringTokenizer;
import javax.servlet.annotation.MultipartConfig;
import javax.swing.JOptionPane;

@MultipartConfig
public class AgregarCliente extends HttpServlet {

    private IControladorUsuario ICU;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       ManejadorUsuario MP=ManejadorUsuario.getinstance();
       String nombre =request.getParameter("nombre");
       JOptionPane.showMessageDialog(null, nombre);
       boolean usuario=MP.verificarnickname(nombre);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            String nickname  = request.getParameter("inputNickname");
            
            String email = request.getParameter("inputEmail");
            
            String nombre = request.getParameter("inputNombre");
            
            String direccion = request.getParameter("inputDireccion");
            
            String contraseña = request.getParameter("inputContrasena");
            
            String apellido = request.getParameter("inputApellido");
            
            String nacimiento = request.getParameter("inputFecha_nacimiento");
            String[] arrayfecha = nacimiento.split("/");
            int dia=Integer.parseInt(arrayfecha[0]), mes=Integer.parseInt(arrayfecha[1]),año=Integer.parseInt(arrayfecha[2]) ;
            Fecha fecha=new Fecha(dia,mes,año);
            
            //PARA TOMAR LA IMAGEN
            Part archivo = request.getPart("inpuImagen");
            InputStream is = archivo.getInputStream();
            //PARA TOMAR LA RUTA A GUARDAR
            ServletContext servletContext = request.getSession().getServletContext();
            String direccionImg = servletContext.getRealPath("/images/Usuarios");
            //COMIENZO A TRANSFORMAR LA RUTA EN LO QUE NECESITO
            StringTokenizer token = new StringTokenizer (direccionImg,"\\"); 
            String direccionArreglada="";
            while(token.hasMoreTokens()){ 
                direccionArreglada= direccionArreglada+"/"+token.nextToken();
            }
            String[] dire = direccionArreglada.split("/");
            String direFinal=new String();
            for(int i=1;i<dire.length;i++){
                if(!dire[i].equals("build"))
                    direFinal=direFinal+"/"+dire[i];
            }
            //CREO EL ARCHIVO EN MI DISCO
            File foto=new File(direFinal+"/"+nickname+".png");      
            FileOutputStream ous=new FileOutputStream(foto);
            int dato=is.read();
            while(dato != -1){
                ous.write(dato);
                dato=is.read();
            }
            ous.close();
            is.close();
            
            

           DataCliente DC = new DataCliente(contraseña,nombre,nickname,email,direccion,apellido,fecha,foto,"images/Usuarios"+"/"+nickname+".png");

            Fabrica fabrica = Fabrica.getInstance();
            ICU = fabrica .getIControladorUsuario();

            ICU.Caso_Registro_Cliente(DC);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
    }

    
}
