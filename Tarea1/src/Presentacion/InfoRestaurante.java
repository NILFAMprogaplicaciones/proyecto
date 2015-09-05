/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Categoria;
import Logica.DataRestaurante;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import Logica.ManejadorCategoria;
import Logica.ManejadorUsuario;
import Logica.Usuario;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author natalia
 */

public class InfoRestaurante extends javax.swing.JInternalFrame {
    public IControladorUsuario ICU;
    public JTree arbolModelo;
    public DataRestaurante datosRestaurante;
    
    ManejadorCategoria MC = ManejadorCategoria.getinstance();
    ManejadorUsuario MU = ManejadorUsuario.getinstance();
    
    public void llenarArbol(){
        this.setLayout(new BorderLayout(5,10));
        
        JScrollPane Menu = new JScrollPane();
        
        Map<String, Categoria> listaCat = MC.coleccion();
        Iterator<Categoria> it = listaCat.values().iterator();
        DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode("Categorías");
        DefaultTreeModel modelo = new DefaultTreeModel(dmtn);
        
        arbolModelo = new JTree(modelo);
        
        Categoria cat = null;
        while(it.hasNext()){
            
            cat = it.next();
            String nombreCat = cat.getnombre();
            DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(nombreCat);
            dmtn.add(n1);
            
            Map<String, Usuario> listaUsr = MU.obtenercoleccion();
            Iterator<Usuario> iter = listaUsr.values().iterator();
            
            Usuario usr = null;
            
            while(iter.hasNext()){
                usr = iter.next();
                if(usr.getClass().getSimpleName().equals("Restaurante")){
                    Map<String, Categoria> u = MU.getCategoriasRestaurantes(usr.getnickname());
                    if(u.containsKey(nombreCat)){
                        String nombreRest = usr.getnickname();
                        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode(nombreRest);
                        n1.add(n2);
                    
                    }
                }
            }
         }
        
       
        
        JTree arbol = new JTree(dmtn);
        Menu.add(arbolModelo);
        Menu.setViewportView(arbolModelo);
        
        
        arbolModelo.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
               
        JLabel tit = new JLabel();
        tit.setText("Seleccione el restaurante");
        
        JButton ok = new JButton();
        ok.setText("OK");
        
        add(tit, BorderLayout.NORTH);
        add(ok, BorderLayout.SOUTH);
        add(Menu, BorderLayout.CENTER);
        setVisible(true);
        
        arbolModelo.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)arbolModelo.getLastSelectedPathComponent();          
                TreePath[] paths = arbolModelo.getSelectionPaths();
                if(!selectedNode.equals(null)){
                    ok.addActionListener(getButtonActionListener());
                    
                }
                
                String nick = selectedNode.toString();
                datosRestaurante = ICU.Caso_Ver_Restaurante(nick);               
                
            }
            
            
        });
        
        
        
    }
    
    private ActionListener getButtonActionListener(){
        return new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JInternalFrame ji = validador.getJInternalFrame(VerInfoRestaurante.class.getName());
                if(ji == null || ji.isClosed()){
                    ji = new VerInfoRestaurante(datosRestaurante);
                    //ji.putClientProperty(datosRestaurante.getnickname(), datosRestaurante);
                    Ventana.getjDesktopPane().add(ji);
                    validador.addJIframe(VerInfoRestaurante.class.getName(), ji);
                }
                ji.setVisible(true);
            }
        };

    }
    
    
    public static void devolverNickRes(){
    }

    /**
     * Creates new form InfoRestaurante
     */
    public InfoRestaurante() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        llenarArbol();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
