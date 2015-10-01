<%@page import="Logica.Producto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="Logica.ManejadorProducto"%>
<jsp:include page='header.jsp'/>                
<%
    ManejadorProducto MP=ManejadorProducto.getinstance();
    Iterator<Producto> it = MP.getColeccion().values().iterator();
    Producto p;
    
%>  
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">

            <table id="lista_productos" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Restaurante</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        while (it.hasNext()){
                        p=it.next();
                    %>
                            <tr>
                                <%
                                    if (p.getClass().getSimpleName().equals("Individual")){
                                %>
                                    <td>
                                        <a href="ver_individual.jsp?producto=<%=p.getnombre()%>"> <%=p.getnombre()%></a>
                                    </td>                                     
                                <%
                                    }else{
                                %>
                                    <td>
                                        <a href="ver_promocion.jsp?producto=<%=p.getnombre()%>"> <%=p.getnombre()%></a>
                                    </td>
                                <%
                                    }
                                %>
                                <td><%=p.getRestaurante().getnickname()%></td>
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
 
<jsp:include page='footer.jsp'/>
