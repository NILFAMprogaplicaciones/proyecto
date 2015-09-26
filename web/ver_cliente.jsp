<%@page import="Logica.*"%>
<jsp:include page='header.jsp'/>
<!DOCTYPE html>
<html>
<body>


<%
    IControladorUsuario ICU;
    Fabrica fabrica = Fabrica.getInstance();
    ICU = fabrica .getIControladorUsuario();
    DataCliente dc=ICU.Caso_Ver_Cliente(request.getParameter("nickname"));
%> 

<div class="container">
    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img src="images/usuario.png" alt="">
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
                                        <input  type="text" class="form-control" id="inputNickname" placeholder=<%= dc.getnickname() %>>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputEmail" class="control-label col-xs-2">Email</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputEmail" placeholder=<%= dc.getcorreo()%>>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputNombre" placeholder=<%= dc.getnombre()%>>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputApellido" class="control-label col-xs-2">Apellido</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputApellido" placeholder=<%= dc.getapellido()%>>
                                    </div>
                            </div>
                                    
                            <div class="form-group">
                                <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputDireccion" placeholder=<%= dc.getdireccion()%>>
                                    </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="inputFecha_nacimiento" class="control-label col-xs-2">Fecha Nacimiento</label>
                                    <div class="col-xs-10">
                                        <input type="date" class="form-control" id="inputFecha_nacimiento" placeholder=<%= dc.getfechastring()%>>
                                    </div>
                            </div>
                                    
                            
                        </form>
                    </div>
                    
                    <div class="tab-pane" id="Pedidos">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                    </td>
                                    <td>Muy rico todo</td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                    </td>
                                    <td>Llego en hora</td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                    </td>
                                    <td>No se que mas inventar</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
 
        </div> 
    </div>
</div>
</body>
</html>

<jsp:include page='footer.jsp'/>