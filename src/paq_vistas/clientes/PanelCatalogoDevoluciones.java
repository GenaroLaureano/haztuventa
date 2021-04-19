package paq_vistas.clientes;

import paq_controladores.clientes.OyenteListarClientes;
import javax.swing.JComboBox;
import javax.swing.JTable;
import paq_modelos.db.ModSQLClientes;

public final class PanelCatalogoDevoluciones extends javax.swing.JPanel {

    public PanelCatalogoDevoluciones(ModSQLClientes sqlClientes) {
        initComponents();
        addEventos(new OyenteListarClientes(sqlClientes, this));
    }

    public void addEventos(OyenteListarClientes e) {
        this.comboDepartamento.addActionListener(e);
        this.comboDepartamento.setName("categoria");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCatalogo = new javax.swing.JPanel();
        panelSuperiorC = new javax.swing.JPanel();
        etiquetaCatalogo = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox<>();
        panelCentralC = new javax.swing.JScrollPane();
        tb_catalogo = new javax.swing.JTable();

        panelCatalogo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catálogo de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelCatalogo.setLayout(new java.awt.BorderLayout());

        panelSuperiorC.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        etiquetaCatalogo.setText("Sexo:");
        panelSuperiorC.add(etiquetaCatalogo);

        comboDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Mujer", "Hombre", "Otro" }));
        panelSuperiorC.add(comboDepartamento);

        panelCatalogo.add(panelSuperiorC, java.awt.BorderLayout.NORTH);

        panelCentralC.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentralC.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelCentralC.setMaximumSize(new java.awt.Dimension(50000, 32767));
        panelCentralC.setMinimumSize(new java.awt.Dimension(100, 100));
        panelCentralC.setPreferredSize(new java.awt.Dimension(1300,500));

        tb_catalogo.setBackground(getBackground());
        tb_catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "SEXO", "EMAIL", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            tb_catalogo.getColumnModel().getColumn(4).setResizable(false);
        }

        panelCatalogo.add(panelCentralC, java.awt.BorderLayout.CENTER);

        add(panelCatalogo);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDepartamento;
    private javax.swing.JLabel etiquetaCatalogo;
    private javax.swing.JPanel panelCatalogo;
    private javax.swing.JScrollPane panelCentralC;
    private javax.swing.JPanel panelSuperiorC;
    private javax.swing.JTable tb_catalogo;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getComboDepartamentoC() {
        return comboDepartamento;
    }

    public JTable getTablaC() {
        return tb_catalogo;
    }
}
