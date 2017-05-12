<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Borrar</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>          
            #enlace1, #f {
                color: white;
                background-color: black;

            }

            input{
                width: 60%;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                font-size: 32px;
                background-color: white;               

            }

            #borrar {
                color: white;
                font-size:29px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;

            }
            #botonBorrar{
                text-align: center
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
            <ul>
                <li><a href="IngresoElemento.jsp" id="a">Ingresar</a></li>
                <li><a href="CrearListar" id="b">Listar</a></li>
                <li><a href="ListarPorArea.jsp" id="c">Listar por Area</a></li>
                <li><a href="BuscarElemento.jsp" id="d">Busqueda</a></li>
                <li><a href="Modificar.jsp" id="e">Modificar</a></li>
                <li><a href="Borrar.jsp" id="f">Borrar</a></li>
            </ul>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <%
                if (request.getAttribute("Borrar") != null) {
                    boolean respuesta = (Boolean) request.getAttribute("Borrar");
                    if (respuesta = true) {

            %>
            <h1>Elemento Borrado Correctamente</h1>
            <%        } else if (respuesta = false) {
            %>
            <h1>Problemas durante el borrado del elemento</h1>
            <%
                    }
                }
            %>
            <p id="borrar">Ingrese el número de etiqueta del elemento que desea borrar:</p>            
            <form method="POST" action="BorrarElemento">
                <input type="text" name="etiqueta" placeholder="Número de Etiqueta..">
                <br>
                <br>
                <br>
                <div id="botonBorrar"><input name="Borrar" type="submit" class="enviar" value="BORRAR"></div>
            </form>




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