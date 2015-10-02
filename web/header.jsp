<%@page import="Logica.Cliente"%>
<%@page import="Clientes.Login"%>
<%@page import="Logica.Usuario"%>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script src="js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/sweetalert.css">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Quick Order</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
    
    <link href="css/jquery.bootstrap-touchspin.css" rel="stylesheet"> 
    <link href="css/dataTables.bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Quick Order</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categoria <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="agregar_categoria.jsp">Agregar</a></li>
                            </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Restaurante <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="agregar_restaurante.jsp">Agregar</a></li>
                              <li><a href="info_restaurante.jsp">Informaci&oacute;n</a></li>
                            </ul>
                    </li>
    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cliente <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="agregar_cliente.jsp">Agregar</a></li>
                              <li><a href="info_cliente.jsp">Informaci&oacute;n</a></li>
                            </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Producto <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="agregar_producto.jsp">Agregar</a></li>
                              <li><a href="info_producto.jsp">Informaci&oacute;n</a></li>
                            </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pedido <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li><a href="generar_pedido.jsp">Generar</a></li>
                              <li><a href="actualizar_pedido.jsp">Actualizar</a></li>
                              <li><a href="#">Informaci&oacute;n</a></li>
                            </ul>
                    </li>                   
                    <%
                        Cliente cli;
                            cli = Login.getUsuarioLogueado(request);
                        if(cli != null) {
                    %>
                        <li class="dropdown">
                            
                            <a  href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <img src="images/avatar-1-small.jpg" class="circle-img" alt=""/> <%=cli.getnombre()%> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <a id="logout"class="btn" type="submit" onclick="logout()">

                                      <span class="username">Cerrar Sesion</span>
                                      <i class="clip-chevron-down"></i>
                                </a>  
                                <li> <a  href="ver_cliente.jsp?nickname=<%=cli.getnickname()%>">Ver Perfil</a> </li>
                            </ul>
                        </li> 
                <% }else{ %> 
                        <li class="dropdown">
                            <a href="login.jsp" class="btn">Iniciar Sesion</a>
                        </li> 
                    <%}%> 
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cargar Datos <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="carga_datos.jsp">CARGA</a>  </li>
                              <!--<li><a href="ver_individual.jsp">ver ind</a></li>
                              <li><a href="ver_promocion.jsp">ver pro</a></li>-->
                            </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<script type="text/javascript">               

    function logout() 
    {
        window.alert("Se cerro su Sesion");
        window.location="Logout";
    }
</script>
