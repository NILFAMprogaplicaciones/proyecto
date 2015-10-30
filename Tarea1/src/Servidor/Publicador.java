
package Servidor;

import Logica.Categoria;
import Logica.Cliente;
import Logica.DataCliente;
import Logica.DataRestaurante;
import Logica.ExcepcionesPersonalizadas;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import Logica.Producto;
import Logica.Restaurante;
import Logica.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
         endpoint = Endpoint.publish("http://localhost:9128/ICU", this);
    }
    
    //CASOS DE USOS
    @WebMethod
    public void Caso_Registro_Cliente(DataCliente datacliente){
        ICU.Caso_Registro_Cliente(datacliente);
    }
    @WebMethod
    public void Caso_Registro_Restaurante(DataRestaurante datarestaurante){
        ICU.Caso_Registro_Restaurante(datarestaurante);
    }
    @WebMethod
    public DataCliente Caso_Ver_Cliente(String nickname){
        return ICU.Caso_Ver_Cliente(nickname);
    }
    @WebMethod
    public DataRestaurante Caso_Ver_Restaurante(String nickName){
        return ICU.Caso_Ver_Restaurante(nickName);
    }
    @WebMethod
    public void AltaCategoria(String nombre){
        ICU.AltaCategoria(nombre);
    }
    
    //FUNCIONES AUXILIARES
    @WebMethod
    public  int CantClientes(){
        return ICU.CantClientes();
    }
    @WebMethod
    public  ArrayList obtenercoleccion(){
        ArrayList al = null;
        return al;//ICU.obtenercoleccion();
    }
    @WebMethod
    public  Producto getProductoRestaurante(String nombrerestaurante, String nombreproducto){
        return ICU.getProductoRestaurante(nombrerestaurante, nombreproducto);
    }
    @WebMethod
    public  Cliente findCliente(String nickname){
        return ICU.findCliente(nickname);
    }
    @WebMethod
    public  Restaurante findRestaurante(String nickname){
        return ICU.findRestaurante(nickname);
    }
    @WebMethod
    public  void ExcepcionCategoria(String Categoria)throws ExcepcionesPersonalizadas{
        ICU.ExcepcionCategoria(Categoria);
    }
    @WebMethod
    public  void ExcepcionDatosCliente(String Nickname,String CorreoElectronico, String Nombre, String Apellido, String Direccion, 
           String dia, String mes, String anio, String Contraseña, String ConfirmarCont) throws ExcepcionesPersonalizadas{
        
        ICU.ExcepcionDatosCliente(Nickname, CorreoElectronico, Nombre, Apellido, Direccion, dia, mes, anio, Contraseña, ConfirmarCont);
    }
    @WebMethod
    public  void ExcepcionDatosRestaurante(String Nickname,String CorreoElectronico, String Nombre, String Direccion, ArrayList coleccion, String Contraseña, String ConfirmarCont) 
            throws ExcepcionesPersonalizadas{
        //ESTA COLECCION SE CARGAR CON EL ARRAYLIST QUE ME PASAN
        Map coleccionfinal=null;
        ICU.ExcepcionDatosRestaurante(Nickname, CorreoElectronico, Nombre, Direccion, coleccionfinal, Contraseña, ConfirmarCont);
    }
    @WebMethod
    public  Categoria getCategoria(String cate){
        return ICU.getCategoria(cate);
    }
    
    /*
    
    @WebMethod
    public  Map obtenercoleccion(){
        
        return ICU.obtenercoleccion();
    }
    public  Map coleccion(){
        return ICU.coleccion();
    }
    public  Map getColeccionRestaurante(){
        return ICU.getColeccionRestaurante();
    }
    public  Map getColeccionClientes(){
        return ICU.getColeccionClientes();
    }
    public  Map getColeccionProductosRestaurantes(String nickname){
        return ICU.getColeccionProductosRestaurantes(nickname);
    }
    
    public  Map getCategoriasRestaurantes(String nickname){
        return ICU.getCategoriasRestaurantes(nickname);
    }
    
    
    }*/
}
