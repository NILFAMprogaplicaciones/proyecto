
package Logica;

import java.io.File;


public class Cliente extends Usuario{
    private String apellido;
    private Fecha  fecha_nacimiento;
    private File   foto;
    
    public Cliente( String nickname, String correo, String nombre,String direccion, String apellido, Fecha fecha_nacimiento){
        super(nickname,correo,nombre,direccion);
        this.apellido=apellido;
        this.fecha_nacimiento=fecha_nacimiento;
       // this.foto=;
    }
    public String getapellido(){
        return apellido;
    }
    public Fecha getfecha(){
        return fecha_nacimiento;
    }
    public void setapellido(String apellido){
        this.apellido=apellido;
    }
    public void setfecha(Fecha fecha){
        this.fecha_nacimiento=fecha;
    } 
}
