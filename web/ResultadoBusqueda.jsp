<%@page import="Auxiliar.Auxiliar"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Restaurantes.Busqueda"%>
<%@page import="Logica.Restaurante"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page='header.jsp'/> 

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">               
             <table id="lista_resultados" class="table table-hover" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Calificacion</th>
                    </tr>
                </thead>

                <tbody>
                    <% 
                        String filtro = request.getParameter("filtro");
                        List Restaurantes=Busqueda.Buscar(filtro);
                        Iterator iterator = Restaurantes.iterator();
                            while(iterator.hasNext()){                      
                                Restaurante res=(Restaurante)iterator.next();   
                    %>                   
                    <tr>
                        <td>
                            <div class="media">
                                    <a class="pull-left"> <img class="media-object" src="images/restaurante.png" style="width: 72px; height: 72px;"> </a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="ver_restaurante.jsp?nicknamerestaurante=<%=res.getnickname()%>"> <%=res.getnombre()%></a></h4>
                                        <p>Promedio: <%=Auxiliar.getPromedio(res.getnickname()) %> </p>                                          
                                    </div>
                            </div>                                                  
                        </td>
                        <td>
                            <%
                                    int promedio = Auxiliar.getPromedio(res.getnickname()), j=0;
                                    while(j<promedio){
                            %>
                                    <span class="glyphicon glyphicon-star"></span> 
                            <%
                                    j++;
                                    }
                            %>
                        </td>
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

<script type="text/javascript">
    $(document).ready(function() {                                   // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
        $('#lista_resultados').DataTable({
            "aaSorting": [[ 1, "desc" ]],
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            });    
    });

</script>


<jsp:include page='footer.jsp'/>

