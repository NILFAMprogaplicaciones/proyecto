/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Mauricio
 */
public class DataCantidad {
    int Cantidad;
    Producto Producto;
    
    public DataCantidad(int cantidad, Producto producto){
        Cantidad= cantidad;
        Producto= producto;
    }  
    public int getCantidad(){
        return Cantidad;
    }
    
    public Producto getProducto(){
        return Producto;
    }
}
