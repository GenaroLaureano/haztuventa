package paq_controladores.devoluciones;

import paq_vistas.devoluciones.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class OyenteDevolucionPrincipal implements ActionListener {

    private final PanelDevolucionPrincipal panelDev;
    private final PanelDevolucion panelDevolucion;
    private final PanelCatalogoDev panelCatalogoDev;

    public OyenteDevolucionPrincipal(PanelDevolucionPrincipal panelDev) {
        this.panelDev = panelDev;
        this.panelDevolucion = new PanelDevolucion();
        this.panelCatalogoDev = new PanelCatalogoDev();
        panelDev.getPanelCentro().add(panelDevolucion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component[] botones = panelDev.getPanelNorte().getComponents();
        JPanel panelCentro = panelDev.getPanelCentro();
        JButton bt_devolucion = (JButton) e.getSource();
        panelCentro.removeAll();
        switch (bt_devolucion.getName()) {
            case "devolucion":
                panelCentro.add(panelDevolucion);
                break;
            case "ventas":
                panelCentro.add(panelCatalogoDev);
        }
        bt_devolucion.setEnabled(false);
        for (int i = 0; i < botones.length; i++) {
            if (!botones[i].getName().equals(bt_devolucion.getName())) {
                botones[i].setEnabled(true);
            }
        }
        panelCentro.revalidate();
        panelCentro.repaint();
    }
}
