
package Logica;

import java.util.Map;
import javax.swing.Icon;


public abstract interface IControladorUsuario {
    
    public abstract void Caso_Registro_Cliente(DataCliente datacliente);
    
    
    
    public abstract void Caso_Registro_Restaurante(DataRestaurante datarestaurante);
    
    
    
    public abstract DataCliente Caso_Ver_Cliente(String nickname);
    
    
    
    public abstract DataRestaurante Caso_Ver_Restaurante(String nickName);
    
    
    
    public abstract void AltaCategoria(String nombre);
    
}
