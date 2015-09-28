<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="500.jsp" %>
<!doctype html>
<html>
   <head>
	  
	<title>Iniciar sesión :: gamebook</title>
    </head>
    <body>
       <jsp:include page='header.jsp'/>   

	<form class="formulario_centrar main" action="Login" ACTION="POST">
		<div class="error">
		<b>La combinación de correo electrónico/contraseña es incorrecta.</b>
			<p>
				Asegurese que la entró correctamente y en el si de que estas seguro
				de que sea correcta, entonces alguien hackeo tu cuenta.
				En ese caso usa el login <code>papli@papli.com</code>
				con contraseña <code>manda</code>.
			</p>
		</div>

		<div class="fila_input">
			<label for="error_login">Correo: </label>
			<input id="error_login" type="text" name="login"/>
		</div>

		<div class="fila_input">
			<label for="error_password">Contraseña:</label>
			<input id="error_password" type="password" name="password"/>
		</div>

		<div class="fila_input">
			<input class="con_margen" type="button"
				   value="Entrar" onclick="submit()"/>
		</div>
	</form>

	 <jsp:include page='footer.jsp'/>
</body>
</html>