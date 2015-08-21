/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataUsuario;
import Logica.Fabrica;
import Logica.IControladorPedido;
import Logica.IControladorProducto;
import Logica.IControladorUsuario;
import Logica.ManejadorUsuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author natalia
 */
public class InfoCliente extends javax.swing.JInternalFrame {
    private IControladorUsuario ICU;
    /**
     * Creates new form InfoCliente
     */
    public InfoCliente() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        
        
        
        }
          
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MostrarInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadeclientes = new javax.swing.JTable();
        listo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        MostrarInfo.setText("Mostrar Informacion");
        MostrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarInfoActionPerformed(evt);
            }
        });

        listadeclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Correo"
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
        jScrollPane1.setViewportView(listadeclientes);

        listo.setText("Listo");
        listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(MostrarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MostrarInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(listo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarInfoActionPerformed
        ManejadorUsuario MC = ManejadorUsuario.getinstance();        
        int cantidadusuarios=MC.CantUsuarios();
        int a=0;
        while (a!=cantidadusuarios){
            DefaultTableModel modelo= (DefaultTableModel) listadeclientes.getModel();
            int columna = modelo.getColumnCount();
            modelo.addRow(new Object[columna]);
            listadeclientes.setModel(modelo);
            a++;
        }
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

    private void listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listoActionPerformed
        ManejadorUsuario MC = ManejadorUsuario.getinstance();        
        int cantidadusuarios=MC.CantUsuarios();
        int a=0;
        //listadeclientes.clearSelection();
        /*while (a!=cantidadusuarios){
            DefaultTableModel modelo= (DefaultTableModel) listadeclientes.getModel();
            int columna = modelo.getColumnCount();
            modelo.removeRow(cantidadusuarios-1);
            listadeclientes.setModel(modelo);
            a++;
        }*/
        dispose();
    }//GEN-LAST:event_listoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MostrarInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listadeclientes;
    private javax.swing.JButton listo;
    // End of variables declaration//GEN-END:variables
}
