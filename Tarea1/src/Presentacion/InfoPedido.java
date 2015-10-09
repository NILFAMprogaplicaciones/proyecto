
package Presentacion;

import Logica.DataPedido;
import Logica.Estado;
import Logica.ExcepcionesPersonalizadas;
import Logica.Fabrica;
import Logica.IControladorPedido;
import Logica.Individual;
import Logica.Pedido;
import Logica.Producto;
import Logica.Promocion;
import java.awt.Color;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class InfoPedido extends javax.swing.JInternalFrame {
    private IControladorPedido ICP;
    public void setidPasado(int id){
        idpasado=id;
    }
    int idpasado;
    public void cargarTablaPedidos(){
           
        //AGREGO LAS FILAS NECESARIAS EN MI JTABLE
        int cantidadpedidos=ICP.getCantidadEnColeccion(),a=0;
        while (a!=cantidadpedidos){
            DefaultTableModel modelo= (DefaultTableModel) TablaPedidos.getModel();
            int columna = modelo.getColumnCount();
            modelo.addRow(new Object[columna]);
            TablaPedidos.setModel(modelo);
            a++;
        }
        //AGREGO VALORES A  LAS FILAS
        Map coleccion=ICP.getColeccionPedido();
        Iterator<Pedido> it = coleccion.values().iterator();
        Pedido pedido=null;
        int fila=0;
        while (it.hasNext()) {
            pedido=it.next();
            this.TablaPedidos.setValueAt(pedido.getnum(), fila, 0);
            this.TablaPedidos.setValueAt(pedido.verfechastring(), fila, 1);
            fila++;
            
        }
    }
    public void limpiarTabla(JTable TablaPedidos){
            try {
                DefaultTableModel modelo=(DefaultTableModel) TablaPedidos.getModel();
                int filas=TablaPedidos.getRowCount();
                for (int i = 0;filas>i; i++) {
                    modelo.removeRow(0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla."+e);
            }
    }
    public InfoPedido() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
        cargarTablaPedidos();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Informacion Pedido");

        TablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha"
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
        jScrollPane1.setViewportView(TablaPedidos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pedidos en el Sistema");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Productos del Pedido seleccionado");

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio unitario", "Tipo", "Cantidad Producto", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaProductos);

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Cliente", "Restaurante"
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
        jScrollPane3.setViewportView(TablaUsuarios);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total general del Pedido");

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 0, 0));

        lblEstado.setBackground(new java.awt.Color(192, 182, 182));
        lblEstado.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        lblEstado.setText("Estado...");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Usuarios del Pedido");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/down_alt.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minus.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(61, 61, 61)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTabla(TablaProductos);
        //OBTENGO EL ID DEL PEDIDO
        int fila=TablaPedidos.getSelectedRow();
        if(fila==-1)
            JOptionPane.showMessageDialog(this,"Seleccione un Pedido","INFORMACION PEDIDO",JOptionPane.WARNING_MESSAGE);
        else{
            int idPedido=(int) TablaPedidos.getValueAt(fila,0);
            //OBJETO EL PEDIDO
            DataPedido datapedido=ICP.Caso_Ver_Pedido(idPedido);
            
            //OBTENGO LA COLECCION DE PRODUCTOS
            Map coleccionproductos=datapedido.getColeccionProductos();
            int cantidadproductos=coleccionproductos.size();
            //AGREGO FILA A LA TABLA
            int a=0;
            while (a!=cantidadproductos){
                DefaultTableModel modelo= (DefaultTableModel) TablaProductos.getModel();
                int columna = modelo.getColumnCount();
                modelo.addRow(new Object[columna]);
                TablaProductos.setModel(modelo);
                a++;
            }
            //AGREGO VALORES A  LAS FILAS
            Iterator<Producto> it = coleccionproductos.values().iterator();
            Producto objeto=null;
            int filapedido=0;
            while (it.hasNext()) {
                objeto=it.next();
                if(objeto.getClass().getSimpleName().equals("Individual")){
                    Individual ind=(Individual) objeto;
                    this.TablaProductos.setValueAt(ind.getnombre(), filapedido, 0);
                    this.TablaProductos.setValueAt(ind.getPrecio(), filapedido, 1);
                    this.TablaProductos.setValueAt("Individual", filapedido, 2);
                    this.TablaProductos.setValueAt(datapedido.getTipoAP().getDataProductoPedido(objeto.getnombre()).getCantidad(), filapedido, 3);
                    this.TablaProductos.setValueAt(datapedido.getTipoAP().getDataProductoPedido(objeto.getnombre()).getSubTotal(), filapedido, 4);
                }
                else{
                    Promocion pro=(Promocion) objeto;
                    this.TablaProductos.setValueAt(pro.getnombre(), filapedido, 0);
                    this.TablaProductos.setValueAt(pro.getPrecioTotal(), filapedido, 1);
                    this.TablaProductos.setValueAt("Promocion", filapedido, 2);
                    this.TablaProductos.setValueAt(datapedido.getTipoAP().getDataProductoPedido(objeto.getnombre()).getCantidad(), filapedido, 3);
                    this.TablaProductos.setValueAt(datapedido.getTipoAP().getDataProductoPedido(objeto.getnombre()).getSubTotal(), filapedido, 4);
                    
                }

                filapedido++;

            }
            TablaUsuarios.setValueAt(datapedido.getCliente().getnickname(), 0, 0);
            TablaUsuarios.setValueAt(datapedido.getRestaurante().getnickname(), 0, 1);

            if (datapedido.getEstado().equals(Estado.PREPARCION)){
                lblEstado.setForeground(Color.RED);
                lblEstado.setText("Estado: PREPARACION");
            }
            if (datapedido.getEstado().equals(Estado.ENVIADO)){
                lblEstado.setForeground(Color.YELLOW);
                lblEstado.setText("Estado: ENVIADO");
            }
            if (datapedido.getEstado().equals(Estado.RECIBIDO)){
                lblEstado.setForeground(Color.GREEN);
                lblEstado.setText("Estado: RECIBIDO");
            }

            double precioTotal=datapedido.getPrecioTotal();
            txtTotal.setText("$U "+(Double.toString(precioTotal)));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila=TablaPedidos.getSelectedRow();
        if(fila==-1)
            JOptionPane.showMessageDialog(this,"Seleccione un Pedido","INFORMACION PEDIDO",JOptionPane.WARNING_MESSAGE);
        else{
            int idPedido=(int) TablaPedidos.getValueAt(fila,0);
            int respuesta=JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar el Pedido","PEDIDO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                try{
                    ICP.ExcepcionEliminacion(idPedido);
                    ICP.Caso_Cancelar_Pedido(idPedido);
                    JOptionPane.showMessageDialog(null,"Pedido Eliminado","PEDIDO",JOptionPane.INFORMATION_MESSAGE); 
                    
                }catch(ExcepcionesPersonalizadas ep){
                    JOptionPane.showMessageDialog(this,ep.getMessage(),"REGISTRO",JOptionPane.ERROR_MESSAGE);
                }
                finally{
                    limpiarTabla(TablaPedidos);
                    cargarTablaPedidos();
                }
            }
        }   
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPedidos;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
