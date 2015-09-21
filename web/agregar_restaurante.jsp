<jsp:include page='header.jsp'/>            

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form class="form-horizontal" id="restauranteFRM" action="Categorias.java">
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
                        <label for="inputCategoria" class="control-label col-xs-2">Categoria</label>
                        <div class="col-xs-10 selectContainer">
                            <select name="selectCategoria" id="selectCategoria" class="form-control">
                                <option value="0">Seleccione Categoria</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="button" id="somebutton" class="btn" value="Cargar caategorias" />
                        <input type="button" class="btn" value="Enviar" onclick="CheckRestaurante();"/>
                        <input type="reset"  class="btn" value="Cancelar" />
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    <script src="http://code.jquery.com/jquery-latest.js"></script> 

    <script>
        $(document).ready(function() {                                        // When the HTML DOM is ready loading, then execute the following function...
            $('#somebutton').click(function() {                               // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
                $.get('Categorias', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $select = $('#selectCategoria');                           // Locate HTML DOM element with ID "someselect".
                    $select.find('option').remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                    $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
                        $('<option>').val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
                    });
                });
            });
        });
    </script> 
<jsp:include page='footer.jsp'/>