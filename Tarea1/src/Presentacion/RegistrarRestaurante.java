
package Presentacion;

import Logica.Categoria;
import Logica.DataRestaurante;
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
import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultListModel;



public class RegistrarRestaurante extends javax.swing.JInternalFrame {

    private IControladorUsuario ICU;
    
    public void Imagenpordefecto(){
        ImageIcon icon;
        Icon icono;
        int ancho = 291;
        int alto = 145;
        fichero = new File("src/Imagenes/usuario.png");
        icon = new ImageIcon(fichero.toString());
        icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        LabelImagen.setText(null);
        LabelImagen.setIcon( icono );
    }
    
    public void comboboxcategorias(){
        //AGREGO LOS ELEMENTOS DE LA COLECCION CATEGORIA AL COMBOBOX
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        Map cole=mc.coleccion();
        Iterator<Categoria> it = cole.values().iterator();
        Categoria cat=null;
        String a=(String) this.combocoleccion.getItemAt(0);
        if(a==null){
            while (it.hasNext()) {
                cat=it.next();//en cat tenemos el valor
                this.combocoleccion.addItem(cat.getnombre());
            }
        }
            
        
    }
        
    
    public RegistrarRestaurante() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        this.txtNickname.requestFocus();
        comboboxcategorias();
        Imagenpordefecto();
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
        listacoleccion = new javax.swing.JList();
        refrescarcoleccion = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Restaurante");

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

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
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

        jScrollPane1.setViewportView(listacoleccion);

        refrescarcoleccion.setText("Agregar");
        refrescarcoleccion.setActionCommand("Agregar ");
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
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(combocoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(215, 215, 215)
                            .addComponent(refrescarcoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(197, 197, 197))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(SeleccionarImagen)))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                .addComponent(txtNickname, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDireccion)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCorreoElectronico)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Cancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IngreseDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(LabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeleccionarImagen)
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combocoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(refrescarcoleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(23, Short.MAX_VALUE))
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
Map<Integer,File> coleccionimagenes = new TreeMap<Integer,File>();
int indice=1;
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
        //AGREGO A UNA COLECCION GLOBAL PARA PASARLA EN EL DATARESTAURANTE
        coleccionimagenes.put(indice, fichero);
        indice++;
    }//GEN-LAST:event_SeleccionarImagenActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        ManejadorCategoria MC = ManejadorCategoria.getinstance();
        
        if(MU.verificarnickname(txtNickname.getText())==true){
            JOptionPane.showMessageDialog(this,"Nickname ya tomado","REGISTRO",JOptionPane.ERROR_MESSAGE);
            txtNickname.requestFocus();
        }
        else if(MU.verificarcorreo(txtCorreoElectronico.getText())==true){
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
            else if(coleccion.isEmpty()){
                JOptionPane.showMessageDialog(this,"Ingrese al menos 1 Categoria","REGISTRO",JOptionPane.WARNING_MESSAGE);
                this.refrescarcoleccion.requestFocus();
            }
           else if(!this.txtCorreoElectronico.getText().equals("")){
                
                boolean arroba=false;    
                for (int x=0;x<txtCorreoElectronico.getText().length();x++){
                    char caracter=this.txtCorreoElectronico.getText().charAt(x);
                    if(caracter=='@')
                        arroba=true;
                }
                if(arroba==false){        
                    JOptionPane.showMessageDialog(this,"Verifique el dominio de su correo","REGISTRO",JOptionPane.WARNING_MESSAGE);
                    txtCorreoElectronico.requestFocus();
                }
                else{
                    //ESTA CONTRASEÑA NO LA INGRESO EN EL SWING, DEBERIA
                    String con="hola";
                    DataRestaurante datarestaurante=new DataRestaurante(con,this.txtNombre.getText(),this.txtNickname.getText(),this.txtCorreoElectronico.getText(), 
                            this.txtDireccion.getText(),coleccion,coleccionimagenes);
                    ICU.Caso_Registro_Restaurante(datarestaurante);

                    //NO LIMPIO NADA YA QUE CADA VES QUE LLAMO EL INTERNAL REALIZO UN NEW
                    this.dispose();   
                }
            }
        }
    }//GEN-LAST:event_RegistrarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        
        //NO LIMPIO NADA YA QUE CADA VES QUE LLAMO EL INTERNAL REALIZO UN NEW
        this.dispose();
        
    }//GEN-LAST:event_CancelarActionPerformed

    private void combocoleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocoleccionActionPerformed
               
    }//GEN-LAST:event_combocoleccionActionPerformed
    //VARIABLES DEFINIDAS PARA AGREGAR EN LA LISTA
    DefaultListModel<String> modelo=new DefaultListModel<>();
    int posision=0;
    Map<String,Categoria> coleccion=new HashMap<String,Categoria>();
    
    private void refrescarcoleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarcoleccionActionPerformed
        
        String seleccion=(String) this.combocoleccion.getSelectedItem(); 
        modelo.add(posision,seleccion);
        listacoleccion.setModel(modelo);
        ManejadorCategoria MC=ManejadorCategoria.getinstance();
        coleccion.put(MC.getCategoria(seleccion).getnombre(), MC.getCategoria(seleccion));
        posision++;  
           
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listacoleccion;
    private javax.swing.JButton refrescarcoleccion;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
