function CheckRestaurante() {
    // Validar formulario de datos de ingreso
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var nickname     = document.getElementById("inputNickname").value;
    var email        = document.getElementById("inputEmail").value;
    var nombre       = document.getElementById("inputNombre").value;
    var direccion    = document.getElementById("inputDireccion").value;
    var contrasena   = document.getElementById("inputContrasena").value;
    var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var categoria    = document.getElementById("inputCategoria").value;
    
    // validar datos
    if (nickname=="") {
        error   = true;
        mensaje = mensaje + "Nickname\n";
    } // endif
    if (email=="") {
        error   = true;
        mensaje = mensaje + "Email\n";
    } // endif
    else if (!expr.test(email)) {
        error   = true;
        mensaje = mensaje + "Formato de email no válido\n";
    } // endif
    if (nombre=="") {
        error   = true;
        mensaje = mensaje + "Nombre\n";
    } // endif
    if (direccion=="") {
        error   = true;
        mensaje = mensaje + "Dirección\n";
    } // endif
    if (contrasena=="") {
        error   = true;
        mensaje = mensaje + "Contraseña\n";
    } // endif
    if (categoria==0) {
        error   = true;
        mensaje = mensaje + "Categoria\n";
    } // endif

    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("restaurantFRM").submit();
    } // endif                                
} // end function


function CheckCliente() {
    // Validar formulario de datos de ingreso
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var nickname     = document.getElementById("inputNickname").value;
    var email        = document.getElementById("inputEmail").value;
    var nombre       = document.getElementById("inputNombre").value;
    var direccion    = document.getElementById("inputDireccion").value;
    var contrasena   = document.getElementById("inputContrasena").value;
    var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var apellido     = document.getElementById("inputApellido").value;
    var fecha_nacimiento = document.getElementById("inputFecha_nacimiento").value;
    var contrasena   = document.getElementById("inputContrasena").value;
      
    // validar datos
    if (nickname=="") {
        error   = true;
        mensaje = mensaje + "Nickname\n";
    } // endif
    if (direccion=="") {
        error   = true;
        mensaje = mensaje + "Dirección\n";
    } // endif
    if (email=="") {
        error   = true;
        mensaje = mensaje + "Email\n";
    } // endif
    else if (!expr.test(email)) {
        error   = true;
        mensaje = mensaje + "Formato de email no válido\n";
    } // endif
    if (nombre=="") {
        error   = true;
        mensaje = mensaje + "Nombre\n";
    } // endif
    if (contrasena=="") {
        error   = true;
        mensaje = mensaje + "Contraseña\n";
    } // endif
    if (apellido=="") {
        error   = true;
        mensaje = mensaje + "Apellido\n";
    } // endif
    if (fecha_nacimiento=="") {
        error   = true;
        mensaje = mensaje + "Fecha Nacimiento\n";
    } // endif

    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("clienteFRM").submit();
    } // endif                                
} // end function


