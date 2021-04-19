package paq_controladores.general;

import paq_vistas.general.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.JButton;
import paq_modelos.general.ModCargarProductos;

public class OyentePrincipal implements ActionListener {

    private final PanelPrincipal panelPrincipal;
    private final PanelNuevo panelNuevo;
    private final PanelModificar panelMod;
    private final PanelCategoria panelCategoria;
    private final PanelCatalogo panelCatalogo;
    private final PanelEliminar panelDel;
    private final PanelAnadir panelAdd;
    private final ModCargarProductos cargarP;
    private final PanelInventario panelInv;

    public OyentePrincipal(PanelPrincipal panelPrincipal, PanelNuevo panelNuevo, PanelModificar panelMod, PanelCategoria panelCategoria, PanelCatalogo panelCatalogo, PanelEliminar panelDel, PanelAnadir panelAdd, ModCargarProductos cargarP) {
        this.panelPrincipal = panelPrincipal;
        this.panelNuevo = panelNuevo;
        this.panelMod = panelMod;
        this.panelCategoria = panelCategoria;
        this.panelCatalogo = panelCatalogo;
        this.panelDel = panelDel;
        this.panelAdd = panelAdd;
        this.cargarP = cargarP;
        this.panelInv = new PanelInventario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();
        Component[] botones = panelPrincipal.getPanelOpciones().getComponents();
        panelPrincipal.getPanelCentral().removeAll();
        switch (bt_origen.getName()) {
            case "nuevo":
                panelPrincipal.getPanelCentral().add(panelNuevo);
                break;
            case "modificar":
                panelPrincipal.getPanelCentral().add(panelMod);
                break;
            case "eliminar":
                panelPrincipal.getPanelCentral().add(panelDel);
                break;
            case "departamento":
                panelPrincipal.getPanelCentral().add(panelCategoria);
                break;
            case "catalogo":
                panelPrincipal.getPanelCentral().add(panelCatalogo);
                break;
            case "anadir":
                panelPrincipal.getPanelCentral().add(panelAdd);
                break;
            case "inventario":
                panelPrincipal.getPanelCentral().add(panelInv);
                break;
        }
        bt_origen.setEnabled(false);
        for (int i = 0; i < botones.length; i++) {
            if (!botones[i].getName().equals(bt_origen.getName())) {
                botones[i].setEnabled(true);
            }
        }
        panelPrincipal.getPanelCentral().revalidate();
        panelPrincipal.getPanelCentral().repaint();
    }
}
