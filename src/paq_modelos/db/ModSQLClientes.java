package paq_modelos.db;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModCliente;

public class ModSQLClientes {

    private ResultSet r;

    public void buscarCliente(String textoBuscar, DefaultTableModel tb_modelo) {
        try {
            while (tb_modelo.getRowCount() != 0) {
                tb_modelo.removeRow(0);
            }
            ModCliente cliente = new ModCliente();
            Connection conexion = ModConexion.getConexion();
            String st_sqlCliente = "SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO_P_CLIENTE, APELLIDO_M_CLIENTE, "
                    + "TELEFONO_CLIENTE"
                    + " FROM CLIENTES WHERE NOMBRE_CLIENTE LIKE ? OR TELEFONO_CLIENTE LIKE ?";

            PreparedStatement consultaBusqueda = conexion.prepareStatement(st_sqlCliente);
            consultaBusqueda.setString(1, "%" + textoBuscar + "%");
            consultaBusqueda.setString(2, "%" + textoBuscar + "%");
            ResultSet recorreBusqueda = consultaBusqueda.executeQuery();

            while (recorreBusqueda.next()) {
                cliente.setIdCliente(recorreBusqueda.getInt(1));
                cliente.setNombre(recorreBusqueda.getString(2));
                cliente.setApellidoPaterno(recorreBusqueda.getString(3));
                cliente.setApellidoMaterno(recorreBusqueda.getString(4));
                cliente.setTelefono(recorreBusqueda.getLong(5));
                Object[] camposCliente = {
                    cliente.getNombre(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getTelefono()
                };
                tb_modelo.addRow(camposCliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ModConexion.cerrarConexion();
        }
    }

    public ModCliente getCliente(long telefonoCliente) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlCliente = "SELECT * FROM CLIENTES WHERE TELEFONO_CLIENTE=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlCliente);
            consulta.setLong(1, telefonoCliente);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ModCliente cliente = new ModCliente();
                cliente.setNombre(recorre.getString(2));
                cliente.setApellidoPaterno(recorre.getString(3));
                cliente.setApellidoMaterno(recorre.getString(4));
                cliente.setSexo(recorre.getString(5));
                cliente.setEmail(recorre.getString(6));
                cliente.setTelefono((long) recorre.getLong(7));
                return cliente;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void eliminarCliente(long telefonoCliente) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlCliente = "DELETE FROM CLIENTES WHERE TELEFONO_CLIENTE=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlCliente);
            consulta.setLong(1, telefonoCliente);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void registrarCliente(ModCliente cliente) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlCliente = "INSERT INTO CLIENTES(NOMBRE_CLIENTE, APELLIDO_P_CLIENTE, APELLIDO_M_CLIENTE, "
                    + "SEXO_CLIENTE, EMAIL_CLIENTE, TELEFONO_CLIENTE) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlCliente);
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getApellidoPaterno());
            consulta.setString(3, cliente.getApellidoMaterno());
            consulta.setString(4, cliente.getSexo());
            consulta.setString(5, cliente.getEmail());
            consulta.setLong(6, cliente.getTelefono());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void modificarCliente(ModCliente cliente, long telefonoCopia) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlCliente = "UPDATE CLIENTES SET NOMBRE_CLIENTE=?, APELLIDO_P_CLIENTE=?, APELLIDO_M_CLIENTE=?, "
                    + "SEXO_CLIENTE=?, EMAIL_CLIENTE=?, TELEFONO_CLIENTE=? WHERE TELEFONO_CLIENTE=?";
            PreparedStatement consulta = conexion.prepareStatement(st_sqlCliente);
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getApellidoPaterno());
            consulta.setString(3, cliente.getApellidoMaterno());
            consulta.setString(4, cliente.getSexo());
            consulta.setString(5, cliente.getEmail());
            consulta.setLong(6, cliente.getTelefono());
            consulta.setLong(7, telefonoCopia);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int listarProductos(int index) {
        Connection conexion = ModConexion.getConexion();
        String st_sexo = "";
        if (index == 1) {
            st_sexo = "F";
        } else if (index == 2) {
            st_sexo = "M";
        } else {
            st_sexo = "OTRO";
        }
        int columnas = 0;
        try {
            PreparedStatement consulta;
            if (index == 0) {
                consulta = conexion.prepareStatement("SELECT NOMBRE_CLIENTE,APELLIDO_P_CLIENTE,APELLIDO_M_CLIENTE,SEXO_CLIENTE,EMAIL_CLIENTE,TELEFONO_CLIENTE FROM CLIENTES");
            } else {
                consulta = conexion.prepareStatement("SELECT NOMBRE_CLIENTE,APELLIDO_P_CLIENTE,APELLIDO_M_CLIENTE,SEXO_CLIENTE,EMAIL_CLIENTE,TELEFONO_CLIENTE FROM CLIENTES WHERE SEXO_CLIENTE = ?");
                consulta.setString(1, st_sexo);
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
}
