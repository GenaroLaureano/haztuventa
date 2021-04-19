package paq_modelos.db;

import java.sql.*;

public class ModConexion {

    private static Connection conexion = null;

    public static Connection getConexion() {
        try {
            String st_ruta = "jdbc:mysql://localhost:3306/HAZTUVENTA"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String st_user = "root";
            String st_pass = "12345678";
            conexion = DriverManager.getConnection(st_ruta, st_user, st_pass);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al realizar conexion");
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
