<%@page import="Logica.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorUsuario"%>
<jsp:include page='header.jsp'/>            

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form method="POST" action="AgregarRestaurante" class="form-horizontal" id="restauranteFRM">
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input onblur="verificarnick()" type="text" class="form-control" id="inputNickname" name="inputNickname" placeholder="Nickname" required>
                                <h4  id="comprobarnick"> </h4>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input onblur="verificarcorreo()" type="text" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email" required>
                                <h4  id="comprobarcorreo"> </h4>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputDireccion" name="inputDireccion" placeholder="Direcci&oacute;n" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputContrasena" class="control-label col-xs-2">Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input type="password" class="form-control" id="inputContrasena" name="inputContrasena" placeholder="Contrase&ntilde;a" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCategoria" class="control-label col-xs-2">Categoria</label>
                        <div class="col-xs-10 selectContainer">
                            <select name="selectCategoria" id="selectCategoria" class="form-control" onclick="listarCategorias();" required>
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
                        <input type="button" class="btn" value="Enviar" onclick="validarrestaurante();"/>
                        <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<script src="http://code.jquery.com/jquery-latest.js"></script>     
<script type="text/javascript">
    function verificarnick(){
         
        var arrayCli = [];
        var pos = 0;
        var nick = document.getElementById("inputNickname").value;

        <%
            ManejadorUsuario mu=ManejadorUsuario.getinstance();
            Iterator<Usuario> ite = mu.obtenercoleccion().values().iterator();
            Usuario ob;
            while (ite.hasNext()){
            ob=ite.next();
        %>
                arrayCli.push("<%= ob.getnickname()%>");
        <%
            }
        %>
            while(pos <= arrayCli.length){
                if(arrayCli[pos]==nick){
                    document.getElementById("comprobarnick").innerHTML = '<img src="images/Delete.png" class="circle-img" alt=""/> Nickname ya tomado'; 
                    pos = arrayCli.length + 1;
                }else if(arrayCli[pos]==null){
                    document.getElementById("comprobarnick").innerHTML = '<img src="images/Apply.png" class="circle-img" alt=""/> Nickname correcto'; 
                    pos = arrayCli.length + 1;
                }else{
                    ++pos;
                }   
        }
         
      }  
      function verificarcorreo(){
          
          var arrayCorreo = [];
          var posicion = 0;
          var correo = document.getElementById("inputEmail").value;
          
          <%
            ManejadorUsuario M=ManejadorUsuario.getinstance();
            Iterator<Usuario> iter = M.obtenercoleccion().values().iterator();
            Usuario elemento;
            while (iter.hasNext()){
            elemento=iter.next();
        %>
                arrayCorreo.push("<%= elemento.getcorreo()%>");
        <%
            }
        %>
            while(posicion <= arrayCorreo.length){
                if(arrayCorreo[posicion]==correo){
                    document.getElementById("comprobarcorreo").innerHTML = '<img src="images/Delete.png" class="circle-img" alt=""/> Email ya tomado'; 
                    posicion = arrayCorreo.length + 1;
                }
                else if(arrayCorreo[posicion]==null){
                    document.getElementById("comprobarcorreo").innerHTML = '<img src="images/Apply.png" class="circle-img" alt=""/> Email correcto'; 
                    posicion = arrayCorreo.length + 1;

                }else{
                    ++posicion;
                }
            }
      }    
    function validarrestaurante(){
        
        var arrayNick = [];
        var arrayCorreo = [];
        var posicion = 0;
        var nick = document.getElementById("inputNickname").value;
        var correo = document.getElementById("inputEmail").value;
        //LLENO MI ARRAYCLIENTES CON LOS NOMBRES DE TODOS LOS CLIENTES DEL SISTEMA
        <%
            ManejadorUsuario MU=ManejadorUsuario.getinstance();
            Iterator<Usuario> it = MU.obtenercoleccion().values().iterator();
            Usuario objeto;
            while (it.hasNext()){
            objeto=it.next();
        %>
                arrayNick.push("<%= objeto.getnickname()%>");
                arrayCorreo.push("<%= objeto.getcorreo()%>");
        <%
            }
        %>
        
        if(arrayNick[0]==null){
            
            window.alert("Restaurante Agregado");
            document.getElementById("restauranteFRM").submit();//mando submit
        }else{ 
            while(posicion <= arrayNick.length){
                if(arrayNick[posicion]==nick || arrayCorreo[posicion]==correo){
                    if(arrayNick[posicion]==nick){
                        window.alert("Nickname ya tomado");
                        posicion = arrayNick.length + 1;
                    }else{
                        window.alert("Correo ya tomado");
                        posicion = arrayNick.length + 1;
                    }
                }
                else if(arrayNick[posicion]==null){
                    window.alert("Restaurante Agregado");
                    document.getElementById("restauranteFRM").submit();

                }else{
                    ++posicion;
                }
            }
        }
    }
</script>
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
