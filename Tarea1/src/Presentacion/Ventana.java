package Presentacion;

import Logica.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class Ventana extends javax.swing.JFrame {

    
    private IControladorUsuario     ICU;
    private IControladorProducto    ICP;
    private IControladorPedido      ICPE;
    private IDatosPrecargados       IDP;
    public Ventana() {
        initComponents(); 
        Fabrica fabrica = Fabrica.getInstance();
        ICU     = fabrica.getIControladorUsuario();
        ICP     = fabrica.getIControladorProducto();
        ICPE    = fabrica.getIControladorPedido();
        IDP     = fabrica.getIDatosPrecargados();
               
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/Quick_Order.png"));


        return retValue;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelEscritorio = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        Registros = new javax.swing.JMenu();
        RegCliente = new javax.swing.JMenuItem();
        RegRestaurante = new javax.swing.JMenuItem();
        RegistrarProducto = new javax.swing.JMenuItem();
        RegCategoria = new javax.swing.JMenuItem();
        Informacion = new javax.swing.JMenu();
        cliente = new javax.swing.JMenuItem();
        restaurante = new javax.swing.JMenuItem();
        producto = new javax.swing.JMenuItem();
        Pedido = new javax.swing.JMenu();
        GenPedido = new javax.swing.JMenuItem();
        InfPedido = new javax.swing.JMenuItem();
        ActEstado = new javax.swing.JMenuItem();
        DatosPrecargaos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quick Order");
        setBackground(new java.awt.Color(51, 255, 204));
        setIconImage(getIconImage());
        setLocation(new java.awt.Point(500, 200));
        setSize(new java.awt.Dimension(0, 0));
        setType(java.awt.Window.Type.POPUP);

        PanelEscritorio.setBackground(null);

        Registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/install.png"))); // NOI18N
        Registros.setText("Registros");
        Registros.setName(""); // NOI18N

        RegCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/People.png"))); // NOI18N
        RegCliente.setText("Registrar Cliente");
        RegCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegClienteActionPerformed(evt);
            }
        });
        Registros.add(RegCliente);

        RegRestaurante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Person.png"))); // NOI18N
        RegRestaurante.setText("Registrar Restaurante");
        RegRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegRestauranteActionPerformed(evt);
            }
        });
        Registros.add(RegRestaurante);

        RegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        RegistrarProducto.setText("Registrar Producto");
        RegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarProductoActionPerformed(evt);
            }
        });
        Registros.add(RegistrarProducto);

        RegCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Folder.png"))); // NOI18N
        RegCategoria.setText("Registrar Categoria");
        RegCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegCategoriaActionPerformed(evt);
            }
        });
        Registros.add(RegCategoria);

        jMenuBar2.add(Registros);

        Informacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/info.png"))); // NOI18N
        Informacion.setText("Informacion");

        cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/People.png"))); // NOI18N
        cliente.setText("Cliente");
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        Informacion.add(cliente);

        restaurante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Person.png"))); // NOI18N
        restaurante.setText("Restaurante");
        restaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restauranteActionPerformed(evt);
            }
        });
        Informacion.add(restaurante);

        producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.png"))); // NOI18N
        producto.setText("Producto");
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        Informacion.add(producto);

        jMenuBar2.add(Informacion);

        Pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/notebook.png"))); // NOI18N
        Pedido.setText("Pedido");

        GenPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cash.png"))); // NOI18N
        GenPedido.setText("Generar");
        GenPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenPedidoActionPerformed(evt);
            }
        });
        Pedido.add(GenPedido);

        InfPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Shopping cart.png"))); // NOI18N
        InfPedido.setText("Informacion");
        InfPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfPedidoActionPerformed(evt);
            }
        });
        Pedido.add(InfPedido);

        ActEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wrench.png"))); // NOI18N
        ActEstado.setText("Actualizar estado");
        ActEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActEstadoActionPerformed(evt);
            }
        });
        Pedido.add(ActEstado);

        jMenuBar2.add(Pedido);

        DatosPrecargaos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archive.png"))); // NOI18N
        DatosPrecargaos.setText("Datos Precargados");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add.png"))); // NOI18N
        jMenuItem1.setText("Cargar datos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        DatosPrecargaos.add(jMenuItem1);

        jMenuBar2.add(DatosPrecargaos);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegRestauranteActionPerformed
       ManejadorCategoria mc=ManejadorCategoria.getinstance();
        int cantidad=mc.cantidad();
        if(cantidad==0){
            JOptionPane.showMessageDialog(this,"No hay Categorias en el sistema","REGISTRO",JOptionPane.WARNING_MESSAGE);
        }
        else{
            RegistrarRestaurante registrarRestaurante = new RegistrarRestaurante();
            int x=(PanelEscritorio.getWidth()/2)-registrarRestaurante.getWidth()/2;
            int y=(PanelEscritorio.getHeight()/2)-registrarRestaurante.getHeight()/2;
            this.PanelEscritorio.add(registrarRestaurante);
            registrarRestaurante.setLocation(x, y);
            registrarRestaurante.show();    
        }
        
    }//GEN-LAST:event_RegRestauranteActionPerformed

    private void RegClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegClienteActionPerformed
       
        RegistrarCliente registrar = new RegistrarCliente();
        int x=(PanelEscritorio.getWidth()/2)-registrar.getWidth()/2;
        int y=(PanelEscritorio.getHeight()/2)-registrar.getHeight()/2;
        PanelEscritorio.add(registrar);
        registrar.setLocation(x,y);
        registrar.show();
    }//GEN-LAST:event_RegClienteActionPerformed

    private void restauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restauranteActionPerformed
        InfoRestaurante infoRest = new InfoRestaurante();
        int x=(PanelEscritorio.getWidth()/2)-infoRest.getWidth()/2;
        int y=(PanelEscritorio.getHeight()/2)-infoRest.getHeight()/2;
        this.PanelEscritorio.add(infoRest);
        infoRest.setLocation(x,y);
        infoRest.show();
    }//GEN-LAST:event_restauranteActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        int cantidadusuarios=MU.CantClientes();
        if(cantidadusuarios==0){
            JOptionPane.showMessageDialog(this,"No hay clientes en el sistema","INFORMACION CLIENTE",JOptionPane.WARNING_MESSAGE );
        }
        else{
            InfoCliente info = new InfoCliente();
            int x=(PanelEscritorio.getWidth()/2)-info.getWidth()/2;
            int y=(PanelEscritorio.getHeight()/2)-info.getHeight()/2;
            this.PanelEscritorio.add(info);
            info.setLocation(x, y);
            info.show();
        }
    }//GEN-LAST:event_clienteActionPerformed

    private void RegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarProductoActionPerformed
        RegistrarProducto registrarProducto = new RegistrarProducto();          
        int x=(PanelEscritorio.getWidth()/2)-registrarProducto.getWidth()/2;
        int y=(PanelEscritorio.getHeight()/2)-registrarProducto.getHeight()/2;
        this.PanelEscritorio.add(registrarProducto);
        registrarProducto.setLocation(x, y);
        registrarProducto.show();
    }//GEN-LAST:event_RegistrarProductoActionPerformed

    private void RegCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegCategoriaActionPerformed
        RegistrarCategoria registrarCategoria = new RegistrarCategoria();
        int x=(PanelEscritorio.getWidth()/2)-registrarCategoria.getWidth()/2;
        int y=(PanelEscritorio.getHeight()/2)-registrarCategoria.getHeight()/2;
        this.PanelEscritorio.add(registrarCategoria);
        registrarCategoria.setLocation(x, y);
        registrarCategoria.show();
    }//GEN-LAST:event_RegCategoriaActionPerformed

    private void GenPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenPedidoActionPerformed
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        int cantidadusuarios=MU.CantClientes();
        int cantidadcategoria=mc.cantidad(),posision=0;
        if(cantidadusuarios==0){
            JOptionPane.showMessageDialog(this,"No hay clientes en el sistema","INFORMACION CLIENTE",JOptionPane.ERROR_MESSAGE);
        }
        else if(cantidadcategoria==0){
            JOptionPane.showMessageDialog(this,"No hay Categorias en el sistema","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
        }
        else{
            GenerarPedido generarpedido = new GenerarPedido();
            int x=(PanelEscritorio.getWidth()/2)-generarpedido.getWidth()/2;
            int y=(PanelEscritorio.getHeight()/2)-generarpedido.getHeight()/2;
            this.PanelEscritorio.add(generarpedido);
            generarpedido.setLocation(x, y);
            generarpedido.show();
        }
    }//GEN-LAST:event_GenPedidoActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        infoProducto verProducto = new infoProducto();          
        int x=(PanelEscritorio.getWidth()/2)-verProducto.getWidth()/2;
        int y=(PanelEscritorio.getHeight()/2)-verProducto.getHeight()/2;
        this.PanelEscritorio.add(verProducto);
        verProducto.setLocation(x, y);
        verProducto.show();      
    }//GEN-LAST:event_productoActionPerformed

    private void InfPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfPedidoActionPerformed
        ManejadorPedido MP=ManejadorPedido.getinstance();
        int cantidad=MP.getCantidadEnColeccion();
        if(cantidad==0){
            JOptionPane.showMessageDialog(this,"No hay Pedidos en el sistema","INFORMACION PEDIDO",JOptionPane.ERROR_MESSAGE);
        }
        else{
            InfoPedido infopedido=new InfoPedido();
            int x=(PanelEscritorio.getWidth()/2)-infopedido.getWidth()/2;
            int y=(PanelEscritorio.getHeight()/2)-infopedido.getHeight()/2;
            this.PanelEscritorio.add(infopedido);
            infopedido.setLocation(x, y);
            infopedido.show();   
        }
    }//GEN-LAST:event_InfPedidoActionPerformed

    private void ActEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActEstadoActionPerformed
        ManejadorPedido MP=ManejadorPedido.getinstance();
        int cantidad=MP.getCantidadEnColeccion();
        if(cantidad==0){
            JOptionPane.showMessageDialog(this,"No hay Pedidos en el sistema","ACTUALIZAR ESTADO PEDIDO",JOptionPane.ERROR_MESSAGE);
        }
        else{
            ActualizarEstadoPedido actualizarEP=new ActualizarEstadoPedido();
            int x=(PanelEscritorio.getWidth()/2)-actualizarEP.getWidth()/2;
            int y=(PanelEscritorio.getHeight()/2)-actualizarEP.getHeight()/2;
            this.PanelEscritorio.add(actualizarEP);
            actualizarEP.setLocation(x, y);
            actualizarEP.show();   
        }
    }//GEN-LAST:event_ActEstadoActionPerformed
