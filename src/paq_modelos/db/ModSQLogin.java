package paq_modelos.db;

import java.sql.*;
import paq_modelos.principal.ModUsuario;

public class ModSQLogin {

    private static int idUsuario;
    private static float fondoCaja;
    private static String st_horaEntrada;

    public ModUsuario validarLogin(String st_idUsuario, String st_contrasena) {
        try {

            Connection conexion = ModConexion.getConexion();
            String st_sqlUsuario = "SELECT ID_USUARIO, NICK_USUARIO, CONTRASENA_USUARIO FROM USUARIOS "
                    + "WHERE NICK_USUARIO=? AND CONTRASENA_USUARIO=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlUsuario);
            consulta.setString(1, st_idUsuario);
            consulta.setString(2, st_contrasena);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ModUsuario usuario = new ModUsuario();
                usuario.setIdUsuario(recorre.getInt(1));
                usuario.setNombre(recorre.getString(2));
                usuario.setContrasena(recorre.getString(3));
                setIdUsuario(recorre.getInt(1));
                obtenerFecha();
                return usuario;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void obtenerFecha() {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_consulta = "SELECT NOW()";
            PreparedStatement ps = conexion.prepareStatement(st_consulta);
            ResultSet recorre = ps.executeQuery();
            if (recorre.next()) {
                setHoraEntrada(recorre.getString(1));
            }
        } catch (SQLException e) {

        }
    }

    public static String getHoraEntrada() {
        return st_horaEntrada;
    }

    public static void setHoraEntrada(String st_horaEntrada) {
        ModSQLogin.st_horaEntrada = st_horaEntrada;
    }

    public static void setIdUsuario(int st_idUsuario) {
        ModSQLogin.idUsuario = st_idUsuario;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static float getFondoCaja() {
        return fondoCaja;
    }

    public static void setFondoCaja(float fondoCaja) {
        ModSQLogin.fondoCaja = fondoCaja;
    }
}
