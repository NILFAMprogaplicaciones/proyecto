
package Logica;


public class Fabrica {
    
    private static Fabrica instancia;
    private Fabrica(){};

    public static Fabrica getInstance(){
    if (instancia == null){
        instancia = new Fabrica();
    }
    return instancia;
    }
    
    //Como en Java todo es puntero(casi), se utiliza el new
    public IControladorUsuario getIControladorUsuario() {
        IControladorUsuario ICU = new ControladorUsuario();
        return ICU;
    }
    
    public IControladorProducto getIControladorProducto() {
        IControladorProducto ICP = new ControladorProducto();
        return ICP;
    }
    
    public IControladorPedido getIControladorPedido() {
        IControladorPedido ICPE = new ControladorPedido();
        return ICPE;
    }
    
    public IControladorCategoria getIControladorCategoria() {
        IControladorCategoria ICC = new ControladorCategoria();
        return ICC;
    }
}
