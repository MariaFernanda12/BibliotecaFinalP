package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Elemento;
import Util.Conexion;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoElementos {

    private Connection conexion;

    public DaoElementos() throws URISyntaxException {
        this.conexion = Conexion.getConnection();

    }

    public boolean insertar(Elemento elm) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into inventario values(?,?,?,?,?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, elm.getCodPUC());
            statement.setInt(2, elm.getEtiqueta());
            statement.setString(3, elm.getNombre());
            statement.setInt(4, elm.getCantidadDisponible());
            statement.setInt(5, elm.getValorU());
            statement.setString(6, elm.getEstado());
            statement.setString(7, elm.getUbicacion());
            statement.setString(8, elm.getPropiedad());
            statement.setString(9, elm.getResponsable());
            statement.setString(10, elm.getArea());

            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Elemento> listarTodo() {
        //1.Consulta

        ArrayList<Elemento> respuesta = new ArrayList();
        String consulta = "select * from inventario";
        try {
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                Elemento elm = new Elemento();
                elm.setCodPUC(resultado.getInt("codPuc"));
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setValorU(resultado.getInt("valorU"));
                elm.setEstado(resultado.getString("estado"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));

                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<Elemento> listarPorArea(String area) {
        //1.Consulta

        ArrayList<Elemento> respuesta = new ArrayList();
        String consulta = "SELECT * FROM inventario where area = '" + area + "'";
        try {
            //----------------------------
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                Elemento elm = new Elemento();
                elm.setCodPUC(resultado.getInt("codPuc"));
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setValorU(resultado.getInt("valorU"));
                elm.setEstado(resultado.getString("estado"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public Elemento buscar(int etiqueta) {
        Elemento elm = null;

        try {
            String consulta = "select * from inventario where etiqueta = ?";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            statement.setInt(1, etiqueta);

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                elm = new Elemento();
                elm.setCodPUC(resultado.getInt("codPuc"));
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setValorU(resultado.getInt("valorU"));
                elm.setEstado(resultado.getString("estado"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

    public Elemento buscarPorNombre(String nombre) {
        Elemento elm = null;

        try {
            String consulta = "select * from inventario where nombre = ?";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            statement.setString(1, nombre);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                elm = new Elemento();
                elm.setCodPUC(resultado.getInt("codPuc"));
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setValorU(resultado.getInt("valorU"));
                elm.setEstado(resultado.getString("estado"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

    public boolean modificarElemento(int newCantidad, String newEstado, String newUbicacion, int etiqueta) {
        boolean resultado = false;

        try {
            String consulta = "update inventario set cantidadDisponible=?, estado=?, ubicacion=? where etiqueta=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, newCantidad);
            statement.setString(2, newEstado);
            statement.setString(3, newUbicacion);
            statement.setInt(4, etiqueta);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public boolean borrarElemento(int etiqueta) {
        boolean retorno = false;
        try {

            String consulta = "delete from inventario where etiqueta = ?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, etiqueta);
            retorno = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }

    public ArrayList<Elemento> cantidadElementosPorArea() {
        ArrayList<Elemento> arr = new ArrayList<Elemento>();

        try {
            String consulta = "select area,  sum(cantidaddisponible) as Total from inventario group by area";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Elemento elm = new Elemento();
                elm = new Elemento();
                elm.setArea(resultado.getString("area"));
                elm.setCantidadDisponible(resultado.getInt("total"));
                arr.add(elm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

}
