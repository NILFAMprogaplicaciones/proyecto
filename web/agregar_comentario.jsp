<jsp:include page='header.jsp'/>                

<!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-4">
                <form  method="POST" action="AgregarComentario" class="form-horizontal" id="comentarioFRM" >
                    
                    <input name="idpedido" type="hidden" class="form-control" id="inputDireccion" value="<%= request.getParameter("id_Pedido")%>" >
                                    
                    <h5><i>Ingrese comentario sobre el pedido</i></h5><br>
                    <div class="form-group">
                        <label for="inputComentario" class="control-label col-xs-2">Comentario</label>
                            <div class="col-xs-10">
                                <textarea rows="4" cols="50" id="inputComentario" name="inputComentario">

                                </textarea>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPuntaje" class="control-label col-xs-2"></label>
                            <div class="col-xs-10">
                                <label>
                                 <input type="radio" name="inputPuntaje" value="1">
                                1<span class="glyphicon glyphicon-star-empty"></span>
                                </label>&nbsp;&nbsp;&nbsp;
                                
                                <label>
                                 <input type="radio" name="inputPuntaje" value="2">
                                2<span class="glyphicon glyphicon-star-empty"></span>
                                </label>&nbsp;&nbsp;&nbsp;
                                
                                <label>
                                 <input type="radio" name="inputPuntaje" value="3">
                                3 <span class="glyphicon glyphicon-star-empty"></span>
                                </label>&nbsp;&nbsp;&nbsp;
                                
                                <label>
                                 <input type="radio" name="inputPuntaje" value="4">
                                4<span class="glyphicon glyphicon-star-empty"></span>
                                </label>&nbsp;&nbsp;&nbsp;
                                
                                <label>
                                 <input type="radio" name="inputPuntaje" value="5">
                                5<span class="glyphicon glyphicon-star-empty"></span>
                                </label>
                               
                            </div>
                    </div>

                    <div class="col-lg-8 col-lg-offset-4">
                        <input type="submit" class="btn" value="Guardar"/>
                        
                         <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                    </div>
                </form>
            </div>    
        </div>

    </div>
    <!-- /.container -->
    
<jsp:include page='footer.jsp'/>
