
package Logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class ManejadorUsuario {
    
    private Map<String,Usuario> ColeccionUsuarios = new HashMap<String,Usuario>();
    //SINGLENTON
    private static ManejadorUsuario instancia = null;
    
    public static ManejadorUsuario getinstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuario();
        }
        return instancia;
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
        boolean resultado=false;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getcorreo().equals(correo))
                resultado= true;
        }
        return resultado;
    }
    public int CantUsuarios(){
        
        return ColeccionUsuarios.size();
    }
    public int CantClientes(){
        int cantidad=0;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            String tipo=objeto.getClass().getSimpleName();
            
            if(tipo.equals("Cliente"))
                cantidad=cantidad+1;
        }
        return cantidad;
    }
    public Map obtenercoleccion(){
       return this.ColeccionUsuarios;   
   }
   //ME RETORNA TODOS LOS RESTAURANTES
   public Map getColeccionRestaurante() {
        new String("Restaurante"); 
        Integer indice=0;
        Map<String,Usuario> ColeccionRest = new HashMap<String,Usuario>();
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Restaurante"))
                ColeccionRest.put(objeto.getnickname(),objeto);
            indice++;
        }
        return ColeccionRest;
   }
   public Map getColeccionProductosRestaurantes(String nickname){
        Map resultado=null;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Restaurante res;
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Restaurante")){
                if(objeto.getnickname().equals(nickname)){
                    res=(Restaurante) objeto;
                    resultado=res.getProductos();
                }
            }
                
               
        }
        return resultado;
   }
   
   public void addProductoIndividual(String Restaurante,Individual prod){
       this.findRestaurante(Restaurante).addProducto(prod);
   }
   public void addProductoPromocion(String Restaurante,Promocion prod){
       this.findRestaurante(Restaurante).addProducto(prod);
   }
   public double buscarprecioproducto(String nickrestaurante, String nombreproducto){
       
       return this.findRestaurante(nickrestaurante).buscarprecio(nombreproducto);
   }
   public Producto getProductoRestaurante(String nickname,String nombreproducto){
        Producto pro=null;
        Restaurante res;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Restaurante")){
                if(objeto.getnickname().equals(nickname)){
                    res=(Restaurante) objeto;
                    pro=res.getProducto(nombreproducto);
                }
            }
                
               
        }
        return pro;
   }
   public Map getCategoriasRestaurantes(String nickname){
        Map resultado=null;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Restaurante res;
        Usuario objeto=null;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Restaurante")){
                if(objeto.getnickname().equals(nickname)){
                    res=(Restaurante) objeto;
                    resultado=res.getCategorias();
                }
            }
                
        }
        return resultado;
   }
}
    
    

