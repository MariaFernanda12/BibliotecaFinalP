package DAOU;

import ModeloU.PrestamoU;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ModeloU.SolicitanteU;
import Util.Conexion;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsuarioU {

    private Connection conexion;

    public DaoUsuarioU() throws URISyntaxException {
        
        this.conexion= Conexion.getConnection();
        
    }

    public SolicitanteU validar(long usuario, String clave) {
        SolicitanteU sol = null;
        try {

            String consulta = "select * from solicitante where identificador="
                    + usuario + " and clave='" + clave + "'";
            Statement statement
                    = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            if (resultado.next()) {
                sol = new SolicitanteU();
                sol.setIdentificador(resultado.getLong("identificador"));
                sol.setNombre(resultado.getString("nombreSol"));
                sol.setTipo(resultado.getString("tipo"));
                sol.setClave(resultado.getString("clave"));
                sol.setCursoArea(resultado.getString("cursoArea"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return sol;
    }

    public boolean cambiarClave(long id, String claveNueva, String claveAntigua) {
        boolean resultado = false;
        try {
            String consulta = "UPDATE solicitante SET clave ='" + claveNueva + "' "
                    + "where identificador=" + id + " and clave='" + claveAntigua + "'";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            resultado = statement.execute();

            System.out.println(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementosU.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    

}
