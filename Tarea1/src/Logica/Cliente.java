
package Logica;

import java.io.File;
import javax.swing.Icon;


public class Cliente extends Usuario{
    private String apellido;
    private Fecha  fecha_nacimiento;
    private File   foto;
    
    public Cliente( DataCliente datacliente){
        super(datacliente.getContraseña(),datacliente.getnickname(),datacliente.getcorreo(),datacliente.getnombre(),datacliente.getdireccion());
        this.apellido=datacliente.getapellido();
        this.fecha_nacimiento=datacliente.getfecha();
        this.foto=datacliente.getFoto();
    }
    
    public String getcontraseña(){
        return getContraseña();
       
    }
    public String getapellido(){
        return apellido;
    }
    public Fecha getfecha(){
        return fecha_nacimiento;
    }
    public File getFoto(){
        return foto;
    }
    public void setapellido(String apellido){
        this.apellido=apellido;
    }
    public void setfecha(Fecha fecha){
        this.fecha_nacimiento=fecha;
    } 
}
