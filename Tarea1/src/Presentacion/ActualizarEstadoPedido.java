
package Presentacion;

import Logica.Estado;
import Logica.Fabrica;
import Logica.IControladorPedido;
import Logica.IControladorUsuario;
import Logica.ManejadorPedido;
import Logica.Pedido;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ActualizarEstadoPedido extends javax.swing.JInternalFrame {

    public void cargarTablaPedidos(){
        ManejadorPedido MP = ManejadorPedido.getinstance();        
        //AGREGO LAS FILAS NECESARIAS EN MI JTABLE
        int cantidadpedidos=MP.getCantidadEnColeccion(),a=0;
        while (a!=cantidadpedidos){
            DefaultTableModel modelo= (DefaultTableModel) TablaPedidos.getModel();
            int columna = modelo.getColumnCount();
            modelo.addRow(new Object[columna]);
            TablaPedidos.setModel(modelo);
            a++;
        }
        //AGREGO VALORES A  LAS FILAS
        Map coleccion=MP.getColeccionPedido();
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
    private IControladorPedido ICP;
    public ActualizarEstadoPedido() {
        initComponents();
        cargarTablaPedidos();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        panel1 = new java.awt.Panel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Enviado = new javax.swing.JCheckBox();
        Recibido = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Actualizar Pedido");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pedidos en el Sistema");

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/down_alt.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ESTADO:");

        txtEstado.setEditable(false);

        jLabel3.setText("Seleccione una opcion:");

        Enviado.setText("ENVIADO");

        Recibido.setText("RECIBIDO");
        Recibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecibidoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Recibido)
                    .addComponent(Enviado))
                .addGap(44, 44, 44)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(Enviado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Recibido))
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecibidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecibidoActionPerformed
    Pedido pedido;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila=TablaPedidos.getSelectedRow();
        if(fila==-1)
            JOptionPane.showMessageDialog(this, "Seleccione un Pedido","ACTUALIZACION",JOptionPane.WARNING_MESSAGE);
        else{
            ManejadorPedido MP=ManejadorPedido.getinstance();

            int ID=(int) TablaPedidos.getValueAt(fila, 0);
            //OBTENGO EL PEDIDO CON LA ID SELECCIONADA
            pedido=MP.getPedido(ID);
            //CARGO MI TXT
            if(pedido.getEstado().equals(Estado.PREPARCION))
                txtEstado.setText("PREPARACION");
            else if(pedido.getEstado().equals(Estado.ENVIADO))
                txtEstado.setText("ENVIADO");
            else
                txtEstado.setText("RECIBIDO");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManejadorPedido MP=ManejadorPedido.getinstance();
        if(txtEstado.getText().equals("RECIBIDO")){
            JOptionPane.showMessageDialog(this, "Imposible cambiar Estado del Pedido","ACTUALIZACION",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtEstado.getText().equals("ENVIADO")){
            if(Enviado.isSelected())
                JOptionPane.showMessageDialog(this, "Verifique su opcion","ACTUALIZACION",JOptionPane.WARNING_MESSAGE);
            else if(Recibido.isSelected()){
                ICP.Caso_Actualizar_Estado_Pedido(pedido.getnum(), Estado.RECIBIDO);
                dispose();
            }
        }
        else if(txtEstado.getText().equals("PREPARACION")){
            if(Enviado.isSelected()&&!Recibido.isSelected()){
                ICP.Caso_Actualizar_Estado_Pedido(pedido.getnum(), Estado.ENVIADO);
                dispose();
            }
            else if(Recibido.isSelected()&&!Enviado.isSelected()){
                ICP.Caso_Actualizar_Estado_Pedido(pedido.getnum(), Estado.RECIBIDO);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Verifique su opcion","ACTUALIZACION",JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Enviado;
    private javax.swing.JCheckBox Recibido;
    private javax.swing.JTable TablaPedidos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtEstado;
    // End of variables declaration//GEN-END:variables
}
