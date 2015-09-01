
package Presentacion;

import Logica.DataPedido;
import Logica.Estado;
import Logica.Fabrica;
import Logica.IControladorPedido;
import Logica.Individual;
import Logica.ManejadorPedido;
import Logica.Pedido;
import Logica.Producto;
import Logica.Promocion;
import java.awt.Color;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Info extends javax.swing.JFrame {

    public void setidPedido(int idpedido){
        InfoPedido info=new InfoPedido();
        info.setidPasado(idpedido);
        
        
    }
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
    public void limpiarTabla(JTable TablaPedidos){
            try {
                DefaultTableModel modelo=(DefaultTableModel) TablaPedidos.getModel();
                int filas=TablaPedidos.getRowCount();
                for (int i = 0;filas>i; i++) {
                    modelo.removeRow(0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
            }
    }
    private IControladorPedido ICP;
    
    public void setidPasado(int id){
        idpasado=id;
    }
    int idpasado;
    
    public Info() {
        initComponents();
        cargarTablaPedidos();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
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
        jInternalFrame2 = new javax.swing.JInternalFrame();
        lblEstado1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPedidos1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaProductos1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaUsuarios1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstado)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(151, 151, 151)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton3))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jInternalFrame2.setVisible(true);

        lblEstado1.setBackground(new java.awt.Color(192, 182, 182));
        lblEstado1.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        lblEstado1.setText("Estado...");

        TablaPedidos1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TablaPedidos1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Usuarios del Pedido");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/down_alt.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Pedidos en el Sistema");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Productos del Pedido seleccionado");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minus.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        TablaProductos1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TablaProductos1);

        TablaUsuarios1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(TablaUsuarios1);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total general del Pedido");

        txtTotal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotal1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel5)))))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstado1)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(151, 151, 151)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(lblEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton6))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTabla(TablaProductos);
        ManejadorPedido MP=ManejadorPedido.getinstance();
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
                ICP.Caso_Cancelar_Pedido(idPedido);
                limpiarTabla(TablaPedidos);
                cargarTablaPedidos();
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
JOptionPane.showMessageDialog(this, idpasado);
        limpiarTabla(TablaProductos);
        ManejadorPedido MP=ManejadorPedido.getinstance();
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int fila=TablaPedidos.getSelectedRow();
        if(fila==-1)
        JOptionPane.showMessageDialog(this,"Seleccione un Pedido","INFORMACION PEDIDO",JOptionPane.WARNING_MESSAGE);
        else{
            int idPedido=(int) TablaPedidos.getValueAt(fila,0);
            int respuesta=JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar el Pedido","PEDIDO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                ICP.Caso_Cancelar_Pedido(idPedido);
                limpiarTabla(TablaPedidos);
                cargarTablaPedidos();
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPedidos;
    private javax.swing.JTable TablaPedidos1;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TablaProductos1;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JTable TablaUsuarios1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstado1;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}
