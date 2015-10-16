<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.*"%>
<jsp:include page='header.jsp'/>
<%
    DataCliente dc=Auxiliar.getCliente(request.getParameter("nickname"));
%> 

<div class="container">
    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img src="<%= dc.getDireccionFoto()%>" alt="<%= dc.getnombre()%>">
        </div>
    </div>
    <div class="col-sm-6 col-lg-6 col-md-6">
        <div id="content">
                <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
                    <li><a href="#Informacion" data-toggle="tab">Informaci&oacute;n</a></li>
                    <li><a href="#Pedidos" data-toggle="tab">Pedidos</a></li>
                </ul>
            <br>
                <div id="my-tab-content" class="tab-content">
                    
                    <div class="tab-pane" id="Informacion">
                        <form  class="form-horizontal" id="clienteFRM">
 
                            <div class="form-group">
                                <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                                    <div class="col-xs-10">
                                        <input  type="text"  class="form-control" id="inputNickname" value="<%= dc.getnickname() %>" readonly>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputEmail" class="control-label col-xs-2">Email</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputEmail" value="<%= dc.getcorreo()%>" readonly>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputNombre" value="<%= dc.getnombre()%>" readonly>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputApellido" class="control-label col-xs-2">Apellido</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputApellido" value="<%= dc.getapellido()%>" readonly>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputDireccion" value="<%= dc.getdireccion()%>" readonly>
                                    </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="inputFecha_nacimiento" class="control-label col-xs-2">Fecha Nacimiento</label>
                                    <div class="col-xs-10">
                                        <input type="date" class="form-control" id="inputFecha_nacimiento" value="<%= dc.getfechastring()%>" readonly>
                                    </div>
                            </div>
                                    
                            
                        </form>
                    </div>
                    
                    <div class="tab-pane" id="Pedidos">
                        <table id="lista_pedidos_cliente" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="col-md-6">Pedido</th>
                                    <th class="col-md-4">Estado</th>
                                    <th class="col-md-1"></th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>
                                        <a href="agregar_comentario.jsp">
                                            <img src="images/Bubble 1.png" alt="">
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                     </table>  
                    </div>
                </div>
 
        </div> 
    </div>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>
    $(document).ready(function() {       
      $('#lista_pedidos_cliente').DataTable();    
    });
</script> 
<jsp:include page='footer.jsp'/>