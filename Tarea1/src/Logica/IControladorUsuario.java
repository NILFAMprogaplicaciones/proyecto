
package Logica;

import java.util.Map;

public abstract interface IControladorUsuario {
    
    public abstract void Caso_Registro_Cliente(DataCliente datacliente);
    
    
    
    public abstract void Caso_Registro_Restaurante(DataRestaurante datarestaurante);
    
    
    
    public abstract DataCliente Caso_Ver_Cliente(String nickname);
    
    
    
    public abstract DataRestaurante Caso_Ver_Restaurante(String nickName);
    
    
    
    public abstract void AltaCategoria(String nombre);
    
    //FUNCIONES AUXILIARES
    /////////////////////////////////////////////////////////
    public abstract int CantClientes();
    public abstract Map obtenercoleccion();
    public abstract Map coleccion();
    public abstract Map getColeccionRestaurante();
    public abstract Map getColeccionClientes();
    public abstract Map getColeccionProductosRestaurantes(String nickname);
    public abstract Restaurante findRestaurante(String nickname);
    public abstract Cliente findCliente(String nickname);
    public abstract Map getCategoriasRestaurantes(String nickname);
    public abstract void ExcepcionCategoria(String Categoria)throws ExcepcionesPersonalizadas;
    public abstract void ExcepcionDatosCliente(String Nickname,String CorreoElectronico, String Nombre, String Apellido, String Direccion, 
           String dia, String mes, String anio, String Contraseña, String ConfirmarCont) throws ExcepcionesPersonalizadas;
    public abstract void ExcepcionDatosRestaurante(String Nickname,String CorreoElectronico, String Nombre, String Direccion, Map coleccion, String Contraseña, String ConfirmarCont) 
            throws ExcepcionesPersonalizadas;
    public abstract Categoria getCategoria(String cate);
    public abstract Producto getProductoRestaurante(String nombrerestaurante, String nombreproducto);
}
