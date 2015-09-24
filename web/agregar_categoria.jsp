<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form method="POST" action="Categorias" class="form-horizontal" id="categoriaFRM">
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre" required>
                            </div>
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="submit" class="btn" value="Enviar"/> <!-- onclick="CheckCategoria();"-->
                        <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>