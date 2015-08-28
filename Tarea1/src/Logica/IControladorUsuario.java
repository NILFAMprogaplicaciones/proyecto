
package Logica;

import java.util.Map;
import javax.swing.Icon;


public interface IControladorUsuario {
    
    public abstract void Caso_Registro_Cliente(DataCliente datacliente);
    
    
    
    public abstract void Caso_Registro_Restaurante(DataRestaurante datarestaurante);
    
    
    
    public abstract DataCliente Caso_Ver_Cliente(String nickname);
    
    
    
    public abstract void Caso_Ver_Restaurante(String nickname, String correo);
    
    
    
    public abstract void AltaCategoria(String nombre);
    
}
