/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Categoria;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import Logica.ManejadorCategoria;

import Logica.ManejadorUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class RegistrarCategoria extends javax.swing.JInternalFrame {

private IControladorUsuario ICU;   
/**
     * Creates new form RegistarCategorai
     */
    public RegistrarCategoria() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        IngreseDatosCategoria = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        IngreseDatosCategoria.setText("Ingrese los siguientes datos:");

        Categoria.setText("Categoria");

        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Registrar)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(Cancelar))
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IngreseDatosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(IngreseDatosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Categoria)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar)
                    .addComponent(Cancelar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        ManejadorCategoria MC = ManejadorCategoria.getinstance();
        if(MC.verificoCat(txtCategoria.getText())==true){
            JOptionPane.showMessageDialog(this,"Categoria ya Ingresada","REGISTRO",JOptionPane.ERROR_MESSAGE);
            txtCategoria.requestFocus();
        } else {
            if (txtCategoria.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Ingrese Categoria","REGISTRO",JOptionPane.WARNING_MESSAGE);
                txtCategoria.requestFocus();
            } else{
                ICU.AltaCategoria(txtCategoria.getText());
                JOptionPane.showMessageDialog(this,"Categoria Ingresada con Exito");
                txtCategoria.setText("");
                dispose();
            }
        }
        
    }//GEN-LAST:event_RegistrarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        txtCategoria.setText("");
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Categoria;
    public javax.swing.JLabel IngreseDatosCategoria;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
