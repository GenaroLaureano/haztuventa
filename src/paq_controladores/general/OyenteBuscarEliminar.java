package paq_controladores.general;

import paq_vistas.general.*;
import paq_modelos.general.*;
import java.awt.event.*;
import javax.swing.*;

public class OyenteBuscarEliminar extends KeyAdapter implements ActionListener {

    private final PanelEliminar panelDel;
    private final PanelPrincipal panelPrincipal;
    private final PanelEliminarProducto panelDelProd;
    private final ModCargarProductos cargaP;

    public OyenteBuscarEliminar(PanelEliminar panelDel, PanelPrincipal panelPrincipal, PanelEliminarProducto psnelDelProd) {
        this.panelDel = panelDel;
        this.panelPrincipal = panelPrincipal;
        this.panelDelProd = psnelDelProd;
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
        panelDelProd.getcCodigoBarras().setText(String.valueOf(producto.getId()));
        panelDelProd.getcDescripcion().setText(producto.getDescripcion());
        panelDelProd.getcCosto().setText(String.valueOf(producto.getCosto()));
        panelDelProd.getcPrecio().setText(String.valueOf(producto.getPrecio()));
        panelDelProd.getcDepartamento().setText(String.valueOf(producto.getCategoria()));
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
        if (!(panelDel.getCampoModifica().getText().equalsIgnoreCase(st))) {
            ModProductos producto = new ModProductos();
            producto.setId(Integer.parseInt(panelDel.getCampoModifica().getText()));
            producto = cargaP.verificarProducto(producto);
            if (cargaP.isVv() == true) {
                cargarProducto(producto);
                panelPrincipal.getPanelCentral().removeAll();
                panelPrincipal.getPanelCentral().add(panelDelProd);
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
