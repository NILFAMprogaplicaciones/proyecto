<%@page import="Logica.Estado"%>
<%@page import="Logica.DataPromocion"%>
<%@page import="Logica.DataIndividual"%>
<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.DataPedido"%>
<%@page import="Logica.Producto"%>
<%@page import="Logica.Restaurante"%>
<%@page import="Logica.ManejadorUsuario"%>
<%@page import="Logica.Individual"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorProducto"%>
<jsp:include page='header.jsp'/>  

<%
    DataPedido dp=Auxiliar.getDataPedido(request.getParameter("id_Pedido")) ;
%>

<link href="css/jquery.bootstrap-touchspin.css" rel="stylesheet">  


<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <div class="form-group">
                
                <h2 class="media-heading"> Restaurante <a href="ver_restaurante.jsp?nicknamerestaurante=<%=dp.getRestaurante().getnickname()%>"><%=dp.getRestaurante().getnombre()%></a></h2>
                <%
                    if(dp.getEstado().equals(Estado.PREPARCION)){
                %>
                        <h3 class="navbar-text navbar-right">ESTADO: <span class="label label-danger"><%=dp.getEstado()%></span></h3>
                <%
                    }else if(dp.getEstado().equals(Estado.ENVIADO)){
                %>
                        <h3 class="navbar-text navbar-right">ESTADO: <span class="label label-primary"><%=dp.getEstado()%></span></h3>
                <%
                    }else{
                %>
                        <h3 class="navbar-text navbar-right">ESTADO: <span class="label label-success"><%=dp.getEstado()%></span></h3>
                <%
                    }
                %>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Total</th>
                        <th class="text-center">Tipo</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Iterator<Producto> it = dp.getColeccionProductos().values().iterator();
                        Producto p;
                        while(it.hasNext()){
                            p=it.next();
                            if(p.getClass().getSimpleName().equals("Individual")){
                                DataIndividual di=Auxiliar.getIndividual(p.getnombre());
                    %>
                            <tr>
                                <td class="col-sm-8 col-md-6">
                                    <div class="media">
                                        <a class="thumbnail pull-left"> <img class="media-object" src="<%=di.getDireccionFoto()%>" style="width: 72px; height: 72px;"> </a>
                                        <div class="media-body">
                                            <h4 class="media-heading"><a ><%=di.getNombre()%></a></h4>
                                            
                                        </div>
                                    </div>
                                </td>
                                <td class="col-sm-1 col-md-1" style="text-align: center">
                                    <input type="text" class="form-control" id="exampleInputEmail1" value="<%=dp.getTipoAP().getDataProductoPedido(di.getNombre()).getCantidad()%>" readonly>
                                </td>
                                <td class="col-sm-1 col-md-1 text-center"><strong>$<%=di.getPrecio()%></strong></td>
                                <td class="col-sm-1 col-md-1 text-center"><strong>$<%=dp.getTipoAP().getDataProductoPedido(di.getNombre()).getSubTotal()%></strong></td>
                                <td class="col-sm-1 col-md-1 text-center"><strong>Individual</strong></td>
                                
                            </tr>
                    <%
                            }else{
                                DataPromocion dpro=Auxiliar.getPromocion(p.getnombre());
                    %>
                               <tr>
                                <td class="col-sm-8 col-md-6">
                                    <div class="media">
                                        <a class="thumbnail pull-left"> <img class="media-object" src="<%=dpro.getDireccionFoto()%>" alt="<%=dpro.getDireccionFoto()%>" style="width: 72px; height: 72px;"> </a>
                                        <div class="media-body">
                                            <h4 class="media-heading"><a><%=dpro.getNombre()%></a></h4>
                                            
                                        </div>
                                    </div>
                                </td>
                                <td class="col-sm-1 col-md-1" style="text-align: center">
                                    <input type="text" class="form-control" id="exampleInputEmail1" value="<%=dp.getTipoAP().getDataProductoPedido(dpro.getNombre()).getCantidad()%>" readonly>
                                </td>
                                <td class="col-sm-1 col-md-1 text-center"><strong>$<%=dpro.getPrecioTotal()%></strong></td>
                                <td class="col-sm-1 col-md-1 text-center"><strong>$<%=dp.getTipoAP().getDataProductoPedido(dpro.getNombre()).getSubTotal()%></strong></td>
                                <td class="col-sm-1 col-md-1 text-center"><strong>Promocion</strong></td>
                            </tr>                         

                    
                    <%
                            }
                        }
                    
                    %>
                </tbody>
                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3>$<%=dp.getPrecioTotal()%></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                            <button type="button" class="btn btn-success" onclick="history.back()"><span class="glyphicon glyphicon-arrow-left" >  </span>Atras
                            </button>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<jsp:include page='footer.jsp'/>