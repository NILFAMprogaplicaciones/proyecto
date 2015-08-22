
package Logica;


public class Pedido {
    
    private int     num;
    private Fecha   fecha;
    private double  precio_total;
    private Estado  estado;
    private String  cliente;
   
    public Pedido(int num, Fecha fecha, double precio_total, Estado estado, String cliente){
        this.num=num;
        this.fecha=fecha;
        this.precio_total=precio_total;
        this.estado=estado;
        this.cliente=cliente;
    }
    
    public int getnum(){
        return num;
    }
    public Fecha getfecha(){
        return fecha;
    }
    public double getprecio_total(){
        return precio_total;
    }
    public Estado getestado(){
        return estado;
    }
    public String getcliente(){
        return cliente;
    }
    
    public void setnum(int num){
        this.num=num;
    }
    public void setfecha(Fecha fecha){
        this.fecha=fecha;
    }
    public void setprecio_total(double precio_total){
        this.precio_total=precio_total;
    }
    public void setestado(Estado estado){
        this.estado=estado;
    }
    public void setcliente(String cliente){
        this.cliente=cliente;
    }
    
}
