package paq_modelos.principal;

import java.sql.Date;

public class ModVenta {

    private int idVenta;
    private int unidadesVenta;
    private Date fechaVenta;
    private String st_formaPago;
    private Float precioVenta;
    private float utilidadVenta;
    private int idUsuario;
    private int tipoSalida;
    private int idInventario;
    private int idCliente;
    private long idProducto;

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getUnidadesVenta() {
        return unidadesVenta;
    }

    public void setUnidadesVenta(int unidadesVenta) {
        this.unidadesVenta = unidadesVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getUtilidadVenta() {
        return utilidadVenta;
    }

    public void setUtilidadVenta(float utilidadVenta) {
        this.utilidadVenta = utilidadVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFormaPago() {
        return st_formaPago;
    }

    public void setFormaPago(String st_formaPago) {
        this.st_formaPago = st_formaPago;
    }

    public int getTipoSalida() {
        return tipoSalida;
    }

    public void setTipoSalida(int tipoSalida) {
        this.tipoSalida = tipoSalida;
    }
}
