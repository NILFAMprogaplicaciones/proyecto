<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.Pedido"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorPedido"%>
<%@page import="Logica.DataIndividual"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.IControladorProducto"%>
<%@page import="Logica.ManejadorProducto"%>
<%@page import="Logica.Producto"%>
<jsp:include page='header.jsp'/>   

    <%
        DataIndividual DI=Auxiliar.getIndividual(request.getParameter("producto")); 
    %> 
        
    <div class="container">
        <div class="row">
            <div class="col-sm-2 col-lg-2 col-md-2">
                <div class="thumbnail">
                    <img src="<%=DI.getDireccionFoto()%>" alt="<%=DI.getDireccionFoto()%>">
                </div>    
            </div>
            <div class="col-sm-10 col-lg-10 col-md-10">
                <form class="form-horizontal" method="GET" action="AgregarProductos" id="detallesproductosFRM">

                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputNombre" name="inputNombre" value="<%=DI.getNombre()%>" readonly>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputDescripcion" value="<%=DI.getDescripcion()%>" readonly>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPrecio" class="control-label col-xs-2">Precio</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputPrecio"  value="<%=DI.getPrecio()%>" readonly >
                            </div>
                    </div>

                </form> 
            </div> 
        </div>                    
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
                        Iterator<Pedido> ite = Auxiliar.getPedidosProductos(DI.getNombre()).values().iterator();
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
        </div>      
</div>
                                
 <script src="http://code.jquery.com/jquery-latest.js"></script>                                
 <script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#pedidos_producto').DataTable();               
    } );
</script>
<jsp:include page='footer.jsp'/>    
        
        
        
        
        
        
        
        
        
        
        
        
        
      