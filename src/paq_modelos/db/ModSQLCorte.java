package paq_modelos.db;

import java.sql.*;

public class ModSQLCorte {

    private ResultSet r;

    public float ventas(String st_entrada, String st_salida) {
        float ventas = 0;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT SUM((UNIDADES_VENTA*PRECIO_VENTA)) AS VENTAS_TOTAL FROM VENTAS WHERE FECHA_VENTA BETWEEN ? AND ? AND ID_TIPO_SALIDA_SALIDA = 1";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, st_entrada);
            consulta.setString(2, st_salida);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ventas = recorre.getFloat(1);
                return ventas;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventas;
    }

    public float utilidad(String entrada, String salida) {
        float utilidad = 0;
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT SUM(UTILIDAD_VENTA) AS UTILIDAD FROM VENTAS WHERE FECHA_VENTA BETWEEN ? AND ? AND ID_TIPO_SALIDA_SALIDA = 1";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, entrada);
            consulta.setString(2, salida);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                utilidad = recorre.getFloat(1);
                return utilidad;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return utilidad;
    }

    public float ventasEfectivo(String entrada, String salida) {
        float ventas = 0;
        String st_efectivo = "EFECTIVO";
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT SUM(UNIDADES_VENTA*PRECIO_VENTA) AS VENTAS FROM VENTAS WHERE FORMA_PAGO_VENTA = ? AND FECHA_VENTA BETWEEN ? AND ?";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, st_efectivo);
            consulta.setString(2, entrada);
            consulta.setString(3, salida);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ventas = recorre.getFloat(1);
                return ventas;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventas;
    }

    public float ventasTarjeta(String entrada, String salida) {
        float ventas = 0;
        String st_efectivo = "TARJETA";
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT SUM(UNIDADES_VENTA*PRECIO_VENTA) AS VENTAS FROM VENTAS WHERE FORMA_PAGO_VENTA = ? AND FECHA_VENTA BETWEEN ? AND ?";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, st_efectivo);
            consulta.setString(2, entrada);
            consulta.setString(3, salida);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ventas = recorre.getFloat(1);
                return ventas;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventas;
    }

    public float ventasVales(String entrada, String salida) {
        float ventas = 0;
        String st_efectivo = "Vales";
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT SUM(UNIDADES_VENTA*PRECIO_VENTA) AS VENTAS FROM VENTAS WHERE FORMA_PAGO_VENTA = ? AND FECHA_VENTA BETWEEN ? AND ?";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, st_efectivo);
            consulta.setString(2, entrada);
            consulta.setString(3, salida);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ventas = recorre.getFloat(1);
                return ventas;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventas;
    }

    public float ventasCanceladas(String entrada, String salida) {
        float ventas = 0;
        String st_efectivo = "EFECTIVO";
        try {
            Connection conexion = ModConexion.getConexion();
            String st_sql = "SELECT SUM(UNIDADES_VENTA*PRECIO_VENTA) AS VENTAS FROM VENTAS WHERE FORMA_PAGO_VENTA = ? AND FECHA_VENTA BETWEEN ? AND ? AND ID_TIPO_SALIDA_SALIDA = 2";
            PreparedStatement consulta = conexion.prepareStatement(st_sql);
            consulta.setString(1, st_efectivo);
            consulta.setString(2, entrada);
            consulta.setString(3, salida);
            ResultSet recorre = consulta.executeQuery();
            if (recorre.next()) {
                ventas = recorre.getFloat(1);
                return ventas;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventas;
    }
}
