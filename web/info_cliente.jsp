<%@page import="Auxiliar.Auxiliar"%>
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
                    Iterator<DataCliente> it = Auxiliar.getColeccionDataCliente().values().iterator();
                    DataCliente dc;
                    
                %>
		
                <%
                    while (it.hasNext()){
                    dc=it.next();
                %>	
                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="<%=dc.getDireccionFoto()%>" alt="<%=dc.getnombre()%>">
                        <div class="caption">
                            <h4><a href="ver_cliente.jsp?nickname=<%= dc.getnickname() %>"> <%= dc.getnickname() %> </a>
                            </h4>
                            
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
    <!-- /.container -->
    
    
<jsp:include page='footer.jsp'/>