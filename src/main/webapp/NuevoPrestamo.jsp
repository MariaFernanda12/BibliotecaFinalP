<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>NuevoPrestamo</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>          
            a.botonMenu:hover, #enlace2{
                color: white;
                background-color: black;
                text-decoration:none; 
                font-size: 37px;    
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
            }
            h1{
                text-align: center;
                color: white;
                font-size:52px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;
                text-shadow: -2px -2px 3px #000, 2px 2px 3px #000, -2px 2px 3px #000, 2px -2px 3px #000;
            }
            .alert{                
                font-size:30px;
                text-align: center;
            }           

            input{
                width: 50%;            
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;

            }
            #boton{
                text-align: center;
            }
            #enlace5{
                position: absolute;
                top: 500px;
            }  



        </style>
    </head>
    <body>
        <header>
            <!--Encabezado-->
            <div class="col-sm-2" id="header1">
                <a href="index.jsp"><img src="Imagenes/escudo.png" alt="NotFound" id="escudo"></a>                
            </div>
            <div class="col-sm-10" id="header2">
                <div id="mainTitle"><p id="titulo">BIBLIOTECA COLEGIO ANTONIO NARIÑO</p></div>
            </div>
        </header>
        <br>
        <!--Menu-->
        <div class="col-sm-2" id="menu">
            <a href="index.jsp" class="botonMenu col-sm-12" id="enlace0">Inicio</a>
            <a href="PrincipalInventario.jsp" class="botonMenu col-sm-12" id="enlace1">Inventario</a>
            <a href="NuevoPrestamo.jsp" class="botonMenu col-sm-12" id="enlace2">Nuevo Prestamo</a>
            <a href="Devolucion.jsp" class="botonMenu col-sm-12" id="enlace3">Devolucion Prestamo</a>
            <a href="PazSalvo" class="botonMenu col-sm-12" id="enlace4">Paz y Salvo</a>
            <a href="ListarPrestamos" class="botonMenu col-sm-12" id="enlace5">Historial Prestamos</a>

        </div>

        <!--Contenido-->
        <div class="col-sm-10" id="content">
            <h1>NUEVO PRESTAMO</h1>
            <br>
            <br>                       
            <%
                if (request.getAttribute("Prestamo") != null) {
                    String respuesta = (String) request.getAttribute("Prestamo");
                    if (respuesta.equals("OK")) {

            %>
            <div class="alert alert-success">
                <strong>Success!&nbsp&nbsp&nbsp</strong>Prestamo Registrado.
            </div>
            <%        } else if (respuesta.equals("NOK")) {
            %>
            <div class="alert alert-warning">
                <strong class="m1">Warning!&nbsp&nbsp&nbsp</strong>Prestamo No Registrado.
            </div>
            <%
                    }
                }
            %>
            <div class="contenido">
                <form method="POST" action="NuevoPrestamo">

                    <p>Etiqueta del elemento:</p>                
                    <input name="etiqueta"  placeholder="Etiqueta...">
                    <br>
                    <br>
                    <br>
                    <p>Identificación Solicitante:</p>              
                    <input name="id"  placeholder="Número de identificación...">
                    <br>
                    <br>
                    <br>
                    <p>Fecha de devolucion: </p>
                    <input type="date" name="fecha">
                    <br>
                    <br>
                    <br>
                    <div id="boton"><input name="Prestar" type="submit" class="enviar" value="PRESTAR"></div>         
                </form>
            </div>
        </div>
        <br>
        <footer>
            <div class="col-sm-12" id="footer">
                <div style="text-align: center">
                    <p>Creado por Maria Fernanda Martinez y Mateo Ortiz Rojas</p>
                    <img id="logoSergio" src="Imagenes/sergio.png" alt="NotFound">
                </div>

            </div>   

        </footer>
    </body>
</html>
