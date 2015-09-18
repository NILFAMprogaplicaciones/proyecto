

<%@page import="java.util.Map"%>
<%@page import="Logica.ManejadorCategoria"%>
<%@page import="java.util.HashMap"%>
<%@page import="Logica.Categoria"%>
<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form class="form-horizontal" id="restauranteFRM" method="POST" action="Categorias">
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNickname" placeholder="Nickname">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNombre" placeholder="Nombre">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputDireccion" placeholder="Direcci&oacute;n">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputContrasena" class="control-label col-xs-2">Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputContrasena" placeholder="Contrase&ntilde;a">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCategoria" class="control-label col-xs-2">Categoria</label>
                        <div class="col-xs-10 selectContainer">
                            <select name="inputCategoria" id="inputCategoria" class="form-control">
                                <option value="0">Seleccione Categoria</option>
                                    <%
                                        Map<String, Categoria> categorias = (Map)request.getAttribute("MapCategorias");
                                       // categorias tiene todas las categorias del sistema
                                    %>
                                <option value="Cat1">Cat 1</option>
                                <option value="Cat2">Cat 2</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="button" class="btn" value="Enviar" onclick="CheckRestaurante();"/>
                        <input type="reset"  class="btn" value="Cancelar" />
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>