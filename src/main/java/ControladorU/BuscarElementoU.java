package ControladorU;

import DAOU.DaoElementosU;
import ModeloU.ElementoU;
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

public class BuscarElementoU extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            //Buscar Por nombre
            String parametro = request.getParameter("Buscar");
            
            ElementoU elm = new ElementoU();
            //1. Crear instancia del DAO
            DaoElementosU daoE = new DaoElementosU();
            //Lista todos los elementos.
            elm = daoE.buscarPorNombre(parametro);
            //2. Envio de los datos por el request.
            request.setAttribute("etiqueta", elm);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("BuscarElemento.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuscarElementoU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Buscar por etiqueta
            String parametro = request.getParameter("Buscar");
            
            ElementoU elm = new ElementoU();
            
            DaoElementosU daoE = new DaoElementosU();
            
            elm = daoE.buscar(Integer.parseInt(parametro));
            
            request.setAttribute("etiqueta", elm);
            //3. RequestDispacher
            RequestDispatcher rd = request.getRequestDispatcher("BuscarElemento.jsp");
            rd.forward(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuscarElementoU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
