package ControladorU;

import DAOU.DaoUsuarioU;
import ModeloU.SolicitanteU;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CambiarClaveU extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String claveNueva = request.getParameter("ClaveNueva");
            String claveAntigua = request.getParameter("ClaveAntigua");
            
            HttpSession sesion = request.getSession();
            DaoUsuarioU daoUser = new DaoUsuarioU();
            SolicitanteU sol = (SolicitanteU) sesion.getAttribute("usuario");
            long id = sol.getIdentificador();
            boolean resultado = daoUser.cambiarClave(id, claveNueva, claveAntigua);
            
            request.setAttribute("CambioClave", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("CambiarClave.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CambiarClaveU.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
