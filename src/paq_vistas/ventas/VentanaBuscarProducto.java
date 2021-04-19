package paq_vistas.ventas;

import paq_controladores.ventas.OyenteBuscarProducto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;

public class VentanaBuscarProducto extends javax.swing.JDialog {

    private JLabel et_monto;
    private JLabel et_numproductos;

    public VentanaBuscarProducto(ModSQLVentas sqlVentas, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sqlVentas.setDefaultModeloTablaBuscarProducto((DefaultTableModel) this.tb_buscar.getModel());
        addEventos(new OyenteBuscarProducto(sqlVentas, this));
    }

    public final void addEventos(OyenteBuscarProducto oyente) {
        this.tb_buscar.addKeyListener(oyente);
        this.bt_aceptar.addActionListener(oyente);
        this.bt_cancelar.addActionListener(oyente);
        this.tx_buscar.addKeyListener(oyente);
        this.tx_buscar.getDocument().addDocumentListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLineBorder = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        et_buscar = new javax.swing.JLabel();
        tx_buscar = new javax.swing.JTextField();
        panelCentro = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        tb_buscar = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        panelBotonAceptar = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();
        panelBotonCancelar = new javax.swing.JPanel();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelLineBorder.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        panelLineBorder.setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.GridLayout(2, 0));

        et_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_buscar.setText("Teclee las palabras clave para buscar en toda la descripcion");
        panelNorte.add(et_buscar);

        tx_buscar.setPreferredSize(new java.awt.Dimension(10, 40));
        panelNorte.add(tx_buscar);

        panelLineBorder.add(panelNorte, java.awt.BorderLayout.NORTH);

        panelCentro.setLayout(new java.awt.BorderLayout());

        tb_buscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Descripción del Producto", "Precio Venta", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(tb_buscar);

        panelCentro.add(panelTabla, java.awt.BorderLayout.CENTER);

        panelLineBorder.add(panelCentro, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.BorderLayout());

        panelBotones.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelSur.add(panelBotones, java.awt.BorderLayout.NORTH);

        panelBotonAceptar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_aceptar.setText("Aceptar");
        bt_aceptar.setName("bt_aceptar"); // NOI18N
        bt_aceptar.setPreferredSize(new java.awt.Dimension(163, 50));
        panelBotonAceptar.add(bt_aceptar);

        panelSur.add(panelBotonAceptar, java.awt.BorderLayout.WEST);

        panelBotonCancelar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_cancelar.setText("Cancelar");
        bt_cancelar.setName("bt_cancelar"); // NOI18N
        bt_cancelar.setPreferredSize(new java.awt.Dimension(163, 50));
        panelBotonCancelar.add(bt_cancelar);

        panelSur.add(panelBotonCancelar, java.awt.BorderLayout.EAST);

        panelLineBorder.add(panelSur, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelLineBorder, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTable getTablaBuscarProducto() {
        return tb_buscar;
    }

    public JTextField getCampoBuscarProducto() {
        return tx_buscar;
    }

    public void setEtiquetaMonto(JLabel et_monto) {
        this.et_monto = et_monto;
    }

    public JLabel getEtiquetaMonto() {
        return et_monto;
    }

    public void setEtiquetaNumeroProducto(JLabel et_numproductos) {
        this.et_numproductos = et_numproductos;
    }

    public JLabel getEtiquetaNumeroProducto() {
        return et_numproductos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JLabel et_buscar;
    private javax.swing.JPanel panelBotonAceptar;
    private javax.swing.JPanel panelBotonCancelar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelLineBorder;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tb_buscar;
    private javax.swing.JTextField tx_buscar;
    // End of variables declaration//GEN-END:variables
}
