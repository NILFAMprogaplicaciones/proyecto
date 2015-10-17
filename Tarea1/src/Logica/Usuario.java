

package Logica;


public class Usuario {
    
    private String nombre;
    private String nickname;
    private String contraseña;
    private String correo;
    private String direccion;
    
    public Usuario(String contraseña,String nickname, String correo,String nombre,String direccion){
        this.setcontraseña(contraseña);
        this.setnombre(nombre);
        this.setnickname(nickname);
        this.setcorreo(correo);
        this.setdireccion(direccion);
    }
    
    public String getContraseña(){
        return contraseña;
    }
    public String getnombre(){
        return nombre;
    }
    public String getnickname(){
        return nickname;
    }
    public String getcorreo(){
        return correo;
    }
    public String getdireccion(){
        return direccion;
    }
    
    public void setcontraseña(String contra){
        this.contraseña=contra;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setnickname(String nickname){
        this.nickname=nickname;
    }
    public void setcorreo(String correo){
        this.correo=correo;
    }
    public void setdireccion(String direccion){
        this.direccion=direccion;
    }
}
