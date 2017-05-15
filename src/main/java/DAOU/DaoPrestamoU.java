package DAOU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ModeloU.PrestamoU;
import UtilU.ConexionU;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPrestamoU {

    private Connection conexion;

    public DaoPrestamoU() throws URISyntaxException {
        this.conexion= ConexionU.getConnection();
    }

    public boolean restarInventario(int etiqueta) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "UPDATE inventario SET cantidadDisponible = cantidadDisponible-1 WHERE etiqueta=?";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, etiqueta);
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean devolucionPrestamo(int etiqueta) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "UPDATE inventario SET cantidadDisponible = cantidadDisponible+1 WHERE etiqueta=?";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, etiqueta);
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean cambiarEstado(long id, int etiqueta) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "UPDATE prestamo SET estado='Terminado' WHERE identificadorSol=?";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setLong(1, id);
            //3. Hacer la ejecucion
            resultado = statement.execute();
            devolucionPrestamo(etiqueta);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean devolucion(int etiqueta) {
        boolean result = false;
        return result;
    }

    public boolean nuevoPrestamo(PrestamoU pr) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into prestamo values(?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, pr.getEtiquetaInv());
            statement.setLong(2, pr.getIdentificadorSol());
            statement.setString(3, pr.getFecha());
            statement.setString(4, pr.getEstadoSol());

            //3. Hacer la ejecucion
            resultado = statement.execute();
            restarInventario(pr.getEtiquetaInv());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<PrestamoU> listarHistorial(long id) {

        ArrayList<PrestamoU> respuesta = new ArrayList();
        String consulta = "select * from prestamo where identificadorSol=" + id + "";

        try {

            Statement statement
                    = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            System.out.println(consulta);
            while (resultado.next()) {
                PrestamoU pr = new PrestamoU();
                pr.setEtiquetaInv(resultado.getInt("etiquetaInv"));
                pr.setFecha(resultado.getString("fechaDev"));
                pr.setEstadoSol(resultado.getString("estado"));

                respuesta.add(pr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<PrestamoU> listarActivo(long id) {

        ArrayList<PrestamoU> respuesta = new ArrayList();
        String consulta = "select * from prestamo where identificadorSol=" + id + " and estado='Activo'";

        try {

            Statement statement
                    = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            System.out.println(consulta);
            while (resultado.next()) {
                PrestamoU pr = new PrestamoU();
                pr.setEtiquetaInv(resultado.getInt("etiquetaInv"));
                pr.setFecha(resultado.getString("fechaDev"));
                pr.setEstadoSol(resultado.getString("estado"));

                respuesta.add(pr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

}
