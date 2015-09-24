<jsp:include page='header.jsp'/>  

    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <form class="form-signin" id="loginFRM" action="">
                  <h3 class="form-signin-heading">Ingresar</h3>

                  <label for="inputNicknameEmail" class="sr-only" >Email address</label>
                  <input type="text" id="inputNicknameEmail" name="inputNicknameEmail" class="form-control" placeholder="Nickname o email" required>
                 
                  <label for="inputPassword" class="sr-only">Contrase&nacute;a</label>
                  <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Contrase&nacute;a" required>
                  <br><br>
                  <div class="col-lg-8 col-lg-offset-3">  
                    <button class="btn" type="submit"Entrar>Entrar</button>
                    <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
                  </div>   
                </form>
            </div>    
        </div>    
    </div> <!-- /container -->

    
<jsp:include page='footer.jsp'/>