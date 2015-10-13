<jsp:include page='header.jsp'/>                
 
<!-- Page Content -->
    <div class="container">
        <div class="row">
                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="images/inicio2.png" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/inicio.png" alt="">
                                </div>
                                
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                   
            <br>
        </div>
    </div>
    <!-- /.container -->
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" class="init">
    $(document).ready(function() {
        $.get('CargaDeDatos', function() {
            // Write here some callback function if necessary.
        });
    });
</script>    
<jsp:include page='footer.jsp'/>