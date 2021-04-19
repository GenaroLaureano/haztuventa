package paq_vistas.clientes;

import paq_controladores.clientes.OyenteBotonesClientes;
import javax.swing.JPanel;
import paq_modelos.db.ModSQLClientes;

public class PanelClientes extends javax.swing.JPanel {

    public PanelClientes() {
        initComponents();
        ModSQLClientes sqlClientes = new ModSQLClientes();
        OyenteBotonesClientes oyente = new OyenteBotonesClientes(sqlClientes, this);
        addEventos(oyente);
        this.bt_nuevocliente.setEnabled(false);
    }

    public final void addEventos(OyenteBotonesClientes oyente) {
        this.bt_eliminarcliente.addActionListener(oyente);
        this.bt_modificarcliente.addActionListener(oyente);
        this.bt_nuevocliente.addActionListener(oyente);
        this.bt_todos.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        bt_nuevocliente = new javax.swing.JButton();
        bt_modificarcliente = new javax.swing.JButton();
        bt_eliminarcliente = new javax.swing.JButton();
        bt_todos = new javax.swing.JButton();
        panelCentro = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 24))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_nuevocliente.setText("Nuevo Cliente");
        bt_nuevocliente.setFocusable(false);
        bt_nuevocliente.setName("nuevoCliente"); // NOI18N
        bt_nuevocliente.setPreferredSize(new java.awt.Dimension(150, 50));
        panelNorte.add(bt_nuevocliente);

        bt_modificarcliente.setText("Modificar Cliente");
        bt_modificarcliente.setFocusable(false);
        bt_modificarcliente.setName("modificarCliente"); // NOI18N
        bt_modificarcliente.setPreferredSize(new java.awt.Dimension(150, 50));
        panelNorte.add(bt_modificarcliente);

        bt_eliminarcliente.setText("Eliminar Cliente");
        bt_eliminarcliente.setFocusable(false);
        bt_eliminarcliente.setName("eliminarCliente"); // NOI18N
        bt_eliminarcliente.setPreferredSize(new java.awt.Dimension(150, 50));
        panelNorte.add(bt_eliminarcliente);

        bt_todos.setText("Clientes");
        bt_todos.setName("todosClientes"); // NOI18N
        bt_todos.setPreferredSize(new java.awt.Dimension(105, 50));
        panelNorte.add(bt_todos);

        add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelCentro.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        add(panelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPanelCentro() {
        return panelCentro;
    }

    public JPanel getPanelNorte() {
        return panelNorte;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_eliminarcliente;
    private javax.swing.JButton bt_modificarcliente;
    private javax.swing.JButton bt_nuevocliente;
    private javax.swing.JButton bt_todos;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables
}
