package Presentacion;

import Logica.Cliente;
import Logica.DataCliente;
import Logica.DataIndividual;
import Logica.DataPedido;
import Logica.DataProductosPedido;
import Logica.DataRestaurante;
import Logica.DatosPrecargados;
import Logica.Estado;
import Logica.Fabrica;
import Logica.Fecha;
import Logica.FechaHora;
import Logica.IControladorUsuario;
import Logica.IControladorProducto;
import Logica.IControladorPedido;
import Logica.Individual;
import Logica.ManejadorCategoria;
import Logica.ManejadorPedido;
import Logica.ManejadorUsuario;
import Logica.Producto;
import Logica.Restaurante;
import Logica.TipoAsosiativoPedido;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;

public class Ventana extends javax.swing.JFrame {
    
    private  IControladorUsuario     ICU;
    private  IControladorProducto    ICP;
    private  IControladorPedido      ICPE;
    public Ventana() {
        initComponents(); 
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        ICP = fabrica.getIControladorProducto();
        ICPE = fabrica.getIControladorPedido();
        
        ICU.AltaCategoria("categoria1");
        Fecha fecha=new Fecha(15,07,1993);
        File foto=new File("src/Imagenes/usuario.png");
   
        DataCliente datacliente=new DataCliente("cliente1","cli1","cli1@cliente1","rafael 4542","apellidocliente",fecha,foto);
        ICU.Caso_Registro_Cliente(datacliente);
        ManejadorCategoria MC=ManejadorCategoria.getinstance();
        Map<Integer,File> colimagen= new TreeMap<>();
        DataRestaurante datarestaurante=new DataRestaurante("restaurante1","res1","res1@restaurante1","belloni 3456",MC.coleccion(),colimagen);
        ICU.Caso_Registro_Restaurante(datarestaurante);
        Restaurante res=new Restaurante(datarestaurante);
        DataIndividual dataindividual=new DataIndividual("prod1","producto prod1",res,10.20,foto);
        DataIndividual dataindividual1=new DataIndividual("prod2","producto prod2",res,20.05,foto);
        ICP.AltaProductoIndividual(dataindividual);
        ICP.AltaProductoIndividual(dataindividual1);
        //GENERO EL PEDIDO
        FechaHora fechahora=new FechaHora(1,1,1,1,1);
        FechaHora fechahora1=new FechaHora(2,2,2,2,2);
        Cliente cliente=new Cliente(datacliente);
        Individual producto=new Individual(dataindividual);
        Individual producto1=new Individual(dataindividual1);
        Map<String,Producto> ColeccionProductos=new HashMap<String,Producto>();
        ColeccionProductos.put(producto.getnombre(), producto);
        ColeccionProductos.put(producto1.getnombre(),producto1);
        Restaurante restaurante=new Restaurante(datarestaurante);
        DataProductosPedido dpp=new DataProductosPedido(producto,2,40);
        DataProductosPedido dpp1=new DataProductosPedido(producto1,5,20);
        Map<String,DataProductosPedido> ColeccionProductosPedido=new HashMap<String,DataProductosPedido>();
        ColeccionProductosPedido.put(dpp.getProducto().getnombre(), dpp);
        ColeccionProductosPedido.put(dpp1.getProducto().getnombre(), dpp1);
        TipoAsosiativoPedido tap=new TipoAsosiativoPedido(ColeccionProductosPedido);
        DataPedido pedido=new DataPedido(1,fechahora,40,Estado.PREPARCION,cliente,ColeccionProductos,restaurante,tap);
        DataPedido pedido1=new DataPedido(2,fechahora1,40,Estado.PREPARCION,cliente,ColeccionProductos,restaurante,tap);
        ICPE.Caso_Generar_Pedido(pedido);
        ICPE.Caso_Generar_Pedido(pedido1);

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
        setIconImages(null);
        setLocation(new java.awt.Point(500, 200));
        setSize(new java.awt.Dimension(0, 0));
        setType(java.awt.Window.Type.POPUP);

        Registros.setText("Registros");
        Registros.setName(""); // NOI18N

        RegCliente.setText("Registrar Cliente");
        RegCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegClienteActionPerformed(evt);
            }
        });
        Registros.add(RegCliente);

        RegRestaurante.setText("Registrar Restaurante");
        RegRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegRestauranteActionPerformed(evt);
            }
        });
        Registros.add(RegRestaurante);

        RegistrarProducto.setText("Registrar Producto");
        RegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarProductoActionPerformed(evt);
            }
        });
        Registros.add(RegistrarProducto);

        RegCategoria.setText("Registrar Categoria");
        RegCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegCategoriaActionPerformed(evt);
            }
        });
        Registros.add(RegCategoria);

        jMenuBar2.add(Registros);

        Informacion.setText("Informacion");

        cliente.setText("Cliente");
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        Informacion.add(cliente);

        restaurante.setText("Restaurante");
        restaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restauranteActionPerformed(evt);
            }
        });
        Informacion.add(restaurante);

        producto.setText("Producto");
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        Informacion.add(producto);

        jMenuBar2.add(Informacion);

        Pedido.setText("Pedido");

        GenPedido.setText("Generar");
        GenPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenPedidoActionPerformed(evt);
            }
        });
        Pedido.add(GenPedido);

        InfPedido.setText("Informacion");
        InfPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfPedidoActionPerformed(evt);
            }
        });
        Pedido.add(InfPedido);

        ActEstado.setText("Actualizar estado");
        ActEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActEstadoActionPerformed(evt);
            }
        });
        Pedido.add(ActEstado);

        jMenuBar2.add(Pedido);

        DatosPrecargaos.setText("Datos Precargados");

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
            .addComponent(PanelEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DatosPrecargados datos=DatosPrecargados.getinstance();
        datos.DatosPrecargado();
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
    public transient javax.swing.JDesktopPane PanelEscritorio;
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
}
