
package Presentacion;

import Logica.Categoria;
import Logica.DataRestaurante;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import Logica.ManejadorCategoria;
import Logica.ManejadorUsuario;
import Logica.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
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
                    nick = selectedNode.toString();
                       
                     
                } 
            }
            
        }); 
        ok.addActionListener(getButtonActionListener());   
    }
    String nick;
    private ActionListener getButtonActionListener(){
        return new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JInternalFrame ji = validador.getJInternalFrame(VerInfoRestaurante.class.getName());
                if(ji == null || ji.isClosed()){
                    datosRestaurante = ICU.Caso_Ver_Restaurante(nick); 
                    ji = new VerInfoRestaurante(datosRestaurante);
                    Ventana.getjDesktopPane().add(ji);
                    validador.addJIframe(VerInfoRestaurante.class.getName(), ji);
                    
                    Toolkit t = Toolkit.getDefaultToolkit();
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int x=(int) ((screenSize.getWidth()/2)-ji.getWidth()/2);
                    int y=(int) ((screenSize.getHeight()/2)-ji.getHeight()/2);
                    ji.setLocation(x, y);
                    ji.show();
                }
                
            }
        };

    }
    
    public InfoRestaurante() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        llenarArbol();   
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("Informacion Restaurante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
