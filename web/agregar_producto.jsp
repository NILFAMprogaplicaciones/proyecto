<jsp:include page='header.jsp'/>                
<link href="css/jquery.bootstrap-touchspin.css" rel="stylesheet">   

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form method="POST" action="AgregarProductos" class="form-horizontal" id="productoFRM">
                    <div class="form-group">
                        <label for="inputRestaurante" class="control-label col-xs-2">Restaurante</label>
                        <div class="col-xs-10 selectContainer">
                            <select name="selectRestaurante" id="selectRestaurante" name="selectRestaurante" class="form-control">
                                <option value="0">Seleccione Restaurante</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="radio">
                            <label>
                              <input type="radio" name="tipo_producto" id="individual" value="individual" onclick="showIndividual()">
                              Individual
                            </label>
                            <label>
                              <input type="radio" name="tipo_producto" id="promocion" value="promocion" onclick="showPromocion()">
                              Promoci&oacute;n
                            </label>
                        </div>  
                    </div>
                    
                    <div id="divIndividual" style="display:none">
                        <div class="form-group">
                            <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre" required>
                                </div>
                        </div>
                        <div class="form-group">
                            <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                                <div class="col-xs-10">

                                    <input type="text" class="form-control" id="inputDescripcion" name="inputDescripcion" placeholder="Descripci&oacute;n">

                                    <input type="text" class="form-control" id="inputDescripcion" placeholder="Descripci&oacute;n" required>
                                </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPrecio" class="control-label col-xs-2">Precio</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputPrecio" name="inputPrecio" placeholder="Precio">

                                    <input type="text" class="form-control" id="inputPrecio" placeholder="Precio" required>
                                </div>
                        </div>
                    </div>
                    
                    <div id="divPromocion" style="display:none">
                        <div class="form-group">
                            <label for="inputDescuento" class="control-label col-xs-2">Descuento</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputDescuento" placeholder="Descuento" required>
                                </div>
                        </div>
                        <div class="checkbox">
                            <div class="form-group">
                              <label for="inputActiva" class="control-label col-xs-2">Activa</label>
                                <div class="col-xs-10">
                                    <input id="inputActiva" type="checkbox" value="Activa">
                                </div>    
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputProductos" class="control-label col-xs-2">Producto</label>
                            <div class="col-xs-10 selectContainer">
                                <select name="selectProductos" id="selectProductos" class="form-control" required>
                                    <option value="0">Seleccione Producto</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputProductos" class="control-label col-xs-2">Cantidad</label>
                            <div class="col-xs-10">
                                <input id="cantidad" type="text" value="" name="cantidad" required>
                            </div>
                        </div>  
                        
                        <div class="col-lg-8 col-lg-offset-4">
                            <input type="button" class="btn" value="Agregar Producto"/> 
                        </div> 

                        <table id="lista_productos_promocion" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Cantidad</th>
                                    <th>Total</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td>1</td>
                                    <td>100</td>
                                </tr>
                                <tr>
                                    <td>Olivia Liang</td>
                                    <td>4</td>
                                    <td>400</td>
                                </tr>
                                <tr>
                                    <td>Cara Stevens</td>
                                    <td>3</td>
                                    <td>300</td>
                                </tr>
                                <tr>
                                    <td>Hermione Butler</td>
                                    <td>5</td>
                                    <td>500</td>
                                </tr>
                            </tbody>
                        </table>                   
                        
                    </div>
                    
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="submit" class="btn" value="Enviar"/> <!--onclick="CheckProducto();"-->
                        <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>                
                
            </div>    
        </div>

    </div>
    <!-- /.container -->

<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script src="js/jquery.bootstrap-touchspin.js"></script>

<script>
    function showIndividual() { 
        document.getElementById('divIndividual').style.display = "block";
        document.getElementById('divPromocion').style.display = "none";
    }
</script>
<script>
    function showPromocion() { 
        document.getElementById('divIndividual').style.display = "block";
        document.getElementById('divPromocion').style.display = "block"; 
    }
</script>  
<script>
    $("input[name='cantidad']").TouchSpin({
      verticalbuttons: true,
      verticalupclass: 'glyphicon glyphicon-plus',
      verticaldownclass: 'glyphicon glyphicon-minus'
    });
</script>
<script type="text/javascript" class="init">

    $(document).ready(function() {
            
            $.get('AgregarProductos', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $select = $('#selectProductos');                           // Locate HTML DOM element with ID "someselect".
                    $select.find('option').remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                    $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
                        $('<option>').val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
                    });
            });
            
            $.get('AgregarRestaurante', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $select = $('#selectRestaurante');                           // Locate HTML DOM element with ID "someselect".
                    $select.find('option').remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                    $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
                        $('<option>').val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
                    });
            });   

           $('#lista_productos_promocion').DataTable();
                
    } );
</script>
<jsp:include page='footer.jsp'/>
