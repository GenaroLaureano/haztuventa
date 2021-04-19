package paq_vistas.general;

import paq_controladores.general.OyenteInventario;
import javax.swing.*;

public final class PanelInventario extends javax.swing.JPanel {

    public PanelInventario() {
        initComponents();
        addEventos(new OyenteInventario(this));
    }

    public void addEventos(OyenteInventario e) {
        this.comboDepartamentoC.addActionListener(e);
        this.comboDepartamentoC.setName("categoria");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCatalogo = new javax.swing.JPanel();
        panelSuperiorC = new javax.swing.JPanel();
        et_departamento = new javax.swing.JLabel();
        comboDepartamentoC = new javax.swing.JComboBox<>();
        panelCentralC = new javax.swing.JScrollPane();
        tb_inventario = new javax.swing.JTable();

        panelCatalogo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelCatalogo.setLayout(new java.awt.BorderLayout());

        panelSuperiorC.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        et_departamento.setText("Departamento");
        panelSuperiorC.add(et_departamento);

        comboDepartamentoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Piso", "Almacen" }));
        panelSuperiorC.add(comboDepartamentoC);

        panelCatalogo.add(panelSuperiorC, java.awt.BorderLayout.NORTH);

        panelCentralC.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentralC.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelCentralC.setMaximumSize(new java.awt.Dimension(50000, 32767));
        panelCentralC.setMinimumSize(new java.awt.Dimension(100, 100));
        panelCentralC.setPreferredSize(new java.awt.Dimension(1300,500));

        tb_inventario.setBackground(getBackground());
        tb_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "CATEGORIA", "ENTRADAS", "SALIDAS", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_inventario.setEnabled(false);
        tb_inventario.setShowHorizontalLines(false);
        tb_inventario.setShowVerticalLines(false);
        tb_inventario.getTableHeader().setReorderingAllowed(false);
        panelCentralC.setViewportView(tb_inventario);
        if (tb_inventario.getColumnModel().getColumnCount() > 0) {
            tb_inventario.getColumnModel().getColumn(0).setResizable(false);
            tb_inventario.getColumnModel().getColumn(1).setResizable(false);
            tb_inventario.getColumnModel().getColumn(2).setResizable(false);
            tb_inventario.getColumnModel().getColumn(3).setResizable(false);
            tb_inventario.getColumnModel().getColumn(4).setResizable(false);
        }

        panelCatalogo.add(panelCentralC, java.awt.BorderLayout.CENTER);

        add(panelCatalogo);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDepartamentoC;
    private javax.swing.JLabel et_departamento;
    private javax.swing.JPanel panelCatalogo;
    private javax.swing.JScrollPane panelCentralC;
    private javax.swing.JPanel panelSuperiorC;
    private javax.swing.JTable tb_inventario;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getComboDepartamentoC() {
        return comboDepartamentoC;
    }

    public JTable getTablaC() {
        return tb_inventario;
    }

}
