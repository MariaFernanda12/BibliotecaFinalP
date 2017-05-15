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

public class DevolucionA extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String etiqueta = request.getParameter("etiqueta");
            Long textoId;
            String id = request.getParameter("id");
            textoId = new Long(Long.parseLong(id));
            
            DaoPrestamoA daoPr = new DaoPrestamoA();
            PrestamoA pr = daoPr.validarPrestamo(Integer.parseInt(etiqueta), textoId);
            if (pr != null) {
                daoPr.cambiarEstado(textoId, Integer.parseInt(etiqueta));
                request.setAttribute("Devolucion", "OK");
                RequestDispatcher rd = request.getRequestDispatcher("Devolucion.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("Devolucion", "NOK");
                RequestDispatcher rd = request.getRequestDispatcher("Devolucion.jsp");
                rd.forward(request, response);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(DevolucionA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
