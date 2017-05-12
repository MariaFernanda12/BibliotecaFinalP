package Controlador;

import DAO.DaoPrestamo;
import Modelo.ModeloPazSalvo;
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

public class PazSalvo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<ModeloPazSalvo> lista = null;
            //1. Crear instancia del DAO
            DaoPrestamo daoPr = new DaoPrestamo();
            //Lista todos los elementos.
            lista = daoPr.listarUsuariosNoPazSalvo();
            //2. Envio de los datos por el request.
            request.setAttribute("Paz", lista);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("PazSalvo.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(PazSalvo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
