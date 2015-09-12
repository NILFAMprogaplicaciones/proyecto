function CheckForm() {
    // Validar formulario de datos de ingreso
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var nombre      = document.getElementById("dataNOM").value;
    var direccion   = document.getElementById("dataDIR").value;
    var telefono    = document.getElementById("dataTEL").value;
    var departamento= document.getElementById("dataDTO").value;
    
    // validar datos
    if (nombre=="") {
        error   = true;
        mensaje = mensaje + "Nombre:\n";
    } // endif
    if (direccion=="") {
        error   = true;
        mensaje = mensaje + "Dirección:\n";
    } // endif
    if (telefono=="") {
        error   = true;
        mensaje = mensaje + "Teléfono: no puede quedar vacío\n";
    } // endif
    if (telefono=="+598") {
        error   = true;
        mensaje = mensaje + "Teléfono: especifíca sólo característica\n";
    } // endif
    if (isNaN(telefono)) {
        error   = true;
        mensaje = mensaje + "Teléfono: debe ser numérico\n";
    } // endif
    if (departamento=="0") {
        error   = true;
        mensaje = mensaje + "Departamento:\n";
    } // endif
    
    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("dataFRM").submit();
    } // endif                                
} // end function

function CheckID() {
    // Validar ID del formulario de datos
    
    // preparar mensaje y control de error
    var error   = false;
    var mensaje = "ATENCION!!!.. Ingrese:\n";
    
    // capturar datos del formulario
    var id  = document.getElementById("dataID").value;
    
    // validar datos
    if (id=="") {
        error   = true;
        mensaje = mensaje + "ID de Persona:\n";
    } // endif
    if (isNaN(id)) {
        error   = true;
        mensaje = mensaje + "ID debe ser numérico:\n";
    } // endif

    
    // controlar error
    if (error) {
        window.alert(mensaje);
    } else {
        document.getElementById("dataFRM").submit();
    } // endif                                
} // end function

