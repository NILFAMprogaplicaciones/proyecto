
package Logica;

import java.io.File;


public class Cliente extends Usuario{
    private String apellido;
    private Fecha  fecha_nacimiento;
    private File   foto;
    private String direccionFoto;
    
    public Cliente( DataCliente datacliente){
        super(datacliente.getContraseña(),datacliente.getnickname(),datacliente.getcorreo(),datacliente.getnombre(),datacliente.getdireccion());
        this.apellido=datacliente.getapellido();
        this.fecha_nacimiento=datacliente.getfecha();
        this.foto=datacliente.getFoto();
        this.direccionFoto=datacliente.getDireccionFoto();
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
    public String getDireccionFoto(){
        return direccionFoto;
    }
    public void setapellido(String apellido){
        this.apellido=apellido;
    }
    public void setfecha(Fecha fecha){
        this.fecha_nacimiento=fecha;
    } 
}
