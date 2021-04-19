package paq_modelos.principal;

public class ModUsuario {

    private int idUsuario;
    private String st_nick;
    private String st_nombre;
    private String st_apellidoPaterno;
    private String st_apellidoMaterno;
    private String st_contrasena;
    private int idCargo;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNick() {
        return st_nick;
    }

    public void setNick(String st_nick) {
        this.st_nick = st_nick;
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

    public String getContrasena() {
        return st_contrasena;
    }

    public void setContrasena(String st_contrasena) {
        this.st_contrasena = st_contrasena;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
}
