<%@page import="Logica.*"%>
<%@page import="java.util.Iterator"%>
<jsp:include page='header.jsp'/>                

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-3">               
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Buscar restaurante o comida">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Buscar</button>
                      </span>
                    </div><!-- /input-group -->           
                <br>
                <p class="lead">Categoria</p>                               
                <div class="list-group" id="listaCategorias"> </div>
            </div>
            <div class="col-md-9">
                <div class="row" id="CuadriculaRestaurantes"> 
                
                    <% 
                        ManejadorUsuario MU=ManejadorUsuario.getinstance();
                        Iterator<Usuario> it = MU.getColeccionRestaurante().values().iterator();
                        Usuario u;
                    %>
                    
                    <%
                        while (it.hasNext()){
                        u=it.next();
                    %>
                    
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="images/usuario.png" alt="">
                                <div class="caption">
                                    <h4><a href="ver_restaurante.jsp"> <%=u.getnickname()%> </a>
                                    
                                    </h4>
                                </div>
                                <div class="ratings">
                                    <p class="pull-right">15 reviews</p>
                                        <p>
                                            <span class="glyphicon glyphicon-star">
                                            </span>
                                            <span class="glyphicon glyphicon-star">
                                            </span>
                                            <span class="glyphicon glyphicon-star">
                                            </span>
                                            <span class="glyphicon glyphicon-star"> 
                                            </span>
                                            <span class="glyphicon glyphicon-star">
                                            </span>
                                        </p>
                                </div>
                            </div>
                        </div>
                    
                    <% 
                        } 
                    %>
                
                </div>                   
                </div>
            </div>
        </div>
   <!--  </div> -->
    <!-- /.container -->

<script src="http://code.jquery.com/jquery-latest.js"></script> 

<script>
    $(document).ready(function() {                                   // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
    $.get('Categorias', function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $listaCategorias = $('#listaCategorias');                           // Locate HTML DOM element with ID "someselect".
            $.each(responseJson, function(key, value) {               // Iterate over the JSON object.                        
                $('<a href="#" class="list-group-item">'+key+'</a>').appendTo($listaCategorias);
                
            });
        });
    });
</script> 

<jsp:include page='footer.jsp'/>
