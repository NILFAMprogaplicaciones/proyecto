<%@page import="Auxiliar.Auxiliar"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Cliente"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.ManejadorUsuario"%>
<jsp:include page='header.jsp'/>                
<link href="css/datepicker.css" rel="stylesheet">
<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form enctype="multipart/form-data" method="POST" action="AgregarCliente"class="form-horizontal" id="clienteFRM" >
                    <div class="form-group">
                        <label for="inputNickname" class="control-label col-xs-2">Nickname</label>
                            <div class="col-xs-10">
                                <input  onblur="verificarnick()" name="inputNickname" type="text" class="form-control" id="inputNickname" placeholder="Nickname" required > 
                                <h4  id="comprobarnick"> </h4>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="control-label col-xs-2">Email</label>
                            <div class="col-xs-10">
                                <input onblur="verificarcorreo()" name="inputEmail"type="text" class="form-control" id="inputEmail" placeholder="Email" required>
                                <h4  id="comprobarcorreo"> </h4>
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
                        <label for="inputConfirmContrasena" class="control-label col-xs-2"> Confirmar Contrase&ntilde;a</label>
                            <div class="col-xs-10">
                                <input onblur="validarcontraseña()" name="inputConfirmContrasena" type="password" class="form-control" id="inputConfirmContrasena" placeholder="Confirmar Contrase&ntilde;a" required>
                                <h4  id="comprobarcontraseña"> </h4></div>
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
                                <input name="inputFecha_nacimiento"type="text" class="form-control" id="inputFecha_nacimiento" placeholder="Fecha Nacimiento" required>
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
      function verificarnick(){
         
        var arrayCli = [];
        var pos = 0;
        var nick = document.getElementById("inputNickname").value;

        <%
            
            
            Iterator<Usuario> ite = Auxiliar.getColeccionesSistema("usuarios").values().iterator();
            Usuario ob;
            while (ite.hasNext()){
            ob=ite.next();
            
        %>
                arrayCli.push("<%= ob.getnickname()%>");
        <%
            }
        %>
            if(nick==""){
                    document.getElementById("comprobarnick").innerHTML = '<div class="alert alert-warning"> <span class="glyphicon glyphicon-info-sign"></span> Nickname vacio</div>';
            }else{   
                while(pos <= arrayCli.length){

                    if(arrayCli[pos]==nick){
                        document.getElementById("comprobarnick").innerHTML = '<div class="alert alert-danger"> <span class="glyphicon glyphicon-remove-sign"></span> Nickname ya tomado</div>'; 
                        pos = arrayCli.length + 1;
                    }else if(arrayCli[pos]==null){
                        document.getElementById("comprobarnick").innerHTML = '<div class="alert alert-success"> <span class="glyphicon glyphicon-ok-sign"> </span> Nickname correcto</div> '; 
                        pos = arrayCli.length + 1;
                    }else{
                        ++pos;
                    }   
                }
            } 
    }  
    function verificarcorreo(){
          
        var arrayCorreo = [];
        var posicion = 0;
        var correo = document.getElementById("inputEmail").value;

        <%
            
            Iterator<Usuario> iter = Auxiliar.getColeccionesSistema("usuarios").values().iterator();
            Usuario elemento;
            while (iter.hasNext()){
            elemento=iter.next();
        %>
                arrayCorreo.push("<%= elemento.getcorreo()%>");
        <%
            }
        %>
            if(correo==""){
                document.getElementById("comprobarcorreo").innerHTML = '<div class="alert alert-warning"> <span class="glyphicon glyphicon-info-sign"></span> Email vacio</div>';
            }else{
                while(posicion <= arrayCorreo.length){
                    if(arrayCorreo[posicion]==correo){
                        document.getElementById("comprobarcorreo").innerHTML = '<div class="alert alert-danger"> <span class="glyphicon glyphicon-remove-sign"></span> Email ya tomado</div>'; 
                        posicion = arrayCorreo.length + 1;
                    }
                    else if(arrayCorreo[posicion]==null){
                        document.getElementById("comprobarcorreo").innerHTML = '<div class="alert alert-success"> <span class="glyphicon glyphicon-ok-sign"> </span> Email correcto</div>'; 
                        posicion = arrayCorreo.length + 1;

                    }else{
                        ++posicion;
                    }
                }
            }
    }
     
    function validarcontraseña(){
        var contraseña=document.getElementById("inputContrasena").value;
        var conficontraseña=document.getElementById("inputConfirmContrasena").value;
        if(contraseña==""||conficontraseña==""){
            document.getElementById("comprobarcontraseña").innerHTML = '<div class="alert alert-warning"> <span class="glyphicon glyphicon-info-sign"></span> Debe ingresar una contraseña</div> ';
        }else{
            if(contraseña!=conficontraseña){
                document.getElementById("comprobarcontraseña").innerHTML = '<div class="alert alert-danger"> <span class="glyphicon glyphicon-remove-sign"></span> Verifique la contraseña</div> ';
            }else{
                document.getElementById("comprobarcontraseña").innerHTML = '<div class="alert alert-success"> <span class="glyphicon glyphicon-ok-sign"> </span> Contraseña correcta</div> ';
            }
        }
    }
    function validarcliente(){
        
        var arrayClientes = [];
        var arrayCorreo = [];
        var posicion = 0;
        var elemento = document.getElementById("inputNickname").value;
        var correo = document.getElementById("inputEmail").value;
        var nombre = document.getElementById("inputNombre").value;
        var direccion = document.getElementById("inputDireccion").value;
        var contraseña=document.getElementById("inputContrasena").value;
        var conficontraseña=document.getElementById("inputConfirmContrasena").value;
        var apellido=document.getElementById("inputApellido").value;
        var fecha=document.getElementById("inputFecha_nacimiento").value;
        //LLENO MI ARRAYCLIENTES CON LOS NOMBRES DE TODOS LOS CLIENTES DEL SISTEMA
        <%
            
            Iterator<Usuario> it = Auxiliar.getColeccionesSistema("usuarios").values().iterator();
            Usuario objeto;
            while (it.hasNext()){
            objeto=it.next();
        %>
                arrayClientes.push("<%= objeto.getnickname()%>");
                arrayCorreo.push("<%= objeto.getcorreo()%>");
        <%
            }
        %>
        if(elemento==""){
            window.alert("Nickname incorrecto");
        }
        else if(correo==""){
            window.alert("Email incorrecto");
        }
        else if(nombre==""){
            window.alert("Nombre incorrecto");
        }
        else if(direccion==""){
            window.alert("Direcion incorrecta");
        }
        else if(contraseña==""){
            window.alert("Contraseña incorrecta");
        }
        else if(conficontraseña==""){
            window.alert("Contraseña incorrecta");
        }
        else if(apellido==""){
            window.alert("Apellido incorrecta");
        }
        else if(fecha==""){
            window.alert("Fecha incorrecta");
        }else{
            if(arrayClientes[0]==null){

                window.alert("Cliente Agregado");
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
    }
</script>
<script src="http://code.jquery.com/jquery-latest.js"></script>


<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#inputFecha_nacimiento').datepicker({
            format: 'dd/mm/yyyy'
        });    
    });     
</script>			
<jsp:include page='footer.jsp'/>
