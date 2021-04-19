package paq_vistas.usuarios;

import paq_controladores.usuarios.OyenteBotonesUsuario;
import javax.swing.JPanel;
import paq_modelos.db.ModSQLUsuario;

public final class PanelUsuarios extends javax.swing.JPanel {

    public PanelUsuarios() {
        initComponents();
        ModSQLUsuario sqlUsuario = new ModSQLUsuario();
        OyenteBotonesUsuario oyente = new OyenteBotonesUsuario(sqlUsuario, this);
        addEventos(oyente);
        this.bt_nuevousuario.setEnabled(false);
    }

    public void addEventos(OyenteBotonesUsuario oyente) {
        this.bt_delusuario.addActionListener(oyente);
        this.bt_modusuario.addActionListener(oyente);
        this.bt_nuevousuario.addActionListener(oyente);
        this.bt_todos.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        bt_nuevousuario = new javax.swing.JButton();
        bt_modusuario = new javax.swing.JButton();
        bt_delusuario = new javax.swing.JButton();
        bt_todos = new javax.swing.JButton();
        panelCentro = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 24))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_nuevousuario.setText("Nuevo Usuario");
        bt_nuevousuario.setName("nuevoUsuario"); // NOI18N
        bt_nuevousuario.setPreferredSize(new java.awt.Dimension(150, 50));
        panelNorte.add(bt_nuevousuario);

        bt_modusuario.setText("Modificar Usuario");
        bt_modusuario.setName("modificarUsuario"); // NOI18N
        bt_modusuario.setPreferredSize(new java.awt.Dimension(150, 50));
        panelNorte.add(bt_modusuario);

        bt_delusuario.setLabel("EliminarUsuario");
        bt_delusuario.setName("eliminarUsuario"); // NOI18N
        bt_delusuario.setPreferredSize(new java.awt.Dimension(150, 50));
        panelNorte.add(bt_delusuario);

        bt_todos.setText("Usuarios");
        bt_todos.setName("listarTodos"); // NOI18N
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
    private javax.swing.JButton bt_delusuario;
    private javax.swing.JButton bt_modusuario;
    private javax.swing.JButton bt_nuevousuario;
    private javax.swing.JButton bt_todos;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables
}
