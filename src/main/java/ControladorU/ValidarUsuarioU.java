package ControladorU;

import DAOU.DaoUsuarioU;
import ModeloU.SolicitanteU;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidarUsuarioU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long textoId;
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        textoId = new Long(Long.parseLong(usuario));
        DaoUsuarioU daoUser = null;
        try {
            daoUser = new DaoUsuarioU();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ValidarUsuarioU.class.getName()).log(Level.SEVERE, null, ex);
        }
        SolicitanteU sol = new SolicitanteU();
        sol = daoUser.validar(textoId, clave);

        if (sol != null) {
            
            if(sol.getNombre()=="Arnulfo"){
          request.setAttribute("Exito", sol);
          RequestDispatcher rd = request.getRequestDispatcher("indexA.jsp");
          rd.forward(request, response);
            }else{
            request.setAttribute("Exito", sol);
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
                
                
            }
        
           
        } else {
            request.setAttribute("Failed", "NOK");
            RequestDispatcher rd = request.getRequestDispatcher("indexU.jsp");
            rd.forward(request, response);
        }

        HttpSession sesion = request.getSession();
        sol = (SolicitanteU) sesion.getAttribute("usuario");
        if (sol == null) {
            sol = new SolicitanteU();
            sol.setIdentificador(textoId);
            sol.setClave(clave);
            sesion.setAttribute("usuario", sol);
        } else {
            sol.setIdentificador(textoId);
            sol.setClave(clave);
            sesion.setAttribute("usuario", sol);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
