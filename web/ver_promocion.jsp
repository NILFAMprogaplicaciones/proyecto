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
        DataPromocion DP=Auxiliar.getPromocion(request.getParameter("producto")); 
    %> 
    <div class="container">
        <div class="row">
            <form class="form-horizontal" id="detallesproductosFRM">          
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
                            <input type="text" class="form-control" id="inputPrecio" value="<%=DP.getPrecioTotal()%>" readonly >
                        </div>
                </div>
                <div class="form-group" id="promocion">
                    <label for="inputPromocion" class="control-label col-xs-4">Promocion activa</label>
                        <div class="col-xs-8">
                            <%if(DP.getActiva()){%>
                                <input type="checkbox" id="inputPromocion" checked >
                            <%}else{%>
                                <input type="checkbox" id="inputPromocion"  >                                
                            <%}%>
                        </div><br>
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

<script src="http://code.jquery.com/jquery-latest.js"></script>                                
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
<jsp:include page='footer.jsp'/>