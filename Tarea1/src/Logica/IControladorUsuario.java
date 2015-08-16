
package Logica;


public interface IControladorUsuario {
    
    public abstract void Caso_Registro_Cliente(String nombre,String nickname, String correo,  
            String direccion, String apellido, Fecha fecha);
    public abstract boolean verificarnickname(String nickname);
    public abstract boolean verificarcorreo(String correo);
    public abstract void Caso_Registro_Restaurante(String nickname, String correo, String nombre, 
            String direccion, Categoria categoria);
    public abstract DataUsuario Caso_Ver_Cliente(String nickname, String correo);
    public abstract void Caso_Ver_Restaurante(String nickname, String correo);
    
}
