package ControladorA;

import DAOA.DaoPrestamoA;
import ModeloA.ModeloPazSalvoA;
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

public class PazSalvoA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<ModeloPazSalvoA> lista = null;
            //1. Crear instancia del DAO
            DaoPrestamoA daoPr = new DaoPrestamoA();
            //Lista todos los elementos.
            lista = daoPr.listarUsuariosNoPazSalvo();
            //2. Envio de los datos por el request.
            request.setAttribute("Paz", lista);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("PazSalvo.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(PazSalvoA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
