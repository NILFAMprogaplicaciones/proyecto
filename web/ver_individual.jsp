<%@page import="Logica.Pedido"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorPedido"%>
<%@page import="Logica.DataIndividual"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.IControladorProducto"%>
<%@page import="Logica.ManejadorProducto"%>
<%@page import="Logica.Producto"%>
<jsp:include page='header.jsp'/>   
<!DOCTYPE html>
<html>
    <body>
        <%
            IControladorProducto ICP;
            Fabrica fabrica = Fabrica.getInstance();
            ICP = fabrica .getIControladorProducto();
            DataIndividual DI=ICP.Caso_Ver_Individual(request.getParameter("producto")); 
        %> 
       
        
        <form class="form-horizontal" method="GET" action="AgregarProductos" id="detallesproductosFRM">
            
            <div class="col-lg-8 col-lg-offset-4">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="row" id="clientes">  
                                <div class="col-sm-4 col-lg-4 col-md-4">
                                        <div class="thumbnail">
                                            <img src="images/producto.jpg" alt="">
                                            <div class="caption">
                                                        <h4>PRODUCTO</h4>
                                            </div>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
                <%
                ManejadorPedido MP=ManejadorPedido.getinstance();
                Iterator<Pedido> ite = MP.getPedidos_Producto(DI.getNombre()).values().iterator();
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
        </form>
               
    </body>
</html>   
<jsp:include page='footer.jsp'/>