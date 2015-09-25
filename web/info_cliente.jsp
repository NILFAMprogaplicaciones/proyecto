<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<jsp:include page='header.jsp'/>                
<%@page import="Logica.*"%>  
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-9">

                <div class="row" id="clientes">  
                <% 
                    ManejadorUsuario MU=ManejadorUsuario.getinstance();
                    Iterator<Usuario> it = MU.getColeccionClientes().values().iterator();
                    Usuario u;
                %>
		
                <%while (it.hasNext()){
                u=it.next();%>	
                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="images/usuario.png" alt="">
                        <div class="caption">
                            <h4><a href="ver_cliente.jsp"> <%= u.getnickname() %> </a>
                            </h4>
                            <p>See more snippets like this online store item at.</p>
                        </div>
                    </div>
                </div>

                <% } %>
                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->
    
    
<jsp:include page='footer.jsp'/>