package paq_vistas.devoluciones;

import paq_controladores.devoluciones.OyenteDevoluciones;
import javax.swing.*;
import paq_modelos.db.ModSQLVentas;

public final class PanelDevolucion extends javax.swing.JPanel {

    public PanelDevolucion() {
        initComponents();
        ModSQLVentas sqlVentas = new ModSQLVentas();
        addEventos(new OyenteDevoluciones(this, sqlVentas));
    }

    public void addEventos(OyenteDevoluciones oyente) {
        this.bt_aceptar.addActionListener(oyente);
        this.tx_codigo.addKeyListener(oyente);

        this.bt_aceptar.setName("aceptar");
        this.tx_codigo.setName("codigo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInventario = new javax.swing.JPanel();
        panelCodigo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tx_codigo = new javax.swing.JTextField();
        bt_aceptar = new javax.swing.JButton();

        panelInventario.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Ingrese Folio Venta");
        panelCodigo.add(jLabel1);

        tx_codigo.setColumns(20);
        panelCodigo.add(tx_codigo);

        bt_aceptar.setText("Aceptar");
        bt_aceptar.setPreferredSize(new java.awt.Dimension(105, 30));
        panelCodigo.add(bt_aceptar);

        panelInventario.add(panelCodigo, java.awt.BorderLayout.CENTER);

        add(panelInventario);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JTextField tx_codigo;
    // End of variables declaration//GEN-END:variables

    public JButton getbAceptar() {
        return bt_aceptar;
    }

    public JTextField getcCodigo() {
        return tx_codigo;
    }

}
