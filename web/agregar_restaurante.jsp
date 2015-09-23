<jsp:include page='header.jsp'/>            

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form class="form-horizontal" id="restauranteFRM">
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNickname" name="inputNickname" placeholder="Nickname">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputDireccion" name="inputDireccion" placeholder="Direcci&oacute;n">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputContrasena" class="control-label col-xs-2">Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input type="password" class="form-control" id="inputContrasena" name="inputContrasena" placeholder="Contrase&ntilde;a">
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCategoria" class="control-label col-xs-2">Categoria</label>
                        <div class="col-xs-10 selectContainer">
                            <select name="selectCategoria" id="selectCategoria" class="form-control" onclick="listarCategorias();">
                                <option value="0">Seleccione Categoria</option>
                            </select>
                        </div>
                    </div>
                    
                    <div id="divListaCategorias" style="display:none">
                      <div class="col-lg-4 col-lg-offset-4">
                        <table id="lista_categorias" class="table table-striped table-bordered" cellspacing="0" width="50%">
                            <thead>
                                <tr>
                                    <th>Categoria</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Piza</td>
                                </tr>
                                <tr>
                                    <td>Hamb</td>
                                </tr>
                            </tbody>
                        </table>   
                        </div>
                    </div>

                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="button" class="btn" value="Enviar" onclick="CheckRestaurante();"/>
                        <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    <script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>
    function listarCategorias() { 
        document.getElementById('divListaCategorias').style.display = "block";
    }
</script>
    <script>
        $(document).ready(function() {                                   // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
                $.get('Categorias', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $select = $('#selectCategoria');                           // Locate HTML DOM element with ID "someselect".
                    $select.find('option').remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                    $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
                        $('<option>').val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
                    });
                });
        });
    </script> 
<jsp:include page='footer.jsp'/>