package paq_controladores.ventas;

import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_vistas.ventas.VentanaVerificador;

public class OyenteVerificador extends KeyAdapter implements ActionListener {

    private final ModSQLVentas sqlVentas;
    VentanaVerificador venVerificador;

    public OyenteVerificador(ModSQLVentas sqlVentas, VentanaVerificador venVerificador) {
        this.venVerificador = venVerificador;
        this.sqlVentas = sqlVentas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent componente = (JComponent) e.getSource();
        switch (componente.getName()) {
            case "tx_verprecio":
            case "campoVerificarPrecio":
                Object[] descripcionYPrecio = sqlVentas.consultarPrecioProducto(venVerificador.getCampoVerificarPrecio().getText());
                if (descripcionYPrecio != null) {
                    venVerificador.getEtiquetaDescripcionProducto().setText(descripcionYPrecio[0].toString());
                    venVerificador.getEtiquetaPrecio().setText(descripcionYPrecio[1].toString());
                }
                break;
            case "bt_addventa":
                sqlVentas.agregarProductoTabla(venVerificador.getCampoVerificarPrecio().getText());
                sumarPrecioYCantidad();
                venVerificador.setVisible(false);
                break;
            case "bt_cancelar":
                venVerificador.setVisible(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F1:
                String st_etiquetaPrecio = venVerificador.getEtiquetaPrecio().getText();
                if (!st_etiquetaPrecio.equals("$0.0")) {
                    sqlVentas.agregarProductoTabla(venVerificador.getCampoVerificarPrecio().getText());
                    sumarPrecioYCantidad();
                    venVerificador.setVisible(false);
                }
                break;
            case KeyEvent.VK_ESCAPE:
                venVerificador.setVisible(false);
        }
    }

    public void sumarPrecioYCantidad() {
        DefaultTableModel tb_ventas = sqlVentas.getDefaultModeloTablaVenta();
        int sumCantidadProductos = 0;
        double sumPreciosProductos = 0;
        for (int i = 0; i < tb_ventas.getRowCount(); i++) {
            int cantidadProductos = (int) tb_ventas.getValueAt(i, 3);
            float precioProductos = (float) tb_ventas.getValueAt(i, 2);
            sumPreciosProductos += precioProductos * cantidadProductos;
            sumCantidadProductos += cantidadProductos;
        }
        venVerificador.getEtiquetaMonto().setText("$" + sumPreciosProductos + "");
        venVerificador.getEtiquetaNumeroProducto().setText(sumCantidadProductos + " Productos en la Venta Actual");
    }
}
