/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataUsuario;
import Logica.Fabrica;
import Logica.IControladorCategoria;
import Logica.IControladorPedido;
import Logica.IControladorProducto;
import Logica.IControladorUsuario;
import Logica.ManejadorColecciones;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author natalia
 */
public class InfoCliente extends javax.swing.JInternalFrame {
    private IControladorUsuario ICU;
    ManejadorColecciones MC = ManejadorColecciones.getinstance();
    int filas=MC.CantUsuarios();
    
        

    /**
     * Creates new form InfoCliente
     */
    public InfoCliente() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        DefaultTableModel modelo =(DefaultTableModel) this.listadeclientes.getModel();
        modelo.addRow(new Object[filas]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        listadeclientes = new javax.swing.JTable(2,2);
        MostrarInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        listadeclientes.setAutoCreateRowSorter(true);
        listadeclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listadeclientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(listadeclientes);

        MostrarInfo.setText("Mostrar Informacion");
        MostrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(MostrarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MostrarInfo)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarInfoActionPerformed
        
        //DataUsuario du=ICU.Caso_Ver_Cliente(this.ingresonick.getText(), "");
      //  this.nick.setText(du.getnickname());
       // this.nombre.setText(du.getnombre());
       // this.apellido.setText(du.getapellido());
        /*this.VentRegCli.setVisible(true);
        this.SeleccionarImagen.setVisible(false);
        this.Registrar.setVisible(false);
        this.txtApellido.setEditable(false);
        this.txtCorreoElectronico.setEditable(false);
        this.txtDireccion.setEditable(false);
        this.txtNickname.setEditable(false);
        this.txtNombre.setEditable(false);*/
    }//GEN-LAST:event_MostrarInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MostrarInfo;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable listadeclientes;
    // End of variables declaration//GEN-END:variables
}
