
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ManejadorColecciones {
    
    private Map<String,Usuario> ColeccionUsuarios = new HashMap<String,Usuario>();
    private Map<String, Categoria> ColeccionCategoria = new HashMap<String, Categoria>();
    private Map<Integer, Pedido> ColeccionPedido = new HashMap<Integer, Pedido>();
    private Map<String, Producto> ColeccionProducto = new HashMap<String, Producto>();
    
    //SINGLENTON
    private static ManejadorColecciones instancia = null;
    
    public static ManejadorColecciones getinstance() {
        if (instancia == null) {
            instancia = new ManejadorColecciones();
        }
        return instancia;
    }
    
    //FUNCIONES DE COLECCION CATEGORIAS
    public void addCategoria(String nombre, Categoria cat) {
        ColeccionCategoria.put(nombre, cat);
    }

    public boolean verificoCat(String nombre) {
        return ColeccionCategoria.containsKey(nombre);
    }
    
    //FUNCIONES DE COLECCION USUARIOS
    public void addUsuario(String nickname, Usuario usuario){
        ColeccionUsuarios.put(nickname, usuario);
    }
    public Cliente findCliente(String nickname){
        return ((Cliente)ColeccionUsuarios.get(nickname));
    }
    public Restaurante findRestaurante(String nickname){
        return ((Restaurante)ColeccionUsuarios.get(nickname));
    }
    public boolean verificarnickname(String nickname){
        return ColeccionUsuarios.containsKey(nickname);
    }
    public boolean verificarcorreo(String correo){
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getcorreo()==correo)
                return true;
        }
        return false;
    }
    
    //FUNCIONES COLECCION PRODUCTOS
    //FUNCIONES COLECCION PEDIDOS
}
