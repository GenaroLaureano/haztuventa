package paq_controladores.general;

import paq_vistas.general.*;
import paq_modelos.general.ModCargarProductos;
import java.awt.event.*;
import javax.swing.*;

public class OyenteEliminarProducto implements ActionListener {

    private final PanelEliminarProducto panelDelProd;
    private final ModCargarProductos cargarP;
    private final PanelPrincipal panelPrincipal;
    private final PanelEliminar panelDel;

    public OyenteEliminarProducto(PanelEliminarProducto panelDelProd, PanelPrincipal panelPrincipal, PanelEliminar panelDel) {
        this.panelDelProd = panelDelProd;
        cargarP = new ModCargarProductos();
        this.panelPrincipal = panelPrincipal;
        this.panelDel = panelDel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();
        switch (bt_origen.getName()) {
            case "guardar":
                int codigo = Integer.parseInt(panelDelProd.getcCodigoBarras().getText());
                int r = cargarP.eliminarProducto(codigo);
                if (r > 0) {
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente el producto");
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede realizar la eliminación");
                }

                break;
            case "cancelar":
                panelPrincipal.getPanelCentral().removeAll();
                panelPrincipal.getPanelCentral().add(panelDel);
                panelPrincipal.getPanelCentral().revalidate();
                panelPrincipal.getPanelCentral().repaint();
        }
    }

    public void limpiarCampos() {
        panelDelProd.getcCodigoBarras().setText("");
        panelDelProd.getcDepartamento().setText("");
        panelDelProd.getcCosto().setText("");
        panelDelProd.getcPrecio().setText("");
        panelDelProd.getcDepartamento().setText("");
    }
}
