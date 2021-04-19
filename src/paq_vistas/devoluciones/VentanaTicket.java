package paq_vistas.devoluciones;

import paq_controladores.devoluciones.OyenteTicket;
import javax.swing.*;
import paq_modelos.db.ModSQLVentas;

public final class VentanaTicket extends javax.swing.JDialog {

    public VentanaTicket(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ModSQLVentas sqlVentas = new ModSQLVentas();
        addEventos(new OyenteTicket(sqlVentas, this));
    }

    public void addEventos(OyenteTicket e) {
        this.bt_cancelar.addActionListener(e);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdd = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        et_folio = new javax.swing.JLabel();
        et_folios = new javax.swing.JLabel();
        panelCentro = new javax.swing.JScrollPane();
        tb_ticket = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        panelCancelar = new javax.swing.JPanel();
        bt_cancelar = new javax.swing.JButton();
        et_total = new javax.swing.JLabel();
        et_totalventa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelAdd.setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        et_folio.setText("Folio:");
        panelNorte.add(et_folio);
        panelNorte.add(et_folios);

        panelAdd.add(panelNorte, java.awt.BorderLayout.NORTH);

        tb_ticket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPCION", "UNIDADES", "PRECIO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelCentro.setViewportView(tb_ticket);

        panelAdd.add(panelCentro, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        panelCancelar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 110, 5));

        bt_cancelar.setText("Cancelar Venta");
        panelCancelar.add(bt_cancelar);

        panelSur.add(panelCancelar);

        et_total.setText("TOTAL VENTA: ");
        panelSur.add(et_total);
        panelSur.add(et_totalventa);

        panelAdd.add(panelSur, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelAdd, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JLabel et_folio;
    private javax.swing.JLabel et_folios;
    private javax.swing.JLabel et_total;
    private javax.swing.JLabel et_totalventa;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelCancelar;
    private javax.swing.JScrollPane panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTable tb_ticket;
    // End of variables declaration//GEN-END:variables

    public JLabel getEtiquetaTotal() {
        return et_totalventa;
    }

    public JTable getTablaTicket() {
        return tb_ticket;
    }

    public JLabel getEtiquetaFolio() {
        return et_folios;
    }

    public JButton getBotonCancelar() {
        return bt_cancelar;
    }

}
