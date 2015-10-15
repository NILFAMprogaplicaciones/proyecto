<%@page import="javax.swing.JOptionPane"%>
<%@page import="Auxiliar.Auxiliar"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.*"%>
<jsp:include page='header.jsp'/>
<link href="css/jquery.bootstrap-touchspin.css" rel="stylesheet"> 
<%
    DataRestaurante dr=Auxiliar.getRestaurante(request.getParameter("nicknamerestaurante"));
   
    Iterator<Producto> it = Auxiliar.getColeccionProductos(dr.getnickname()).values().iterator();
    Producto p;
    
%> 
<div class="container">
    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img src="images/restaurante.png" alt="">
            <span> <%=dr.getnombre()%> </span>
                <div class="ratings">
                    <p>Promedio:</p>
                     <%
                        int promedio = Auxiliar.getPromedio(dr.getnickname()), j=0;
                        while(j<promedio){
                    %>
                      <span class="glyphicon glyphicon-star"></span> 
                    <%
                        j++;
                        }
                    %>
                </div>
        </div>
    </div>
    <div class="col-sm-6 col-lg-6 col-md-6">
        <div id="content">
                <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
                    <li><a href="#Menu" data-toggle="tab">Men&uacute;</a></li>
                    <li><a href="#Informacion" data-toggle="tab">Informaci&oacute;n</a></li>
                    <li><a href="#Comentarios" data-toggle="tab">Comentarios</a></li>
                </ul>
            <br>
                <div id="my-tab-content" class="tab-content">
                    <div class="tab-pane active" id="Menu">
                        <table id="lista_menu" class="table table-hover" cellspacing="0" width="100%">
                         <thead>
                             <tr>
                                 <th class="col-md-8">Menu</th>
                                 <th>Descripcion</th>
                                 <th class="col-md-0.5"></th>
                             </tr>
                         </thead>
                         <tbody>
                            <%
                                while (it.hasNext()){
                                p=it.next();
                            %>
                            <tr>
                                <td>
                                  <%
                                      if (p.getClass().getSimpleName().equals("Individual")){
                                  %>
                                          <span><%=p.getnombre()%></span>                                        
                                  <%
                                      }else{
                                  %>
                                      <span><%=p.getnombre()%></span>

                                  <%
                                      }
                                  %>
                                </td>
                                <td>
                                    <i><%=p.getdescripcion()%></i>                               
                                </td>
                                <td>
                                <!--aca habria que programar cuando hace click
                                    en el carrito se levante un cartel que diga que
                                    se inserto el producto al pedido
                                -->                         
                                  <%
                                      if (p.getClass().getSimpleName().equals("Individual")){
                                  %>
                                        <a href="ver_individual.jsp?producto=<%=p.getnombre()%>"/><img src="images/Zoom In.png"></a>                                        
                                  <%
                                      }else{
                                  %>
                                        <a href="ver_promocion.jsp?producto=<%=p.getnombre()%>"/><img src="images/Zoom In.png"></a>

                                  <%
                                      }
                                  %>
                                </td>
                            </tr>
                                <% 
                                    }
                                %>
                         </tbody>
                      </table>  
                    </div>
                    
                    <div class="tab-pane" id="Informacion">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputEmail" value="<%=dr.getnombre()%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputNickname" value="<%=dr.getnickname()%>" readonly>
                                </div>
                            </div>
                           <div class="form-group">
                                <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputDireccion" value="<%=dr.getdireccion()%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail" class="control-label col-xs-2">Email</label>
                                <div class="col-xs-10">
                                    <input type="email" class="form-control" id="inputEmail" value="<%=dr.getcorreo()%>" readonly>
                                </div>
                            </div>
                        </form>
                    </div>
                    
                    <div class="tab-pane" id="Comentarios">
                        <table class="table">
                            <tbody>
                                <%
                                    Iterator<DataPedido> ite = Auxiliar.getColeccionPedido().values().iterator();
                                    DataPedido dp;
                                    while (ite.hasNext()) {
                                        dp=ite.next();
                                        if(dp.getRestaurante().getnickname().equals(dr.getnickname())){
                                            Pedido pedido = Auxiliar.getPedido(dp.getId());
                                                if(pedido.getComentario()!=null){
                                %>
                                    <tr>
                                        <td>
                                            <%
                                                int puntaje = pedido.getComentario().getPuntaje(), indice=0;
                                                while(indice<puntaje){
                                            %>
                                                    <span class="glyphicon glyphicon-star"></span>
                                            <%
                                                    indice++;
                                                }
                                            %>
                                        </td>
                                        
                                        <td><%=pedido.getComentario().getTexto()%></td>
                                        <td><%=pedido.getComentario().getFecha().getdia()%>/<%=pedido.getComentario().getFecha().getmes()%>/<%=pedido.getComentario().getFecha().getaño()%></td>
                                        <td><%=pedido.getComentario().getInfoPedido()%></td>
                                        <td><%=pedido.getComentario().getCliente().getnickname()%></td>
                                    </tr>
                                <%
                                             }
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
 
        </div> 
    </div>
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
 <script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#lista_menu').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            });               
    } );
</script>
<jsp:include page='footer.jsp'/>