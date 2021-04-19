package paq_vistas.clientes;

import paq_controladores.clientes.OyenteCamposModificarCliente;
import javax.swing.*;
import paq_modelos.db.ModSQLClientes;

public class VentanaCamposModificarCliente extends javax.swing.JDialog {

    private long telefono;
    private JTable tb_clientes;
    private JTextField tx_clientes;

    public VentanaCamposModificarCliente(ModSQLClientes sqlClientes, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        addEventos(new OyenteCamposModificarCliente(sqlClientes, this));
    }

    public final void addEventos(OyenteCamposModificarCliente oyente) {
        this.bt_cancelar.addActionListener(oyente);
        this.bt_guardar.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_gruposexos = new javax.swing.ButtonGroup();
        panelModCliente = new javax.swing.JPanel();
        panelSurBotones = new javax.swing.JPanel();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        panelCentroCampos = new javax.swing.JPanel();
        panelEtiquetas = new javax.swing.JPanel();
        et_nombre = new javax.swing.JLabel();
        et_apellidop = new javax.swing.JLabel();
        et_apellidom = new javax.swing.JLabel();
        et_sexo = new javax.swing.JLabel();
        et_telefono = new javax.swing.JLabel();
        et_email = new javax.swing.JLabel();
        panelCampos = new javax.swing.JPanel();
        tx_nombre = new javax.swing.JTextField();
        tx_apellidop = new javax.swing.JTextField();
        tx_apellidom = new javax.swing.JTextField();
        panelSexo = new javax.swing.JPanel();
        bt_masculino = new javax.swing.JRadioButton();
        bt_femenino = new javax.swing.JRadioButton();
        bt_otro = new javax.swing.JRadioButton();
        tx_telefono = new javax.swing.JTextField();
        tx_email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelModCliente.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        panelModCliente.setLayout(new java.awt.BorderLayout());

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

        panelModCliente.add(panelSurBotones, java.awt.BorderLayout.PAGE_END);

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

        et_sexo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_sexo.setText("Sexo:");
        panelEtiquetas.add(et_sexo);

        et_telefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_telefono.setText("Telefono:");
        panelEtiquetas.add(et_telefono);

        et_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_email.setText("Email:");
        panelEtiquetas.add(et_email);

        panelCentroCampos.add(panelEtiquetas, java.awt.BorderLayout.WEST);

        panelCampos.setLayout(new java.awt.GridLayout(6, 1, 0, 15));

        tx_nombre.setColumns(20);
        panelCampos.add(tx_nombre);

        tx_apellidop.setColumns(20);
        panelCampos.add(tx_apellidop);

        tx_apellidom.setColumns(20);
        panelCampos.add(tx_apellidom);

        panelSexo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_gruposexos.add(bt_masculino);
        bt_masculino.setText("M");
        bt_masculino.setActionCommand("m");
        panelSexo.add(bt_masculino);

        bt_gruposexos.add(bt_femenino);
        bt_femenino.setText("F");
        bt_femenino.setActionCommand("f");
        panelSexo.add(bt_femenino);

        bt_gruposexos.add(bt_otro);
        bt_otro.setText("Otro");
        bt_otro.setActionCommand("otro");
        panelSexo.add(bt_otro);

        panelCampos.add(panelSexo);

        tx_telefono.setColumns(20);
        panelCampos.add(tx_telefono);

        tx_email.setColumns(20);
        panelCampos.add(tx_email);

        panelCentroCampos.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelModCliente.add(panelCentroCampos, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelModCliente, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setTelefonoCopia(long telefono) {
        this.telefono = telefono;
    }

    public long getTelefonoCopia() {
        return telefono;
    }

    public javax.swing.JTextField getCampoApellidoM() {
        return tx_apellidom;
    }

    public javax.swing.JTextField getCampoApellidoP() {
        return tx_apellidop;
    }

    public javax.swing.JTextField getCampoEmail() {
        return tx_email;
    }

    public javax.swing.JTextField getCampoNombre() {
        return tx_nombre;
    }

    public javax.swing.JTextField getCampoTelefono() {
        return tx_telefono;
    }

    public javax.swing.JRadioButton getRadioBotonF() {
        return bt_femenino;
    }

    public javax.swing.JRadioButton getRadioBotonM() {
        return bt_masculino;
    }

    public javax.swing.JRadioButton getRadioBotonOtro() {
        return bt_otro;
    }

    public javax.swing.ButtonGroup getGrupoSexos() {
        return bt_gruposexos;
    }

    public JTable getTablaClientes() {
        return tb_clientes;
    }

    public void setTablaClientes(JTable tb_clientes) {
        this.tb_clientes = tb_clientes;
    }

    public JTextField getCampoCliente() {
        return tx_clientes;
    }

    public void setCampoCliente(JTextField tx_clientes) {
        this.tx_clientes = tx_clientes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JRadioButton bt_femenino;
    private javax.swing.ButtonGroup bt_gruposexos;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JRadioButton bt_masculino;
    private javax.swing.JRadioButton bt_otro;
    private javax.swing.JLabel et_apellidom;
    private javax.swing.JLabel et_apellidop;
    private javax.swing.JLabel et_email;
    private javax.swing.JLabel et_nombre;
    private javax.swing.JLabel et_sexo;
    private javax.swing.JLabel et_telefono;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelCentroCampos;
    private javax.swing.JPanel panelEtiquetas;
    private javax.swing.JPanel panelModCliente;
    private javax.swing.JPanel panelSexo;
    private javax.swing.JPanel panelSurBotones;
    private javax.swing.JTextField tx_apellidom;
    private javax.swing.JTextField tx_apellidop;
    private javax.swing.JTextField tx_email;
    private javax.swing.JTextField tx_nombre;
    private javax.swing.JTextField tx_telefono;
    // End of variables declaration//GEN-END:variables
}
