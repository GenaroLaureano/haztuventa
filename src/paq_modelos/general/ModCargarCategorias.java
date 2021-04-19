package paq_modelos.general;

import paq_modelos.db.ModConexion;
import java.sql.*;

public class ModCargarCategorias {

    private final ModConexion miConexion;
    private ResultSet rs;
    private PreparedStatement ps;

    public ModCargarCategorias() {
        miConexion = new ModConexion();
    }

    public void consultaCategorias() {
        Connection accesoDB = miConexion.getConexion();
        try {
            ps = accesoDB.prepareStatement("SELECT NOMBRE_CATEGORIA FROM CATEGORIAS");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Cuando Carga Categorias: " + e);
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void cargarProveedores() {
        Connection accesoDB = miConexion.getConexion();
        try {
            ps = accesoDB.prepareStatement("SELECT NOMBRE_PROVEEDOR FROM PROVEEDORES");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Cuando Carga PROVEEDORES: " + e);
        }
    }
}
