package paq_modelos.principal;

public class ModCliente {

    private int idCliente;
    private String st_nombre;
    private String st_apellidoPaterno;
    private String st_apellidoMaterno;
    private String st_sexo;
    private String st_email;
    private long telefono;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return st_nombre;
    }

    public void setNombre(String st_nombre) {
        this.st_nombre = st_nombre;
    }

    public String getApellidoPaterno() {
        return st_apellidoPaterno;
    }

    public void setApellidoPaterno(String st_apellidoPaterno) {
        this.st_apellidoPaterno = st_apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return st_apellidoMaterno;
    }

    public void setApellidoMaterno(String st_apellidoMaterno) {
        this.st_apellidoMaterno = st_apellidoMaterno;
    }

    public String getSexo() {
        return st_sexo;
    }

    public void setSexo(String st_sexo) {
        this.st_sexo = st_sexo;
    }

    public String getEmail() {
        return st_email;
    }

    public void setEmail(String st_email) {
        this.st_email = st_email;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
