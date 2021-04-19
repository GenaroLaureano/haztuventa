package paq_vistas.devoluciones;

import paq_controladores.devoluciones.OyenteDevolucionPrincipal;
import javax.swing.JPanel;

public final class PanelDevolucionPrincipal extends javax.swing.JPanel {

    public PanelDevolucionPrincipal() {
        initComponents();
        addEventos(new OyenteDevolucionPrincipal(this));
    }

    public void addEventos(OyenteDevolucionPrincipal oyente) {
        this.bt_devolucion.addActionListener(oyente);
        this.bt_ventas.addActionListener(oyente);

        this.bt_devolucion.setName("devolucion");
        this.bt_ventas.setName("ventas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        bt_devolucion = new javax.swing.JButton();
        bt_ventas = new javax.swing.JButton();
        panelCentro = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_devolucion.setText("Devoluciones");
        bt_devolucion.setPreferredSize(new java.awt.Dimension(120, 50));
        panelNorte.add(bt_devolucion);

        bt_ventas.setText("Ventas");
        bt_ventas.setPreferredSize(new java.awt.Dimension(105, 50));
        panelNorte.add(bt_ventas);

        add(panelNorte, java.awt.BorderLayout.NORTH);
        add(panelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_devolucion;
    private javax.swing.JButton bt_ventas;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables

    public JPanel getPanelNorte() {
        return panelNorte;
    }

    public JPanel getPanelCentro() {
        return panelCentro;
    }
}
