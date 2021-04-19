package paq_modelos.general;

import java.sql.*;
import javax.swing.DefaultListModel;
import paq_modelos.principal.ModInventario;
import paq_modelos.db.ModConexion;

public class ModCargarProductos {

    private final ModConexion miConexion;
    private ResultSet rs;
    private PreparedStatement ps;
    private boolean vv;

    public ModCargarProductos() {
        System.out.println("ejale");
        miConexion = new ModConexion();
    }

    public int registrarProductos(ModProductos producto) {
        System.out.println("ver2");
        Connection accesoBD = miConexion.getConexion();
        System.out.println("ver------------------------------"+accesoBD);
        int resultado = 0;
        try {
            ps = accesoBD.prepareStatement("INSERT INTO PRODUCTOS("
                    + "ID_PRODUCTO,"
                    + "DESCRIPCION_PRODUCTO,"
                    + "COSTO_PRODUCTO,"
                    + "PRECIO_PRODUCTO,"
                    + "EXISTENCIA_PRODUCTO,"
                    + "ID_CATEGORIA_CATEGORIA) VALUES(?,?,?,?,?,?)");

            ps.setLong(1, producto.getId());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getCosto());
            ps.setFloat(4, producto.getPrecio());
            ps.setInt(5, producto.getExistencia());
            ps.setInt(6, producto.getCategoria());

            resultado = ps.executeUpdate();

//            accesoBD.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int registrarInventario(ModInventario inventario) {
        Connection accesoBD = miConexion.getConexion();
        int resultado = 0;
        try {
            ps = accesoBD.prepareStatement("INSERT INTO INVENTARIO("
                    + "ENTRADAS_INVENTARIO,"
                    + "SALIDAS_INVENTARIO,"
                    + "TOTAL_INVENTARIO,"
                    + "ID_PRODUCTO_PRODUCTO,"
                    + "ID_UBICACION_UBICACION) VALUES(?,?,?,?,?)");
            ps.setInt(1, inventario.getEntradas());
            ps.setInt(2, inventario.getSalidas());
            ps.setInt(3, inventario.getTotal());
            ps.setLong(4, inventario.getId_producto());
            ps.setInt(5, inventario.getId_ubicacion());
            resultado = ps.executeUpdate();
            accesoBD.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public void registrarInventario2(Long id) {
        Connection accesoBD = miConexion.getConexion();
        int resultado = 0;
        try {
            ps = accesoBD.prepareStatement("INSERT INTO INVENTARIO("
                    + "ENTRADAS_INVENTARIO,"
                    + "SALIDAS_INVENTARIO,"
                    + "TOTAL_INVENTARIO,"
                    + "ID_PRODUCTO_PRODUCTO,"
                    + "ID_UBICACION_UBICACION) VALUES(?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setLong(4, id);
            ps.setInt(5, 1);
            resultado = ps.executeUpdate();
            accesoBD.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ModProductos verificarProducto(ModProductos producto) {
        Connection accesoBD = miConexion.getConexion();
        try {
            ps = accesoBD.prepareStatement("SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = ?");
            ps.setLong(1, producto.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                producto.setDescripcion(rs.getString("DESCRIPCION_PRODUCTO"));
                producto.setCosto(rs.getFloat("COSTO_PRODUCTO"));
                producto.setPrecio(rs.getFloat("PRECIO_PRODUCTO"));
                producto.setExistencia(rs.getInt("EXISTENCIA_PRODUCTO"));
                producto.setCategoria(rs.getInt("ID_CATEGORIA_CATEGORIA"));
                vv = true;
            } else {
                vv = false;
            }
            rs.close();
            accesoBD.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return producto;
    }

    public int registrarProducto(ModProductos producto, int id) {
        int resultado = 0;
        Connection accesoBD = miConexion.getConexion();
        try {
            ps = accesoBD.prepareStatement("UPDATE PRODUCTOS SET"
                    + " ID_PRODUCTO = ?,"
                    + "DESCRIPCION_PRODUCTO = ?,"
                    + "COSTO_PRODUCTO = ?,"
                    + "PRECIO_PRODUCTO = ?,"
                    + "ID_CATEGORIA_CATEGORIA = ? WHERE ID_PRODUCTO = ?");

            ps.setLong(1, producto.getId());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getCosto());
            ps.setFloat(4, producto.getPrecio());
            ps.setInt(5, producto.getCategoria());
            ps.setInt(6, id);

            resultado = ps.executeUpdate();

            accesoBD.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int registraCategoria(ModCategorias categoria) {
        int resultado = 0;
        Connection accesoBD = miConexion.getConexion();
        try {
            ps = accesoBD.prepareStatement("INSERT INTO CATEGORIAS(NOMBRE_CATEGORIA) VALUES(?)");
            ps.setString(1, categoria.getNombre());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int eliminarCategoria(ModCategorias categoria) {
        Connection accesoBD = miConexion.getConexion();
        int resultado = 0;
        try {
            ps = accesoBD.prepareStatement("DELETE FROM CATEGORIAS WHERE NOMBRE_CATEGORIA = ?");
            ps.setString(1, categoria.getNombre());
            resultado = ps.executeUpdate();
            accesoBD.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int eliminarProducto(int codigo) {
        Connection accesoBD = miConexion.getConexion();
        int resultado = 0;
        try {
            ps = accesoBD.prepareStatement("DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ?");
            ps.setInt(1, codigo);
            resultado = ps.executeUpdate();
            accesoBD.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;

    }

    public int listarProductos(ModCategorias categoria) {
        Connection accesoBD = miConexion.getConexion();
        int columnas = 0;
        try {
            if (categoria.getId() == 0) {
                ps = accesoBD.prepareStatement("SELECT ID_PRODUCTO, NOMBRE_CATEGORIA, COSTO_PRODUCTO, PRECIO_PRODUCTO, (PRECIO_PRODUCTO-COSTO_PRODUCTO) AS GANANCIA FROM PRODUCTOS INNER JOIN CATEGORIAS ON ID_CATEGORIA_CATEGORIA = ID_CATEGORIA WHERE ID_CATEGORIA =ID_CATEGORIA_CATEGORIA");
            } else {
                ps = accesoBD.prepareStatement("SELECT ID_PRODUCTO, NOMBRE_CATEGORIA, COSTO_PRODUCTO, PRECIO_PRODUCTO, (PRECIO_PRODUCTO-COSTO_PRODUCTO) AS GANANCIA FROM PRODUCTOS INNER JOIN CATEGORIAS ON ID_CATEGORIA_CATEGORIA = ID_CATEGORIA WHERE ID_CATEGORIA =?");
                ps.setInt(1, categoria.getId());
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsM = rs.getMetaData();
            columnas = rsM.getColumnCount();
        } catch (Exception e) {
            System.out.println(e);
        }
        return columnas;
    }

    public int listarInventario(int index) {
        Connection accesoBD = miConexion.getConexion();
        int columnas = 0;
        try {
            if (index != 0) {
                ps = accesoBD.prepareStatement("SELECT ID_PRODUCTO,NOMBRE_CATEGORIA,ENTRADAS_INVENTARIO,SALIDAS_INVENTARIO,TOTAL_INVENTARIO FROM INVENTARIO INNER JOIN PRODUCTOS ON ID_PRODUCTO_PRODUCTO = ID_PRODUCTO INNER JOIN CATEGORIAS ON ID_CATEGORIA_CATEGORIA = ID_CATEGORIA WHERE ID_UBICACION_UBICACION = ?");
                ps.setInt(1, index);

                rs = ps.executeQuery();
                ResultSetMetaData rsM = rs.getMetaData();
                columnas = rsM.getColumnCount();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return columnas;
    }

    public int buscarProducto(String st_cod) {
        int columnas = 0;
        try {
            ModCategorias categoria = new ModCategorias();
            Connection accesoBD = miConexion.getConexion();
            ps = accesoBD.prepareStatement("SELECT NOMBRE_CATEGORIA FROM CATEGORIAS WHERE NOMBRE_CATEGORIA LIKE ?");
            ps.setString(1, "%" + st_cod + "%");
            rs = ps.executeQuery();
            ResultSetMetaData rsM = rs.getMetaData();
            columnas = rsM.getColumnCount();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return columnas;
    }

    public void buscarCategoria(String st_texto, DefaultListModel modeloLista) {
        try {
            while (modeloLista.getSize() != 0) {
                modeloLista.remove(0);
            }
            ModCategorias categoria = new ModCategorias();
            Connection accesoBD = miConexion.getConexion();
            String st_consulta = "SELECT NOMBRE_CATEGORIA FROM CATEGORIAS WHERE NOMBRE_CATEGORIA LIKE ?";

            ps = accesoBD.prepareStatement(st_consulta);
            ps.setString(1, "%" + st_texto + "%");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                categoria.setNombre(rs.getString("NOMBRE_CATEGORIA"));
                modeloLista.add(i++, categoria.getNombre());
            }
            rs.close();
            accesoBD.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ModInventario seleccionarInventario(long id, int ubicacion) {
        Connection conexion = ModConexion.getConexion();
        ModInventario inventario = new ModInventario();
        String st_sqlInv = "SELECT ENTRADAS_INVENTARIO,SALIDAS_INVENTARIO,TOTAL_INVENTARIO,ID_PRODUCTO_PRODUCTO,ID_UBICACION_UBICACION FROM INVENTARIO WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = ?";
        try {
            ps = conexion.prepareStatement(st_sqlInv);
            ps.setLong(1, id);
            ps.setLong(2, ubicacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                inventario.setEntradas(rs.getInt(1));
                inventario.setSalidas(rs.getInt(2));
                inventario.setTotal(rs.getInt(3));
                inventario.setId_producto(id);
                inventario.setId_ubicacion(ubicacion);
                return inventario;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int actualizarInventarioEntradas(ModInventario inventario, int entradas) {
        int resultado = 0;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE INVENTARIO SET ENTRADAS_INVENTARIO = ?, TOTAL_INVENTARIO = (ENTRADAS_INVENTARIO-SALIDAS_INVENTARIO)"
                    + "WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = 2";
            ps = conexion.prepareStatement(st_sqlInv);
            int totalEntradas = entradas + inventario.getEntradas();
            ps.setInt(1, totalEntradas);
            ps.setLong(2, inventario.getId_producto());
            ps.setInt(3, inventario.getId_ubicacion());
            resultado = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int actualizarInventarioEntradas2(ModInventario inventario, int entradas) {
        int resultado = 0;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE INVENTARIO SET ENTRADAS_INVENTARIO =ENTRADAS_INVENTARIO + ?, TOTAL_INVENTARIO = (ENTRADAS_INVENTARIO-SALIDAS_INVENTARIO)"
                    + "WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = ?";
            ps = conexion.prepareStatement(st_sqlInv);
            System.out.println("inventario entradas" + inventario.getEntradas());
            int totalEntradas = entradas + inventario.getEntradas();
            ps.setInt(1, entradas);
            ps.setLong(2, inventario.getId_producto());
            ps.setInt(3, inventario.getId_ubicacion());
            resultado = ps.executeUpdate();
            conexion.close();
            if (inventario.getId_ubicacion() == 1) {
                reducirInventario(inventario.getId_producto(), entradas);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int reducirInventario(Long codigoBarra, int entradas) {
        int resultado = 0;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sqlInv = "UPDATE INVENTARIO SET SALIDAS_INVENTARIO = SALIDAS_INVENTARIO + ?, TOTAL_INVENTARIO = (ENTRADAS_INVENTARIO-SALIDAS_INVENTARIO)"
                    + "WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = 2";
            ps = conexion.prepareStatement(st_sqlInv);
            ps.setInt(1, entradas);
            ps.setLong(2, codigoBarra);
            resultado = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int maxAlmacen(Long id) {
        int max = 0;
        Connection conexion = ModConexion.getConexion();
        String st_sqlInv = "SELECT TOTAL_INVENTARIO FROM INVENTARIO WHERE ID_PRODUCTO_PRODUCTO = ? && ID_UBICACION_UBICACION = 2";
        try {
            ps = conexion.prepareStatement(st_sqlInv);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return max;
    }

    public boolean isVv() {
        return vv;
    }

    public void setVv(boolean vv) {
        this.vv = vv;
    }

    public ResultSet getRs() {
        return rs;
    }
}