int entro=0;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        if(entro==0){
            IDP.DatosPrecargado();
            entro=1;
        }
        else{
            JOptionPane.showMessageDialog(this,"Ya realizo esta accion","DATOS PRECARGADOS",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Ventana a=new Ventana();
                a.setExtendedState(JFrame.MAXIMIZED_BOTH);
                a.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActEstado;
    private javax.swing.JMenu DatosPrecargaos;
    private javax.swing.JMenuItem GenPedido;
    private javax.swing.JMenuItem InfPedido;
    private javax.swing.JMenu Informacion;
    public static javax.swing.JDesktopPane PanelEscritorio;
    private javax.swing.JMenu Pedido;
    private javax.swing.JMenuItem RegCategoria;
    private javax.swing.JMenuItem RegCliente;
    private javax.swing.JMenuItem RegRestaurante;
    private javax.swing.JMenuItem RegistrarProducto;
    private javax.swing.JMenu Registros;
    private javax.swing.JMenuItem cliente;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem producto;
    private javax.swing.JMenuItem restaurante;
    // End of variables declaration//GEN-END:variables

    public static JDesktopPane getjDesktopPane(){
           return PanelEscritorio;
   }
}

class validador {
	 
    public static java.util.HashMap<String, javax.swing.JInternalFrame> jIframes = new java.util.HashMap<String, javax.swing.JInternalFrame>();
 
    public static void addJIframe(String key, javax.swing.JInternalFrame jiframe) {
        jIframes.put(key, jiframe);
    }
 
    public static javax.swing.JInternalFrame getJInternalFrame(String key) {
        return jIframes.get(key);
    }
    
    
}