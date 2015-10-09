
package Logica;

import java.util.Map;


public class ControladorProducto implements IControladorProducto {   
          
    @Override
    public void AltaProductoIndividual(DataIndividual dataindividual) {
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Individual prod = new Individual(dataindividual);
        MU.addProductoIndividual(dataindividual.getRestaurante().getnickname(),prod);
        MP.addProductoIndividual( prod);
        
    }
    
    @Override
    public void AltaProductoPromocion(DataPromocion datapromocion) {
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        Promocion prod = new Promocion(datapromocion);
        MU.addProductoPromocion(datapromocion.getRestaurante().getnickname(),prod);
        MP.addProductoPromocion( prod);
        
    }
    
    @Override
    public DataIndividual Caso_Ver_Individual(String nombre){
        ManejadorProducto mp = ManejadorProducto.getinstance();
        Individual i= mp.findIndividual(nombre);
        DataIndividual di = new DataIndividual(i.getnombre(),i.getdescripcion(),i.getRestaurante(),i.getPrecio(),i.getImagen(),i.getDireccionFoto());
        return di;
    }
    
    @Override
    public DataPromocion Caso_Ver_Promocion(String nombre){
        ManejadorProducto mp = ManejadorProducto.getinstance();
        Promocion p= mp.findPromocion(nombre);
        DataPromocion dp = new DataPromocion(p.getRestaurante(),p.getnombre(),p.getdescripcion(),p.getPrecioTotal(),p.getactiva(),p.getdescuento(),p.getColeccionProductos(),p.getImagen(),p.getDireccionFoto());
        return dp;
    }
    
    @Override
    public void Caso_Actualizar_Individual(String nombreproducto,DataIndividual dataindividual){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        ManejadorUsuario    mu=ManejadorUsuario.getinstance();
        mp.remove(nombreproducto);
        Individual individual=new Individual(dataindividual);
        mu.addProductoIndividual(dataindividual.getRestaurante().getnickname(),individual);
        mp.addProductoIndividual(individual);
        
    }
     
    @Override
    public void Caso_Actualizar_Promocion(String nombreproducto,DataPromocion datapromocion){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        ManejadorUsuario    mu=ManejadorUsuario.getinstance();
        mp.remove(nombreproducto);
        Promocion promocion=new Promocion(datapromocion);
        mu.addProductoPromocion(datapromocion.getRestaurante().getnickname(),promocion);
        mp.addProductoPromocion(promocion);
        
    }
    
    //FUNCIONES AUXILIARES
    ////////////////////////////////////////////////////////
    
    @Override
    public int cantidadProductos(){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        return mp.cantidadProductos();
    }
    @Override
    public Map getColeccion(){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        return mp.getColeccion();
    }
    @Override
    public Promocion findPromocion(String nombre){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        return mp.findPromocion(nombre);
    }
    @Override
    public int CantidadProductosPromo(String nombre){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        return mp.CantidadProductosPromo(nombre);
    }
    @Override
    public Producto findProducto(String nombre){
        ManejadorProducto   mp=ManejadorProducto.getinstance();
        return mp.findProducto(nombre);
    }
} 
