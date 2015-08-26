/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author natalia
 */
public class DataIndividual {
    private String nombre;
    private String descripcion;
    private Restaurante restaurante;
    private double precio;
    
    public DataIndividual(/*String nombre, String descripcion, Restaurante restaurante, */double precio){
        /*this.nombre=nombre;
        this.descripcion=descripcion;
        this.restaurante=restaurante;*/
        this.precio=precio;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }    
    public Restaurante getRestaurante(){
        return restaurante;
    }
    public double getPrecio(){
        return precio;
    }
}


