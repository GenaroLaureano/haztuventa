package paq_controladores.ventas;

import paq_vistas.ventas.*;
import java.awt.Event;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_utilidades.ModVentanas;

public class OyentesMultiplesVenta extends KeyAdapter implements ActionListener {

    private final PanelVentas panelVentas;
    private final ModSQLVentas sqlVentas;
    private int existencia;

    public OyentesMultiplesVenta(ModSQLVentas sqlVentas, PanelVentas panelVentas) {
        this.panelVentas = panelVentas;
        this.sqlVentas = sqlVentas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numFilas;
        JComponent componente = (JComponent) e.getSource();
        JFrame venPadre = ModVentanas.getVentanaPadre();
        JTextField tx_CodigoBarras = null;
        switch (componente.getName()) {
            case "agregarProducto":
            case "botonAgregarProducto":
                tx_CodigoBarras = panelVentas.getCampoCodigoBarras();
                String idProducto = tx_CodigoBarras.getText();

                sqlVentas.agregarProductoTabla(idProducto);
                tx_CodigoBarras.setText("");
                break;
            case "bt_buscar":
                VentanaBuscarProducto venBuscarProducto = new VentanaBuscarProducto(sqlVentas, venPadre, true);
                venBuscarProducto.setEtiquetaMonto(panelVentas.getEtiquetaMonto());
                venBuscarProducto.setEtiquetaNumeroProducto(panelVentas.getEtiquetaNumeroProductos());
                ModVentanas.abrirVentanaDialogo(venPadre,
                        venBuscarProducto, 800, 500);
                venBuscarProducto.setVisible(true);
                break;
            case "botonBorrar":
                numFilas = sqlVentas.getTablaVentasProductos().getRowCount();
                if (numFilas > 0) {
                    int filaSeleccionada = sqlVentas.getTablaVentasProductos().getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        DefaultTableModel tb_venta = sqlVentas.getDefaultModeloTablaVenta();
                        tb_venta.removeRow(sqlVentas.getTablaVentasProductos().getSelectedRow());
                    }
                    sumarPrecioYCantidad();
                }
                if (numFilas == 1) {
                    panelVentas.getBotonCobrar().setEnabled(false);
                }
                break;
            case "botonVerificar":
                VentanaVerificador venVerificador = new VentanaVerificador(sqlVentas, venPadre, true);
                venVerificador.setEtiquetaMonto(panelVentas.getEtiquetaMonto());
                venVerificador.setEtiquetaNumeroProducto(panelVentas.getEtiquetaNumeroProductos());
                ModVentanas.abrirVentanaDialogo(venPadre,
                        venVerificador, 500, 350);
                venVerificador.setVisible(true);
                break;
            case "bt_cobrar":
                VentanaCobrarProducto venCobrarProducto = new VentanaCobrarProducto(sqlVentas, venPadre, true);
                venCobrarProducto.setEtiquetaMontoVentas(panelVentas.getEtiquetaMonto());
                venCobrarProducto.setEtiquetaNumeroProductosVentas(panelVentas.getEtiquetaNumeroProductos());
                ModVentanas.abrirVentanaDialogo(venPadre,
                        venCobrarProducto, 650, 550);
                venCobrarProducto.setBotonCobrarProductos(panelVentas.getBotonCobrar());
                venCobrarProducto.setVisible(true);
        }
        if (!componente.getName().equals("agregarProducto")) {
            venPadre.requestFocus();
        }
        if (componente.getName().equals("botonAgregarProducto")) {
            tx_CodigoBarras.requestFocus();
        }
        numFilas = sqlVentas.getTablaVentasProductos().getRowCount();
        if (numFilas > 0) {
            sumarPrecioYCantidad();
            panelVentas.getBotonCobrar().setEnabled(true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        JFrame venPadre = ModVentanas.getVentanaPadre();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F10: //Ventana Buscar ModProducto
                ModVentanas.abrirVentanaDialogo(venPadre,
                        new VentanaBuscarProducto(sqlVentas, venPadre, true), 800, 500);
                break;
            case KeyEvent.VK_F9: //Ventana Verificar Precio
                ModVentanas.abrirVentanaDialogo(venPadre,
                        new VentanaVerificador(sqlVentas, venPadre, true), 500, 350);
                break;
            case KeyEvent.VK_F12: //Ventana Cobrar ModProducto
                ModVentanas.abrirVentanaDialogo(venPadre,
                        new VentanaCobrarProducto(sqlVentas, venPadre, true), 550, 350);
                break;
            case Event.DELETE: //Eliminar ModProducto de Tabla
                int numFilas = sqlVentas.getTablaVentasProductos().getRowCount();
                if (numFilas > 0) {
                    int filaSeleccionada = sqlVentas.getTablaVentasProductos().getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        DefaultTableModel tb_venta = sqlVentas.getDefaultModeloTablaVenta();
                        tb_venta.removeRow(sqlVentas.getTablaVentasProductos().getSelectedRow());
                    }
                    sumarPrecioYCantidad();
                }
                if (numFilas == 1) {
                    panelVentas.getBotonCobrar().setEnabled(false);
                }
        }

        //Gestionando eventos para incrementar y disminuir la cantidad del producto a vender
        if (e.getKeyCode() == 93 || e.getKeyCode() == 47) {
            DefaultTableModel tb_venta = sqlVentas.getDefaultModeloTablaVenta();
            int filaSeleccionada = sqlVentas.getTablaVentasProductos().getSelectedRow();
            int cantidad = (int) tb_venta.getValueAt(filaSeleccionada, 3);
            int existenciaActual = (int) tb_venta.getValueAt(filaSeleccionada, 4);;
            existencia = cantidad + existenciaActual;
            switch (e.getKeyCode()) {
                case 93: //PRESIONO TECLA +
                    if (cantidad < existencia) {
                        cantidad++;
                    }
                    break;
                case 47: //PRESIONO TECLA -
                    if (cantidad > 1) {
                        cantidad--;
                    }
            }
            tb_venta.setValueAt(cantidad, filaSeleccionada, 3);
            tb_venta.setValueAt(existencia - cantidad, filaSeleccionada, 4);
            sumarPrecioYCantidad();
        }
    }

    public void sumarPrecioYCantidad() {
        DefaultTableModel tb_venta = sqlVentas.getDefaultModeloTablaVenta();
        int sumCantidadProductos = 0;
        float sumPreciosProductos = 0;
        for (int i = 0; i < tb_venta.getRowCount(); i++) {
            int cantidadProductos = (int) tb_venta.getValueAt(i, 3);
            float precioProductos = (float) tb_venta.getValueAt(i, 2);
            sumPreciosProductos += precioProductos * cantidadProductos;
            sumCantidadProductos += cantidadProductos;
        }
        panelVentas.getEtiquetaMonto().setText("$" + sumPreciosProductos + "");
        panelVentas.getEtiquetaNumeroProductos().setText(sumCantidadProductos + " Productos en la Venta Actual");
    }
}
