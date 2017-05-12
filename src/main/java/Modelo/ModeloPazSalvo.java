package Modelo;

public class ModeloPazSalvo {

    private String nobreSol;
    private String cursoArea;
    private String nobre;
    private String estado;

    public String getNobreSol() {
        return nobreSol;
    }

    public void setNobreSol(String nobreSol) {
        this.nobreSol = nobreSol;
    }

    public String getCursoArea() {
        return cursoArea;
    }

    public void setCursoArea(String cursoArea) {
        this.cursoArea = cursoArea;
    }

    public String getNobre() {
        return nobre;
    }

    public void setNobre(String nobre) {
        this.nobre = nobre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ModeloPazSalvo{" + "nobreSol=" + nobreSol + ", cursoArea=" + cursoArea + ", nobre=" + nobre + ", estado=" + estado + '}';
    }

}
