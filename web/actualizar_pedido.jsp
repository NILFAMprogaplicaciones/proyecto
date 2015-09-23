<jsp:include page='header.jsp'/>                 

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md12">
                
            <table id="lista_pedidos" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                        <th class="col-md-0.5"></th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Tiger Nixon</td>
                        <td>System Architect</td>
                        <td>Preparacion</td>
                        <td>
                            <img src='images/Write.png'title='Actualizar estado' data-toggle="modal" data-target="#myModal">
                            </> 
                        </td>                        
                    </tr>

                    <tr>
                        <td>Olivia Liang</td>
                        <td>Support Engineer</td>
                        <td>Preparacion</td>
                        <td> 
                            <img src='images/Write.png'title='Actualizar estado' data-toggle="modal" data-target="#myModal">
                            </>
                        </td>
                    </tr>
                    <tr>
                        <td>Cara Stevens</td>
                        <td>Sales Assistant</td>
                        <td>Preparacion</td>
                        <td> 
                            <img src='images/Write.png'title='Actualizar estado' data-toggle="modal" data-target="#myModal">
                            </>
                        </td>
                    </tr>
                    <tr>
                        <td>Hermione Butler</td>
                        <td>Regional Director</td>
                        <td>Preparacion</td>
                        <td> 
                            <img src='images/Write.png'title='Actualizar estado' data-toggle="modal" data-target="#myModal">
                            </>
                        </td>                       
                    </tr>
                </tbody>
            </table>
                
            </div>    
        </div>
        
    </div>
    <!-- /.container -->

  <!-- Modal Actualizar estado-->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Actualizar Estado</h4>
        </div>
        <div class="modal-body">
            <p>
                <form method="POST" action="" id="actualizarestadoFRM">
                    <div class="form-group">
                        <div class="radio">
                            <label>
                                <input type="radio" name="estado_pedido" id="Enviado">
                                  Enviado
                            </label>
                            <label>
                                  <input type="radio" name="estado_pedido" id="Recibido" value="Recibido">
                                  Recibido
                            </label>
                            <label>
                                  <input type="radio" name="estado_pedido" id="Preparacion" value="Preparacion">
                                  Preparacion
                            </label>
                        </div>  
                    </div>
                </form>
            </p>    
        </div>
        <div class="modal-footer">
          <input type="button" class="btn btn-default" value="Actualizar"/>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div> 
    </div>
  </div>
    
    
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>
    $(document).ready(function() {
        $('#lista_pedidos').DataTable();
    } );
</script>
<jsp:include page='footer.jsp'/>