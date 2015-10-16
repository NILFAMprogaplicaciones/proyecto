<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.Producto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="Logica.ManejadorProducto"%>
<jsp:include page='header.jsp'/>       

<%
    Iterator<Producto> it = Auxiliar.getColeccionesSistema("productos").values().iterator();
    Producto p;
%>  
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">

            <table id="lista_productos" class="table table-hover" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Restaurante</th>
                        <th class="col-md-1"></th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        while (it.hasNext()){
                        p=it.next();
                    %>
                            <tr>
                                <td>
                                    <div class="media">
                                        <a class="pull-left"> <img class="media-object" src="<%= p.getDireccionFoto()%>" style="width: 72px; height: 72px;"> </a>
                                            <div class="media-body">
                                                <h4 class="media-heading"><%=p.getnombre()%></h4>       
                                            </div>
                                    </div>
                                </td>
                                <td><%=p.getRestaurante().getnombre()%></td>
                                <td>
                                <%
                                    if (p.getClass().getSimpleName().equals("Individual")){
                                %>
                                        <a href="ver_individual.jsp?producto=<%=p.getnombre()%>">
                                            <img src="images/Zoom In.png">
                                        </a>                                        
                                <%
                                    }else{
                                %>
                                    <a href="ver_promocion.jsp?producto=<%=p.getnombre()%>">
                                        <img src="images/Zoom In.png">
                                    </a>
                                
                                <%
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

    </div>
    <!-- /.container -->
 
 <script src="http://code.jquery.com/jquery-latest.js"></script> 
 <script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#lista_productos').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
 
            }  
            });
                
    } );
</script>
<jsp:include page='footer.jsp'/>
