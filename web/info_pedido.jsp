<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<jsp:include page='header.jsp'/>                
<%@page import="Logica.*"%>  
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">

                <div class="row">  
                    <table id="lista_pedidos" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Fecha</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                     </table>  
                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->
              
 <script src="http://code.jquery.com/jquery-latest.js"></script>
 <script type="text/javascript" class="init">
    $(document).ready(function() {
           $('#lista_pedidos').DataTable();               
    } );
</script>   
<jsp:include page='footer.jsp'/>