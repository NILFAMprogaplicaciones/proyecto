<%@page import="Logica.Usuario"%>
<%@page import="Logica.Cliente"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorUsuario"%>
<jsp:include page='header.jsp'/>                

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form method="POST" action="AgregarCliente"class="form-horizontal" id="clienteFRM" >
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input name="inputNickname" type="text" class="form-control" id="inputNickname" placeholder="Nickname" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input name="inputEmail"type="text" class="form-control" id="inputEmail" placeholder="Email" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNombre" class="control-label col-xs-2">Nombre</label>
                            <div class="col-xs-10">
                                <input name="inputNombre"type="text" class="form-control" id="inputNombre" placeholder="Nombre" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDireccion" class="control-label col-xs-2">Direcci&oacute;n</label>
                            <div class="col-xs-10">
                                <input name="inputDireccion"type="text" class="form-control" id="inputDireccion" placeholder="Direcci&oacute;n" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputContrasena" class="control-label col-xs-2">Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input name="inputContrasena" type="password" class="form-control" id="inputContrasena" placeholder="Contrase&ntilde;a" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputApellido" class="control-label col-xs-2">Apellido</label>
                            <div class="col-xs-10">
                                <input name="inputApellido" type="text" class="form-control" id="inputApellido" placeholder="Apellido" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFecha_nacimiento" class="control-label col-xs-2">Fecha Nacimiento</label>
                            <div class="col-xs-10">
                                <input name="inputFecha_nacimiento"type="date" class="form-control" id="inputFecha_nacimiento" placeholder="Fecha Nacimiento" required>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inpuImagen" class="control-label col-xs-2">Imagen</label>
                            <div class="col-xs-10">
                                <input name="inpuImagen"type="file" id="exampleInputFile">
                            </div>    
                    </div>
                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="button" class="btn" value="Enviar" onclick="validarcliente();"/>
                        
                         <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
    <script type="text/javascript">
        
    function validarcliente(){
        
        var arrayClientes = [];
        var arrayCorreo = [];
        var posicion = 0;
        var elemento = document.getElementById("inputNickname").value;
        var correo = document.getElementById("inputEmail").value;
        //LLENO MI ARRAYCLIENTES CON LOS NOMBRES DE TODOS LOS CLIENTES DEL SISTEMA
        <%
            ManejadorUsuario MU=ManejadorUsuario.getinstance();
            Iterator<Usuario> it = MU.obtenercoleccion().values().iterator();
            Usuario objeto;
            while (it.hasNext()){
            objeto=it.next();
        %>
                arrayClientes.push("<%= objeto.getnickname()%>");
                arrayCorreo.push("<%= objeto.getcorreo()%>");
        <%
            }
        %>
        
        if(arrayClientes[0]==null){
            
            window.alert.("Cliente Agregado");
            document.getElementById("clienteFRM").submit();//mando submit
        }else{ 
            while(posicion <= arrayClientes.length){
                if(arrayClientes[posicion]==elemento || arrayCorreo[posicion]==correo){
                    if(arrayClientes[posicion]==elemento){
                        window.alert("Nickname ya tomado");
                        posicion = arrayClientes.length + 1;
                    }else{
                        window.alert("Correo ya tomado");
                        posicion = arrayClientes.length + 1;
                    }
                }
                else if(arrayClientes[posicion]==null){
                    window.alert("Cliente Agregado");
                    document.getElementById("clienteFRM").submit();

                }else{
                    ++posicion;
                }
            }
        }
    }
</script>
<jsp:include page='footer.jsp'/>