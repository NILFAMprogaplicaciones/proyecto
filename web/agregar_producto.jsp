<%@page import="Logica.Individual"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorProducto"%>
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
                            <select name="selectRestaurante" id="selectRestaurante"  class="form-control">
                                <option value="0">Seleccione Restaurante</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="radio">
                            <label>
                              <input type="radio" name="tipo_individual" id="individual" value="Individual" onclick="showIndividual()">
                              Individual
                            </label>
                            <label>
                              <input type="radio" name="tipo_promocion" id="promocion" value="Promocion" onclick="showPromocion()">
                              Promoci&oacute;n
                            </label>
                        </div>  
                    </div>
                    
                    <div id="divIndividual" style="display:none">
                        
                        <div class="form-group">
                            <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre" >
                                </div>
                        </div>
                        <div class="form-group">
                            <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                                <div class="col-xs-10">

                                    <input type="text" class="form-control" id="inputDescripcion" name="inputDescripcion" placeholder="Descripci&oacute;n" >
                                </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPrecio" class="control-label col-xs-2">Precio</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputPrecio" name="inputPrecio" placeholder="Precio" >
                                </div>
                        </div>
                    </div>
                    
                    <div id="divPromocion" style="display:none">
                        
                        <div class="form-group">
                            <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="inputNombre" name="inputNombrePromo" placeholder="Nombre" >
                                </div>
                        </div>
                        <div class="form-group">
                            <label for="inputDescripcion" class="control-label col-xs-2">Descripci&oacute;n</label>
                                <div class="col-xs-10">

                                    <input type="text" class="form-control" id="inputDescripcion" name="inputDescripcionPromo" placeholder="Descripci&oacute;n"  >
                                </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="inputDescuento" class="control-label col-xs-2">Descuento</label>
                                <div class="col-xs-10">
                                    <input type="text" name="inputDescuento" class="form-control" id="inputDescuento" placeholder="Descuento" >
                                </div>
                        </div>
                        <div class="checkbox">
                            <div class="form-group">
                              <label for="inputActiva" class="control-label col-xs-2">Activa</label>
                                <div class="col-xs-10">
                                    <input id="inputActiva" name="inputActiva" type="checkbox" value="Activa">
                                </div>    
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputProductos" class="control-label col-xs-2">Producto</label>
                            <div class="col-xs-10 selectContainer">
                                <select name="selectProductos" id="selectProductos" class="form-control" >
                                    <option value="0">Seleccione Producto</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputProductos" class="control-label col-xs-2">Cantidad</label>
                            <div class="col-xs-10">
                                <input id="cantidad" type="text" value="" name="cantidad" >
                            </div>
                        </div>  
                        
                        <div class="col-lg-8 col-lg-offset-4">
                            <input type="button" class="btn" value="Agregar Producto" onclick="agregarProducto();"/> 
                        </div> 

                        <table id="lista_productos_promocion" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Cantidad</th>
                                    <th>Total</th>
                                </tr>
                            </thead>

                           
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
    function agregarProducto() { 
        var arrayProducto = [];
        var arrayProductoPrecio = [];
        <%
            ManejadorProducto MP=ManejadorProducto.getinstance();
            Iterator<Individual> it = MP.getColeccionIndividual().values().iterator();
            Individual objeto;
            while (it.hasNext()){
                objeto=it.next();
                String precio=String.valueOf(objeto.getPrecio());
        %> 
                arrayProducto.push("<%=objeto.getnombre()%>");
                arrayProductoPrecio.push("<%=precio%>");
        <%
            }
        %>
        
        
        var producto = document.getElementById("selectProductos").value;
        var cantidad = document.getElementById("cantidad").value;
        var datosactuales = document.getElementById("lista_productos_promocion").innerHTML;
        
        for(var indice=0;indice<=arrayProducto.length; indice++){
            if(arrayProducto[indice]==producto){
                var total=cantidad*arrayProductoPrecio[indice];
            }
        }
        
        var datos = "<tbody><tr> <td>"+producto+"</td> <td>"+cantidad+"</td> <td>"+total+"</td> </tr>";
        document.getElementById("lista_productos_promocion").innerHTML = datosactuales + datos;
    }
</script>
<script>
    function showIndividual() { 
        document.getElementById('divIndividual').style.display = "block";
        document.getElementById('divPromocion').style.display = "none";
    }
</script>
<script>
    function showPromocion() { 
        document.getElementById('divIndividual').style.display = "none";
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
