
package Logica;

import java.io.File;
import javax.swing.Icon;


public class Cliente extends Usuario{
    private String apellido;
    private Fecha  fecha_nacimiento;
    private Icon   foto;
    
    public Cliente( String nickname, String correo, String nombre,String direccion, String apellido, Fecha fecha_nacimiento,Icon foto){
        super(nickname,correo,nombre,direccion);
        this.apellido=apellido;
        this.fecha_nacimiento=fecha_nacimiento;
        //this.foto=foto;
    }
    public String getapellido(){
        return apellido;
    }
    public Fecha getfecha(){
        return fecha_nacimiento;
    }
    public Icon getFoto(){
        return foto;
    }
    public void setapellido(String apellido){
        this.apellido=apellido;
    }
    public void setfecha(Fecha fecha){
        this.fecha_nacimiento=fecha;
    } 
}
