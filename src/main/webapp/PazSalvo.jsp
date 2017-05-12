<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ModeloPazSalvo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Paz-Salvo</title>                
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
            #enlace5{
                position: absolute;
                top: 500px;
            }
            input{
                width: 70%;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                font-size: 32px;
                background-color: white;               

            }
            #botonEnviar{
                text-align: center
            }
            #p1 {
                color: white;
                font-size:28px;   
                font-family: "Futura Md BT", serif;
                font-weight: bold;

            }
            #titulo, #titulo2{
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
            <h1 id="titulo2" style="text-align: center">Paz y Salvo</h1>
            <br>
            <p id="p1">A la fecha, los siguientes usuarios por sugerencia de la 
                biblioteca no se les debería generar paz y salvo dado que tienen prestamos activos:</p> 
            <div id="contentTable">
                <table border="2">
                    <tr>
                        <th style="width:400px">Nombre Solicitante</th>                                               
                        <th style="width:400px">Curso-Area</th>                    
                        <th style="width:700px">Elemento en Prestamo</th>                                    
                        <th style="width:400px">Estado</th> 


                    </tr>
                    <%  if (request.getAttribute("Paz") != null) {
                            ArrayList<ModeloPazSalvo> modelo = (ArrayList<ModeloPazSalvo>) request.getAttribute("Paz");
                            for (ModeloPazSalvo paz : modelo) {
                    %>            
                    <tr>    
                        <td><%=paz.getNobreSol()%></td>
                        <td><%=paz.getCursoArea()%></td>
                        <td><%=paz.getNobre()%></td>
                        <td><%=paz.getEstado()%></td>
                                          
                    </tr>

                    <%
                            }
                        }
                    %>

                </table>
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