<%@page import="Logica.Categoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorCategoria"%>
<%@page import="Logica.ManejadorUsuario"%>
<jsp:include page='header.jsp'/>                
    
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form method="POST" action="Categorias" class="form-horizontal" id="categoriaFRM" onsubmit="return validarcategoria()">
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre" required>
                            </div>
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="submit" class="btn" value="Enviar" /> <!--onclick="CheckCategoria();" -->
                        <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
   
<script type="text/javascript">
        
    function validarcategoria(){
        var array = [];
        <%
            ManejadorCategoria MC=ManejadorCategoria.getinstance();
            Iterator<Categoria> it = MC.coleccion().values().iterator();
            Categoria c=null;
        %>
    
        <%
            while (it.hasNext()){
            c=it.next();
        %>
                array.push("<%= c.getnombre()%>");
        <%
            }
        %>
        var posicion = 0;
        var elemento = document.getElementById("inputNombre").value;
        if(array[0]==null){
            window.alert("Categoria Agregada");
            document.getElementById("restauranteFRM").submit();//mando submit
        }else{   
             
                    while(posicion <= array.length){
                        if(array[posicion]==elemento){
                            window.alert("Imposible agregar Categoria");

                        }
                        else if(array[posicion]==null){
                            window.alert("Categoria Agregada");
                            document.getElementById("restauranteFRM").submit();
                            
                        }else{
                            ++posicion;
                        }
                        
                    }
            
        }
             
    }
</script>
<jsp:include page='footer.jsp'/>