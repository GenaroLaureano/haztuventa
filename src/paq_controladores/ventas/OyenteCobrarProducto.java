package paq_controladores.ventas;

import paq_vistas.ventas.*;
import paq_modelos.principal.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_utilidades.ModVentanas;
import paq_vistas.clientes.VentanaBuscarCliente;

public class OyenteCobrarProducto extends WindowAdapter implements ActionListener, DocumentListener, KeyListener {

    private final ModSQLVentas sqlVentas;
    private final VentanaCobrarProducto venCobrarProducto;
    private double sumPreciosProductos = 0;
    private VentanaBuscarCliente venBuscarCliente;
    private ModCliente cliente;
    private VentanaTarjeta venTarjeta;
    private VentanaVales venVales;

    public OyenteCobrarProducto(ModSQLVentas sqlVentas, VentanaCobrarProducto ventanaCobrarProducto) {
        this.sqlVentas = sqlVentas;
        this.venCobrarProducto = ventanaCobrarProducto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent componente = (JComponent) e.getSource();
        switch (componente.getName()) {
            case "cliente":
                JLabel et_nombrecliente = venCobrarProducto.getEtiquetaNombreCliente();
                et_nombrecliente.setText("CLIENTE");
                JFrame venPadre = ModVentanas.getVentanaPadre();
                venBuscarCliente = new VentanaBuscarCliente(sqlVentas, venPadre, true);
                venBuscarCliente.setEtiquetaNombreCliente(et_nombrecliente);
                cliente = new ModCliente();
                venBuscarCliente.setCliente(cliente);
                ModVentanas.abrirVentanaDialogo(venPadre,
                        venBuscarCliente, 950, 450);
                venBuscarCliente.setVisible(true);
                break;
            case "publicoGeneral":
                et_nombrecliente = venCobrarProducto.getEtiquetaNombreCliente();
                et_nombrecliente.setText("PUBLICO EN GENERAL");
                break;

            case "bt_cobrar":
                cobrarProductos();
                break;
            case "bt_cancelar":
                venCobrarProducto.setVisible(false);
                break;
            case "efectivo":
                venCobrarProducto.getCampoCantidadPago().setEnabled(true);
                break;
            case "tarjeta":
                JFrame venPadre2 = ModVentanas.getVentanaPadre();
                venTarjeta = new VentanaTarjeta(venPadre2, true);
                ModVentanas.abrirVentanaDialogo(venPadre2,
                        venTarjeta, 300, 300);
                venTarjeta.setVisible(true);
                venCobrarProducto.getCampoCantidadPago().setEnabled(false);
                break;
            case "vales":
                JFrame venPadre3 = ModVentanas.getVentanaPadre();
                venVales = new VentanaVales(venPadre3, true);
                ModVentanas.abrirVentanaDialogo(venPadre3,
                        venVales, 400, 300);
                venVales.setVisible(true);
                venCobrarProducto.getCampoCantidadPago().setEnabled(false);
                break;
        }
        venCobrarProducto.getCampoCantidadPago().requestFocus();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        DefaultTableModel tb_ventas = sqlVentas.getDefaultModeloTablaVenta();
        int sumCantidadProductos = 0;
        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            int cantidadProductos = (int) tb_ventas.getValueAt(i, 3);
            float precioProductos = (float) tb_ventas.getValueAt(i, 2);
            sumPreciosProductos += precioProductos * cantidadProductos;
            sumCantidadProductos += cantidadProductos;
        }
        venCobrarProducto.getEtiquetaCantidadMonto().setText("$" + sumPreciosProductos + "");
        venCobrarProducto.getEtiquetaNumeroArticulos().setText(sumCantidadProductos + "");
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        operacionCambioEfectivo();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        operacionCambioEfectivo();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        operacionCambioEfectivo();
    }

    public void operacionCambioEfectivo() {
        try {
            double cambio;
            String st_dineroRecibido = venCobrarProducto.getCampoCantidadPago().getText();
            if (!st_dineroRecibido.isEmpty()) {
                double cantidadPago = Double.parseDouble(st_dineroRecibido);
                cambio = cantidadPago == 0 ? 0 : cantidadPago - sumPreciosProductos;
            } else {
                cambio = 0;
            }
            venCobrarProducto.getEtiquetaCantidadCambio().setText("$" + Math.abs(cambio) + "");
        } catch (NumberFormatException e) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F2:
                cobrarProductos();
                break;
            case KeyEvent.VK_ESCAPE:
                venCobrarProducto.setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void cobrarProductos() {
        String st_cantidadMonto = venCobrarProducto.getEtiquetaCantidadMonto().getText();
        if (!st_cantidadMonto.equals("$0.0")) {
            String st_modoPago = "";
            if (venCobrarProducto.getGrupoModoPadoVales().isSelected()) {
                st_modoPago = "VALES";
            } else if (venCobrarProducto.getGrupoModoPagoEfectivo().isSelected()) {
                st_modoPago = "EFECTIVO";
            } else {
                st_modoPago = "TARJETA";
            }
            DefaultTableModel tb_ventas = sqlVentas.getDefaultModeloTablaVenta();
            String st_tipoCliente = venCobrarProducto.getEtiquetaNombreCliente().getText();
            ModVenta venta = new ModVenta();
            if (st_tipoCliente.equalsIgnoreCase("PUBLICO EN GENERAL") || !st_tipoCliente.equalsIgnoreCase("CLIENTE")) {
                if (!venCobrarProducto.getCampoCantidadPago().getText().isEmpty()) {
                    sqlVentas.crearTicket();
                    int idTicket = sqlVentas.idTicket();
                    for (int i = 0; i < sqlVentas.getTablaVentasProductos().getRowCount(); i++) {
                        float costo = sqlVentas.costoProducto((long) tb_ventas.getValueAt(i, 0));
                        float ventaTotal = (int) tb_ventas.getValueAt(i, 3) * (float) tb_ventas.getValueAt(i, 2);
                        sqlVentas.actualizarTickte(ventaTotal, idTicket);
                        float totalUtilidad = (int) tb_ventas.getValueAt(i, 3) * costo;
                        venta.setUnidadesVenta((int) tb_ventas.getValueAt(i, 3));
                        venta.setPrecioVenta((float) tb_ventas.getValueAt(i, 2));
                        venta.setIdProducto((long) tb_ventas.getValueAt(i, 0));
                        venta.setUtilidadVenta(ventaTotal - totalUtilidad);
                        sqlVentas.registrarVenta(st_tipoCliente, venta, cliente, st_modoPago, idTicket);
                    }
                    limpiarTablaVenta();
                    venCobrarProducto.getEtiquetaMontoVentas().setText("$0.0");
                    venCobrarProducto.getEtiquetaNumeroProductosVentas().setText("0 Productos en la Venta Actual");
                    venCobrarProducto.getBotonCobrarProductos().setEnabled(false);
                    venCobrarProducto.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(venCobrarProducto, "Debes Ingresar la Cantidad del Pago",
                            "Cantidad del Pago", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (st_tipoCliente.equalsIgnoreCase("CLIENTE")) {
                JOptionPane.showMessageDialog(venCobrarProducto, "Debes Seleccionar un Cliente",
                        "Seleccionar Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void limpiarTablaVenta() {
        DefaultTableModel tb_ventas = sqlVentas.getDefaultModeloTablaVenta();
        while (tb_ventas.getRowCount() != 0) {
            tb_ventas.removeRow(0);
        }
    }
}
