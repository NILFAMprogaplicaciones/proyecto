/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Categoria;
import Logica.Fabrica;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Logica.IControladorUsuario;
import Logica.Fecha;
import Logica.ManejadorCategoria;
import Logica.ManejadorUsuario;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class RegistrarRestaurante extends javax.swing.JInternalFrame {

        private IControladorUsuario ICU;
        
    
    public RegistrarRestaurante() {
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

        IngreseDatosCliente = new javax.swing.JLabel();
        Nickname = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        CorreoElectronico = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        Direccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        LabelImagen = new javax.swing.JLabel();
        SeleccionarImagen = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        combocoleccion = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        refrescarcoleccion = new javax.swing.JButton();

        IngreseDatosCliente.setText("Ingrese los siguientes datos:");

        Nickname.setText("Nickname");

        txtNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameActionPerformed(evt);
            }
        });

        CorreoElectronico.setText("Correo Electronico");

        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });

        Nombre.setText("Nombre");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        Direccion.setText("Direccion");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        LabelImagen.setText("IMAGEN");

        SeleccionarImagen.setText("Seleccionar Imagen");
        SeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarImagenActionPerformed(evt);
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

        combocoleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocoleccionActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        refrescarcoleccion.setText("Ver/Agregar Coleciones");
        refrescarcoleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarcoleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Registrar)
                        .addGap(216, 216, 216)
                        .addComponent(Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(IngreseDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeleccionarImagen)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                    .addComponent(txtNickname, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCorreoElectronico)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(combocoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(refrescarcoleccion)))
                .addGap(549, 583, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IngreseDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nickname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CorreoElectronico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Direccion))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarImagen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combocoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(refrescarcoleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameActionPerformed

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:false
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed
File fichero;
    private void SeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarImagenActionPerformed
        // TODO add your handling code here:
        int resultado;

        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.FileChooser.setFileFilter(filtro);
        resultado= ventana.FileChooser.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = ventana.FileChooser.getSelectedFile();
            try{
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(LabelImagen.getWidth(), LabelImagen.getHeight(), Image.SCALE_DEFAULT));
                LabelImagen.setText(null);
                LabelImagen.setIcon( icono );

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }
        }
    }//GEN-LAST:event_SeleccionarImagenActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        ManejadorUsuario MC = ManejadorUsuario.getinstance();
        if(MC.verificarnickname(txtNickname.getText())==true){
            JOptionPane.showMessageDialog(this,"Nickname ya tomado","REGISTRO",JOptionPane.ERROR_MESSAGE);
            txtNickname.requestFocus();
        }
        else if(MC.verificarnickname(txtCorreoElectronico.getText())==true){
            JOptionPane.showMessageDialog(this,"Correo electronico ya tomado","REGISTRO",JOptionPane.ERROR_MESSAGE);
            txtCorreoElectronico.requestFocus();
        }
        else{
            if(this.txtNickname.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Ingrese un nickname","REGISTRO",JOptionPane.WARNING_MESSAGE);
                txtNickname.requestFocus();
            }
            else if(this.txtCorreoElectronico.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Ingrese su Correo Electronico","REGISTRO",JOptionPane.WARNING_MESSAGE);
                txtCorreoElectronico.requestFocus();
            }
            else if(this.txtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Ingrese su Nombre","REGISTRO",JOptionPane.WARNING_MESSAGE);
                txtNombre.requestFocus();
            }
            
            else if(this.txtDireccion.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Ingrese su Direccion","REGISTRO",JOptionPane.WARNING_MESSAGE);
                txtDireccion.requestFocus();
            }
            else{
                Map<String,Categoria> cole=new HashMap<String,Categoria>();
               // Categoria a=new Categoria(leo.getText());
                //cole.put(leo.getText(), a);
                
                ICU.Caso_Registro_Restaurante(this.txtNickname.getText(),this.txtCorreoElectronico.getText(), this.txtNombre.getText(),this.txtDireccion.getText(),cole);

                
                this.txtCorreoElectronico.setText("");
                this.txtDireccion.setText("");
                this.txtNickname.setText("");
                this.txtNombre.setText("");
                cole.clear();
                
               
                this.dispose();
                //this.setVisible(false);
            }

        }
    }//GEN-LAST:event_RegistrarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        //RegistrarCliente registrar = new RegistrarCliente();
        this.Nickname.setText("");
        this.CorreoElectronico.setText("");
        this.txtNombre.setText("");
        this.txtDireccion.setText("");
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void combocoleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocoleccionActionPerformed
               
    }//GEN-LAST:event_combocoleccionActionPerformed

    private void refrescarcoleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarcoleccionActionPerformed
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        Map coleccion=mc.coleccion();
        
        final Iterator<Categoria> it = coleccion.values().iterator();
        Categoria cat=null;
        String a=(String) this.combocoleccion.getItemAt(0);
        JOptionPane.showMessageDialog(this,a); 
        if(a.equals("")){
           JOptionPane.showMessageDialog(this,"entro"); 
            while (it.hasNext()) {
                cat=it.next();//en cat tenemos el valor
                this.combocoleccion.addItem(cat.getnombre());
            }
        }
    }//GEN-LAST:event_refrescarcoleccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel CorreoElectronico;
    public javax.swing.JLabel Direccion;
    public javax.swing.JLabel IngreseDatosCliente;
    private javax.swing.JLabel LabelImagen;
    private javax.swing.JLabel Nickname;
    public javax.swing.JLabel Nombre;
    private javax.swing.JButton Registrar;
    public javax.swing.JButton SeleccionarImagen;
    private javax.swing.JComboBox combocoleccion;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refrescarcoleccion;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
