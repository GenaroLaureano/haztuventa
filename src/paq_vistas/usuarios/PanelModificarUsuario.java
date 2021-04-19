package paq_vistas.usuarios;

import paq_controladores.usuarios.OyenteModificarUsuario;
import javax.swing.*;
import paq_modelos.db.ModSQLUsuario;

public class PanelModificarUsuario extends javax.swing.JPanel {

    public PanelModificarUsuario(ModSQLUsuario sqlUsuario) {
        initComponents();
        addEventos(new OyenteModificarUsuario(sqlUsuario, this));
    }
    
    public final void addEventos(OyenteModificarUsuario oyente){
        this.bt_aceptar.addActionListener(oyente);
        this.tx_usuario.getDocument().addDocumentListener(oyente);
        
    }

    public JTable getTablaUsuario() {
        return tb_usuario;
    }

    public JTextField getCampoUsuario() {
        return tx_usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorteTextos = new javax.swing.JPanel();
        et_modusuario = new javax.swing.JLabel();
        et_modinfo = new javax.swing.JLabel();
        panelCentroTabla = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        tb_usuario = new javax.swing.JTable();
        tx_usuario = new javax.swing.JTextField();
        panelBoton = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setLayout(new java.awt.BorderLayout());

        panelNorteTextos.setLayout(new java.awt.GridLayout(2, 0));

        et_modusuario.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        et_modusuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_modusuario.setText("Modificar Usuario");
        panelNorteTextos.add(et_modusuario);

        et_modinfo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        et_modinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_modinfo.setText("Teclee el Número o Nombre del Usuario:");
        panelNorteTextos.add(et_modinfo);

        add(panelNorteTextos, java.awt.BorderLayout.PAGE_START);

        panelCentroTabla.setLayout(new java.awt.BorderLayout());

        panelTabla.setPreferredSize(new java.awt.Dimension(454, 300));

        tb_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDO M", "APELLIDO P", "NICK"
            }
        ));
        panelTabla.setViewportView(tb_usuario);

        panelCentroTabla.add(panelTabla, java.awt.BorderLayout.CENTER);
        panelCentroTabla.add(tx_usuario, java.awt.BorderLayout.PAGE_START);

        add(panelCentroTabla, java.awt.BorderLayout.CENTER);

        panelBoton.setLayout(new java.awt.BorderLayout(0, 10));

        bt_aceptar.setText("Aceptar");
        bt_aceptar.setName(""); // NOI18N
        bt_aceptar.setPreferredSize(new java.awt.Dimension(97, 50));
        panelBoton.add(bt_aceptar, java.awt.BorderLayout.PAGE_END);

        add(panelBoton, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel et_modinfo;
    private javax.swing.JLabel et_modusuario;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCentroTabla;
    private javax.swing.JPanel panelNorteTextos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tb_usuario;
    private javax.swing.JTextField tx_usuario;
    // End of variables declaration//GEN-END:variables
}
