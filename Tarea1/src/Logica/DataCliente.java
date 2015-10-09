
package Logica;

import java.io.File;

public class DataCliente {
    private String contraseña;
    private String nombre;
    private String nickname;
    private String correo;
    private String direccion;
    private String apellido;
    private Fecha  fecha_nacimiento;
    private File   foto;
    private String direccionFoto;
    
    
    public DataCliente(String contraseña,String nombre, String nickname, String correo, String direccion,String apellido, Fecha fecha_nacimiento, File foto, String direccionfoto){
        this.contraseña=contraseña;
        this.nombre=nombre;
        this.nickname=nickname;
        this.correo=correo;
        this.direccion=direccion;
        this.apellido=apellido;
        this.fecha_nacimiento=fecha_nacimiento;
        this.foto=foto;
        this.direccionFoto=direccionfoto;
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
    public String getapellido(){
        return apellido;
    }
    public Fecha getfecha(){
        return fecha_nacimiento;
    }
    public String getfechastring(){
        int dia=this.fecha_nacimiento.getdia();
        int mes=this.fecha_nacimiento.getmes();
        int año=this.fecha_nacimiento.getaño();
        String fecha=Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año);
        return fecha;   
    }
    public File getFoto(){
        return foto;
    }
    public String getDireccionFoto(){
        return direccionFoto;
    }
}
