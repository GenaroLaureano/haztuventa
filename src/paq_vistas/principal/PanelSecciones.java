package paq_vistas.principal;

import paq_controladores.principal.OyenteBotonesSecciones;

public class PanelSecciones extends javax.swing.JPanel {

    public PanelSecciones() {
        initComponents();
        this.bt_ventas.setEnabled(false);
        OyenteBotonesSecciones oyente = new OyenteBotonesSecciones(this);
        addEventos(oyente);
    }

    public final void addEventos(OyenteBotonesSecciones oyente) {
        this.bt_ventas.addActionListener(oyente);
        this.bt_clientes.addActionListener(oyente);
        this.bt_productos.addActionListener(oyente);
        this.bt_usuarios.addActionListener(oyente);
        this.bt_corte.addActionListener(oyente);
        this.bt_devoluciones.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        panelNorteBotonesSecciones = new javax.swing.JPanel();
        bt_ventas = new javax.swing.JButton();
        bt_clientes = new javax.swing.JButton();
        bt_productos = new javax.swing.JButton();
        bt_usuarios = new javax.swing.JButton();
        bt_corte = new javax.swing.JButton();
        bt_devoluciones = new javax.swing.JButton();
        panelCentro = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 15));
        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.BorderLayout());

        panelNorteBotonesSecciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_ventas.setText("CAJA");
        bt_ventas.setFocusable(false);
        bt_ventas.setName("seccionVentas"); // NOI18N
        bt_ventas.setPreferredSize(new java.awt.Dimension(105, 50));
        panelNorteBotonesSecciones.add(bt_ventas);

        bt_clientes.setText("CLIENTES");
        bt_clientes.setFocusable(false);
        bt_clientes.setName("seccionClientes"); // NOI18N
        bt_clientes.setPreferredSize(new java.awt.Dimension(105, 50));
        panelNorteBotonesSecciones.add(bt_clientes);

        bt_productos.setText("PRODUCTOS");
        bt_productos.setFocusable(false);
        bt_productos.setName("seccionProductos"); // NOI18N
        bt_productos.setPreferredSize(new java.awt.Dimension(115, 50));
        panelNorteBotonesSecciones.add(bt_productos);

        bt_usuarios.setText("USUARIOS");
        bt_usuarios.setFocusable(false);
        bt_usuarios.setName("seccionUsuarios"); // NOI18N
        bt_usuarios.setPreferredSize(new java.awt.Dimension(105, 50));
        panelNorteBotonesSecciones.add(bt_usuarios);

        bt_corte.setText("CORTE CAJA");
        bt_corte.setFocusable(false);
        bt_corte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_corte.setName("botonSalir"); // NOI18N
        bt_corte.setPreferredSize(new java.awt.Dimension(130, 50));
        panelNorteBotonesSecciones.add(bt_corte);

        bt_devoluciones.setText("VENTAS");
        bt_devoluciones.setName("devoluciones"); // NOI18N
        bt_devoluciones.setPreferredSize(new java.awt.Dimension(105, 50));
        panelNorteBotonesSecciones.add(bt_devoluciones);

        panelNorte.add(panelNorteBotonesSecciones, java.awt.BorderLayout.NORTH);

        add(panelNorte, java.awt.BorderLayout.NORTH);

        panelCentro.setLayout(new java.awt.BorderLayout());
        add(panelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JPanel getPanelCentro() {
        return panelCentro;
    }

    public javax.swing.JPanel getPanelNorteBotonesSecciones() {
        return panelNorteBotonesSecciones;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_clientes;
    private javax.swing.JButton bt_corte;
    private javax.swing.JButton bt_devoluciones;
    private javax.swing.JButton bt_productos;
    private javax.swing.JButton bt_usuarios;
    private javax.swing.JButton bt_ventas;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelNorteBotonesSecciones;
    // End of variables declaration//GEN-END:variables

}
