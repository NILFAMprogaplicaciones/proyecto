
package Logica;

public class FechaHora {
    private int dia;
    private int mes;
    private int año;
    private int hora;
    private int minutos;
    
    public FechaHora(int dia, int mes, int año, int hora, int minutos){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
        this.hora=hora;
        this.minutos=minutos;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }
    public int getHora( ){
        return hora;
    }
    public int getMinuto(){
        return minutos;
    }
    
}
