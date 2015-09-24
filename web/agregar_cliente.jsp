<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form class="form-horizontal" id="clienteFRM">
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNickname" placeholder="Nickname" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputEmail" placeholder="Email" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNombre" placeholder="Nombre" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputDireccion" placeholder="Direcci&oacute;n" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputContrasena" class="control-label col-xs-2">Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input type="password" class="form-control" id="inputContrasena" placeholder="Contrase&ntilde;a" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputApellido" class="control-label col-xs-2">Apellido</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputApellido" placeholder="Apellido" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFecha_nacimiento" class="control-label col-xs-2">Fecha Nacimiento</label>
                            <div class="col-xs-10">
                                <input type="date" class="form-control" id="inputFecha_nacimiento" placeholder="Fecha Nacimiento" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inpuImagen" class="control-label col-xs-2">Imagen</label>
                            <div class="col-xs-10">
                                <input type="file" id="exampleInputFile">
                            </div>    
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="submit" class="btn" value="Enviar" /><!-- onclick="CheckCliente();"-->
                         <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>