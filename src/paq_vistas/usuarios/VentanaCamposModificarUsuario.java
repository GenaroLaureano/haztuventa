package paq_vistas.usuarios;

import paq_controladores.usuarios.OyenteCamposModificarUsuario;
import java.sql.*;
import javax.swing.*;
import paq_modelos.db.ModSQLUsuario;

public final class VentanaCamposModificarUsuario extends javax.swing.JDialog {

    private String st_nick;
    private JTable tb_usuario;
    private JTextField tx_usuario;
    private final ModSQLUsuario sqlUsuario;

    public VentanaCamposModificarUsuario(ModSQLUsuario sqlUsuario, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.sqlUsuario = sqlUsuario;
        cargarCargos();
        addEventos(new OyenteCamposModificarUsuario(sqlUsuario, this));
    }

    public final void addEventos(OyenteCamposModificarUsuario oyente) {
        this.bt_cancelar.addActionListener(oyente);
        this.bt_guardar.addActionListener(oyente);

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

        bt_gruposexos = new javax.swing.ButtonGroup();
        panelBorderLine = new javax.swing.JPanel();
        panelSurBotones = new javax.swing.JPanel();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        panelCentroCampos = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        et_nombre = new javax.swing.JLabel();
        et_apellidop = new javax.swing.JLabel();
        et_apellidom = new javax.swing.JLabel();
        et_nick = new javax.swing.JLabel();
        et_email = new javax.swing.JLabel();
        et_cargo = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        tx_nombre = new javax.swing.JTextField();
        tx_apellidop = new javax.swing.JTextField();
        tx_apellidom = new javax.swing.JTextField();
        tx_nick = new javax.swing.JTextField();
        tx_contrasena = new javax.swing.JTextField();
        comboCargo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelBorderLine.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        panelBorderLine.setLayout(new java.awt.BorderLayout());

        panelSurBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        bt_guardar.setText("Guardar Cambios");
        bt_guardar.setToolTipText("");
        bt_guardar.setName("botonGuardarCambios"); // NOI18N
        bt_guardar.setPreferredSize(new java.awt.Dimension(141, 50));
        panelSurBotones.add(bt_guardar);

        bt_cancelar.setText("Cancelar");
        bt_cancelar.setName("bt_cancelar"); // NOI18N
        bt_cancelar.setPreferredSize(new java.awt.Dimension(98, 50));
        panelSurBotones.add(bt_cancelar);

        panelBorderLine.add(panelSurBotones, java.awt.BorderLayout.PAGE_END);

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

        et_nick.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_nick.setText("Nick:");
        panelEtiquetas.add(et_nick);

        et_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_email.setText("Contraseña:");
        panelEtiquetas.add(et_email);

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

        tx_nick.setColumns(20);
        panelCampos.add(tx_nick);

        tx_contrasena.setColumns(20);
        panelCampos.add(tx_contrasena);

        panelCampos.add(comboCargo);

        panelCentroCampos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelBorderLine.add(panelCentroCampos, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelBorderLine, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setNick(String st_nick) {
        this.st_nick = st_nick;
    }

    public String getNick() {
        return st_nick;
    }

    public JTextField getCampoUsuario() {
        return tx_usuario;
    }

    public void setCampoUsuario(JTextField tx_usuario) {
        this.tx_usuario = tx_usuario;
    }

    public JTextField getCampoApellidoM() {
        return tx_apellidom;
    }

    public void setCampoApellidoM(JTextField tx_apellidom) {
        this.tx_apellidom = tx_apellidom;
    }

    public JTextField getCampoApellidoP() {
        return tx_apellidop;
    }

    public void setCampoApellidoP(JTextField tx_apellidop) {
        this.tx_apellidop = tx_apellidop;
    }

    public JTextField getCampoContrasenal() {
        return tx_contrasena;
    }

    public void setCampoContrasenal(JTextField tx_contrasena) {
        this.tx_contrasena = tx_contrasena;
    }

    public JTextField getCampoNick() {
        return tx_nick;
    }

    public void setCampoNick(JTextField tx_nick) {
        this.tx_nick = tx_nick;
    }

    public JTextField getCampoNombre() {
        return tx_nombre;
    }

    public void setCampoNombre(JTextField tx_nombre) {
        this.tx_nombre = tx_nombre;
    }

    public JComboBox<String> getComboCargo() {
        return comboCargo;
    }

    public void setComboCargo(JComboBox<String> comboCargo) {
        this.comboCargo = comboCargo;
    }

    public JTable getTablaUsuario() {
        return tb_usuario;
    }

    public void setTablaUsuario(JTable tb_usuario) {
        this.tb_usuario = tb_usuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.ButtonGroup bt_gruposexos;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JComboBox<String> comboCargo;
    private javax.swing.JLabel et_apellidom;
    private javax.swing.JLabel et_apellidop;
    private javax.swing.JLabel et_cargo;
    private javax.swing.JLabel et_email;
    private javax.swing.JLabel et_nick;
    private javax.swing.JLabel et_nombre;
    private javax.swing.JPanel panelBorderLine;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelCentroCampos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelSurBotones;
    private javax.swing.JTextField tx_apellidom;
    private javax.swing.JTextField tx_apellidop;
    private javax.swing.JTextField tx_contrasena;
    private javax.swing.JTextField tx_nick;
    private javax.swing.JTextField tx_nombre;
    // End of variables declaration//GEN-END:variables
}
