package paq_vistas.principal;

import paq_controladores.principal.OyenteSaldoInicial;
import javax.swing.JTextField;

public final class PanelSaldoInicial extends javax.swing.JPanel {

    public PanelSaldoInicial() {
        initComponents();
        addEventos(new OyenteSaldoInicial(this));
    }

    public void addEventos(OyenteSaldoInicial e) {
        this.bt_aceptar.addActionListener(e);
        this.tx_cantidad.addKeyListener(e);

        this.bt_aceptar.setName("aceptar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentro = new javax.swing.JPanel();
        et_cantidad = new javax.swing.JLabel();
        tx_cantidad = new javax.swing.JTextField();
        bt_aceptar = new javax.swing.JButton();

        panelCentro.setLayout(new java.awt.GridLayout(3, 1));

        et_cantidad.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_cantidad.setText("Ingrese saldo inicial:");
        panelCentro.add(et_cantidad);
        panelCentro.add(tx_cantidad);

        bt_aceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_aceptar.setText("Aceptar");
        bt_aceptar.setPreferredSize(new java.awt.Dimension(150, 50));
        panelCentro.add(bt_aceptar);

        add(panelCentro);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel et_cantidad;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JTextField tx_cantidad;
    // End of variables declaration//GEN-END:variables

    public JTextField getcCantidad() {
        return tx_cantidad;
    }
}
