package paq_vistas.usuarios;

import paq_controladores.usuarios.OyenteNuevoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import paq_modelos.db.ModSQLUsuario;

public final class PanelNuevoUsuario extends javax.swing.JPanel {

    private final ModSQLUsuario sqlUsuario;

    public PanelNuevoUsuario(ModSQLUsuario sqlUsuario) {
        initComponents();
        this.sqlUsuario = sqlUsuario;
        OyenteNuevoUsuario oyente = new OyenteNuevoUsuario(sqlUsuario, this);
        addOyente(oyente);
        cargarCargos();
    }

    public void addOyente(OyenteNuevoUsuario e) {
        this.bt_guardar.addActionListener(e);
        this.bt_cancelar.addActionListener(e);
        this.bt_guardar.setName("guardar");
        this.bt_cancelar.setName("cancelar");
    }

    public void cargarCargos() {
        try {
            ResultSet r = sqlUsuario.cargarCargos();

            while (r.next()) {
                this.getComboCargo().addItem(r.getString("NOMBRE_CARGO"));
            }
            r.close();

        } catch (SQLException ex) {
            System.out.println("En evento de ventana: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorteNuevoUsuario = new javax.swing.JPanel();
        et_nuevo = new javax.swing.JLabel();
        et_info = new javax.swing.JLabel();
        panelCentroCampos = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        et_nombre = new javax.swing.JLabel();
        et_apellidop = new javax.swing.JLabel();
        et_apellidom = new javax.swing.JLabel();
        et_nuevousuario = new javax.swing.JLabel();
        et_contrasena = new javax.swing.JLabel();
        et_cargo = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        tx_nombre = new javax.swing.JTextField();
        tx_apellidop = new javax.swing.JTextField();
        tx_apellidom = new javax.swing.JTextField();
        tx_usuario = new javax.swing.JTextField();
        tx_contrasena = new javax.swing.JTextField();
        comboCargo = new javax.swing.JComboBox<>();
        panelSurBotones = new javax.swing.JPanel();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setLayout(new java.awt.BorderLayout());

        panelNorteNuevoUsuario.setLayout(new java.awt.GridLayout(2, 0));

        et_nuevo.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        et_nuevo.setText("NUEVO USUARIO");
        panelNorteNuevoUsuario.add(et_nuevo);

        et_info.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        et_info.setText("Llene la siguiente información acerca del usuario");
        panelNorteNuevoUsuario.add(et_info);

        add(panelNorteNuevoUsuario, java.awt.BorderLayout.NORTH);

        panelCentroCampos.setLayout(new java.awt.BorderLayout());

        panelEtiquetas.setLayout(new java.awt.GridLayout(6, 1, 0, 15));

        et_nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_nombre.setText("Nombre:");
        panelEtiquetas.add(et_nombre);

        et_apellidop.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_apellidop.setText("Apellido Paterno:");
        panelEtiquetas.add(et_apellidop);

        et_apellidom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_apellidom.setText("Apellido Materno:");
        panelEtiquetas.add(et_apellidom);

        et_nuevousuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_nuevousuario.setText("Nombre de Usuario:");
        panelEtiquetas.add(et_nuevousuario);

        et_contrasena.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_contrasena.setText("Contraseña:");
        panelEtiquetas.add(et_contrasena);

        et_cargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_cargo.setText("Cargo:");
        panelEtiquetas.add(et_cargo);

        panelCentroCampos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setLayout(new java.awt.GridLayout(6, 1, 0, 15));

        tx_nombre.setColumns(20);
        panelCampos.add(tx_nombre);

        tx_apellidop.setColumns(20);
        panelCampos.add(tx_apellidop);

        tx_apellidom.setColumns(20);
        panelCampos.add(tx_apellidom);

        tx_usuario.setColumns(20);
        panelCampos.add(tx_usuario);

        tx_contrasena.setColumns(20);
        panelCampos.add(tx_contrasena);

        comboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        comboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCargoActionPerformed(evt);
            }
        });
        panelCampos.add(comboCargo);

        panelCentroCampos.add(panelCampos, java.awt.BorderLayout.CENTER);

        add(panelCentroCampos, java.awt.BorderLayout.CENTER);

        panelSurBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        bt_guardar.setText("Guardar Usuario");
        bt_guardar.setPreferredSize(new java.awt.Dimension(141, 50));
        panelSurBotones.add(bt_guardar);

        bt_cancelar.setText("Cancelar");
        bt_cancelar.setPreferredSize(new java.awt.Dimension(98, 50));
        panelSurBotones.add(bt_cancelar);

        add(panelSurBotones, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void comboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCargoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JComboBox<String> comboCargo;
    private javax.swing.JLabel et_apellidom;
    private javax.swing.JLabel et_apellidop;
    private javax.swing.JLabel et_cargo;
    private javax.swing.JLabel et_contrasena;
    private javax.swing.JLabel et_info;
    private javax.swing.JLabel et_nombre;
    private javax.swing.JLabel et_nuevo;
    private javax.swing.JLabel et_nuevousuario;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelCentroCampos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelNorteNuevoUsuario;
    private javax.swing.JPanel panelSurBotones;
    private javax.swing.JTextField tx_apellidom;
    private javax.swing.JTextField tx_apellidop;
    private javax.swing.JTextField tx_contrasena;
    private javax.swing.JTextField tx_nombre;
    private javax.swing.JTextField tx_usuario;
    // End of variables declaration//GEN-END:variables

    public JTextField getCampoApellidoM() {
        return tx_apellidom;
    }

    public JTextField getCampoApellidoP() {
        return tx_apellidop;
    }

    public JTextField getCampoContrseña() {
        return tx_contrasena;
    }

    public JTextField getCampoNombre() {
        return tx_nombre;
    }

    public JTextField getCampoUsuario() {
        return tx_usuario;
    }

    public JComboBox<String> getComboCargo() {
        return comboCargo;
    }
}
