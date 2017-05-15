package ControladorU;

import DAOU.DaoElementosU;
import ModeloU.ElementoU;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarPorAreaU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*try (PrintWriter out = response.getWriter()) {
        
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String Enciclopedia = request.getParameter("Enciclopedia");
            String Diccionarios = request.getParameter("Diccionarios");
            String Espanol = request.getParameter("Espanol");
            String Matematicas = request.getParameter("Matematicas");
            String Fisica = request.getParameter("Fisica");
            String Quimica = request.getParameter("Quimica");
            String Sociales = request.getParameter("Sociales");
            String Ingles = request.getParameter("Ingles");
            String Ciencias = request.getParameter("Ciencias");
            String Preescolar = request.getParameter("Preescolar");
            String Filosofia = request.getParameter("Filosofia");
            String Religion = request.getParameter("Religion");
            String Etica = request.getParameter("Etica");
            String Informatica = request.getParameter("Informatica");
            String Atlas = request.getParameter("Atlas");
            String Salud = request.getParameter("Salud");
            String Dibujo = request.getParameter("Dibujo");
            String Institucionales = request.getParameter("Institucionales");
            String MaterialDidactico = request.getParameter("Material Didactico");
            String Multimedia = request.getParameter("Multimedia");
            String Equipo = request.getParameter("Equipo");
            ArrayList<ElementoU> lista = null;
            DaoElementosU daoE = new DaoElementosU();
            
            if (Enciclopedia != null) {
                lista = daoE.listarPorArea(Enciclopedia);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Diccionarios != null) {
                lista = daoE.listarPorArea(Diccionarios);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Espanol != null) {
                lista = daoE.listarPorArea("Español");
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Matematicas != null) {
                lista = daoE.listarPorArea(Matematicas);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Fisica != null) {
                lista = daoE.listarPorArea(Fisica);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Quimica != null) {
                lista = daoE.listarPorArea(Quimica);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Sociales != null) {
                lista = daoE.listarPorArea(Sociales);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Ingles != null) {
                lista = daoE.listarPorArea(Ingles);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Ciencias != null) {
                lista = daoE.listarPorArea(Ciencias);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Preescolar != null) {
                lista = daoE.listarPorArea(Preescolar);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Filosofia != null) {
                lista = daoE.listarPorArea(Filosofia);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Religion != null) {
                lista = daoE.listarPorArea(Religion);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Etica != null) {
                lista = daoE.listarPorArea(Etica);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Informatica != null) {
                lista = daoE.listarPorArea(Informatica);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Atlas != null) {
                lista = daoE.listarPorArea(Atlas);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Salud != null) {
                lista = daoE.listarPorArea(Salud);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Dibujo != null) {
                lista = daoE.listarPorArea(Dibujo);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Institucionales != null) {
                lista = daoE.listarPorArea(Institucionales);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (MaterialDidactico != null) {
                lista = daoE.listarPorArea(MaterialDidactico);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Multimedia != null) {
                lista = daoE.listarPorArea(Multimedia);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
            if (Equipo != null) {
                lista = daoE.listarPorArea(Equipo);
                request.setAttribute("elementos", lista);
                RequestDispatcher rd = request.getRequestDispatcher("ListarElementos.jsp");
                rd.forward(request, response);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(ListarPorAreaU.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
