<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Logica.DataProductosPedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Cliente"%>
<%@page import="Clientes.Login"%>
<%@page import="Logica.Usuario"%>

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
    <link rel="stylesheet" type="text/css" href="css/sweetalert.css">
    
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
                <a class="navbar-brand" href="info_restaurante.jsp">Quick Order</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                
                <form class="form-search navbar-form navbar-left" method="get" action="Busqueda">
                    <div class="input-append">
                        <input type="text" class="form-control" name="filtro" placeholder="Buscar restaurante o comida">
                        <button type="submit" class="btn glyphicon glyphicon-search"></button>
                    </div>
                </form>
                <ul class="nav navbar-nav">           
                    <li class="dropdown">
                        <a href="info_producto.jsp" class="dropdown-toggle"  role="button" aria-haspopup="true" >Informacion Productos</a>
                            
                    </li>
                    <li class="dropdown">
                        <a href="info_restaurante.jsp" class="dropdown-toggle"  role="button" aria-haspopup="true" > Restaurantes</a>
                            
                    </li>
                </ul>    
                <ul class="nav navbar-nav navbar-right">
                    <%
                        Cliente cli;
                            cli = Login.getUsuarioLogueado(request);
                            
                        if(cli != null) {                          
                    %>                   
                        <li class="dropdown">
                            <a  href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" > <img src="<%=cli.getDireccionFoto()%>"style="width: 30px; height: 30px;" class="circle-img" alt=""/> <%=cli.getnombre()%> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                
                                <li class="username"> <a  href="ver_cliente.jsp?nickname=<%=cli.getnickname()%>">Ver Perfil</a> </li>
                                <a id="logout" class="btn"  type="submit" onclick="logout()">

                                    <span class="username">Cerrar Sesion</span>
                                    
                                </a>  
                            </ul>
                        </li> 
                        <li class="dropdown">
                            <a  href="#" class="dropdown-toggle glyphicon glyphicon-shopping-cart " data-toggle="dropdown" role="button" aria-haspopup="true" > </a>                          
                            <ul class="dropdown-menu">
                                <div style="overflow:auto; height:600px;width:471px" class="row col-sm-5">
                                    <div  class="col-sm-9 col-md-9 col-md-offset-1">
                                        <%
                                        List<DataProductosPedido> Carrito=(List<DataProductosPedido>)session.getAttribute("carrito");
                                        if(Carrito==null){
                                        %>
                                            <h4>Carrito Vacio</h4>
                                        <%}else{%>
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Producto</th>
                                                        <th>Cantidad</th>
                                                        <th class="text-center">Precio</th>
                                                        <th class="text-center">Total</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%                                                    
                                                        Iterator iterator = Carrito.iterator();
                                                        Double Total=Double.parseDouble("0");
                                                        while(iterator.hasNext()){ 
                                                            Double Precio=Double.parseDouble("0");
                                                            DataProductosPedido Producto=(DataProductosPedido)iterator.next();
                                                            Precio = Producto.getSubTotal() / Producto.getCantidad();
                                                            Total = Total + Producto.getSubTotal();
                                                    %>
                                                    <tr>
                                                        <td class="col-sm-8 col-md-2">
                                                        <div class="media">
                                                             <img class="thumbnail pull-left media-object" src="<%=Producto.getProducto().getDireccionFoto()%>" style="width: 72px; height: 72px;">
                                                            <div class="media-body">
                                                                <h4 class="media-heading"><%=Producto.getProducto().getnombre()%></h4>
                                                            </div>
                                                        </div>
                                                        </td>
                                                        <td class="col-sm-8 col-md-6" style="text-align: center"><%=Producto.getCantidad()%></td>
                                                        <td class="col-sm-1 col-md-1 text-center"><strong>$<%=Precio%></strong></td>
                                                        <td class="col-sm-1 col-md-1 text-center"><strong>$<%=Producto.getSubTotal()%></strong></td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <td><h3>Total</h3></td>
                                                        <td class="text-center"><h3>$<%=Total%></h3></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td>
                                                            <form method="get" action="Carrito" id="GenerarPedidoFRM">
                                                                <button type="submit" class="btn btn-success">
                                                                    Confirmar <span class="glyphicon glyphicon-play"></span>
                                                                </button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </tfoot>
                                            <%}%>
                                        </table>
                                    
                                    </div>
                                </div>
                            </ul>
                        </li>
                <% }else{ %> 
                        <li class="dropdown">
                            <a href="login.jsp" class="btn">Iniciar Sesion</a>
                        </li> 
                        <li class="dropdown">
                            <a href="agregar_cliente.jsp" class="btn">Registrarse</a>
                        </li> 
                    <%}%>
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
