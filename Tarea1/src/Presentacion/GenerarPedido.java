
package Presentacion;

import Logica.Categoria;
import Logica.Cliente;
import Logica.DataPedido;
import Logica.DataProductosPedido;
import Logica.Estado;
import Logica.Fabrica;
import Logica.FechaHora;
import Logica.IControladorPedido;
import Logica.ManejadorCategoria;
import Logica.ManejadorPedido;
import Logica.ManejadorUsuario;
import Logica.Pedido;
import Logica.Producto;
import Logica.Promocion;
import Logica.Restaurante;
import Logica.TipoAsosiativoPedido;
import Logica.Usuario;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GenerarPedido extends javax.swing.JInternalFrame {

    private IControladorPedido ICP;
    
        
    
    public void cargarclientes(){
        //INSTANCEO EL MANEJADOR DE USUARIO
        ManejadorUsuario MU = ManejadorUsuario.getinstance();
        //AGREGO LAS FILAS NECESARIAS EN MI JTABLE
        int cantidadusuarios=MU.CantClientes();
        int a=0;
        while (a!=cantidadusuarios){
            DefaultTableModel modelo= (DefaultTableModel) listadeclientes.getModel();
            int columna = modelo.getColumnCount();
            modelo.addRow(new Object[columna]);
            listadeclientes.setModel(modelo);
            a++;
        }
        //AREGO VALORES A  LAS FILAS
        Map coleccion=MU.obtenercoleccion();
        Iterator<Usuario> it = coleccion.values().iterator();
        Usuario usu=null;
        int fila=0;
        while (it.hasNext()) {
            usu=it.next();//en usu tenemos el valor
            String objeto= usu.getClass().getSimpleName();
            if(objeto.equals("Cliente")){
                this.listadeclientes.setValueAt(usu.getnickname(), fila, 0);
                this.listadeclientes.setValueAt(usu.getcorreo(), fila, 1);
                fila++;
            }
            
        }
    }
    public void cargarcategorias(){
        //AGREGO LOS ELEMENTOS DE LA COLECCION CATEGORIA A LA LISTA
        DefaultListModel<String> modelo=new DefaultListModel<>();
        ManejadorCategoria mc=ManejadorCategoria.getinstance();
        int posision=0;
        Map cole=mc.coleccion();
        Iterator<Categoria> it = cole.values().iterator();
        Categoria cat=null;
        while (it.hasNext()) {
            cat=it.next();//en cat tenemos el valor
            modelo.add(posision,cat.getnombre());
            this.listacategorias.setModel(modelo);
            posision++;
        }
    }
    public GenerarPedido() {
        initComponents();
        cargarclientes();
        cargarcategorias();
        Fabrica fabrica = Fabrica.getInstance();
        ICP = fabrica.getIControladorPedido();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listadeclientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listares = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listacategorias = new javax.swing.JList();
        Mostrarrestaurantes = new javax.swing.JButton();
        listacategoria = new javax.swing.JLabel();
        listarestaurantes = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaproductos = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        MostrarProdcutos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        CantidadProductos = new javax.swing.JSpinner();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        lblRestaurante = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaPedido = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        listo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

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

        jScrollPane2.setViewportView(listares);

        jScrollPane3.setViewportView(listacategorias);

        Mostrarrestaurantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forward_alt.png"))); // NOI18N
        Mostrarrestaurantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarrestaurantesActionPerformed(evt);
            }
        });

        listacategoria.setText("Lista de Categorias");

        listarestaurantes.setText("Lista de Restaurantes");

        jScrollPane4.setViewportView(listaproductos);

        jLabel1.setText("Lista de Productos");

        MostrarProdcutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forward_alt.png"))); // NOI18N
        MostrarProdcutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarProdcutosActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
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
        jScrollPane5.setViewportView(TablaProductos);

        jLabel2.setText("Cantidad");

        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nickname", "Correo", "Fecha/Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCliente.setMinimumSize(new java.awt.Dimension(46, 45));
        jScrollPane6.setViewportView(TablaCliente);

        lblEstado.setText("Estado del pedido...");

        lblRestaurante.setText("Restaurante...");

        TablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Tipo", "Precio por unidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TablaPedido);

        jLabel5.setText("Precio Total");

        txtPrecioTotal.setEditable(false);

        jLabel6.setText("Codigo");

        txtCodigo.setEditable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new archive.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        listo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back_alt.png"))); // NOI18N
        listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lista de Clientes");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(listacategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Mostrarrestaurantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listarestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MostrarProdcutos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addComponent(lblRestaurante)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(75, 75, 75)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRestaurante)
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 216, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listacategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listarestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Mostrarrestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MostrarProdcutos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarrestaurantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarrestaurantesActionPerformed
        String seleccion = (String) listacategorias.getSelectedValue();
        
        if(seleccion==null){
            JOptionPane.showMessageDialog(this,"Por vafor seleccione una Categoria","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
        }
        else{
            //AGREGO LOS ELEMENTOS DE LA COLECCION CATEGORIA A LA LISTA
            DefaultListModel<String> modelo=new DefaultListModel<>();
            ManejadorUsuario MU=ManejadorUsuario.getinstance();

            int posision=0;

            Map coleccionrestaurantes=MU.getColeccionRestaurante();
            Iterator<Restaurante> it = coleccionrestaurantes.values().iterator();
            Restaurante res=null;
            while (it.hasNext()) {
                res=it.next();
                if(res.ExisteCategoria(seleccion)){
                    modelo.add(posision,res.getnickname());
                    this.listares.setModel(modelo);
                    posision++; 
                }

            }
        }     
    }//GEN-LAST:event_MostrarrestaurantesActionPerformed

    private void MostrarProdcutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarProdcutosActionPerformed
        String seleccion = (String) listares.getSelectedValue(); 
        if(seleccion==null){
            JOptionPane.showMessageDialog(this,"Por vafor seleccione un Restaurante","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
        }
        else{
            //AGREGO LOS PRODUCTOS DE MI RESTAURANTE
            DefaultListModel<String> modelo=new DefaultListModel<>();
            ManejadorUsuario MU=ManejadorUsuario.getinstance();

            int posision=0;

            Map cole=MU.getColeccionProductosRestaurantes(seleccion);
            Iterator<Producto> it = cole.values().iterator();
            Producto pro=null;
            while (it.hasNext()) {
                pro=it.next();
                if(pro.getClass().getSimpleName().equals("Promocion")){
                    Promocion promo=(Promocion) pro;
                    if(promo.getactiva()==true){
                        modelo.add(posision,promo.getnombre());
                        this.listaproductos.setModel(modelo);
                    }
                        
                }
                else{
                    modelo.add(posision,pro.getnombre());
                    this.listaproductos.setModel(modelo);
                }
                posision++; 
            }
        }
    }//GEN-LAST:event_MostrarProdcutosActionPerformed
    int fila=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //OBTENGO VALORES DE LA LISTA DE PRODUCTOS
        String producto=(String)listaproductos.getSelectedValue();
        if(producto==null){
            JOptionPane.showMessageDialog(this,"Por vafor seleccione un Producto","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
        }
        else{
            if(CantidadProductos.getValue().equals(0))
                JOptionPane.showMessageDialog(this,"Verifique su cantidad de Productos","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
            else{
                //AGREGAR FILAS A LA TABLA
                DefaultTableModel modelo= (DefaultTableModel) this.TablaProductos.getModel();
                int columna = modelo.getColumnCount();
                modelo.addRow(new Object[columna]);
                TablaProductos.setModel(modelo);

                //AGREGO VALORES A  LAS FILAS
                TablaProductos.setValueAt(producto, fila, 0);
                TablaProductos.setValueAt(CantidadProductos.getValue(), fila, 1);

                fila++;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private double Redondear(double numero){
            return Math.rint(numero*100)/100;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int filalistacliente=listadeclientes.getSelectedRow();
        
        
        if(filalistacliente==-1)
            JOptionPane.showMessageDialog(this,"Seleccion un Cliente de la tabla","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
        else if(fila==0)
            JOptionPane.showMessageDialog(this,"No a agregado Productos al Pedido","GENERAR PEDIDO",JOptionPane.WARNING_MESSAGE);
        else{ 
            String seleccion=(String) listadeclientes.getValueAt(filalistacliente, 0);
            Map<String,Producto> coleccionproducto=new HashMap<String,Producto>();
            Map<String,DataProductosPedido> ColeccionDPP=new HashMap<String,DataProductosPedido>();
            //INSTANCEO MANEJADORES
            ManejadorUsuario MU=ManejadorUsuario.getinstance();
            ManejadorPedido MP=ManejadorPedido.getinstance();
            //ESCRIBO EN LAS LBL
            lblEstado.setText("Estado del Pedido: PREPARACION");
            lblRestaurante.setText("Restaurante: "+(String) listares.getSelectedValue());
            //AGREGAR FILAS A LA TABLA
            DefaultTableModel modelo= (DefaultTableModel) this.TablaCliente.getModel();
            int columna = modelo.getColumnCount();
            modelo.addRow(new Object[columna]);
            TablaCliente.setModel(modelo);
                //FECHA Y HORA DEL SISTEMA
            Calendar fechayhora = Calendar.getInstance();
           
            int dia=fechayhora.get(Calendar.DATE), mes=1+fechayhora.get(Calendar.MONTH),año=fechayhora.get(Calendar.YEAR),
                    hora=fechayhora.get(Calendar.HOUR),minutos=fechayhora.get(Calendar.MINUTE);
            String fecha = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año)+"-"+Integer.toString(hora)+":"+Integer.toString(minutos);
            //AGREGO VALORES A LA FILAS
            TablaCliente.setValueAt(listadeclientes.getValueAt(filalistacliente, 0),0, 0);
            TablaCliente.setValueAt(listadeclientes.getValueAt(filalistacliente, 1),0, 1);
            TablaCliente.setValueAt(fecha,0, 2);
            ////////////////////////////////////////////////////////////////
            int cantidad=0;
            double preciototal=0;

            while(cantidad!=fila){
                DefaultTableModel modelo2= (DefaultTableModel) this.TablaPedido.getModel();
                int columna2 = modelo2.getColumnCount();
                modelo2.addRow(new Object[columna]);
                TablaPedido.setModel(modelo2);

                //OBTENGO NOMBRE DEL PRODUCTO DE TABLAPRODUCTOS A TABLAPEDIDO
                String nombreProducto=(String) TablaProductos.getValueAt(cantidad,0);
                TablaPedido.setValueAt(nombreProducto, cantidad, 0);
                //CANTIDAD POR PRODUCTO
                int cantidadPedido=(Integer) TablaProductos.getValueAt(cantidad,1);
                TablaPedido.setValueAt(cantidadPedido, cantidad, 1);
                //TIPO DE PRODUCTO
                String tipoDeProducto=MU.findRestaurante((String) listares.getSelectedValue()).getProducto((String) TablaProductos.getValueAt(cantidad,0)).getClass().getSimpleName();
                TablaPedido.setValueAt(tipoDeProducto, cantidad, 2);
                //PRECIO POR UNIDAD
                double precioDeProducto=(Double)MU.findRestaurante((String) listares.getSelectedValue()).buscarprecio(nombreProducto);
                TablaPedido.setValueAt(precioDeProducto, cantidad, 3);


                String PedidoNomProducto=(String) TablaPedido.getValueAt(cantidad,0 );
                Producto producto=MU.findRestaurante((String)listares.getSelectedValue()).getProducto((String) TablaPedido.getValueAt(cantidad,0 ));

                preciototal=preciototal+((cantidadPedido)*(precioDeProducto));
                coleccionproducto.put(PedidoNomProducto,producto);


                DataProductosPedido dpp=new DataProductosPedido(producto,cantidadPedido,((cantidadPedido)*(precioDeProducto)));
                
                ColeccionDPP.put(dpp.getProducto().getnombre(),dpp);
                
                cantidad++;
            }
            //SETEO EN LAS TXT FINALES
            txtPrecioTotal.setText(String.valueOf(Redondear(preciototal)));
            Map col=MP.getColeccionPedido();
            Iterator<Pedido> it = col.values().iterator();
            Pedido ped=null;
            int id=0;
            while (it.hasNext()) {
                ped=it.next();
                id=ped.getnum();
            }
            txtCodigo.setText(Integer.toString(id+1));

            FechaHora fechahora=new FechaHora(dia,mes,año,hora,minutos);
            Cliente cliente=MU.findCliente((String) TablaCliente.getValueAt(0, 0));
            
            TipoAsosiativoPedido tipoasosiativopedido=new TipoAsosiativoPedido(ColeccionDPP);
            
            DataPedido datapedido=new DataPedido((id+1),fechahora,Redondear(preciototal),Estado.PREPARCION,cliente,coleccionproducto,(MU.findRestaurante((String)listares.getSelectedValue())),tipoasosiativopedido);
            
            ICP.Caso_Generar_Pedido(datapedido);
            dispose();
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listoActionPerformed
        //NO LIMPIO NADA YA QUE CADA VES QUE LLAMO EL INTERNAL REALIZO UN NEW
        dispose();
    }//GEN-LAST:event_listoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner CantidadProductos;
    private javax.swing.JButton MostrarProdcutos;
    private javax.swing.JButton Mostrarrestaurantes;
    private javax.swing.JTable TablaCliente;
    private javax.swing.JTable TablaPedido;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblRestaurante;
    private javax.swing.JLabel listacategoria;
    private javax.swing.JList listacategorias;
    private javax.swing.JTable listadeclientes;
    private javax.swing.JList listaproductos;
    private javax.swing.JList listares;
    private javax.swing.JLabel listarestaurantes;
    private javax.swing.JButton listo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
