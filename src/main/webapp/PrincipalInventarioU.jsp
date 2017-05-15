<%@page import="Modelo.Solicitante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Inventario</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>          
            a.botonMenu:hover, #enlace1{
                color: white;
                background-color: black;
                text-decoration:none; 
                font-size: 37px;    
                font-family: fantasy;
                text-shadow: -2px -2px 1px #000, 2px 2px 1px #000, -2px 2px 1px #000, 2px -2px 1px #000;
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
        </div>

        <%if (request.getAttribute("Exito2") != null) {
                Solicitante sol = (Solicitante) request.getAttribute("Exito");
        %>
        <form action="ListarPrestamos">
            <h1>Bienvenido <%=sol.getTipo()%> , <%=sol.getNombre()%> </h1>
            <%
                    request.setAttribute("Exito2", sol);
                }
            %>
        </form>
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