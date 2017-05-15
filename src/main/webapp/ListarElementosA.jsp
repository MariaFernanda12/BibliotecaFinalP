
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Elemento"%>
<%@page import="Controlador.CrearListar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Elemntos</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/Libros.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/Style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>   
            #b{
                background-color: black;
            }
            #tituloInventario{
                text-align: center;
                color: white;
                font-size:52px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;
                text-shadow: -2px -2px 3px #000, 2px 2px 3px #000, -2px 2px 3px #000, 2px -2px 3px #000;

            }
            th, td {
                text-align: center;
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

            #global {
                height: 80%;
                width: 100%;
                border: 1px solid #03a933;
                padding-left: 0.5em;
                background-color: #03a933;               
                overflow-y: scroll;
                text-align: center;
            }
            a.botonMenu:hover, #enlace1, #b{
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
            <div id="global">
                <div class="col-sm-11">
                    <h1 id="tituloInventario">Inventario</h1>
                    <div id="contentTable">
                        <table border="2">
                            <tr>
                                <th>Etiqueta</th>                                               
                                <th style="width:700px">Nombre</th>                    
                                <th>Cantidad Disponible</th>                                    
                                <th>Estado</th> 
                                <th>Ubicacion</th>
                                <th>Area</th>

                            </tr>
                            <%  if (request.getAttribute("elementos") != null) {
                                    ArrayList<Elemento> elm = (ArrayList<Elemento>) request.getAttribute("elementos");
                                    for (Elemento elemento : elm) {
                            %>            
                            <tr>    
                                <td> <%=elemento.getEtiqueta()%> </td>
                                <td style="width:700px ;height: auto" ><%=elemento.getNombre()%></td>
                                <td> <%=elemento.getCantidadDisponible()%></td>                
                                <td><%=elemento.getEstado()%></td> 
                                <td> <%=elemento.getUbicacion()%> </td>                
                                <td> <%=elemento.getArea()%></td>                    
                            </tr>

                            <%
                                    }
                                }
                            %>

                        </table>
                    </div>
                </div>
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