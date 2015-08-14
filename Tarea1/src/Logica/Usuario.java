

package Logica;


public class Usuario {
    
    private String nombre;
    private String nickname;
    private String correo;
    private String direccion;
    
    public Usuario(String nombre, String nickname, String correo, String direccion){
        this.nombre=nombre;
        this.nickname=nickname;
        this.correo=correo;
        this.direccion=direccion;
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
