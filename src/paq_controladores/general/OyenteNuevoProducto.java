package paq_controladores.general;

import paq_modelos.general.*;
import paq_modelos.principal.ModInventario;
import java.awt.event.*;
import javax.swing.*;
import paq_vistas.general.PanelNuevo;

public class OyenteNuevoProducto implements ActionListener {

    private final PanelNuevo panelNuevo;
    private ModCargarProductos cargarP;

    public OyenteNuevoProducto(PanelNuevo panelNuevo) {
        this.panelNuevo = panelNuevo;
        this.cargarP = new ModCargarProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();

        switch (bt_origen.getName()) {
            case "guardar":
                ModProductos producto = new ModProductos();
                producto.setId(Integer.parseInt(panelNuevo.getcCodigoBarra().getText()));
                producto.setDescripcion(panelNuevo.getcDescripcion().getText());
                producto.setCosto(Float.valueOf(panelNuevo.getcCosto().getText()));
                producto.setPrecio(Float.valueOf(panelNuevo.getcPrecio().getText()));
                producto.setExistencia(Integer.parseInt(panelNuevo.getcExistencia().getText()));
                producto.setCategoria(panelNuevo.getComboCategorias().getSelectedIndex());
                System.out.println("ver1");
                int resultado = cargarP.registrarProductos(producto);
                System.out.println("ver2");
                int resultadoInventario = cargarP.registrarInventario(agregarInventario(producto));
                cargarP.registrarInventario2(producto.getId());
                if (resultado > 0 && resultadoInventario > 0) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "REGISTRO COMPLETADO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                }
                break;
            case "cancelar":
                limpiarCampos();
        }
    }

    public void limpiarCampos() {
        panelNuevo.getcCodigoBarra().setText("");
        panelNuevo.getcDescripcion().setText("");
        panelNuevo.getcCosto().setText("");
        panelNuevo.getcPrecio().setText("");
        panelNuevo.getComboCategorias().setSelectedIndex(0);
        panelNuevo.getcExistencia().setText("");
    }

    public ModInventario agregarInventario(ModProductos producto) {
        ModInventario inventario = new ModInventario();
        inventario.setEntradas(producto.getExistencia());
        inventario.setSalidas(0);
        inventario.setTotal(producto.getExistencia());
        inventario.setId_producto(producto.getId());
        inventario.setId_ubicacion(2);
        return inventario;
    }
}
