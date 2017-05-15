<%@page import="Modelo.Solicitante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenido</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            a.botonMenu:hover, #enlace0{
                color: white;
                background-color: black;                 
                font-size: 37px;    
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
            }

            h1{
                color: white;
                font-size:52px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;
                text-shadow: -2px -2px 3px #000, 2px 2px 3px #000, -2px 2px 3px #000, 2px -2px 3px #000;
            }
            .centrado{
                position: absolute;
                top: 40%; 
                left: 50%;
                transform: translate(-50%, -50%);
                border: 10px solid black;
                padding-left:  200px;
                padding-right: 200px;
                padding-top:  30px;
                padding-bottom: 50px;
                margin-top:  30px;
            }
            p{
                color: white;
                font-size:40px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;
            }
            .alert{                
                font-size:30px;
                text-align: center;
            }


        </style>

    </head>
    <body>
        <header>
            <!--Encabezado-->
            <div class="col-sm-2" id="header1">
                <img src="Imagenes/escudo.png" alt="NotFound" id="escudo">               
            </div>
            <div class="col-sm-10" id="header2">
                <div id="mainTitle"><p id="titulo">BIBLIOTECA COLEGIO ANTONIO NARIÑO</p></div>
            </div>
        </header>
        <br>
        <!--Contenido-->
        <div class="col-sm-12" id="content">           
            <h1 style="text-align: center">Bienvenido</h1>
            <div>
                <%
                    if (request.getAttribute("Failed") != null) {
                        String respuesta = (String) request.getAttribute("Failed");
                        if (respuesta.equals("NOK")) {

                %>
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                    <strong class="m1">Warning!&nbsp&nbsp&nbsp</strong>USUARIO Y/O CONTRASEÑA INCORRECTOS.
                </div>

                <%                }
                %>
                <%                }
                %>
            </div>
            <div class="centrado">
                <form method="POST" action="ValidarUsuario">
                    <div style="text-align: center"><p>Usuario:</p></div>
                    <input name="usuario" type="text" style="text-align: center; font-size: 30px">
                    <br>
                    <br>
                    <br>
                    <div style="text-align: center"><p>Contraseña:</p></div>
                    <input name="password" type="password" style="text-align: center; font-size: 30px">
                    <br>
                    <br>
                    <br>
                    <div style="text-align: center"><input name="ingresar" type="submit" class="enviar" value="INGRESAR"></div>
                </form>
            </div>

        </div>

        <footer>
            <!Footer Creadores>
            <div class="col-sm-12" id="footer">

            </div>        


        </footer>
    </body>
</html>
