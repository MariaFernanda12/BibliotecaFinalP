<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Elemento"%>
<%@page import="Controlador.CrearListar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Buscar</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#porEtiqueta").click(function () {
                    $("#ingreseBuscarEt,#FormPost,#botonEnviar1").show();
                    $("#ingreseBuscarNom,#FormGet,#botonEnviar2, #tablaBusqueda").hide();
                });
                $("#porNombre").click(function () {
                    $("#ingreseBuscarNom,#FormGet,#botonEnviar2").show();
                    $("#ingreseBuscarEt,#FormPost,#botonEnviar1, #tablaBusqueda").hide();
                });
            });
        </script>
        <style>
            input{
                width: 100%;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                font-size: 32px;
                background-color: white;

            }

            p {
                color: white;
                font-size:30px;
                font-family: "Futura Md BT", serif;
                font-weight: bold;

            }
            #botonEnviar1, #botonEnviar2{
                text-align: center
            }
            table{
                text-align: center;
                color: black;
                font-family: "Futura Md BT", serif;
                font-size: 22px;
                border-color: black;
                background-color: white;
            }
            #contentTable{
                text-align: center;
            }
            th, td {
                text-align: center;
            }
            .col-sm-6{
                text-align: center;
                align-content: center;
            }
            a{
                -webkit-appearance: button;
                -moz-appearance: button;
                appearance: button;
                background-color: #039d4f;
                text-align: center;
                color: white;
                font-size: 37px;
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
            }
            a:hover, #c, #enlace1{
                background-color: black;
                text-decoration: none;
                text-align: center;
                color: white;
                font-size: 37px;
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
                cursor: pointer;
            }

            #ingreseBuscarEt, #ingreseBuscarNom, #FormGet, #FormPost, #botonEnviar1, #botonEnviar2{
                display: none;
            }
            #porEtiqueta, #porNombre{
                height: 100px;
                width: 200px;
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

            <ul>
                <li><a href="CrearListar" id="a">Lista de Elementos</a></li>
                <li><a href="ListarPorArea.jsp" id="b">Lista por Area</a></li>
                <li><a href="BuscarElemento.jsp" id="c">Busqueda</a></li>

            </ul>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="col-sm-6">

                <a  id="porEtiqueta">Buscar por Etiqueta</a>
            </div>
            <div class="col-sm-6">
                <a  id="porNombre">Buscar por Nombre</a>
            </div>
            <br>
            <br>
            <br>
            <p id="ingreseBuscarEt">Ingrese el número de etiqueta que desea buscar:</p>
            <form method="POST" action="BuscarElemento" id="FormPost">
                <input type="text" name="Buscar" placeholder="Etiqueta..">
                <br>
                <br>
                <br>
                <div id="botonEnviar1"><input name="Enviar" type="submit" class="enviar" value="BUSCAR"></div>
            </form>
            <p id="ingreseBuscarNom">Ingrese el nombre que desea buscar:</p>
            <form method="GET" action="BuscarElemento" id="FormGet">
                <input type="text" name="Buscar" placeholder="Nombre..">
                <br>
                <br>
                <br>
                <div id="botonEnviar2"><input name="Enviar" type="submit" class="enviar" value="BUSCAR"></div>
            </form>


            <%  if (request.getAttribute("etiqueta") != null) {
                    Elemento elm = (Elemento) request.getAttribute("etiqueta");
            %>
            <br>
            <br>
            <br>
            <table id="tablaBusqueda" border="2">
                <tr>
                    <th>Etiqueta</th>
                    <th style="width:700px">Nombre</th>
                    <th>Cantidad Disponible</th>
                    <th>Estado</th>
                    <th>Ubicacion</th>
                    <th>Area</th>

                </tr>
                <tr>
                    <td> <%=elm.getEtiqueta()%> </td>
                    <td style="width:700px ;height: auto" ><%=elm.getNombre()%></td>
                    <td> <%=elm.getCantidadDisponible()%></td>
                    <td><%=elm.getEstado()%></td>
                    <td> <%=elm.getUbicacion()%> </td>
                    <td> <%=elm.getArea()%></td>
                </tr>

                <%

                    } else {

                    }
                %>

            </table>

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