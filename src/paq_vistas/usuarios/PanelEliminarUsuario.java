package paq_vistas.usuarios;

import paq_controladores.usuarios.OyenteEliminarUsuario;
import paq_modelos.db.ModSQLUsuario;

public class PanelEliminarUsuario extends javax.swing.JPanel {

    public PanelEliminarUsuario(ModSQLUsuario sqlUsuario) {
        initComponents();
        addEventos(new OyenteEliminarUsuario(sqlUsuario, this));
    }

    public final void addEventos(OyenteEliminarUsuario oyente) {
        this.bt_aceptar.addActionListener(oyente);
        this.tx_usuario.getDocument().addDocumentListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorteTextos = new javax.swing.JPanel();
        et_delusuario = new javax.swing.JLabel();
        et_delinfo = new javax.swing.JLabel();
        panelCentroTabla = new javax.swing.JPanel();
        tx_usuario = new javax.swing.JTextField();
        panelTabla = new javax.swing.JScrollPane();
        tb_usuario = new javax.swing.JTable();
        panelBoton = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setLayout(new java.awt.BorderLayout());

        panelNorteTextos.setLayout(new java.awt.GridLayout(2, 0));

        et_delusuario.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        et_delusuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_delusuario.setText("Eliminar Usuario");
        panelNorteTextos.add(et_delusuario);

        et_delinfo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        et_delinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_delinfo.setText("Teclee el Número o Nombre del Usuario:");
        panelNorteTextos.add(et_delinfo);

        add(panelNorteTextos, java.awt.BorderLayout.PAGE_START);

        panelCentroTabla.setLayout(new java.awt.BorderLayout());
        panelCentroTabla.add(tx_usuario, java.awt.BorderLayout.PAGE_START);

        panelTabla.setPreferredSize(new java.awt.Dimension(454, 200));

        tb_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "NICK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(tb_usuario);

        panelCentroTabla.add(panelTabla, java.awt.BorderLayout.CENTER);

        add(panelCentroTabla, java.awt.BorderLayout.CENTER);

        panelBoton.setLayout(new java.awt.BorderLayout(0, 10));

        bt_aceptar.setText("Aceptar");
        bt_aceptar.setName("bt_aceptar"); // NOI18N
        bt_aceptar.setPreferredSize(new java.awt.Dimension(97, 50));
        panelBoton.add(bt_aceptar, java.awt.BorderLayout.PAGE_END);

        add(panelBoton, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTable getTablaUsuario() {
        return tb_usuario;
    }

    public javax.swing.JTextField getCampoUsuario() {
        return tx_usuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel et_delinfo;
    private javax.swing.JLabel et_delusuario;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCentroTabla;
    private javax.swing.JPanel panelNorteTextos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tb_usuario;
    private javax.swing.JTextField tx_usuario;
    // End of variables declaration//GEN-END:variables

}
