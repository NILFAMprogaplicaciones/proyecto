
package Presentacion;

import Logica.DataCantidad;
import Logica.DataIndividual;
import Logica.DataPromocion;
import Logica.Fabrica;
import Logica.IControladorProducto;
import Logica.Individual;
import Logica.ManejadorPedido;
import Logica.ManejadorProducto;
import Logica.ManejadorUsuario;
import Logica.Pedido;
import Logica.Producto;
import Logica.Promocion;
import Logica.Restaurante;
import java.awt.Image;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class infoProducto extends javax.swing.JInternalFrame {
    private IControladorProducto ICP;
    
    public void Ocultar(){
         Activa.setVisible(false);
         EstadoPromo.setVisible(false);
         ProductosPromo.setVisible(false);
         Productos.setVisible(false);
         TablaPedidos.setVisible(false);
         TablaProductos.setVisible(false);
         infoPedidos.setVisible(false);
         PedidosProductos.setVisible(false);   
         txtDescuento.setVisible(false);
         lbldescuento.setVisible(false);
         SeleccionarImagen.setVisible(false);
    }
    
    public infoProducto() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorProducto();
        Ocultar();
        tablaProducto();
    }
    
    public void tablaProducto(){
        ManejadorProducto MP = ManejadorProducto.getinstance();        
        //AGREGO LAS FILAS NECESARIAS EN MI JTABLE
        int cantidadproductos=MP.cantidadProductos();
        int a=0;
        while (a!=cantidadproductos){
            DefaultTableModel modelo= (DefaultTableModel) listadeproductos.getModel();
            int columna = modelo.getColumnCount();
            modelo.addRow(new Object[columna]);
            listadeproductos.setModel(modelo);
            a++;
        }
        //AGREGO VALORES A  LAS FILAS
        Set coleccion=MP.getColeccion();
        Iterator<Producto> it = coleccion.iterator();
        Producto prod=null;
        int fila=0;
        while (it.hasNext()) {
              prod=it.next();
                this.listadeproductos.setValueAt(prod.getnombre(), fila, 0);
                this.listadeproductos.setValueAt(prod.nombreRestaurante(), fila, 1);
                fila++;
        }
        
    }
    
        public void tablaProductosPromo(){
            ManejadorProducto MP = ManejadorProducto.getinstance();  
            int fila = this.listadeproductos.getSelectedRow();
            String nombre=(String)this.listadeproductos.getValueAt(fila, 0);
            Promocion promo=MP.findPromocion(nombre);
            //AGREGO LAS FILAS NECESARIAS EN MI JTABLE
            int cantidadproductos= MP.CantidadProductosPromo(nombre);
            int a=0;
            while (a!=cantidadproductos){
                DefaultTableModel modelo= (DefaultTableModel) Productos.getModel();
                int columna = modelo.getColumnCount();
                modelo.addRow(new Object[columna]);
                Productos.setModel(modelo);
                a++;
            }
            //AGREGO VALORES A  LAS FILAS
            Map coleccion=promo.getColeccionProductos();
            Iterator<DataCantidad> it = coleccion.values().iterator();
            DataCantidad prod=null;
            fila=0;
            while (it.hasNext()) {
                  prod=it.next();
                    this.Productos.setValueAt(prod.getProducto().getnombre(), fila, 0);
                    this.Productos.setValueAt(prod.getCantidad(), fila, 1);//aca hay que ver el tipo asociativo CANTIDAD
                    fila++;
            }

        }
        public void tablaPedidos(){
            ManejadorPedido MP = ManejadorPedido.getinstance();  
            int fila = this.listadeproductos.getSelectedRow();
            String nombre=(String)this.listadeproductos.getValueAt(fila, 0);

            //AGREGO LAS FILAS NECESARIAS EN MI JTABLE
            int cantidadproductos=MP.getPedidos_Producto(nombre).size();
            int a=0;
            while (a!=cantidadproductos){
                DefaultTableModel modelo= (DefaultTableModel) infoPedidos.getModel();
                int columna = modelo.getColumnCount();
                modelo.addRow(new Object[columna]);
                infoPedidos.setModel(modelo);
                a++;
            }
            //AGREGO VALORES A  LAS FILAS
            Map coleccion=MP.getPedidos_Producto(nombre);
            Iterator<Pedido> it = coleccion.values().iterator();
            Pedido ped=null;
            fila=0;
            while (it.hasNext()) {
                  ped=it.next();
                    this.infoPedidos.setValueAt(ped.verfechastring(),fila, 0);
                    this.infoPedidos.setValueAt(ped.getCliente().getnombre(),fila, 1);
                    this.infoPedidos.setValueAt(ped.getPrecioTotal(), fila, 2);
                    fila++;
            }
        
        }
        public void limpiarTablaPedidos(JTable infoPedidos){
            try {
                DefaultTableModel modelo=(DefaultTableModel) infoPedidos.getModel();
                int filas=infoPedidos.getRowCount();
                for (int i = 0;filas>i; i++) {
                    modelo.removeRow(0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
            }
        }
        public void limpiarTablaProductosPromo(JTable Productos){
            try {
                DefaultTableModel modelo=(DefaultTableModel) Productos.getModel();
                int filas=Productos.getRowCount();
                for (int i = 0;filas>i; i++) {
                    modelo.removeRow(0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
            }
        }    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IngreseDatosCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadeproductos = new javax.swing.JTable();
        ver = new javax.swing.JButton();
        IngreseDatosCliente1 = new javax.swing.JLabel();
        listo = new javax.swing.JButton();
        EstadoPromo = new javax.swing.JLabel();
        Activa = new javax.swing.JTextField();
        ProductosPromo = new javax.swing.JLabel();
        TablaPedidos = new javax.swing.JScrollPane();
        infoPedidos = new javax.swing.JTable();
        PedidosProductos = new javax.swing.JLabel();
        TablaProductos = new javax.swing.JScrollPane();
        Productos = new javax.swing.JTable();
        Foto = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        SeleccionarImagen = new javax.swing.JButton();
        NombreProd = new javax.swing.JLabel();
        txtNombreProd = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        Descripcion = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        lbldescuento = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();

        IngreseDatosCliente.setText("Informacion de cliente");

        setClosable(true);
        setIconifiable(true);
        setTitle("Informacion Producto");

        listadeproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Restaurante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listadeproductos);

        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });

        IngreseDatosCliente1.setText("Informacion de producto");

        listo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
        listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listoActionPerformed(evt);
            }
        });

        EstadoPromo.setText("La Promocion se encuentra: ");

        Activa.setEditable(false);

        ProductosPromo.setText("Productos de la promocion");

        infoPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cliente", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPedidos.setViewportView(infoPedidos);

        PedidosProductos.setText("Pedidos que incluyen este Producto");

        Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProductos.setViewportView(Productos);

        Foto.setText("IMAGEN");
        Foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SeleccionarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forward.png"))); // NOI18N
        SeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarImagenActionPerformed(evt);
            }
        });

        NombreProd.setText("Nombre");

        txtNombreProd.setEditable(false);
        txtNombreProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProdActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        Descripcion.setText("Descripcion");

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtDescuento.setEditable(false);

        lbldescuento.setText("Descuento");

        precio.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(txtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbldescuento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SeleccionarImagen)
                                    .addComponent(Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(listo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(IngreseDatosCliente1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(EstadoPromo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Activa, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(PedidosProductos))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TablaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(ProductosPromo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IngreseDatosCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ver)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Descripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(precio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldescuento)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Editar)
                        .addGap(13, 13, 13)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SeleccionarImagen))
                    .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoPromo)
                    .addComponent(Activa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(ProductosPromo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(PedidosProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        //TOMO LA FILA DE LA QUE SELECCIONO EL VALOR
        
        
        ManejadorProducto MP=ManejadorProducto.getinstance();
        int fila = this.listadeproductos.getSelectedRow();
        String nombre=(String)this.listadeproductos.getValueAt(fila, 0);

        //COLOCO LA FILA, EL 0 ES PARA SELECCIONAR EL VALOR DE LA PRIMERA COLUMNA
        if(fila==-1){
            JOptionPane.showMessageDialog(this,"Por favor, seleccione un Producto","INFORMACION PRODUCTO",JOptionPane.WARNING_MESSAGE );
        }
        else{
            if (MP.findProducto(nombre).getClass().getSimpleName().equals("Individual")){
                Ocultar();
                
                this.TablaPedidos.setVisible(true);
                this.infoPedidos.setVisible(true);
                this.PedidosProductos.setVisible(true); 
                DataIndividual di;
                di = ICP.Caso_Ver_Individual(nombre);
                this.txtNombreProd.setText(di.getNombre());
                double precio = di.getPrecio();
                String precioString = Double.toString(precio);
                this.txtPrecio.setText(precioString);
                this.txtDescripcion.setText(di.getDescripcion());
                this.limpiarTablaPedidos(infoPedidos);
                this.tablaPedidos();
                //APARTIR DE ACA TODO EL CODIGO ES PARA CARGAR FOTO, CON UN FILE
                fichero=di.getImagen();
                ImageIcon icon;
                Icon icono;
                icon = new ImageIcon(fichero.toString());
                icono = new ImageIcon(icon.getImage().getScaledInstance(Foto.getWidth(), Foto.getHeight(), Image.SCALE_DEFAULT));
                Foto.setText(null);
                Foto.setIcon( icono );
                             
            } else{
                    DataPromocion dp;
                    
                    dp = ICP.Caso_Ver_Promocion(nombre);
                    this.txtNombreProd.setText(dp.getNombre());
                    double precio = dp.getPrecioTotal();
                    String precioString = Double.toString(precio);
                    this.txtPrecio.setText(precioString);
                    this.txtDescripcion.setText(dp.getDescripcion());
                    this.EstadoPromo.setVisible(true);
                    this.Activa.setVisible(true);
                    if (dp.getActiva()){
                        this.Activa.setText("Activa");
                    }else{
                        this.Activa.setText("Inactiva");
                    }
                    this.lbldescuento.setVisible(true);
                    this.txtDescuento.setVisible(true);
                    this.txtDescuento.setText(Integer.toString(dp.getDescuento()));
                    this.ProductosPromo.setVisible(true);
                    this.TablaProductos.setVisible(true);
                    this.TablaPedidos.setVisible(true);
                    this.Productos.setVisible(true);
                    this.PedidosProductos.setVisible(true);
                    this.infoPedidos.setVisible(true);
                    this.limpiarTablaProductosPromo(Productos);
                    this.tablaProductosPromo();
                    this.limpiarTablaPedidos(infoPedidos);
                    this.tablaPedidos();
                    
                    
                    //APARTIR DE ACA TODO EL CODIGO ES PARA CARGAR FOTO, CON UN FILE
                    fichero=dp.getImagen();
                    ImageIcon icon;
                    Icon icono;
                    icon = new ImageIcon(fichero.toString());
                    icono = new ImageIcon(icon.getImage().getScaledInstance(Foto.getWidth(), Foto.getHeight(), Image.SCALE_DEFAULT));
                    Foto.setText(null);
                    Foto.setIcon( icono );
                          
                }
        }
    }//GEN-LAST:event_verActionPerformed
File fichero;
    private void txtNombreProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProdActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:false
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listoActionPerformed
        //NO LIMPIO NADA YA QUE CADA VES QUE LLAMO EL INTERNAL REALIZO UN NEW
        dispose();
    }//GEN-LAST:event_listoActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        int fila = listadeproductos.getSelectedRow();
        String nombreproducto=(String)listadeproductos.getValueAt(fila, 0);
        String nombrerestaurante=(String) listadeproductos.getValueAt(fila, 1);
        Producto producto= MU.getProductoRestaurante(nombrerestaurante, nombreproducto);
        
        if(producto.getClass().getSimpleName().equals("Individual")){
            txtNombreProd.setEditable(true);
            txtDescripcion.setEditable(true);
            txtPrecio.setEditable(true);
            SeleccionarImagen.setVisible(true);
        }
        else
        {
            txtNombreProd.setEditable(true);
            txtDescripcion.setEditable(true);
            txtDescuento.setEditable(true);
            Activa.setEditable(true);
            SeleccionarImagen.setVisible(true);
        }
            
    }//GEN-LAST:event_EditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ManejadorProducto MP=ManejadorProducto.getinstance();
        ManejadorUsuario MU=ManejadorUsuario.getinstance();
        int fila = listadeproductos.getSelectedRow();
        String nombreproducto=(String)listadeproductos.getValueAt(fila, 0);
        String nombrerestaurante=(String) listadeproductos.getValueAt(fila, 1);
        Producto producto= MU.getProductoRestaurante(nombrerestaurante, nombreproducto);
        Restaurante res=MU.findRestaurante(nombrerestaurante);
        if(producto.getClass().getSimpleName().equals("Individual")){
            Individual individual=(Individual) producto;
            if(!res.verificarproducto(txtNombreProd.getText())){
                DataIndividual dataindividual=new DataIndividual(txtNombreProd.getText(),txtDescripcion.getText(), individual.getRestaurante(), Double.parseDouble(txtPrecio.getText()), fichero);    
                ICP.Caso_Actualizar_Individual(nombreproducto, dataindividual);
            }
            else
                JOptionPane.showMessageDialog(this,"Nombre de Producto ya tomado","INFORMACION PRODUCTO",JOptionPane.ERROR_MESSAGE );

        } 
        else{
            if(!res.verificarproducto(txtNombreProd.getText())){
                Promocion promo= (Promocion) producto;
                boolean activa;
                if(Activa.equals("Activa"))
                    activa=true;
                else
                    activa=false;
                    DataPromocion datapromo= new DataPromocion(promo.getRestaurante(), txtNombreProd.getText(), txtDescripcion.getText(), promo.getPrecioTotal(),activa, Integer.parseInt(txtDescuento.getText()), promo.getColeccionProductos(), fichero);
                    ICP.Caso_Actualizar_Promocion(nombreproducto, datapromo);
            }
            else
                JOptionPane.showMessageDialog(this,"Nombre de Producto ya tomado","INFORMACION PRODUCTO",JOptionPane.ERROR_MESSAGE );
            
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarImagenActionPerformed

        int resultado;

        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.FileChooser.setFileFilter(filtro);
        resultado= ventana.FileChooser.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = ventana.FileChooser.getSelectedFile();
            try{
                ImageIcon icon = new ImageIcon(fichero.toString());
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(Foto.getWidth(), Foto.getHeight(), Image.SCALE_DEFAULT));
                Foto.setText(null);
                Foto.setIcon( icono );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }
        }
    }//GEN-LAST:event_SeleccionarImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Activa;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JButton Editar;
    private javax.swing.JLabel EstadoPromo;
    private javax.swing.JLabel Foto;
    public javax.swing.JLabel IngreseDatosCliente;
    public javax.swing.JLabel IngreseDatosCliente1;
    private javax.swing.JLabel NombreProd;
    private javax.swing.JLabel PedidosProductos;
    private javax.swing.JTable Productos;
    private javax.swing.JLabel ProductosPromo;
    public javax.swing.JButton SeleccionarImagen;
    private javax.swing.JScrollPane TablaPedidos;
    private javax.swing.JScrollPane TablaProductos;
    private javax.swing.JTable infoPedidos;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldescuento;
    private javax.swing.JTable listadeproductos;
    private javax.swing.JButton listo;
    public javax.swing.JLabel precio;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtNombreProd;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
}
