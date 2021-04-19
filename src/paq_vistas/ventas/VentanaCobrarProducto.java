package paq_vistas.ventas;

import paq_controladores.ventas.OyenteCobrarProducto;
import javax.swing.*;
import paq_modelos.db.ModSQLVentas;

public class VentanaCobrarProducto extends javax.swing.JDialog {

    private final ModSQLVentas sqlVentas;
    private JLabel et_numproductos;
    private JLabel et_montoventas;
    private JButton bt_cobrarproductos;

    public VentanaCobrarProducto(ModSQLVentas sqlVentas, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.sqlVentas = sqlVentas;
        addEventos(new OyenteCobrarProducto(sqlVentas, this));
    }

    public final void addEventos(OyenteCobrarProducto oyente) {
        this.bt_cobrar.addActionListener(oyente);
        this.bt_cancelar.addActionListener(oyente);
        this.tx_cantpago.addKeyListener(oyente);
        this.tx_cantpago.requestFocus();
        this.bt_cliente.addActionListener(oyente);
        this.bt_publico.addActionListener(oyente);
        this.bt_cliente.addKeyListener(oyente);
        this.bt_publico.addKeyListener(oyente);
        this.addWindowListener(oyente);
        this.tx_cantpago.getDocument().addDocumentListener(oyente);
        this.bt_pagotarjeta.addActionListener(oyente);
        this.bt_pagoefectivo.addActionListener(oyente);
        this.bt_pagovales.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_grupoclientes = new javax.swing.ButtonGroup();
        bt_grupomodopago = new javax.swing.ButtonGroup();
        panelCobro = new javax.swing.JPanel();
        panelMuestra = new javax.swing.JPanel();
        panelBotonesCobrar = new javax.swing.JPanel();
        bt_cobrar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        et_totalarticulos = new javax.swing.JLabel();
        et_numarticulos = new javax.swing.JLabel();
        panelCobrar = new javax.swing.JPanel();
        panelComponentesCobrar = new javax.swing.JPanel();
        panelBorderCliente = new javax.swing.JPanel();
        panelTipoCliente = new javax.swing.JPanel();
        bt_publico = new javax.swing.JRadioButton();
        bt_cliente = new javax.swing.JRadioButton();
        et_nombrecliente = new javax.swing.JLabel();
        et_cantmonto = new javax.swing.JLabel();
        panelCamposCambio = new javax.swing.JPanel();
        panelModoPago = new javax.swing.JPanel();
        et_modopago = new javax.swing.JLabel();
        bt_pagoefectivo = new javax.swing.JRadioButton();
        bt_pagotarjeta = new javax.swing.JRadioButton();
        bt_pagovales = new javax.swing.JRadioButton();
        panelCampoCantidadPago = new javax.swing.JPanel();
        et_pagocon = new javax.swing.JLabel();
        tx_cantpago = new javax.swing.JTextField();
        panelTextoCambio = new javax.swing.JPanel();
        et_cambio = new javax.swing.JLabel();
        et_cantcambio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelCobro.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        panelCobro.setLayout(new java.awt.BorderLayout());

        panelMuestra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 36))); // NOI18N

        panelBotonesCobrar.setLayout(new java.awt.GridLayout(4, 0));

        bt_cobrar.setText("Cobrar");
        bt_cobrar.setName("bt_cobrar"); // NOI18N
        bt_cobrar.setPreferredSize(new java.awt.Dimension(120, 50));
        panelBotonesCobrar.add(bt_cobrar);

        bt_cancelar.setText("Cancelar");
        bt_cancelar.setName("bt_cancelar"); // NOI18N
        bt_cancelar.setPreferredSize(new java.awt.Dimension(120, 50));
        panelBotonesCobrar.add(bt_cancelar);

        et_totalarticulos.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        et_totalarticulos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_totalarticulos.setText("Total de Articulos:");
        panelBotonesCobrar.add(et_totalarticulos);

        et_numarticulos.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        et_numarticulos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_numarticulos.setText("0");
        panelBotonesCobrar.add(et_numarticulos);

        panelMuestra.add(panelBotonesCobrar);

        panelCobro.add(panelMuestra, java.awt.BorderLayout.EAST);

        panelCobrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cobrar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 30))); // NOI18N
        panelCobrar.setLayout(new java.awt.BorderLayout());

        panelComponentesCobrar.setLayout(new java.awt.GridLayout(3, 0));

        panelBorderCliente.setLayout(new java.awt.BorderLayout());

        bt_grupoclientes.add(bt_publico);
        bt_publico.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        bt_publico.setSelected(true);
        bt_publico.setText("Publico en General");
        bt_publico.setActionCommand("publicoGeneral");
        bt_publico.setName("publicoGeneral"); // NOI18N
        panelTipoCliente.add(bt_publico);

        bt_grupoclientes.add(bt_cliente);
        bt_cliente.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        bt_cliente.setText("Cliente");
        bt_cliente.setActionCommand("cliente");
        bt_cliente.setName("cliente"); // NOI18N
        panelTipoCliente.add(bt_cliente);

        panelBorderCliente.add(panelTipoCliente, java.awt.BorderLayout.NORTH);

        et_nombrecliente.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        et_nombrecliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_nombrecliente.setText("PUBLICO EN GENERAL");
        panelBorderCliente.add(et_nombrecliente, java.awt.BorderLayout.CENTER);

        panelComponentesCobrar.add(panelBorderCliente);

        et_cantmonto.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        et_cantmonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_cantmonto.setText("$0.0");
        panelComponentesCobrar.add(et_cantmonto);

        panelCamposCambio.setLayout(new java.awt.BorderLayout());

        et_modopago.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        et_modopago.setText("Modo Pago:");
        panelModoPago.add(et_modopago);

        bt_grupomodopago.add(bt_pagoefectivo);
        bt_pagoefectivo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        bt_pagoefectivo.setSelected(true);
        bt_pagoefectivo.setText("Efectivo");
        bt_pagoefectivo.setActionCommand("publicoGeneral");
        bt_pagoefectivo.setName("efectivo"); // NOI18N
        panelModoPago.add(bt_pagoefectivo);

        bt_grupomodopago.add(bt_pagotarjeta);
        bt_pagotarjeta.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        bt_pagotarjeta.setText("Tarjeta");
        bt_pagotarjeta.setActionCommand("cliente");
        bt_pagotarjeta.setName("tarjeta"); // NOI18N
        panelModoPago.add(bt_pagotarjeta);

        bt_grupomodopago.add(bt_pagovales);
        bt_pagovales.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        bt_pagovales.setText("Vales");
        bt_pagovales.setName("vales"); // NOI18N
        panelModoPago.add(bt_pagovales);

        panelCamposCambio.add(panelModoPago, java.awt.BorderLayout.NORTH);

        panelCampoCantidadPago.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        et_pagocon.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        et_pagocon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_pagocon.setText("Pago con:");
        panelCampoCantidadPago.add(et_pagocon);

        tx_cantpago.setColumns(10);
        panelCampoCantidadPago.add(tx_cantpago);

        panelCamposCambio.add(panelCampoCantidadPago, java.awt.BorderLayout.CENTER);

        panelTextoCambio.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        et_cambio.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        et_cambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        et_cambio.setText("Su Cambio:");
        panelTextoCambio.add(et_cambio);

        et_cantcambio.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        et_cantcambio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_cantcambio.setText("$0.0");
        panelTextoCambio.add(et_cantcambio);

        panelCamposCambio.add(panelTextoCambio, java.awt.BorderLayout.SOUTH);

        panelComponentesCobrar.add(panelCamposCambio);

        panelCobrar.add(panelComponentesCobrar, java.awt.BorderLayout.CENTER);

        panelCobro.add(panelCobrar, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCobro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JLabel getEtiquetaCantidadCambio() {
        return et_cantcambio;
    }

    public JButton getBotonCobrarProductos() {
        return bt_cobrarproductos;
    }

    public void setBotonCobrarProductos(JButton bt_cobrarproductos) {
        this.bt_cobrarproductos = bt_cobrarproductos;
    }

    public javax.swing.JLabel getEtiquetaCantidadMonto() {
        return et_cantmonto;
    }

    public javax.swing.JLabel getEtiquetaNumeroArticulos() {
        return et_numarticulos;
    }

    public javax.swing.JTextField getCampoCantidadPago() {
        return tx_cantpago;
    }

    public javax.swing.ButtonGroup getGrupoClientes() {
        return bt_grupoclientes;
    }

    public javax.swing.JLabel getEtiquetaNombreCliente() {
        return et_nombrecliente;
    }

    public void setEtiquetaNumeroProductosVentas(JLabel et_numproductos) {
        this.et_numproductos = et_numproductos;
    }

    public javax.swing.JLabel getEtiquetaNumeroProductosVentas() {
        return et_numproductos;
    }

    public void setEtiquetaMontoVentas(JLabel et_montoventas) {
        this.et_montoventas = et_montoventas;
    }

    public JLabel getEtiquetaMontoVentas() {
        return et_montoventas;
    }

    public JRadioButton getGrupoModoPadoVales() {
        return bt_pagovales;
    }

    public JRadioButton getGrupoModoPagoEfectivo() {
        return bt_pagoefectivo;
    }

    public JRadioButton getGrupoModoPagoTarjeta() {
        return bt_pagotarjeta;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JRadioButton bt_cliente;
    private javax.swing.JButton bt_cobrar;
    private javax.swing.ButtonGroup bt_grupoclientes;
    private javax.swing.ButtonGroup bt_grupomodopago;
    private javax.swing.JRadioButton bt_pagoefectivo;
    private javax.swing.JRadioButton bt_pagotarjeta;
    private javax.swing.JRadioButton bt_pagovales;
    private javax.swing.JRadioButton bt_publico;
    private javax.swing.JLabel et_cambio;
    private javax.swing.JLabel et_cantcambio;
    private javax.swing.JLabel et_cantmonto;
    private javax.swing.JLabel et_modopago;
    private javax.swing.JLabel et_nombrecliente;
    private javax.swing.JLabel et_numarticulos;
    private javax.swing.JLabel et_pagocon;
    private javax.swing.JLabel et_totalarticulos;
    private javax.swing.JPanel panelBorderCliente;
    private javax.swing.JPanel panelBotonesCobrar;
    private javax.swing.JPanel panelCampoCantidadPago;
    private javax.swing.JPanel panelCamposCambio;
    private javax.swing.JPanel panelCobrar;
    private javax.swing.JPanel panelCobro;
    private javax.swing.JPanel panelComponentesCobrar;
    private javax.swing.JPanel panelModoPago;
    private javax.swing.JPanel panelMuestra;
    private javax.swing.JPanel panelTextoCambio;
    private javax.swing.JPanel panelTipoCliente;
    private javax.swing.JTextField tx_cantpago;
    // End of variables declaration//GEN-END:variables
}
