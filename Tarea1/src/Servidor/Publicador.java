
package Servidor;

import Logica.DataCliente;
import Logica.Fabrica;
import Logica.IControladorPedido;
import Logica.IControladorUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {
    
    private Fabrica fabrica = Fabrica.getInstance();
    private IControladorUsuario ICU= fabrica.getIControladorUsuario();
    private Endpoint endpoint = null;
    
    public Publicador(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/publicador", this);
    }
    
    @WebMethod
    public void Caso_Registro_Cliente(DataCliente datacliente){
        ICU.Caso_Registro_Cliente(datacliente);
    };
}
