function CheckRestaurante() {
    // Validar formulario de datos de ingreso
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var nombre       = document.getElementById("inputEmail").value;
    var nickname     = document.getElementById("inputNickname").value;
    var direccion    = document.getElementById("inputDireccion").value;
    var email        = document.getElementById("inputEmail").value;
    
    // validar datos
    if (nombre=="") {
        error   = true;
        mensaje = mensaje + "Nombre:\n";
    } // endif
    if (nickname=="") {
        error   = true;
        mensaje = mensaje + "Nickname:\n";
    } // endif
    if (direccion=="") {
        error   = true;
        mensaje = mensaje + "Direcci&oacute;n\n";
    } // endif
    if (email=="") {
        error   = true;
        mensaje = mensaje + "Email\n";
    } // endif
    
    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("restaurantFRM").submit();
    } // endif                                
} // end function


