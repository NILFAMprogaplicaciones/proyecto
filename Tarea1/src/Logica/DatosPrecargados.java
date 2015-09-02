
package Logica;

import java.io.File;
import javax.swing.JOptionPane;


public class DatosPrecargados {
    ManejadorUsuario MU=ManejadorUsuario.getinstance(); 
    private static DatosPrecargados instancia = null;
    
    public static DatosPrecargados getinstance() {
        if (instancia == null) {
            instancia = new DatosPrecargados();
        }
        return instancia;
    }
   
    public void DatosPrecargado(){
        //CLIENTES
        Fecha fecha1=new Fecha(15,11,1983),fecha2=new Fecha(2,8,1975),fecha3=new Fecha(12,9,1987),fecha4=new Fecha(28,07,1951),fecha5=new Fecha(23,12,1978);
        File foto1 = new File("src/Imagenes/co.jpg"),foto2 = new File("src/Imagenes/ro.jpg"),foto3 = new File("src/Imagenes/usuario.png"),foto4 = new File("src/Imagenes/an.jpg"),foto5 = new File("src/Imagenes/we.jpg");
        
        DataCliente datacliente1=new DataCliente("Gerardo", "costas", "gcostas@gmail.com", "Pdte. Berro 1548","Cotelo", fecha1, foto1); 
        Cliente cliente1=new Cliente(datacliente1);
        MU.addUsuario(cliente1.getnickname(), cliente1);
        
        DataCliente datacliente2=new DataCliente("Rodrigo", "roro", "rcotelo@yahoo.com", "Av. Italia 2078","Costas", fecha2, foto2); 
        Cliente cliente2=new Cliente(datacliente2);
        MU.addUsuario(cliente2.getnickname(), cliente2);
        
        DataCliente datacliente3=new DataCliente("Cecilia", "chechi", "cgarrido@hotmail.com", "Gral. Urquiza 1548","Garrido", fecha3, foto3); 
        Cliente cliente3=new Cliente(datacliente3);
        MU.addUsuario(cliente3.getnickname(), cliente3);
        
        DataCliente datacliente4=new DataCliente("Andrea", "andy", "agarcia@gmail.com", "Dr. Manuel Albo 4512","García", fecha4, foto4); 
        Cliente cliente4=new Cliente(datacliente4);
        MU.addUsuario(cliente4.getnickname(), cliente4);
        
        DataCliente datacliente5=new DataCliente("Adrian", "weiss", "aweiss@hotmail.com", "Monte Caseros 5615","Weiss", fecha5, foto5); 
        Cliente cliente5=new Cliente(datacliente5);
        MU.addUsuario(cliente5.getnickname(), cliente5);
        
        JOptionPane.showMessageDialog(null,"Datos Cargados","DATOS PRECARGADOS",JOptionPane.INFORMATION_MESSAGE);
    }
     



    
}
