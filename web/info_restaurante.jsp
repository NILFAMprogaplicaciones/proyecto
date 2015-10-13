<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.*"%>
<%@page import="java.util.Iterator"%>
<jsp:include page='header.jsp'/>                

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-3">               
                         
                <br>
                <p class="lead">Categoria</p>                               
                <div class="list-group" id="listaCategorias"> </div>
            </div>
            <div class="col-md-9">
                <br>
             <table id="lista_restaurantes" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Nickname</th>
                        <th>Direccion</th>
                        <th>Promedio</th>
                        <th class="col-md-1"></th>
                    </tr>
                </thead>

                <tbody>
                     <% 
                        Iterator<DataRestaurante> it = Auxiliar.getColeccionDataRestaurante().values().iterator();
                        DataRestaurante dr;
                   
                        if(request.getParameter("categoria")==null){
                            while (it.hasNext()){
                                dr=it.next();
                    %>   
                        <tr>
                            <td><%=dr.getnombre()%></td>
                            <td><%=dr.getnickname()%></td>
                            <td><%=dr.getdireccion()%></td>
                            <td>
                                <%
                                    int promedio = Auxiliar.getPromedio(dr.getnickname()), j=0;
                                    while(j<promedio){
                                %>
                                    <span class="glyphicon glyphicon-star"></span> 
                                <%
                                    j++;
                                    }
                                %>
                            </td>
                            <td>
                                <a href="ver_restaurante.jsp?nicknamerestaurante=<%=dr.getnickname()%>">
                                  <img src="images/Zoom In.png">  
                                </a>
                                <!--<%session.setAttribute("restaurante", dr.getnickname());%>-->
                            </td>
                        </tr>
                      <%    } 
                        }else {
                            while (it.hasNext()){
                                dr=it.next();
                                if (dr.ExisteCategoria(request.getParameter("categoria"))){
                      %>
                            <tr>
                                <td><%=dr.getnombre()%></td>
                                <td><%=dr.getnickname()%></td>
                                <td><%=dr.getdireccion()%></td>
                                <td>
                                <%
                                    int promedio = Auxiliar.getPromedio(dr.getnickname()), j=0;
                                    while(j<promedio){
                                %>
                                    <span class="glyphicon glyphicon-star"></span> 
                                <%
                                    j++;
                                    } 
                                %>
                            </td>
                                <td>
                                    <a href="ver_restaurante.jsp?nicknamerestaurante=<%=dr.getnickname()%>"> 
                                        <img src="images/Zoom In.png">
                                    </a>
                                    <!--<%session.setAttribute("restaurante", dr.getnickname());%>-->
                                </td>
                            </tr>
                    <% 
                            }
                        }
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
                    $('<a href="info_restaurante.jsp?categoria='+key+'" class="list-group-item">'+key+'</a>').appendTo($listaCategorias);

                });
            });
        $('#lista_restaurantes').DataTable();    
        });
</script> 
<jsp:include page='footer.jsp'/>
