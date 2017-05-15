<%@page import="Modelo.Solicitante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>CambiarClave</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            a.botonMenu:hover, #enlace4{
                color: white;
                background-color: black;                 
                font-size: 37px;    
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
            }     
            h1{
                text-align: left;
                color: white;                                 
                font-size: 37px;    
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
            }
            input{
                width: 50%;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                font-size: 32px;
                background-color: white;

            }
            #botonCambiar{
                text-align: center;
            }
            .p1{
                text-align: left;
                color: white;                                 
                font-size: 37px;    
                font-family: fantasy;
            }

        </style>

    </head>
    <body>
        <header>
            <!--Encabezado-->
            <div class="col-sm-2" id="header1">
                <a href="Home.jsp"><img src="Imagenes/escudo.png" alt="NotFound" id="escudo"></a>                
            </div>
            <div class="col-sm-10" id="header2">
                <div id="mainTitle"><p id="titulo">BIBLIOTECA COLEGIO ANTONIO NARIÑO</p></div>
            </div>
        </header>
        <br>
        <!--Menu-->
        <div class="col-sm-2" id="menu">
            <a href="Home.jsp" class="botonMenu col-sm-12" id="enlace0">Inicio</a>
            <a href="PrincipalInventario.jsp" class="botonMenu col-sm-12" id="enlace1">Elementos Biblioteca</a>            
            <a href="Estado" class="botonMenu col-sm-12" id="enlace2">Mi Estado</a>
            <a href="Historial" class="botonMenu col-sm-12" id="enlace3">Historial Prestamos</a>
            <a href="CambiarClave.jsp" class="botonMenu col-sm-12" id="enlace4">Cambiar Clave</a>            
        </div>

        <!--Contenido-->
        <div class="col-sm-10" id="content">

            <h1 style="text-align: center" id="tituloClave">Cambiar Clave</h1>
            <br>
            <br>
            <br>            
            <form method="POST" action="CambiarClave">
                <p class="p1">Digite su clave actual</p>
                <input type="text" name="ClaveAntigua" placeholder="Clave Actual...">
                <br>
                <br>
                <br>
                <p class="p1">Digite su nueva clave</p>
                <input type="text" name="ClaveNueva" placeholder="Nueva Clave...">
                <br>
                <br>
                <br>
                <div id="botonCambiar"><input name="Enviar" type="submit" class="enviar" value="CAMBIAR"></div>
            </form>

            <%
                if (request.getAttribute("CambioClave") != null) {
                    boolean b = (Boolean) request.getAttribute("CambioClave");
                    if (b == true) {


            %>
            <p>Clave cambiada satisfactoriamente</p>
            <%            } else {


            %>
            <p>Clave cambiada satisfactoriamente</p>
            <%                    }
                }
            %>
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