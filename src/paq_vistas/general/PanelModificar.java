package paq_vistas.general;

import paq_controladores.general.OyenteBuscarModificar;
import javax.swing.JTextField;

public class PanelModificar extends javax.swing.JPanel {

    public PanelModificar() {
        initComponents();
    }

    public void addEventos(OyenteBuscarModificar e) {
        this.bt_modifica.addActionListener(e);
        this.tx_modifica.addKeyListener(e);
        this.bt_modifica.setName("aceptar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        tx_modifica = new javax.swing.JTextField();
        bt_modifica = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        setLayout(flowLayout1);

        panelCentral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modifica Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelCentral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelCentral.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        tx_modifica.setColumns(20);
        tx_modifica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tx_modifica.setToolTipText("");
        panelCentral.add(tx_modifica);

        bt_modifica.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_modifica.setText("Aceptar");
        bt_modifica.setPreferredSize(new java.awt.Dimension(150, 30));
        panelCentral.add(bt_modifica);

        add(panelCentral);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_modifica;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JTextField tx_modifica;
    // End of variables declaration//GEN-END:variables

    public JTextField getCampoModifica() {
        return tx_modifica;
    }
}
