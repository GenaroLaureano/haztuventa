package paq_controladores.general;

import paq_vistas.general.*;
import paq_modelos.general.*;
import java.awt.event.*;
import javax.swing.*;

public class OyenteModificarProductos extends KeyAdapter implements ActionListener {

    private final PanelModificarProducto panelModProd;
    private final ModCargarProductos cargarP;
    private final PanelPrincipal panelPrincipal;
    private final PanelModificar panelMod;

    public OyenteModificarProductos(PanelModificarProducto panelModProd, PanelPrincipal panelPrincipal, PanelModificar panelMod) {
        this.panelModProd = panelModProd;
        cargarP = new ModCargarProductos();
        this.panelPrincipal = panelPrincipal;
        this.panelMod = panelMod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();

        switch (bt_origen.getName()) {
            case "guardar":
                abrirVentanaSecundaria();
                ventanaInicial();
                break;
            case "cancelar":
                ventanaInicial();
        }
    }

    public void limpiarCampos() {
        panelModProd.getcCodigoBarra().setText("");
        panelModProd.getcDescripcion().setText("");
        panelModProd.getcCosto().setText("");
        panelModProd.getcPrecio().setText("");
        panelModProd.getComboCategorias().setSelectedIndex(0);

    }

    public void ventanaInicial() {
        panelPrincipal.getPanelCentral().removeAll();
        panelPrincipal.getPanelCentral().add(panelMod);
        panelPrincipal.getPanelCentral().revalidate();
        panelPrincipal.getPanelCentral().repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        abrirVentanaSecundaria();
    }

    public void abrirVentanaSecundaria() {
        ModProductos producto = new ModProductos();
        producto.setId(Integer.parseInt(panelModProd.getcCodigoBarra().getText()));
        producto.setDescripcion(panelModProd.getcDescripcion().getText());
        producto.setCosto(Float.valueOf(panelModProd.getcCosto().getText()));
        producto.setPrecio(Float.valueOf(panelModProd.getcPrecio().getText()));
        producto.setCategoria(panelModProd.getComboCategorias().getSelectedIndex());

        int codigo = Integer.parseInt(panelModProd.getcCodigoBarra().getText());
        int r = cargarP.registrarProducto(producto, codigo);

        if (r > 0) {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "El producto se modifico Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "El producto no se pudo modificar");
        }
    }
}
