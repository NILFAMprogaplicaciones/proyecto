<%@page import="Logica.*"%>
<%@page import="java.util.Iterator"%>
<jsp:include page='header.jsp'/>                

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-3">               
                  
                <p class="lead">Categoria</p>                               
                <div class="list-group" id="listaCategorias"> </div>
            </div>
            <div class="col-md-9">
                
             <table id="lista_restaurantes" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Direccion</th>
                    </tr>
                </thead>

                <tbody>
                    <% 
                        ManejadorUsuario MU=ManejadorUsuario.getinstance();
                        Iterator<Usuario> it = MU.getColeccionRestaurante().values().iterator();
                        Usuario u;
                    %>
                    <%
                        while (it.hasNext()){
                        u=it.next();
                    %>
                            <tr>
                                <td>
                                    <a href="ver_restaurante.jsp?nicknamerestaurante=<%=u.getnickname()%>"> <%=u.getnickname()%></a>
                                </td>
                                <td><%=u.getdireccion()%></td>
                            </tr>
                    <% 
                        }
                    %>
                </tbody>
             </table>  
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
    $('#lista_restaurantes').DataTable();    
    });
</script> 
<jsp:include page='footer.jsp'/>
