package paq_modelos.principal;

public class ModDevolucion {

    private String st_descripcion;
    private int unidades;
    private float precio;

    public String getDescripcion() {
        return st_descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.st_descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
