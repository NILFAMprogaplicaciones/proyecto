
package Presentacion;

import Logica.DataCliente;
import Logica.ExcepcionesPersonalizadas;
import Logica.Fabrica;
import Logica.Fecha;
import Logica.IControladorUsuario;
import Logica.ManejadorUsuario;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrarCliente extends javax.swing.JInternalFrame {
    
    private IControladorUsuario ICU;
    private String d,m,a;
    
    public void cargarcombobox(){
        int cantidad=1940,posicion=1;
        String cant;
        while(cantidad<=2015){
            cant=Integer.toString(cantidad);
            anio.insertItemAt(cant, posicion);
            cantidad++;
            posicion++;
        }
    }
    public void Imagenpordefecto(){
        int ancho = 235;
        int alto = 152;
        fichero = new File("src/Imagenes/usuario.png");
        icon = new ImageIcon(fichero.toString());
        //icono = new ImageIcon(icon.getImage().getScaledInstance(LabelImagen.getWidth(), LabelImagen.getHeight(), Image.SCALE_DEFAULT));
        icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        LabelImagen.setText(null);
        LabelImagen.setIcon( icono );
    }
    
    public RegistrarCliente() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        cargarcombobox();
        this.txtNickname.requestFocus();
        Imagenpordefecto();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nickname = new javax.swing.JLabel();
        IngreseDatosCliente = new javax.swing.JLabel();
        FechaNacimiento = new javax.swing.JLabel();
        Direccion = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        CorreoElectronico = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        anio = new javax.swing.JComboBox();
        mes = new javax.swing.JComboBox();
        dia = new javax.swing.JComboBox();
        LabelImagen = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        SeleccionarImagen = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Cliente");

        Nickname.setText("Nickname");

        IngreseDatosCliente.setText("Ingrese los siguientes datos:");

        FechaNacimiento.setText("Fecha Nacimiento");

        Direccion.setText("Direccion");

        Apellido.setText("Apellido");

        CorreoElectronico.setText("Correo Electronico");

        Nombre.setText("Nombre");

        txtNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameActionPerformed(evt);
            }
        });

        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        anio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AÑO" }));
        anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioActionPerformed(evt);
            }
        });

        mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MES", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });

        dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIA", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaActionPerformed(evt);
            }
        });

        LabelImagen.setText("IMAGEN");
        LabelImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        SeleccionarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forward.png"))); // NOI18N
        SeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarImagenActionPerformed(evt);
            }
        });

        Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus.png"))); // NOI18N
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(IngreseDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(SeleccionarImagen)))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Cancelar)
                                .addGap(91, 91, 91)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDireccion)
                            .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(txtNickname))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(IngreseDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nickname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CorreoElectronico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaNacimiento))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(SeleccionarImagen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioActionPerformed
        
        a=(String) anio.getSelectedItem();
    }//GEN-LAST:event_anioActionPerformed

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        
        m=(String)mes.getSelectedItem();
    }//GEN-LAST:event_mesActionPerformed

    private void diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaActionPerformed
        d=(String)dia.getSelectedItem();
    }//GEN-LAST:event_diaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        //NO LIMPIO NADA YA QUE CADA VES QUE LLAMO EL INTERNAL REALIZO UN NEW
        this.dispose();
        
    }//GEN-LAST:event_CancelarActionPerformed

    File fichero=null;
    ImageIcon icon;
    Icon icono;
    private void SeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarImagenActionPerformed
        
        
        int resultado;

        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.FileChooser.setFileFilter(filtro);
        resultado= ventana.FileChooser.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = ventana.FileChooser.getSelectedFile();
            try{
                icon = new ImageIcon(fichero.toString());
                icono = new ImageIcon(icon.getImage().getScaledInstance(LabelImagen.getWidth(), LabelImagen.getHeight(), Image.SCALE_DEFAULT));
                LabelImagen.setText(null);
                LabelImagen.setIcon( icono );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }
        }
    }//GEN-LAST:event_SeleccionarImagenActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        ManejadorUsuario MC = ManejadorUsuario.getinstance();
       
        try{
            MC.ExcepcionDatosCliente(txtNickname.getText(),txtCorreoElectronico.getText(),txtNombre.getText(),txtApellido.getText(),
                    txtDireccion.getText(),dia.getSelectedItem().toString(),mes.getSelectedItem().toString(),anio.getSelectedItem().toString());
            //D,M,A estan parseados
            int D,M,A;
            D = Integer.parseInt(d);
            M = Integer.parseInt(m);
            A = Integer.parseInt(a);
            Fecha fecha=new Fecha(D,M,A);
            //ESTA CONTRASEÑA NO LA INGRESO EN EL SWING, DEBERIA
            String con="hola";
            DataCliente datacliente=new DataCliente(con,this.txtNombre.getText(), this.txtNickname.getText(),
                this.txtCorreoElectronico.getText(), this.txtDireccion.getText(),
                this.txtApellido.getText(), fecha,fichero);
            ICU.Caso_Registro_Cliente(datacliente);
            JOptionPane.showMessageDialog(null,"Cliente Registrado","REGISTRO",JOptionPane.INFORMATION_MESSAGE);
            //NO LIMPIO NADA YA QUE CADA VES QUE LLAMO EL INTERNAL REALIZO UN NEW    
            this.dispose();
            
        }catch(ExcepcionesPersonalizadas ep){
            
            JOptionPane.showMessageDialog(this,ep.getMessage(),"REGISTRO",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_RegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Apellido;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel CorreoElectronico;
    public javax.swing.JLabel Direccion;
    public javax.swing.JLabel FechaNacimiento;
    public javax.swing.JLabel IngreseDatosCliente;
    private javax.swing.JLabel LabelImagen;
    private javax.swing.JLabel Nickname;
    public javax.swing.JLabel Nombre;
    private javax.swing.JButton Registrar;
    public javax.swing.JButton SeleccionarImagen;
    private javax.swing.JComboBox anio;
    private javax.swing.JComboBox dia;
    private javax.swing.JComboBox mes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
