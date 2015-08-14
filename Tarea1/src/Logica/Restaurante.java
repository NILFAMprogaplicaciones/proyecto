


package Logica;

import Logica.Categoria;

public class Restaurante extends Usuario {
    
    private Categoria categoria = new Categoria();
    
    public Restaurante(String nickname, String correo, String nombre, String direccion, Categoria categoria){
        super(nickname, correo, nombre, direccion);
        this.categoria=categoria;
    }
    
}
