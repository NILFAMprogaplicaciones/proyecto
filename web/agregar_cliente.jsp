<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form  class="form-horizontal" id="clienteFRM" method="POST" action="AgregarCliente" >
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" name="inputNickname" id="inputNickname" placeholder="Nickname">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" name="inputEmail" id="inputEmail" placeholder="Email">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" name="inputNombre" id="inputNombre" placeholder="Nombre">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" name="inputDireccion" id="inputDireccion" placeholder="Direcci&oacute;n">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputContrasena" class="control-label col-xs-2">Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input type="password" class="form-control"name="inputContrasena" id="inputContrasena" placeholder="Contrase&ntilde;a">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputApellido" class="control-label col-xs-2">Apellido</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" name="inputApellido" id="inputApellido" placeholder="Apellido">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFecha_nacimiento" class="control-label col-xs-2">Fecha Nacimiento</label>
                            <div class="col-xs-10">
                                <input type="date" class="form-control" name="inputFecha_nacimiento" id="inputFecha_nacimiento" placeholder="Fecha Nacimiento">
                            </div>
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="submit" class="btn" value="Enviar" onclick="CheckCliente();"/>
                        <input type="reset"  class="btn" value="Cancelar" />
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>