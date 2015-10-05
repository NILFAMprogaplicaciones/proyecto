<%@page import="Logica.*"%>
<jsp:include page='header.jsp'/>
<%
    IControladorUsuario ICU;
    Fabrica fabrica = Fabrica.getInstance();
    ICU = fabrica .getIControladorUsuario();
    DataRestaurante dc=ICU.Caso_Ver_Restaurante(request.getParameter("nicknamerestaurante"));
%> 
<div class="container">
    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img src="images/restaurante.png" alt="">
            <span> <%=dc.getnombre()%> </span>
                <div class="ratings">
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                        </p>
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
                        <table id="lista_menu" class="table table-striped table-bordered" cellspacing="0" width="100%">
                         <thead>
                             <tr>
                                 <th>Menu</th>
                                 <th>Menu</th>
                             </tr>
                         </thead>

                         <tbody>
                           
                         </tbody>
                      </table>  
                        
                    </div>
                    
                    <div class="tab-pane" id="Informacion">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputEmail" value="<%=dc.getnombre()%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputNickname" value="<%=dc.getnickname()%>" readonly>
                                </div>
                            </div>
                           <div class="form-group">
                                <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputDireccion" value="<%=dc.getdireccion()%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail" class="control-label col-xs-2">Email</label>
                                <div class="col-xs-10">
                                    <input type="email" class="form-control" id="inputEmail" value="<%=dc.getcorreo()%>" readonly>
                                </div>
                            </div>
                        </form>
                    </div>
                    
                    <div class="tab-pane" id="Comentarios">
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
                                
 <script src="http://code.jquery.com/jquery-latest.js"></script>                                
 <script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#lista_menu').DataTable();               
    } );
</script>
<jsp:include page='footer.jsp'/>