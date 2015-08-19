package Logica;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;



public class ControladorCategoria implements IControladorCategoria {

    private static ControladorCategoria instancia = null;
    private Map<String, Categoria> ColeccionCategoria = new HashMap<String, Categoria>();

    public static ControladorCategoria getinstance() {
        if (instancia == null) {
            instancia = new ControladorCategoria();
        }
        return instancia;
    }

    public void addCategoria(String nombre, Categoria cat) {
        ColeccionCategoria.put(nombre, cat);
    }

    public boolean verificoCat(String nombre) {
        return ColeccionCategoria.containsKey(nombre);
    }

    public void AltaCategoria(String nombre) {

        if (verificoCat(nombre)) {
        Categoria cat = new Categoria(nombre);
        addCategoria(nombre, cat);
        }
    }

    
    
    public void prueba() {

        JOptionPane.showMessageDialog(null, "Interactuo con funcion de la interfaz", "PRUEBA", JOptionPane.INFORMATION_MESSAGE);
    }

}
