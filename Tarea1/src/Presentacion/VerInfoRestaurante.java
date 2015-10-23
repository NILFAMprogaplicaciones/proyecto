
package Presentacion;

import Logica.DataRestaurante;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import Logica.Producto;
import java.awt.Image;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class VerInfoRestaurante extends javax.swing.JInternalFrame {
    private IControladorUsuario ICU;
    
    public void datosRestaurante(){
        txtNickRestaurante.setEditable(false);
        txtNomRestaurante.setEditable(false);
        txtCorreoRestaurante.setEditable(false);
        txtDirRestaurante.setEditable(false);
        
        
    }
    
    
    DataRestaurante datarestaurante;
    int idFoto=1;
    public void CargaDeDatos(DataRestaurante dres){
        txtNickRestaurante.setText(dres.getnickname());
        txtNomRestaurante.setText(dres.getnombre());
        txtDirRestaurante.setText(dres.getdireccion());
        txtCorreoRestaurante.setText(dres.getcorreo());
        
        if(dres.getFoto(idFoto)!=null){        
            File foto=dres.getFoto(idFoto);
            int largo=237, ancho=127;
            ImageIcon icon;
            Icon icono;
            icon = new ImageIcon(foto.toString());
            icono = new ImageIcon(icon.getImage().getScaledInstance(largo, ancho, Image.SCALE_DEFAULT));
            imagenRestaurante.setText(null);
            imagenRestaurante.setIcon( icono );
        }
        else{
            File foto=new File("src/Imagenes/usuario.png");
            int largo=237, ancho=127;
            ImageIcon icon;
            Icon icono;
            icon = new ImageIcon(foto.toString());
            icono = new ImageIcon(icon.getImage().getScaledInstance(largo, ancho, Image.SCALE_DEFAULT));
            imagenRestaurante.setText(null);
            imagenRestaurante.setIcon( icono ); 
        }
        //AGREGO LOS PRODUCTOS DE MI RESTAURANTE
        DefaultListModel<String> modelo=new DefaultListModel<>();

        int posision=0;

        Map cole=ICU.getColeccionProductosRestaurantes(txtNickRestaurante.getText());
        Iterator<Producto> it = cole.values().iterator();
        Producto pro=null;
        while (it.hasNext()) {
            pro=it.next();
            modelo.add(posision,pro.getnombre());
            this.listadeproductos.setModel(modelo);
            posision++; 
        }
    }
    
    public VerInfoRestaurante(DataRestaurante dr) {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        CargaDeDatos(dr);
        datosRestaurante();
        datarestaurante=dr;
        
          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDatos = new javax.swing.JPanel();
        iNickRestaurante = new javax.swing.JLabel();
        iNomRestaurante = new javax.swing.JLabel();
        iCorreoRestaurante = new javax.swing.JLabel();
        iDirRestaurante = new javax.swing.JLabel();
        txtNickRestaurante = new javax.swing.JTextField();
        txtNomRestaurante = new javax.swing.JTextField();
        txtCorreoRestaurante = new javax.swing.JTextField();
        txtDirRestaurante = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listadeproductos = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        imagenRestaurante = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Informacion Restaurante");

        iNickRestaurante.setText("Nickname :");

        iNomRestaurante.setText("Nombrre :");

        iCorreoRestaurante.setText("Correo :");

        iDirRestaurante.setText("Dirección:");

        txtNickRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickRestauranteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iNickRestaurante)
                    .addComponent(iNomRestaurante)
                    .addComponent(iCorreoRestaurante)
                    .addComponent(iDirRestaurante))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreoRestaurante)
                    .addComponent(txtNomRestaurante)
                    .addComponent(txtNickRestaurante)
                    .addComponent(txtDirRestaurante, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iNickRestaurante)
                    .addComponent(txtNickRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iNomRestaurante)
                    .addComponent(txtNomRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iCorreoRestaurante)
                    .addComponent(txtCorreoRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iDirRestaurante)
                    .addComponent(txtDirRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forward_alt.png"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listadeproductos);

        jLabel1.setText("Productos del Restaurante");

        imagenRestaurante.setText("ImagenRestaurante");
        imagenRestaurante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imagenRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagenRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNickRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickRestauranteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNickRestauranteActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int cantidad=datarestaurante.getColeccionImagenes().size();
        File foto=datarestaurante.getFoto(idFoto+1);
        if(idFoto<cantidad){
            idFoto++;
            int largo=237, ancho=127;
            ImageIcon icon;
            Icon icono;
            icon = new ImageIcon(foto.toString());
            icono = new ImageIcon(icon.getImage().getScaledInstance(largo, ancho, Image.SCALE_DEFAULT));
            imagenRestaurante.setText(null);
            imagenRestaurante.setIcon( icono );
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        File foto=datarestaurante.getFoto(idFoto-1);
        if(idFoto>1){
            idFoto--;
            int largo=237, ancho=127;
            ImageIcon icon;
            Icon icono;
            icon = new ImageIcon(foto.toString());
            icono = new ImageIcon(icon.getImage().getScaledInstance(largo, ancho, Image.SCALE_DEFAULT));
            imagenRestaurante.setText(null);
            imagenRestaurante.setIcon( icono );
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel iCorreoRestaurante;
    private javax.swing.JLabel iDirRestaurante;
    private javax.swing.JLabel iNickRestaurante;
    private javax.swing.JLabel iNomRestaurante;
    private javax.swing.JLabel imagenRestaurante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listadeproductos;
    private javax.swing.JTextField txtCorreoRestaurante;
    private javax.swing.JTextField txtDirRestaurante;
    private javax.swing.JTextField txtNickRestaurante;
    private javax.swing.JTextField txtNomRestaurante;
    // End of variables declaration//GEN-END:variables
}
