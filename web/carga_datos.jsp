
<!DOCTYPE html>
<html>
    <body>
        <form method="GET" action="CargaDeDatos" class="form-horizontal" id="clienteFRM" onsubmit="return DatosAgregados()">
                    
            <div class="col-lg-8 col-lg-offset-4">
                <input type="submit" class="btn" value="Enviar"/>
                <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
            </div>
<script type="text/javascript">
    function DatosAgregados(){
        window.alert("Datos Cargados Correctamente");
    }
    
    
</script>
  
        </form>
    </body>
</html>


