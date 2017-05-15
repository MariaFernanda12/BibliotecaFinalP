package ControladorA;

import DAOA.DaoElementosA;
import ModeloA.ElementoA;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarElementoA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("Buscar");

        ElementoA elm = new ElementoA();
        //1. Crear instancia del DAO        
        DaoElementosA daoE;
        try {
            daoE = new DaoElementosA();
            //Lista todos los elementos.
            elm = daoE.buscarPorNombre(parametro);
            //2. Envio de los datos por el request.
            request.setAttribute("etiqueta", elm);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("BuscarElemento.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuscarElementoA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("Buscar");

        ElementoA elm = new ElementoA();

        DaoElementosA daoE;
        try {
            daoE = new DaoElementosA();
            elm = daoE.buscar(Integer.parseInt(parametro));
            request.setAttribute("etiqueta", elm);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("BuscarElemento.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuscarElementoA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}