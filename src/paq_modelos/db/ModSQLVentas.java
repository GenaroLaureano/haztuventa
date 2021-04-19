package paq_modelos.db;

import paq_modelos.principal.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.general.ModProductos;

public class ModSQLVentas {

    private DefaultTableModel tb_venta;
    private DefaultTableModel tb_buscarproducto;
    private DefaultTableModel tb_buscarcliente;
    private DefaultTableModel tb_ticket;
    private JTable tb_ventaproductos;
    private int cantidad;
    private ResultSet rs;

    public ModProducto agregarProductoTabla(String st_idProducto) {
        int r = reducirInventario(Long.parseLong(st_idProducto));
        if (r != 0) {
            boolean productoExistente = validarFilasExistentes(Long.parseLong(st_idProducto));
            ModProducto producto = new ModProducto();
            Connection conexion = ModConexion.getConexion();
            String st_sqlProducto = "SELECT ID_PRODUCTO, DESCRIPCION_PRODUCTO,PRECIO_PRODUCTO"
                    + " FROM PRODUCTOS WHERE ID_PRODUCTO=?";

            PreparedStatement consulta = null;
            try {
                consulta = conexion.prepareStatement(st_sqlProducto);
                consulta.setString(1, st_idProducto);
                ResultSet recorre = consulta.executeQuery();
                if (recorre.next()) {
                    producto.setIdProducto(recorre.getLong(1));
                    producto.setDescripcionProducto(recorre.getString(2));
                    producto.setPrecio(recorre.getFloat(3));
                }

                if (!productoExistente) {
                    Object[] camposProducto = {
                        producto.getIdProducto(),
                        producto.getDescripcionProducto(),
                        producto.getPrecio(),
                        1
                    };
                    tb_venta.addRow(camposProducto);

                }
                return producto;

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
               // ModConexion.cerrarConexion();
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY EXISTENCIA EN PISO DEL PRODUCTO");
        }
        return null;

    }

    public int reducirInventario(Long codigoBarra) {
        int existencia = 0;
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT TOTAL_INVENTARIO FROM INVENTARIO WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = 1";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setLong(1, codigoBarra);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                existencia = recorre.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return existencia;
    }

    public float costoProducto(long id) {
        float existencia = 0;
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT COSTO_PRODUCTO FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setLong(1, id);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                existencia = recorre.getFloat(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return existencia;
    }

    public void buscarProducto(String st_descripcion) {
        try {
            while (tb_buscarproducto.getRowCount() != 0) {
                tb_buscarproducto.removeRow(0);
            }
            ModProducto producto = new ModProducto();
            Connection conexion = ModConexion.getConexion();
            String st_sqlProducto = "SELECT ID_PRODUCTO, DESCRIPCION_PRODUCTO,PRECIO_PRODUCTO,"
                    + "ID_CATEGORIA_CATEGORIA"
                    + " FROM PRODUCTOS WHERE DESCRIPCION_PRODUCTO LIKE ?";
            String st_sqlCategoria = "SELECT NOMBRE_CATEGORIA FROM CATEGORIAS WHERE ID_CATEGORIA=?";

            PreparedStatement consultaBusqueda = conexion.prepareStatement(st_sqlProducto);
            consultaBusqueda.setString(1, "%" + st_descripcion + "%");
            ResultSet recorreBusqueda = consultaBusqueda.executeQuery();

            PreparedStatement consulta;
            ResultSet recorre;
            String nombreCategoria = null;
            while (recorreBusqueda.next()) {
                producto.setIdProducto(recorreBusqueda.getLong(1));
                producto.setDescripcionProducto(recorreBusqueda.getString(2));
                producto.setPrecio(recorreBusqueda.getFloat(3));
                producto.setCategoria(recorreBusqueda.getInt(4));

            }
            consulta = conexion.prepareStatement(st_sqlCategoria);
            consulta.setInt(1, producto.getCategoria());
            recorre = consulta.executeQuery();
            if (recorre.next()) {
                nombreCategoria = recorre.getString(1);
            }

            Object[] camposProducto = {producto.getIdProducto(), producto.getDescripcionProducto(),
                producto.getPrecio(), nombreCategoria};

            tb_buscarproducto.addRow(camposProducto);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ModConexion.cerrarConexion();
        }
    }

    public Object[] consultarPrecioProducto(String st_idProducto) {
        ModProducto producto = new ModProducto();
        Connection conexion = ModConexion.getConexion();
        String st_sqlProducto = "SELECT DESCRIPCION_PRODUCTO,PRECIO_PRODUCTO FROM PRODUCTOS WHERE ID_PRODUCTO=?";
        PreparedStatement consulta = null;
        try {
            consulta = conexion.prepareStatement(st_sqlProducto);
            consulta.setString(1, st_idProducto);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                producto.setDescripcionProducto(recorre.getString(1));
                producto.setPrecio(recorre.getFloat(2));
            }

            Object[] descripcionYPrecio = {producto.getDescripcionProducto(), producto.getPrecio()};
            return descripcionYPrecio;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ModConexion.cerrarConexion();
        }
        return null;
    }

    public void buscarCliente(String st_textoBuscar) {
        try {
            while (tb_buscarcliente.getRowCount() != 0) {
                tb_buscarcliente.removeRow(0);
            }
            ModCliente cliente = new ModCliente();
            Connection conexion = ModConexion.getConexion();
            String st_sqlCliente = "SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO_P_CLIENTE, APELLIDO_M_CLIENTE, "
                    + "TELEFONO_CLIENTE"
                    + " FROM CLIENTES WHERE NOMBRE_CLIENTE LIKE ? OR TELEFONO_CLIENTE LIKE ?";

            PreparedStatement consultaBusqueda = conexion.prepareStatement(st_sqlCliente);
            consultaBusqueda.setString(1, "%" + st_textoBuscar + "%");
            consultaBusqueda.setString(2, "%" + st_textoBuscar + "%");
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
                tb_buscarcliente.addRow(camposCliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ModConexion.cerrarConexion();
        }
    }

    public void registrarVenta(String st_tipoCliente, ModVenta venta, ModCliente cliente, String st_modoPago, int idTicket) {

        try {

            String st_sqlVenta = "INSERT INTO VENTAS(UNIDADES_VENTA, FECHA_VENTA,"
                    + "FORMA_PAGO_VENTA, PRECIO_VENTA,UTILIDAD_VENTA, ID_USUARIO_USUARIO,ID_TIPO_SALIDA_SALIDA,"
                    + "ID_INVENTARIO_INVENTARIO, ID_PRODUCTO_PRODUCTO,"
                    + "ID_CLIENTE_CLIENTE,ID_TICKET_TICKET) VALUES(?, NOW(), ?, ?, ?, ?, ?,?,?,?,?)";
            Connection conexion = ModConexion.getConexion();

            PreparedStatement consultaVenta = conexion.prepareStatement(st_sqlVenta);
            switch (st_tipoCliente) {
                case "PUBLICO EN GENERAL":
                    consultaVenta.setInt(9, 1);
                    break;
                default:
                    String st_sqlCliente = "SELECT ID_CLIENTE, TELEFONO_CLIENTE FROM CLIENTES "
                            + "WHERE TELEFONO_CLIENTE=?";
                    PreparedStatement consultaCliente = conexion.prepareStatement(st_sqlCliente);
                    consultaCliente.setLong(1, cliente.getTelefono());
                    ResultSet recorreCliente = consultaCliente.executeQuery();
                    int idCliente = 0;
                    if (recorreCliente.next()) {
                        idCliente = recorreCliente.getInt(1);
                    }
                    consultaVenta.setInt(9, idCliente);
            }
            consultaVenta.setInt(1, venta.getUnidadesVenta());
            consultaVenta.setString(2, st_modoPago);
            consultaVenta.setFloat(3, venta.getPrecioVenta());
            consultaVenta.setFloat(4, venta.getUtilidadVenta());
            consultaVenta.setInt(5, ModSQLogin.getIdUsuario());
            consultaVenta.setInt(6, 1);
            String st_sqlInventario = "SELECT ID_INVENTARIO FROM INVENTARIO WHERE ID_PRODUCTO_PRODUCTO=? && ID_UBICACION_UBICACION = 1";
            PreparedStatement consultaInventario = conexion.prepareStatement(st_sqlInventario);
            consultaInventario.setLong(1, venta.getIdProducto());
            ResultSet recorreInventario = consultaInventario.executeQuery();
            int id_inventario = 0;
            if (recorreInventario.next()) {
                id_inventario = recorreInventario.getInt(1);
            }
            consultaVenta.setInt(7, id_inventario);
            consultaVenta.setLong(8, venta.getIdProducto());
            consultaVenta.setInt(10, idTicket);
            consultaVenta.executeUpdate();
            String st_sqlInv = "UPDATE INVENTARIO SET SALIDAS_INVENTARIO =SALIDAS_INVENTARIO + ?, TOTAL_INVENTARIO = (ENTRADAS_INVENTARIO-SALIDAS_INVENTARIO)"
                    + "WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = 1";
            PreparedStatement consultaProducto = conexion.prepareStatement(st_sqlInv);
            consultaProducto.setInt(1, venta.getUnidadesVenta());
            consultaProducto.setLong(2, venta.getIdProducto());
            consultaProducto.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ModConexion.cerrarConexion();
        }
    }

    public int crearTicket() {
        Connection conexion = ModConexion.getConexion();
        int resultado = 0;
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO TICKETS(TOTAL_VENTA_TICKET,DETALLE_TICKET) VALUES(?,?)");

            ps.setLong(1, 0);
            ps.setString(2, "VENTA");
            resultado = ps.executeUpdate();

            conexion.clearWarnings();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public void actualizarTickte(float total, int id) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE TICKETS SET TOTAL_VENTA_TICKET =TOTAL_VENTA_TICKET + ? WHERE ID_TICKET = ?";
            PreparedStatement consultaProducto = conexion.prepareStatement(st_sqlInv);
            consultaProducto.setFloat(1, total);
            consultaProducto.setInt(2, id);
            consultaProducto.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int idTicket() {
        int id = 0;
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT ID_TICKET FROM TICKETS WHERE TOTAL_VENTA_TICKET = ?";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setFloat(1, 0);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                id = recorre.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return id;
    }

    public float totalVentas(int id) {
        float total = 0;
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT TOTAL_VENTA_TICKET FROM TICKETS WHERE ID_TICKET = ?";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setFloat(1, id);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                total = recorre.getInt(1);
                return total;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return total;
    }

    public boolean validarFilasExistentes(long codigoBarrasNuevo) {
        int numeroFilas = tb_ventaproductos.getRowCount();
        for (int i = 0; i < numeroFilas; i++) {
            long codigoBarras = (long) tb_venta.getValueAt(i, 0);
            if (codigoBarras == codigoBarrasNuevo) {
                cantidad = (int) tb_venta.getValueAt(i, 3);
                int existencia = reducirInventario(codigoBarrasNuevo);
                if (cantidad < existencia) {
                    cantidad++;
                    tb_venta.setValueAt(cantidad, i, 3);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay más existencia");
                }
                return true;
            }
        }
        return false;
    }

    public int devolverTicket(int idTicket) {
        int columnas = 0;
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT DESCRIPCION_PRODUCTO,UNIDADES_VENTA,PRECIO_VENTA FROM PRODUCTOS INNER JOIN VENTAS ON ID_PRODUCTO = ID_PRODUCTO_PRODUCTO INNER JOIN TICKETS ON ID_TICKET_TICKET = ID_TICKET WHERE ID_TICKET_TICKET=? AND DETALLE_TICKET = ?";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setInt(1, idTicket);
            consulta.setString(2, "VENTA");
            rs = consulta.executeQuery();
            ResultSetMetaData rsM = rs.getMetaData();
            columnas = rsM.getColumnCount();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columnas;
    }

    public boolean verificar(int idTicket) {
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT DESCRIPCION_PRODUCTO,UNIDADES_VENTA,PRECIO_VENTA FROM PRODUCTOS INNER JOIN VENTAS ON ID_PRODUCTO = ID_PRODUCTO_PRODUCTO INNER JOIN TICKETS ON ID_TICKET_TICKET = ID_TICKET WHERE ID_TICKET_TICKET=? AND DETALLE_TICKET = ?";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setInt(1, idTicket);
            consulta.setString(2, "VENTA");
            rs = consulta.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public void cancelarTicket(int id) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE TICKETS SET DETALLE_TICKET = ? WHERE ID_TICKET = ?";
            PreparedStatement consultaProducto = conexion.prepareStatement(st_sqlInv);
            consultaProducto.setString(1, "DEVOLUCION");
            consultaProducto.setInt(2, id);
            consultaProducto.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void cancelarVenta(int id) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE VENTAS SET ID_TIPO_SALIDA_SALIDA= ? WHERE ID_TICKET_TICKET = ?";
            PreparedStatement consultaProducto = conexion.prepareStatement(st_sqlInv);
            consultaProducto.setInt(1, 2);
            consultaProducto.setInt(2, id);
            consultaProducto.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<ModProductos> unidadesProducto(int idTicket) {
        int columnas = 0;
        ModProductos producto = new ModProductos();
        ArrayList<ModProductos> al_productos = new ArrayList();
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT ID_PRODUCTO_PRODUCTO, UNIDADES_VENTA FROM VENTAS WHERE ID_TIPO_SALIDA_SALIDA = ? AND ID_TICKET_TICKET= ?";
        try {
            PreparedStatement consulta = conexion.prepareStatement(st_sqlInv);
            consulta.setInt(1, 2);
            consulta.setInt(2, idTicket);
            rs = consulta.executeQuery();

            while (rs.next()) {
                producto.setId(rs.getLong(1));
                producto.setExistencia(rs.getInt(2));
                al_productos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return al_productos;
    }

    public void actualizarInventario(long id, int cantidad) {
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE INVENTARIO SET ENTRADAS_INVENTARIO = ENTRADAS_INVENTARIO + ? WHERE ID_PRODUCTO_PRODUCTO = ? AND ID_UBICACION_UBICACION = ?";
            PreparedStatement consultaProducto = conexion.prepareStatement(st_sqlInv);
            consultaProducto.setInt(1, cantidad);
            consultaProducto.setLong(2, id);
            consultaProducto.setInt(3, 1);
            consultaProducto.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int listarVentas(int index, String st_entrada, String st_salida) {
        Connection conexion = ModConexion.getConexion();
        int columnas = 0;
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT ID_TICKET, COUNT(ID_PRODUCTO_PRODUCTO) AS PRODUCTOS, TOTAL_VENTA_TICKET, SUM(UTILIDAD_VENTA) FROM VENTAS INNER JOIN TICKETS ON ID_TICKET_TICKET = ID_TICKET  WHERE FECHA_VENTA BETWEEN ? AND ? AND ID_TIPO_SALIDA_SALIDA = ? GROUP BY ID_TICKET");
            consulta.setString(1, st_entrada);
            consulta.setString(2, st_salida);
            consulta.setInt(3, index);
            rs = consulta.executeQuery();
            ResultSetMetaData rsM = rs.getMetaData();
            columnas = rsM.getColumnCount();
        } catch (Exception e) {
            System.out.println(e);
        }
        return columnas;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void setTablaVentasProductos(JTable tb_ventaproductos) {
        this.tb_ventaproductos = tb_ventaproductos;
    }

    public JTable getTablaVentasProductos() {
        return tb_ventaproductos;
    }

    public final void setDefaultModeloTablaVenta(DefaultTableModel tb_venta) {
        this.tb_venta = tb_venta;
    }

    public DefaultTableModel getDefaultModeloTablaVenta() {
        return tb_venta;
    }

    public final void setDefaultModeloTablaBuscarProducto(DefaultTableModel tb_buscarproducto) {
        this.tb_buscarproducto = tb_buscarproducto;
    }

    public DefaultTableModel getDefaultModeloTablaBuscarProducto() {
        return tb_buscarproducto;
    }

    public final void setDefaultModeloTablaBuscarCliente(DefaultTableModel tb_buscarcliente) {
        this.tb_buscarcliente = tb_buscarcliente;
    }

    public DefaultTableModel getDefaultModeloTablaBuscarCliente() {
        return tb_buscarcliente;
    }

    public DefaultTableModel getModeloTablaTicket() {
        return tb_ticket;
    }

    public void setModeloTablaTicket(DefaultTableModel modeloTablaTicket) {
        this.tb_ticket = modeloTablaTicket;
    }
}
