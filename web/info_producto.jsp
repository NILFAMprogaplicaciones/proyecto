<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">

            <table id="lista_productos" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Restaurante</th>
                        <th class="col-md-0.5"></th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Tiger Nixon</td>
                        <td>System Architect</td>
                        <td>
                            <img src='images/Zoom In.png'title='Detalles' data-toggle="modal" data-target="#myModal">
                            </> 
                        </td>                        
                    </tr>

                    <tr>
                        <td>Olivia Liang</td>
                        <td>Support Engineer</td>
                        <td> 
                            <img src='images/Zoom In.png'title='Detalles' data-toggle="modal" data-target="#myModal">
                            </>
                        </td>
                    </tr>
                    <tr>
                        <td>Cara Stevens</td>
                        <td>Sales Assistant</td>
                        <td> 
                            <img src='images/Zoom In.png'title='Detalles' data-toggle="modal" data-target="#myModal">
                            </>
                        </td>
                    </tr>
                
                </tbody>
            </table>  
                
           </div>
        </div>

    </div>
    <!-- /.container -->
    
  <!-- Modal Detalles productos-->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Detalles</h4>
        </div>
        <div class="modal-body">
                <form method="POST" action="" id="detallesproductosFRM">
                    <div class="form-group">
                            <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                <div class="col-xs-4">
                                    <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
                                </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputDescripcion" placeholder="Descripci&oacute;n">
                            </div><br><br>
                    </div>
                    <div class="form-group">
                        <label for="inputPrecio" class="control-label col-xs-2">Precio</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputPrecio" placeholder="Precio">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescuento" class="control-label col-xs-2">Descuento</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputDescuento" placeholder="Descuento">
                            </div><br><br>
                    </div>
                    
                    <!-- FALTA FUNCION QUE MUESTRE ESTA DIV SOLO SI ES PROMOCION-->
                    <div id="promocion">
                        <div class="form-group">
                            <label for="inputPromocion" class="control-label col-xs-4">Promocion activa</label>
                                <div class="col-xs-8">
                                    <input type="checkbox" id="inputPromocion">
                                </div><br>
                        </div>
                        
                        <table id="productos_promocion" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <h4>Productos de la promocion:</h4>
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td>3</td>                       
                                </tr>

                                <tr>
                                    <td>Olivia Liang</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>Cara Stevens</td>
                                    <td>2</td>
                                </tr>

                            </tbody>
                        </table>  
                    </div>   
                    
                     <table id="pedidos_producto" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <h4>Pedidos que incluyen este producto:</h4>
                            <thead>
                                <tr>
                                    <th>Fecha</th>
                                    <th>Cliente</th>
                                    <th>Precio total</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td>3</td>  
                                    <td>3</td>
                                </tr>

                                <tr>
                                    <td>Olivia Liang</td>
                                    <td>1</td>
                                    <td>3</td>
                                </tr>
                                <tr>
                                    <td>Cara Stevens</td>
                                    <td>2</td>
                                    <td>3</td>
                                </tr>

                            </tbody>
                        </table>  
                    
                </form>
            </p>    
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
          
      </div>
      
    </div>
  </div>    
    
<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script>
    $(document).ready(function() {
        $('#lista_productos').DataTable();
    } );
</script>    
<jsp:include page='footer.jsp'/>
