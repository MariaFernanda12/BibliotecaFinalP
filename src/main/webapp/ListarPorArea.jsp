<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Listado</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .boton2{                
                -webkit-appearance: button;
                -moz-appearance: button;
                appearance: button;
                text-align: center;            
                color: white;
                font-size: 37px;    
                font-family: fantasy;        
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;                
                height: 100px;
                width: 300px;

            }
            #enlace8{
                background-color: blue;

            }
            #enlace9{
                background-color: red;

            }#enlace10{
                background-color: blueviolet;

            }
            #enlace11{
                background-color: bisque;

            }
            #enlace12{
                background-color: aqua;

            }
            #enlace13{
                background-color: chocolate;

            }
            #enlace14{
                background-color: coral;

            }
            #enlace15{
                background-color: yellow;

            }
            #enlace16{
                background-color: tomato;

            }
            #enlace17{
                background-color: sienna;

            }
            #enlace18{
                background-color: violet;

            }
            #enlace19{
                background-color: skyblue;

            }
            #enlace20{
                background-color: crimson;

            }
            #enlace21{
                background-color: slateblue;

            }
            #enlace22{
                background-color: teal;

            }
            #enlace23{
                background-color: darkgoldenrod;

            }
            #enlace24{
                background-color: threedface;

            }
            #enlace25{
                background-color: orchid;
                font-size: 34px;
            }
            #enlace26{
                background-color: purple;

            }
            #enlace27{
                background-color: mediumvioletred;

            }
            #enlace28{
                background-color: mediumvioletred;

            }
            #contentTable{
                text-align: center;
            }

            td{
                width: 200px;
                height: 100px;
            }
            #tituloListar{
                text-align: center;
                color: white;
                font-size:52px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;
                text-shadow: -2px -2px 3px #000, 2px 2px 3px #000, -2px 2px 3px #000, 2px -2px 3px #000;

            }
            #c{
                background-color: black; 
            }
            a.botonMenu:hover, #enlace1, #c{
                color: white;
                background-color: black;
                text-decoration:none; 
                font-size: 37px;    
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
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
            <br>
            <h1 id="tituloListar">Selecciona el area</h1>
            <br>            
            <!--Son 20 Areas -->
            <div id="contentTable">
                <form method="POST" action="ListarPorArea" name="seleccion">
                    <table style="width:100%">
                        <tr>
                            <td><input name="Enciclopedia" type="submit" class="boton2" id="enlace28" value="Enciclopedia"></td>
                            <td><input name="Diccionarios" type="submit" class="boton2" id="enlace8" value="Diccionarios"></td>
                            <td><input name="Espanol" type="submit" class="boton2" id="enlace9" value="Espa&ntilde;ol"></td>

                        </tr>
                        <tr>
                            <td><input name="Matematicas" type="submit" class="boton2" id="enlace10" value="Matematicas"></td>
                            <td><input name="Fisica" type="submit" class="boton2" id="enlace11" value="Fisica"></td>
                            <td><input name="Quimica" type="submit" class="boton2" id="enlace12" value="Quimica"></td>

                        </tr>
                        <tr>
                            <td><input name="Sociales" type="submit" class="boton2" id="enlace13" value="Sociales"></td>
                            <td><input name="Ingles" type="submit" class="boton2" id="enlace14" value="Ingles"></td>
                            <td><input name="Ciencias" type="submit" class="boton2" id="enlace15" value="Ciencias"></td>

                        </tr>
                        <tr>
                            <td><input name="Preescolar" type="submit" class="boton2" id="enlace16" value="Preescolar"></td>
                            <td><input name="Filosofia" type="submit" class="boton2" id="enlace17" value="Filosofia"></td>
                            <td><input name="Religion" type="submit" class="boton2" id="enlace18" value="Religion"></td>

                        </tr>
                        <tr>
                            <td><input name="Etica" type="submit" class="boton2" id="enlace19" value="Etica"></td>
                            <td><input name="Informatica" type="submit" class="boton2" id="enlace20" value="Informatica"></td>
                            <td><input name="Atlas" type="submit" class="boton2" id="enlace21" value="Atlas"></td>


                        </tr>
                        <tr>
                            <td><input name="Salud" type="submit" class="boton2" id="enlace22" value="Salud"></td>
                            <td><input name="Dibujo" type="submit" class="boton2" id="enlace23" value="Dibujo"></td>
                            <td><input name="Institucionales" type="submit" class="boton2" id="enlace24" value="Institucionales"></td>

                        </tr>
                        <tr>
                            <td><input name="Material Didactico" type="submit" class="boton2" id="enlace25" value="Material Didactico"></td>
                            <td><input name="Multimedia" type="submit" class="boton2" id="enlace26" value="Multimedia"></td>
                            <td><input name="Equipo" type="submit" class="boton2" id="enlace27" value="Equipo"></td>

                        </tr>
                    </table>                  
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