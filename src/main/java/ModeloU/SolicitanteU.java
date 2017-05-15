package ModeloU;

public class SolicitanteU {

    private long identificador;
    private String nombre;

    /*Si es estudiante o docente*/
    private String tipo;
    /*Ultimos 4 digitos de su # de identificacion*/
    private String clave;
    /*Si es estudiante se pone el curso, si es docente se pone el area del docente*/
    private String cursoArea;

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCursoArea() {
        return cursoArea;
    }

    public void setCursoArea(String cursoArea) {
        this.cursoArea = cursoArea;
    }

    @Override
    public String toString() {
        return "Solicitante{" + "identificador=" + identificador + ", nombre=" + nombre + ", tipo=" + tipo + ", clave=" + clave + ", cursoArea=" + cursoArea + '}';
    }

}
