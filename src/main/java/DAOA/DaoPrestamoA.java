package DAOA;

import ModeloA.HistorialPrestamosA;
import ModeloA.ModeloPazSalvoA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ModeloA.PrestamoA;
import Util.Conexion;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPrestamoA {
    
    private Connection conexion;
    
    public DaoPrestamoA() throws URISyntaxException {
        this.conexion = Conexion.getConnection();
         
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
            String consulta = "UPDATE prestamo SET estado='Terminado' WHERE identificadorSol=? and etiquetaInv=?";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setLong(1, id);
            statement.setInt(2, etiqueta);
            //3. Hacer la ejecucion
            resultado = statement.execute();
            devolucionPrestamo(etiqueta);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public PrestamoA validarPrestamo(int etiqueta, long id) {
        PrestamoA pr = null;
        try {
            //1.Establecer la consulta
            String consulta = "select * from prestamo where etiquetaInv=" + etiqueta + " and identificadorSol=" + id + " and estado='Activo'";
            //2. Crear el PreparedStament
            Statement statement
                    = this.conexion.createStatement();
            ResultSet resultado
                    = statement.executeQuery(consulta);
            if (resultado.next()) {
                pr = new PrestamoA();
                pr.setEtiquetaInv(resultado.getInt("etiquetaInv"));
                pr.setIdentificadorSol(resultado.getLong("identificadorSol"));
                pr.setFecha(resultado.getString("fechaDev"));
                pr.setEstadoSol(resultado.getString("estado"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return pr;
    }
    
    public boolean nuevoPrestamo(PrestamoA pr) {
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
    
    public ArrayList<HistorialPrestamosA> listarHistorial() {
        //1.Consulta

        ArrayList<HistorialPrestamosA> respuesta = new ArrayList();
        String consulta = "select inventario.nombre, solicitante.nombreSol, prestamo.fechaDev, prestamo.estado\n"
                + "from((inventario inner join prestamo on (inventario.etiqueta = Prestamo.etiquetaInv))\n"
                + "inner join solicitante on (solicitante.identificador=prestamo.identificadorSol))";
        
        try {
            
            Statement statement = this.conexion.createStatement();
            
            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                HistorialPrestamosA pr = new HistorialPrestamosA();
                pr.setNombreElemento(resultado.getString("nombre"));
                pr.setNombre(resultado.getString("nombreSol"));
                pr.setFecha(resultado.getString("fechaDev"));
                pr.setEstadoSol(resultado.getString("estado"));
                
                respuesta.add(pr);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    public ArrayList<ModeloPazSalvoA> listarUsuariosNoPazSalvo() {
        //1.Consulta

        ArrayList<ModeloPazSalvoA> respuesta = new ArrayList();
        String consulta = "select distinct solicitante.nombreSol, solicitante.cursoArea, inventario.nombre, prestamo.estado from((prestamo inner join solicitante\n"
                + "on(prestamo.identificadorSol=solicitante.identificador and prestamo.estado='Activo'))\n"
                + "inner join inventario on(inventario.etiqueta=prestamo.etiquetaInv))";
        
        try {
            
            Statement statement = this.conexion.createStatement();
            
            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                ModeloPazSalvoA pr = new ModeloPazSalvoA();
                pr.setNobreSol(resultado.getString("nombreSol"));
                pr.setCursoArea(resultado.getString("cursoArea"));
                pr.setNobre(resultado.getString("nombre"));
                pr.setEstado(resultado.getString("estado"));
                
                respuesta.add(pr);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
}