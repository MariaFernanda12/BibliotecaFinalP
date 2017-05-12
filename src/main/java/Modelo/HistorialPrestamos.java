package Modelo;

public class HistorialPrestamos {

    //Nombre del Elemento
    private String nombreElemento;
    //Nombre del solicitante
    private String nombre;
    //Fecha de devolución
    private String fecha;
    //Estado del prestamo//
    private String estadoSol;

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoSol() {
        return estadoSol;
    }

    public void setEstadoSol(String estadoSol) {
        this.estadoSol = estadoSol;
    }

}
