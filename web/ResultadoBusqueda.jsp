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
                        <th>Correo</th>
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
                            <div class="col-sm-2 col-lg-2 col-md-2">
                                <div class="thumbnail" style="text-align: center">
                                    
                                    <div class="ratings">
                                    <p>Promedio: <%=Auxiliar.getPromedio(res.getnickname()) %> </p>
                                    </div>
                                        <h4><a href="ver_restaurante.jsp?nicknamerestaurante=<%=res.getnickname()%>"> <%=res.getnombre()%></a></h4>
                                    <img class="img-rounded" src="images/restaurante.png" alt="">                                    
                                </div>
                             </div>                           
                        </td>
                        <td><%=res.getcorreo()%></td>
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
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            });    
    });

</script>


<jsp:include page='footer.jsp'/>

