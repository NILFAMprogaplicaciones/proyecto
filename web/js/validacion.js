


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
    var categoria    = document.getElementById("selectCategoria").value;
    var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
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
        document.getElementById("restauranteFRM").submit();
    } // endif                                
} // end function


function CheckCliente(){
   
  // var boolean = true;
    //if (boolean == true) {
        windows.alert("El nickname ya esta tomado");
    //}
   // else{
   //     document.getElementById("clienteFRM").submit();
  //  }
                         
} 

function CheckCategoria() {
    // Validar formulario de datos de ingreso
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var nombre     = document.getElementById("inputNombre").value;
     
    if (nombre=="") {
        error   = true;
        mensaje = mensaje + "Nombre\n";
    } // endif
    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("categoriaFRM").submit();
    } // endif                                
} // end function

function CheckProducto() {
    // Validar formulario de datos de ingreso
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var nombre     = document.getElementById("inputNombre").value;
    var resto      = document.getElementById("selectRestaurante").value;
    var desc       = document.getElementById("inputDescripcion").value;
    var precio     = document.getElementById("inputPrecio").value;

    if (nombre=="") {
        error   = true;
        mensaje = mensaje + "Nombre\n";
    } // endif
    if (resto=="") {
        error   = true;
        mensaje = mensaje + "Restaurante\n";
    } // endif
    if (desc=="") {
        error   = true;
        mensaje = mensaje + "Descripcion\n";
    } // endif
    if (precio=="") {
        error   = true;
        mensaje = mensaje + "Precio\n";
    } // endif
    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("productoFRM").submit();
    } // endif                                
} // end function
