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
                            <input type="text" class="form-control" id="inputNombre" name="inputNombre" value="<%=DI.getNombre()%>">
                        </div>
            </div>
            <div class="form-group">
                <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="inputDescripcion" value="<%=DI.getDescripcion()%>">
                    </div>
            </div>
            <div class="form-group">
                <label for="inputPrecio" class="control-label col-xs-2">Precio</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="inputPrecio"  value="<%=DI.getPrecio()%>">
                    </div>
            </div>
            </div>
        </form>
               
    </body>
</html>   
<jsp:include page='footer.jsp'/>