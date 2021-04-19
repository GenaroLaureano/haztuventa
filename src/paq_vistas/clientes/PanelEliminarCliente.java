package paq_vistas.clientes;

import paq_controladores.clientes.OyenteEliminarCliente;
import paq_modelos.db.ModSQLClientes;

public class PanelEliminarCliente extends javax.swing.JPanel {

    public PanelEliminarCliente(ModSQLClientes sqlClientes) {
        initComponents();
        addEventos(new OyenteEliminarCliente(sqlClientes, this));
    }

    public final void addEventos(OyenteEliminarCliente oyente) {
        this.bt_aceptar.addActionListener(oyente);
        this.tx_cliente.getDocument().addDocumentListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorteTextos = new javax.swing.JPanel();
        et_eliminarcliente = new javax.swing.JLabel();
        et_infoeliminar = new javax.swing.JLabel();
        panelCentroTabla = new javax.swing.JPanel();
        tx_cliente = new javax.swing.JTextField();
        panelTabla = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        panelBoton = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setLayout(new java.awt.BorderLayout());

        panelNorteTextos.setLayout(new java.awt.GridLayout(2, 0));

        et_eliminarcliente.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        et_eliminarcliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_eliminarcliente.setText("Eliminar Cliente");
        panelNorteTextos.add(et_eliminarcliente);

        et_infoeliminar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        et_infoeliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_infoeliminar.setText("Teclee el Número o Nombre del Cliente:");
        panelNorteTextos.add(et_infoeliminar);

        add(panelNorteTextos, java.awt.BorderLayout.PAGE_START);

        panelCentroTabla.setLayout(new java.awt.BorderLayout());
        panelCentroTabla.add(tx_cliente, java.awt.BorderLayout.PAGE_START);

        panelTabla.setPreferredSize(new java.awt.Dimension(454, 200));

        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(tb_clientes);

        panelCentroTabla.add(panelTabla, java.awt.BorderLayout.CENTER);

        add(panelCentroTabla, java.awt.BorderLayout.CENTER);

        panelBoton.setLayout(new java.awt.BorderLayout(0, 10));

        bt_aceptar.setText("Aceptar");
        bt_aceptar.setName("bt_aceptar"); // NOI18N
        bt_aceptar.setPreferredSize(new java.awt.Dimension(97, 50));
        panelBoton.add(bt_aceptar, java.awt.BorderLayout.PAGE_END);

        add(panelBoton, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTable getTablaClientes() {
        return tb_clientes;
    }

    public javax.swing.JTextField getCampoCliente() {
        return tx_cliente;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel et_eliminarcliente;
    private javax.swing.JLabel et_infoeliminar;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCentroTabla;
    private javax.swing.JPanel panelNorteTextos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTextField tx_cliente;
    // End of variables declaration//GEN-END:variables
}
