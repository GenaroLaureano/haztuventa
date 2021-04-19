package paq_modelos.principal;

public class ModProducto {

    private long idProducto;
    private String st_descripcionProducto;
    private float costo;
    private float precio;
    private int existenciaProducto;
    private int categoria;

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return st_descripcionProducto;
    }

    public void setDescripcionProducto(String st_descripcionProducto) {
        this.st_descripcionProducto = st_descripcionProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
