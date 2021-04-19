package paq_controladores.ventas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_vistas.ventas.VentanaBuscarProducto;

public class OyenteBuscarProducto extends KeyAdapter implements ActionListener, DocumentListener {

    private final ModSQLVentas sqlVentas;
    private final VentanaBuscarProducto venBuscaProducto;
    private int numFilaSeleccionada;

    public OyenteBuscarProducto(ModSQLVentas sqlVentas, VentanaBuscarProducto venBuscaProducto) {
        this.sqlVentas = sqlVentas;
        this.venBuscaProducto = venBuscaProducto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_producto = (JButton) e.getSource();
        switch (bt_producto.getName()) {
            case "botonModificar":
                System.out.println("modificar");
                break;
            case "botonEliminar":
                System.out.println("eliminar");
            case "bt_aceptar":
                agregarProductoBuscadoAVentas();
                break;
            case "bt_cancelar":
                venBuscaProducto.setVisible(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                agregarProductoBuscadoAVentas();
                break;
            case KeyEvent.VK_ESCAPE:
                venBuscaProducto.setVisible(false);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        String st_descripcion = venBuscaProducto.getCampoBuscarProducto().getText();
        sqlVentas.buscarProducto(st_descripcion);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        String st_descripcion = venBuscaProducto.getCampoBuscarProducto().getText();
        sqlVentas.buscarProducto(st_descripcion);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        String st_descripcion = venBuscaProducto.getCampoBuscarProducto().getText();
        sqlVentas.buscarProducto(st_descripcion);
    }

    public void agregarProductoBuscadoAVentas() {
        DefaultTableModel tb_buscarproducto = (DefaultTableModel) venBuscaProducto.getTablaBuscarProducto().getModel();
        DefaultTableModel tb_venta = sqlVentas.getDefaultModeloTablaVenta();
        numFilaSeleccionada = venBuscaProducto.getTablaBuscarProducto().getSelectedRow();
        if (numFilaSeleccionada >= 0) {
            long codigoBarras = (long) tb_buscarproducto.getValueAt(numFilaSeleccionada, 0);
            int r = sqlVentas.reducirInventario(codigoBarras);
            if (r != 0) {
                boolean validaExistente = sqlVentas.validarFilasExistentes(codigoBarras);
                if (!validaExistente) {
                    Object[] producto = {
                        tb_buscarproducto.getValueAt(numFilaSeleccionada, 0),
                        tb_buscarproducto.getValueAt(numFilaSeleccionada, 1),
                        tb_buscarproducto.getValueAt(numFilaSeleccionada, 2),
                        1
                    };
                    tb_venta.addRow(producto);
                    sumarPrecioYCantidad();
                }
                venBuscaProducto.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No hay más existencia");
            }
        }
    }

    public void sumarPrecioYCantidad() {
        DefaultTableModel tb_ventas = sqlVentas.getDefaultModeloTablaVenta();
        int sumCantidadProductos = 0;
        float sumPreciosProductos = 0;
        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            int cantidadProductos = (int) tb_ventas.getValueAt(i, 3);
            float precioProductos = (float) tb_ventas.getValueAt(i, 2);
            sumPreciosProductos += precioProductos * cantidadProductos;
            sumCantidadProductos += cantidadProductos;
        }
        venBuscaProducto.getEtiquetaMonto().setText("$" + sumPreciosProductos + "");
        venBuscaProducto.getEtiquetaNumeroProducto().setText(sumCantidadProductos + " Productos en la Venta Actual");
    }
}
