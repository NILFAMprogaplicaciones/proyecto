<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form class="form-horizontal" id="clienteFRM">
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
                                <input type="password" class="form-control" id="inputContrasena" placeholder="Contrase&ntilde;a">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputApellido" class="control-label col-xs-2">Apellido</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputApellido" placeholder="Apellido">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFecha_nacimiento" class="control-label col-xs-2">Fecha Nacimiento</label>
                            <div class="col-xs-10">
                                <input type="date" class="form-control" id="inputFecha_nacimiento" placeholder="Fecha Nacimiento">
                            </div>
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="button" class="btn" value="Enviar" onclick="CheckCliente();"/>
                         <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>