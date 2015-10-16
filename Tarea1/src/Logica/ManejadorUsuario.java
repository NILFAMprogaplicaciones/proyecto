
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        Usuario objeto;
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
        Usuario objeto;
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
        
        Map<String,Usuario> ColeccionRest = new HashMap<String,Usuario>();
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Restaurante"))
                ColeccionRest.put(objeto.getnickname(),objeto);
            
        }
        return ColeccionRest;
   }
   
   public Map getColeccionClientes() {
        
        Map<String,Usuario> ColeccionRest = new HashMap<String,Usuario>();
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Usuario objeto;
        while(it.hasNext()){
            objeto=it.next();
            if(objeto.getClass().getSimpleName().equals("Cliente"))
                ColeccionRest.put(objeto.getnickname(),objeto);
        }
        return ColeccionRest;
   }
   
   public Map getColeccionProductosRestaurantes(String nickname){
        Map resultado=null;
        Iterator<Usuario> it = ColeccionUsuarios.values().iterator();
        Restaurante res;
        Usuario objeto;
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
        Usuario objeto;
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
        Usuario objeto;
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
   
   //EXCEPCIONES
   public void ExcepcionDatosCliente(String Nickname,String CorreoElectronico, String Nombre, String Apellido, String Direccion, 
           String dia, String mes, String anio) throws ExcepcionesPersonalizadas{
       
        if(verificarnickname(Nickname)==true){
            throw new ExcepcionesPersonalizadas("Nickname ya tomado");
        }
        else if(verificarcorreo(CorreoElectronico)==true){
            throw new ExcepcionesPersonalizadas("Correo Electronico ya tomado");
        }
        else{
            if(Nickname.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese un Nickname");
            }
            else if(CorreoElectronico.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Correo Electronico");
            }
            else if(Nombre.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Nombre");
            }
            else if(Apellido.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Apellido");
            }
            else if(Direccion.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Direccion");
            }
            else if(dia.equals("DIA")){
                throw new ExcepcionesPersonalizadas("Ingrese su DIA de nacimiento");
            }
            else if(mes.equals("MES")){
                throw new ExcepcionesPersonalizadas("Ingrese su MES de nacimiento");
            }
            else if(anio.equals("AÑO")){
                throw new ExcepcionesPersonalizadas("Ingrese su AÑO de nacimiento");
            }
            else if(!CorreoElectronico.equals("")){
                
                boolean arroba=false;    
                for (int x=0;x<CorreoElectronico.length();x++){
                    char caracter=CorreoElectronico.charAt(x);
                    if(caracter=='@')
                        arroba=true;
                }
                if(arroba==false){        
                    throw new ExcepcionesPersonalizadas("Verifique el dominio de su correo");
                    
                }
            }
        }
   }
   
   public void ExcepcionDatosCliente(String Nickname,String CorreoElectronico) throws ExcepcionesPersonalizadas{
       
        if(verificarnickname(Nickname)==true)
            throw new ExcepcionesPersonalizadas("Nickname ya tomado");
        else if(verificarcorreo(CorreoElectronico)==true)
            throw new ExcepcionesPersonalizadas("Correo Electronico ya tomado");           
   }
   
   public void ExcepcionDatosRestaurante(String Nickname,String CorreoElectronico, String Nombre, String Direccion, Map coleccion) throws ExcepcionesPersonalizadas{
        if(verificarnickname(Nickname)==true){
            throw new ExcepcionesPersonalizadas("Nickname ya tomado");
        }
        else if(verificarcorreo(CorreoElectronico)==true){
            throw new ExcepcionesPersonalizadas("Correo Electronico ya tomado");
        }
        else{
            if(Nickname.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese un Nickname");
            }
            else if(CorreoElectronico.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Correo Electronico");
            }
            else if(Nombre.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Nombre");
            }
            else if(Direccion.equals("")){
                throw new ExcepcionesPersonalizadas("Ingrese su Direccion");
            }
            else if(coleccion.isEmpty()){
                throw new ExcepcionesPersonalizadas("Ingrese al menos 1 Categoria");
            }
            else if(!CorreoElectronico.equals("")){
                
                boolean arroba=false;    
                for (int x=0;x<CorreoElectronico.length();x++){
                    char caracter=CorreoElectronico.charAt(x);
                    if(caracter=='@')
                        arroba=true;
                }
                if(arroba==false){        
                    throw new ExcepcionesPersonalizadas("Verifique el dominio de su correo");
                    
                }
            }
        }
   }
   
    public void ExcepcionDatosRestaurante(String Nickname,String CorreoElectronico) throws ExcepcionesPersonalizadas{
        if(verificarnickname(Nickname)==true)
            throw new ExcepcionesPersonalizadas("Nickname ya tomado");
        else if(verificarcorreo(CorreoElectronico)==true)
            throw new ExcepcionesPersonalizadas("Correo Electronico ya tomado");
    }
  }
    
    

