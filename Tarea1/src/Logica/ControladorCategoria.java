package Logica;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;



public class ControladorCategoria implements IControladorCategoria {

    public void AltaCategoria(String nombre) {
        ManejadorColecciones mc=ManejadorColecciones.getinstance();
        Categoria cat = new Categoria(nombre);
        mc.addCategoria(nombre, cat);
        }
}


