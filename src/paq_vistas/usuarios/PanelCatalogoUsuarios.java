package paq_vistas.usuarios;

import paq_controladores.usuarios.OyenteListarUsuarios;
import java.sql.*;
import javax.swing.*;
import paq_modelos.db.ModSQLUsuario;

public final class PanelCatalogoUsuarios extends javax.swing.JPanel {

    private final ModSQLUsuario sqlUsuario;

    public PanelCatalogoUsuarios(ModSQLUsuario sqlUsuarios) {
        initComponents();
        this.sqlUsuario = sqlUsuarios;
        cargarCargos();
        addEventos(new OyenteListarUsuarios(sqlUsuarios, this));
    }

    public final void addEventos(OyenteListarUsuarios e) {
        this.comboDepartamentoC.addActionListener(e);
        this.comboDepartamentoC.setName("categoria");
    }

    public void cargarCargos() {

        ResultSet r = sqlUsuario.cargarCargos();
        try {
            while (r.next()) {
                this.getComboDepartamentoC().addItem(r.getString("NOMBRE_CARGO"));
            }
        } catch (SQLException ex) {
            System.out.println("En evento de ventana: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCatalogo = new javax.swing.JPanel();
        panelSuperiorC = new javax.swing.JPanel();
        et_cargo = new javax.swing.JLabel();
        comboDepartamentoC = new javax.swing.JComboBox<>();
        panelCentralC = new javax.swing.JScrollPane();
        tb_catalogo = new javax.swing.JTable();

        panelCatalogo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catálogo de Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelCatalogo.setLayout(new java.awt.BorderLayout());

        panelSuperiorC.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        et_cargo.setText("Cargo");
        panelSuperiorC.add(et_cargo);

        comboDepartamentoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        panelSuperiorC.add(comboDepartamentoC);

        panelCatalogo.add(panelSuperiorC, java.awt.BorderLayout.NORTH);

        panelCentralC.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentralC.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelCentralC.setMaximumSize(new java.awt.Dimension(50000, 32767));
        panelCentralC.setMinimumSize(new java.awt.Dimension(100, 100));
        panelCentralC.setPreferredSize(new java.awt.Dimension(1300,500));

        tb_catalogo.setBackground(getBackground());
        tb_catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "NICK", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_catalogo.setEnabled(false);
        tb_catalogo.setShowHorizontalLines(false);
        tb_catalogo.setShowVerticalLines(false);
        tb_catalogo.getTableHeader().setReorderingAllowed(false);
        panelCentralC.setViewportView(tb_catalogo);
        if (tb_catalogo.getColumnModel().getColumnCount() > 0) {
            tb_catalogo.getColumnModel().getColumn(0).setResizable(false);
            tb_catalogo.getColumnModel().getColumn(1).setResizable(false);
            tb_catalogo.getColumnModel().getColumn(2).setResizable(false);
            tb_catalogo.getColumnModel().getColumn(3).setResizable(false);
        }

        panelCatalogo.add(panelCentralC, java.awt.BorderLayout.CENTER);

        add(panelCatalogo);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDepartamentoC;
    private javax.swing.JLabel et_cargo;
    private javax.swing.JPanel panelCatalogo;
    private javax.swing.JScrollPane panelCentralC;
    private javax.swing.JPanel panelSuperiorC;
    private javax.swing.JTable tb_catalogo;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getComboDepartamentoC() {
        return comboDepartamentoC;
    }

    public JTable getTablaC() {
        return tb_catalogo;
    }

}
