
package Logica;


public class Fecha {
    
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(int dia, int mes, int año){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }
    
    public int getdia(){
        return dia;
    }
    public int getmes(){
        return mes;
    }
    public int getaño(){
        return año;
    }
    
    public void setdia(int dia){
        this.dia=dia;
    }
    public void setmes(int mes){
        this.mes=mes;
    }
    public void setaño(int año){
        this.año=año;
    }
    
}
