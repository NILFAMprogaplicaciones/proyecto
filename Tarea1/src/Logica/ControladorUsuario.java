
package Logica;
        
import java.util.Map;

public class ControladorUsuario implements IControladorUsuario  {
    
    
    
    @Override
    public void Caso_Registro_Cliente(DataCliente datacliente){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
        Cliente c=new Cliente(datacliente);
        mc.addUsuario(datacliente.getnickname(),c);
                    
    
    }
    @Override
    public DataCliente Caso_Ver_Cliente(String nickname){
        ManejadorUsuario mc=ManejadorUsuario.getinstance();
        Cliente c= mc.findCliente(nickname);
        DataCliente du=new DataCliente(c.getContraseña(),c.getnombre(),c.getnickname(),c.getcorreo(),c.getdireccion(),c.getapellido(),c.getfecha(),c.getFoto(),c.getDireccionFoto());
        return du;
    }
    
    
    @Override
    public void Caso_Registro_Restaurante(DataRestaurante datarestaurante){
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        Restaurante res=new Restaurante(datarestaurante);
        mu.addUsuario(datarestaurante.getnickname(), res);
        
    }
    @Override
    public DataRestaurante Caso_Ver_Restaurante(String nickName){
        ManejadorUsuario mu=ManejadorUsuario.getinstance();
        Restaurante r= mu.findRestaurante(nickName);
        DataRestaurante dr = new DataRestaurante(r.getContraseña(),r.getnombre(),r.getnickname(), r.getcorreo(),  r.getdireccion(),r.getCategorias(), r.getColeccionImagenes());
        return  dr;
    }
    
    @Override
    public void AltaCategoria(String nombre) {
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        Categoria cat = new Categoria(nombre);
        mc.addCategoria(nombre, cat);
    }
    
    //FUNCIONES AUXILIARES
    ////////////////////////////////////////////////////////
    @Override
    public int CantClientes(){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.CantClientes();
    }
    @Override
    public Map obtenercoleccion(){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.obtenercoleccion();
    }
    @Override
    public Map coleccion(){
        ManejadorCategoria MC =ManejadorCategoria.getinstance();
        return MC.coleccion();
    }
    @Override
    public Map getColeccionRestaurante(){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.getColeccionRestaurante();
    }
    @Override
    public Map getColeccionClientes(){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.getColeccionClientes();        
    }
    @Override
    public Map getColeccionProductosRestaurantes(String nickname){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.getColeccionProductosRestaurantes(nickname);
    }
    @Override
    public Restaurante findRestaurante(String nickname){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.findRestaurante(nickname);
    }
    @Override
    public Cliente findCliente(String nickname){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.findCliente(nickname);
    }
    @Override
    public Map getCategoriasRestaurantes(String nickame){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.getCategoriasRestaurantes(nickame);
    }
    @Override
    public void ExcepcionCategoria(String Categoria)throws ExcepcionesPersonalizadas{
        ManejadorCategoria MC =ManejadorCategoria.getinstance();
        MC.ExcepcionCategoria(Categoria);
    }
    @Override
    public void ExcepcionDatosCliente(String Nickname,String CorreoElectronico, String Nombre, String Apellido, String Direccion, 
           String dia, String mes, String anio, String Contraseña, String ConfirmarCont) throws ExcepcionesPersonalizadas{
        
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        MU.ExcepcionDatosCliente(Nickname, CorreoElectronico, Nombre, Apellido, Direccion, dia, mes, anio, Contraseña, ConfirmarCont);
    }
    @Override
    public void ExcepcionDatosRestaurante(String Nickname,String CorreoElectronico, String Nombre, String Direccion, Map coleccion, String Contraseña, String ConfirmarCont) 
            throws ExcepcionesPersonalizadas{
        
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        MU.ExcepcionDatosRestaurante(Nickname, CorreoElectronico, Nombre, Direccion, coleccion, Contraseña,ConfirmarCont);
    }
    @Override
    public Categoria getCategoria(String cate){
        ManejadorCategoria MC =ManejadorCategoria.getinstance();
        return MC.getCategoria(cate);
    }
    @Override
    public Producto getProductoRestaurante(String nombrerestaurante, String nombreproducto){
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        return MU.getProductoRestaurante(nombrerestaurante, nombreproducto);
    }
}
