<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.ManejadorPedido"%>
<%@page import="Logica.Pedido"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.DataCantidad"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="Logica.DataPromocion"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.IControladorProducto"%>
<jsp:include page='header.jsp'/>   
    
    <%
        String restaurante = (String)session.getAttribute("restaurante");
        DataPromocion DP=Auxiliar.getPromocion(request.getParameter("producto")); 
    %> 
    <div class="container">
        <div class="row">
            <form method="POST"action="Carrito" class="form-horizontal" id="detallesproductosFRM">          
                <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputNombre" name="inputNombre" value="<%=DP.getNombre()%>" readonly>
                            </div>
                </div>
                <div class="form-group">
                    <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" id="inputDescripcion" value="<%=DP.getDescripcion()%>" readonly>
                        </div>
                </div>
                <div class="form-group">
                    <label for="inputPrecio" class="control-label col-xs-2">Precio</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" id="inputPrecio" name="inputPrecio" value="<%=DP.getPrecioTotal()%>" readonly >
                        </div>
                </div>
                <div class="form-group" id="promocion">
                        
                            <%if(DP.getActiva()){%>
                                <label for="inputPromocion" class="control-label col-xs-4">Promocion Avtiva  <span class="glyphicon glyphicon-check"></span></label>
                            <%}else{%>
                                <label for="inputPromocion" class="control-label col-xs-4">Promocion Inactiva  <span class="glyphicon glyphicon-unchecked"></span></label>                            
                            <%}%>
                        <br>
                </div>  
                <div class="col-lg-2 col-lg-offset-3">
                        <input id="cantidad" type="text" value="" name="cantidad" >
                        <button type="submit" class="btn glyphicon glyphicon-shopping-cart"onclick="DatosAgregados();"></button>
                        <!--<a href="ver_restaurante.jsp?producto=<%=restaurante%>"></a>-->
                </div>
            </form>              
        </div><!--cierro div row --> <br>
        
        <div class="row">
            <table id="productos_promocion" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <i><h4>Productos de la promocion:</i></h4><br>
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                        <%

                            Iterator<DataCantidad> it = DP.getColeccionProducto().values().iterator();
                            DataCantidad dc=null;

                        %>
                        <%
                            while (it.hasNext()){
                            dc=it.next();
                        %>
                <tbody>
                    <tr>
                        <td><%=dc.getProducto().getnombre()%></td>
                        <td><%=dc.getCantidad()%></td>                       
                    </tr>
                </tbody>
                    <%
                        }
                    %>
            </table>  
        </div><br>
        
        <div class="row">        
            <table id="pedidos_producto" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <i><h4>Pedidos que incluyen este producto:</i></h4><br>
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Cliente</th>
                        <th>Precio total</th>
                    </tr>
                </thead>
                    <%
                    Iterator<Pedido> ite = Auxiliar.getPedidosProductos(DP.getNombre()).values().iterator();
                    Pedido pe=null;

                    %>
                    <%
                        while (ite.hasNext()){
                        pe=ite.next();
                    %>
                <tbody>
                    <tr>
                        <td><%=pe.verfechastring()%></td>
                        <td><%=pe.getCliente().getnickname()%></td>  
                        <td><%=pe.getPrecioTotal()%></td>
                    </tr>
                </tbody>
                <%}%>
            </table>  
        </div> <!--cierro div row -->
    </div> 
            
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Cancelar"><span aria-hidden="true">&times;</span></button>     
      </div>
      <div class="modal-body">
        <h4 class="modal-title" id="myModalLabel">Se agrego el producto a su carrito</h4>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary" onclick="" data-dismiss="modal" >Aceptar</button>
      </div>
    </div>
  </div>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/jquery.bootstrap-touchspin.js"></script>
<script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#productos_promocion').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            });     
           $('#pedidos_producto').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            }); 
    } );
</script>
<script type="text/javascript">
    
    function DatosAgregados(){
        
        window.alert("Producto agregado al carrito");
        document.getElementById("detallesprodutosFRM").submit();//mando submit
    }
    
</script>
<script>
    $("input[name='cantidad']").TouchSpin({
      verticalbuttons: true,
      min: 1,
      initval: 1,
      verticalupclass: 'glyphicon glyphicon-plus',
      verticaldownclass: 'glyphicon glyphicon-minus'
    });
</script>
<jsp:include page='footer.jsp'/>