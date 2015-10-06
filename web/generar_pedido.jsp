<%@page import="java.util.Iterator"%>
<%@page import="Logica.*"%>
<jsp:include page='header.jsp'/>  

<link href="css/jquery.bootstrap-touchspin.css" rel="stylesheet">   

    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                
             <table id="lista_cliente" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>NickName</th>
                        <th>Correo Electronico</th>
                    </tr>
                </thead>

                <tbody>
                    <% 
                        ManejadorUsuario MU=ManejadorUsuario.getinstance();
                        Iterator<Usuario> it = MU.getColeccionClientes().values().iterator();
                        Usuario u;
                    %>
                    <%
                        while (it.hasNext()){
                        u=it.next();
                    %>
                            <tr>
                                <td><%=u.getnickname()%></td>
                                <td><%=u.getcorreo() %></td>
                            </tr>
                    <% 
                        }
                    %>
                </tbody>
             </table>  
            </div>    
        </div>
                
        <div class="row">       
            <div class="col-md-4 col-md-offset-2">
                <form  class="form-horizontal">
                    <div class="form-group">
                            <label for="inputCategoria" class="control-label col-xs-4">Categoria</label>
                            <div class="col-xs-8 selectContainer">
                                <select name="selectCategoria" id="selectCategoria" class="form-control" required>
                                    <option value="0">Seleccione Categoria</option>
                                </select>
                            </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4">
                <form  class="form-horizontal">
                    <div class="form-group">
                        <label for="inputRestaurante" class="control-label col-xs-4">Restaurante</label>
                        <div class="col-xs-8 selectContainer">
                            <select  name="selectRestaurante" id="selectRestaurante"  class="form-control">
                                <option value="0">Seleccione Restaurante</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
        </div>
                
        <div class="row">
            <div class="col-md-4  col-md-offset-2">
                <form  class="form-horizontal">
                    <div class="form-group">
                        <label for="inputProductos" class="control-label col-xs-4">Producto</label>
                        <div class="col-xs-8 selectContainer">
                            <select name="selectProductos" id="selectProductos" class="form-control" >
                                <option value="0">Seleccione Producto</option>
                            </select>
                        </div>
                    </div>
                </form>   
            </div>    
            <div class="col-md-4">
                <form  class="form-horizontal">
                    <div class="form-group">
                        <label for="inputCantidad" class="control-label col-xs-4">Cantidad</label>
                            <div class="col-xs-8">
                                <input id="cantidad" type="text" value="" name="cantidad" >
                            </div>
                    </div>
                </form>    
            </div>
        </div>
        <br>
        <div class="row"> 
            <div class="col-md-6 col-md-offset-3">
                <table id="lista_cantidad_producto" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>

                    <tbody>
                    </tbody>
                </table> 
            </div>    
        </div>  
        <br>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <form>
                    <div class="form-group">
                        <label for="inputPrecioTotal" class="control-label col-xs-4">Precio total</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="inputPrecioTotal" name="inputPrecioTotal" value="">
                            </div>
                    </div>
                </form>    
            </div>       
            <div class="col-md-4"> 
                <form>
                    <div class="form-group">
                        <label for="inputCodigo" class="control-label col-xs-4">Codigo</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="inputCodigo" value="">
                            </div>
                    </div>
                </form> 
            </div>    
        </div>
        
    </div><!-- /.container -->
   
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script src="js/jquery.bootstrap-touchspin.js"></script>

<script>
    $("input[name='cantidad']").TouchSpin({
      verticalbuttons: true,
      verticalupclass: 'glyphicon glyphicon-plus',
      verticaldownclass: 'glyphicon glyphicon-minus'
    });
</script>

<script type="text/javascript" class="init">

    $(document).ready(function() {           
            $.get('Categorias', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $select = $('#selectCategoria');                           // Locate HTML DOM element with ID "someselect".
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
            $.get('AgregarProductos', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $select = $('#selectProductos');                           // Locate HTML DOM element with ID "someselect".
                    $select.find('option').remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                    $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
                        $('<option>').val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
                    });
            });
            $('#lista_cliente').DataTable();
            $('#lista_cantidad_producto').DataTable();
                
    } );
</script>

<jsp:include page='footer.jsp'/>
