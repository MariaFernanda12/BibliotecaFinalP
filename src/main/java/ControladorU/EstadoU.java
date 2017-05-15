package ControladorU;

import DAOU.DaoPrestamoU;
import ModeloU.PrestamoU;
import ModeloU.SolicitanteU;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EstadoU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<PrestamoU> lista = null;
            HttpSession sesion = request.getSession();
            DaoPrestamoU daoPr = new DaoPrestamoU();
            SolicitanteU sol = (SolicitanteU) sesion.getAttribute("usuario");
            long id = sol.getIdentificador();
            lista = daoPr.listarActivo(id);
            request.setAttribute("Prestamo", lista);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("EstadoUsuarios.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EstadoU.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
