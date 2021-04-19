package paq_modelos.db;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModUsuario;

public class ModSQLUsuario {

    private ModUsuario usuario;
    private DefaultTableModel tb_buscarusuario;
    private JTable tb_ventaproductos;
    private ResultSet r;

    public void buscarUsuario(String st_textoBuscar, DefaultTableModel tb_modelo) {
        try {
            while (tb_modelo.getRowCount() != 0) {
                tb_modelo.removeRow(0);
            }
            ModUsuario usuarios = new ModUsuario();
            Connection conexion = ModConexion.getConexion();
            String st_sqlUsuario = "SELECT ID_USUARIO, NOMBRE_USUARIO, APELLIDO_P_USUARIO, APELLIDO_M_USUARIO,"
                    + " NICK_USUARIO, ID_CARGO_CARGO"
                    + " FROM USUARIOS WHERE NOMBRE_USUARIO LIKE ? OR NICK_USUARIO LIKE ?";

            PreparedStatement consultaBusqueda = conexion.prepareStatement(st_sqlUsuario);
            consultaBusqueda.setString(1, "%" + st_textoBuscar + "%");
            consultaBusqueda.setString(2, "%" + st_textoBuscar + "%");
            ResultSet recorreBusqueda = consultaBusqueda.executeQuery();

            while (recorreBusqueda.next()) {
                usuarios.setIdUsuario(recorreBusqueda.getInt(1));
                usuarios.setNombre(recorreBusqueda.getString(2));
                usuarios.setApellidoPaterno(recorreBusqueda.getString(3));
                usuarios.setApellidoMaterno(recorreBusqueda.getString(4));
                usuarios.setNick(recorreBusqueda.getString(5));
                usuarios.setIdCargo(recorreBusqueda.getInt(6));

                Object[] camposUsuario = {
                    usuarios.getNombre(),
                    usuarios.getApellidoPaterno(),
                    usuarios.getApellidoMaterno(),
                    usuarios.getNick(),
                    usuarios.getIdUsuario(),
                    usuarios.getIdCargo()
                };
                tb_modelo.addRow(camposUsuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ModConexion.cerrarConexion();
        }
    }

    public int registrarUsuario(ModUsuario usuario) {
        int r = 0;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "INSERT INTO USUARIOS(NICK_USUARIO, NOMBRE_USUARIO, "
                    + "APELLIDO_P_USUARIO, APELLIDO_M_USUARIO, "
                    + "CONTRASENA_USUARIO, ID_CARGO_CARGO) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, usuario.getNick());
            consulta.setString(2, usuario.getNombre());
            consulta.setString(3, usuario.getApellidoPaterno());
            consulta.setString(4, usuario.getApellidoMaterno());
            consulta.setString(5, usuario.getContrasena());
            consulta.setInt(6, usuario.getIdCargo());
            r = consulta.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return r;
    }

    public ModUsuario getUsuario(String nick) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT * FROM USUARIOS WHERE NICK_USUARIO=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, nick);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ModUsuario usu = new ModUsuario();
                usu.setNick(recorre.getString(2));
                usu.setNombre(recorre.getString(3));
                usu.setApellidoPaterno(recorre.getString(4));
                usu.setApellidoMaterno(recorre.getString(5));
                usu.setContrasena(recorre.getString(6));
                usu.setIdCargo(recorre.getInt(7));
                return usu;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void modificarUsuario(ModUsuario usuario, String nick) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlUsuario = "UPDATE USUARIOS SET NICK_USUARIO=?, NOMBRE_USUARIO=?, APELLIDO_P_USUARIO=?, APELLIDO_M_USUARIO=?, "
                    + "CONTRASENA_USUARIO=?, ID_CARGO_CARGO=? WHERE NICK_USUARIO=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlUsuario);
            consulta.setString(1, usuario.getNick());
            consulta.setString(2, usuario.getNombre());
            consulta.setString(3, usuario.getApellidoPaterno());
            consulta.setString(4, usuario.getApellidoMaterno());
            consulta.setString(5, usuario.getContrasena());
            consulta.setInt(6, usuario.getIdCargo());

            consulta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminarUsuario(String nick) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlUsuario = "DELETE FROM USUARIOS WHERE NICK_USUARIO=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlUsuario);
            consulta.setString(1, nick);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet cargarCargos() {
        ResultSet r = null;
        Connection conexion = ModConexion.getConexion();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT NOMBRE_CARGO FROM CARGOS");
            r = consulta.executeQuery();
        } catch (SQLException e) {
            System.out.println("Cuando Carga Categorias: " + e);
        }
        return r;
    }

    public int listarUsuarios(int index) {
        Connection conexion = ModConexion.getConexion();
        int columnas = 0;
        try {
            PreparedStatement consulta;
            if (index == 0) {
                consulta = conexion.prepareStatement("SELECT NICK_USUARIO,NOMBRE_USUARIO,APELLIDO_P_USUARIO,APELLIDO_M_USUARIO FROM USUARIOS");
            } else {
                consulta = conexion.prepareStatement("SELECT NICK_USUARIO,NOMBRE_USUARIO,APELLIDO_P_USUARIO,APELLIDO_M_USUARIO FROM USUARIOS WHERE ID_CARGO_CARGO = ?");
                consulta.setInt(1, index);
            }
            r = consulta.executeQuery();
            ResultSetMetaData rsM = r.getMetaData();
            columnas = rsM.getColumnCount();
        } catch (Exception e) {
            System.out.println(e);
        }
        return columnas;
    }

    public ResultSet getR() {
        return r;
    }

    public String nombreUusario(int id) {
        String st_nombre = "";
        ResultSet r = null;
        Connection conexion = ModConexion.getConexion();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT NOMBRE_USUARIO,APELLIDO_P_USUARIO,APELLIDO_M_USUARIO FROM USUARIOS WHERE ID_USUARIO = ?");
            consulta.setInt(1, id);
            r = consulta.executeQuery();

            if (r.next()) {
                st_nombre = r.getString(1);
                st_nombre += " " + r.getString(2);
                st_nombre += " " + r.getString(3);
            }

        } catch (SQLException e) {
            System.out.println("Cuando Carga Categorias: " + e);
        }
        return st_nombre;
    }

    public Time obtenerHora() {
        Time hora = null;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_consulta = "SELECT NOW()";
            PreparedStatement ps = conexion.prepareStatement(st_consulta);
            ResultSet recorre = ps.executeQuery();
            if (recorre.next()) {
                hora = recorre.getTime(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return hora;
    }

    public String obtenerFecha() {
        String st_fecha = "";
        try {
            Connection conexion = ModConexion.getConexion();
            String st_consulta = "SELECT NOW()";
            PreparedStatement ps = conexion.prepareStatement(st_consulta);
            ResultSet recorre = ps.executeQuery();
            if (recorre.next()) {
                st_fecha = recorre.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return st_fecha;
    }
}
