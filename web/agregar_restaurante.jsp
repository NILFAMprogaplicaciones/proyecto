<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form class="form-horizontal" id="restauranteFRM">
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="email" class="form-control" id="inputEmail" placeholder="Nombre">
                            </div>
                    </div>
                    <div class="form-group">
                                    <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" id="inputNickname" placeholder="Nickname">
                                    </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputDireccion" placeholder="Direcci&oacute;n">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                            </div>
                    </div>                
                    <input type="button" class="btn" value="Enviar" onclick="CheckRestaurante();"/>
                    <input type="reset"  class="btn" value="Cancelar" />
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>