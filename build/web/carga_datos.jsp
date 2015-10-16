<jsp:include page='header.jsp'/>  
<!DOCTYPE html>
<html>
    <body>
        <form method="GET" action="CargaDeDatos" class="form-horizontal" id="datoscargadosFRM" >
                    
            <div class="col-lg-8 col-lg-offset-4">
                <input type="button" class="btn" value="Cargar" onclick="DatosAgregados();"/>
                <a href="index.jsp"><input type="button" class="btn" value="Cancelar" /></a>
            </div>
            
<script type="text/javascript">
    
    function DatosAgregados(){
        
        window.alert("Datos Cargados Correctamente");
        document.getElementById("datoscargadosFRM").submit();//mando submit
    }
    
</script>
  
        </form>
    </body>
</html>
<jsp:include page='footer.jsp'/>

