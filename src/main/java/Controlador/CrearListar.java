package Controlador;

import DAO.DaoElementos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Elemento;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

public class CrearListar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<Elemento> lista = null;
            //1. Crear instancia del DAO
            DaoElementos daoE = new DaoElementos();
            //Lista todos los elementos.
            lista = daoE.listarTodo();
            //2. Envio de los datos por el request.
            request.setAttribute("elementos", lista);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CrearListar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //1.Captura de datos del formulario
            String codigoPUC = request.getParameter("codigo");
            String etiqueta = request.getParameter("etiqueta");
            String nombre = request.getParameter("nombre");
            String cantidadDisponible = request.getParameter("cantidadDisponible");
            String valorU = request.getParameter("valorU");
            String estado = request.getParameter("estado");
            String ubicacion = request.getParameter("ubicacion");
            String propiedad = request.getParameter("propiedad");
            String responsable = request.getParameter("responsable");
            String area = request.getParameter("area");
            
            //3. Crear el DTO
            Elemento elm = new Elemento();
            elm.setCodPUC(Integer.parseInt(codigoPUC));
            elm.setEtiqueta(Integer.parseInt(etiqueta));
            elm.setNombre(nombre);
            elm.setCantidadDisponible(Integer.parseInt(cantidadDisponible));
            elm.setValorU(Integer.parseInt(valorU));
            elm.setEstado(estado);
            elm.setUbicacion(ubicacion);
            elm.setPropiedad(propiedad);
            elm.setResponsable(responsable);
            elm.setArea(area);
            
            //4. Enlazarme con el DAO.
            DaoElementos daoElm = new DaoElementos();
            boolean resultado = daoElm.insertar(elm);
            if (resultado == false) {
                request.setAttribute("insersion", "OK");
            } else {
                request.setAttribute("insersion", "NOK");
            }
            //5. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("IngresoElemento.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CrearListar.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
