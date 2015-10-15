<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.DataPedido"%>
<jsp:include page='header.jsp'/>   
    <div class="container">
        <div class="row">
            <div class="col-sm-2 col-lg-2 col-md-2">
                <div class="thumbnail">
                    <img src="images/restaurante.png" alt="">
                </div>    
            </div>
            <div class="col-sm-10 col-lg-10 col-md-10">
                <form class="form-horizontal" method="GET" action="AgregarProductos" id="detallesproductosFRM">

                    <div class="form-group">
                        <label for="inputNombreRestaurante" class="control-label col-xs-2">Restaruante</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputNombreRestaurante" name="inputNombreRestaurante" >
                            </div>
                    </div>
                            
                </form> 
            </div> 
        </div>                    
        <div class="row">
            <table id="productos_pedidos" class="table table-hover" cellspacing="0" width="100%">
                <i><h4>Productos en este pedido:</i></h4><br>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Imagen</th>
                        <th class="col-md-1">Precio</th>
                        <th>Descripci&oacute;n</th>
                        <th>Tipo</th>
                        <th class="col-md-1">Cantidad</th>
                        <th class="col-md-1">Total</th>
                    </tr>
                </thead>
           
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
            </table> 
        </div>      
</div>
                                
 <script src="http://code.jquery.com/jquery-latest.js"></script>                                
 <script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#productos_pedidos').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            });               
    } );
</script>
<jsp:include page='footer.jsp'/>    
        
        
        
        
        
        
        
        
        
        
        
        
        
      