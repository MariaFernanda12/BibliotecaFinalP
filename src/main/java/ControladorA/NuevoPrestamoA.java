package ControladorA;

import DAOA.DaoPrestamoA;
import ModeloA.PrestamoA;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NuevoPrestamoA extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String etiqueta = request.getParameter("etiqueta");
            Long textoId;
            String id = request.getParameter("id");
            textoId = new Long(Long.parseLong(id));
            String fecha = request.getParameter("fecha");
            
            PrestamoA pr = new PrestamoA();
            pr.setEtiquetaInv(Integer.parseInt(etiqueta));
            pr.setIdentificadorSol(textoId);
            pr.setFecha(fecha);
            pr.setEstadoSol("Activo");
            
            DaoPrestamoA daoPr = new DaoPrestamoA();
            
            boolean resultado = daoPr.nuevoPrestamo(pr);
            if (resultado == false) {
                request.setAttribute("Prestamo", "OK");
            } else {
                request.setAttribute("Prestamo", "NOK");
            }
            RequestDispatcher rd = request.getRequestDispatcher("NuevoPrestamo.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NuevoPrestamoA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
