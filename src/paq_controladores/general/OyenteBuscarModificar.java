package paq_controladores.general;

import paq_vistas.general.*;
import paq_modelos.general.*;
import java.awt.event.*;
import javax.swing.*;

public class OyenteBuscarModificar extends KeyAdapter implements ActionListener {

    private final PanelModificar panelMod;
    private final PanelPrincipal panelPrincipal;
    private final PanelModificarProducto panelModProd;
    private final ModCargarProductos cargaP;

    public OyenteBuscarModificar(PanelModificar panelMod, PanelPrincipal panelPrincipal, PanelModificarProducto panelModProd) {
        this.panelMod = panelMod;
        this.panelPrincipal = panelPrincipal;
        this.panelModProd = panelModProd;
        cargaP = new ModCargarProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();
        switch (bt_origen.getName()) {
            case "aceptar":
                abrirVentanaSecundaria();
        }
    }

    public void cargarProducto(ModProductos producto) {
        panelModProd.getcCodigoBarra().setText(String.valueOf(producto.getId()));
        panelModProd.getcDescripcion().setText(String.valueOf(producto.getDescripcion()));
        panelModProd.getcCosto().setText(String.valueOf(producto.getCosto()));
        panelModProd.getcPrecio().setText(String.valueOf(producto.getPrecio()));
        panelModProd.getComboCategorias().setSelectedIndex(producto.getCategoria());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                abrirVentanaSecundaria();
                break;
        }
    }

    public void abrirVentanaSecundaria() {
        String st = "";
        if (!(panelMod.getCampoModifica().getText().equalsIgnoreCase(st))) {
            ModProductos producto = new ModProductos();
            producto.setId(Integer.parseInt(panelMod.getCampoModifica().getText()));
            producto = cargaP.verificarProducto(producto);
            if (cargaP.isVv() == true) {
                cargarProducto(producto);
                panelPrincipal.getPanelCentral().removeAll();
                panelPrincipal.getPanelCentral().add(panelModProd);
                panelPrincipal.getPanelCentral().revalidate();
                panelPrincipal.getPanelCentral().repaint();
                cargaP.setVv(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se ecnontro un producto con ese ID");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el ID");
        }
    }
}
