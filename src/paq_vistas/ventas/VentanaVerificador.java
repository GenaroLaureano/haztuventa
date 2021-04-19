package paq_vistas.ventas;

import paq_controladores.ventas.OyenteVerificador;
import javax.swing.JLabel;
import paq_modelos.db.ModSQLVentas;

public class VentanaVerificador extends javax.swing.JDialog {

    private JLabel et_monto;
    private JLabel et_numprod;

    public VentanaVerificador(ModSQLVentas sqlVentas, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        addEventos(new OyenteVerificador(sqlVentas, this));
    }

    public final void addEventos(OyenteVerificador oyente) {
        this.tx_verprecio.addKeyListener(oyente);
        this.tx_verprecio.addActionListener(oyente);
        this.bt_addventa.addActionListener(oyente);
        this.bt_cancelar.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLineBorder = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        et_verprecio = new javax.swing.JLabel();
        tx_verprecio = new javax.swing.JTextField();
        panelCentro = new javax.swing.JPanel();
        et_descripcionprod = new javax.swing.JLabel();
        et_precio = new javax.swing.JLabel();
        panelSur = new javax.swing.JPanel();
        panelBotonAgregar = new javax.swing.JPanel();
        bt_addventa = new javax.swing.JButton();
        panelBotonCancelar = new javax.swing.JPanel();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelLineBorder.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        panelLineBorder.setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.GridLayout(2, 0));

        et_verprecio.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        et_verprecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        et_verprecio.setText("VERIFICADOR DE PRECIOS");
        panelNorte.add(et_verprecio);

        tx_verprecio.setName("tx_verprecio"); // NOI18N
        tx_verprecio.setPreferredSize(new java.awt.Dimension(10, 40));
        panelNorte.add(tx_verprecio);

        panelLineBorder.add(panelNorte, java.awt.BorderLayout.NORTH);

        panelCentro.setLayout(new java.awt.GridLayout(2, 0));

        et_descripcionprod.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        et_descripcionprod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_descripcionprod.setText("DESCRIPCION DEL PRODUCTO");
        panelCentro.add(et_descripcionprod);

        et_precio.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        et_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_precio.setText("$0.0");
        panelCentro.add(et_precio);

        panelLineBorder.add(panelCentro, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.BorderLayout());

        panelBotonAgregar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_addventa.setText("Agregar a Venta");
        bt_addventa.setName("bt_addventa"); // NOI18N
        bt_addventa.setPreferredSize(new java.awt.Dimension(163, 50));
        panelBotonAgregar.add(bt_addventa);

        panelSur.add(panelBotonAgregar, java.awt.BorderLayout.WEST);

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

    public javax.swing.JTextField getCampoVerificarPrecio() {
        return tx_verprecio;
    }

    public javax.swing.JLabel getEtiquetaPrecio() {
        return et_precio;
    }

    public javax.swing.JLabel getEtiquetaDescripcionProducto() {
        return et_descripcionprod;
    }

    public void setEtiquetaMonto(JLabel et_monto) {
        this.et_monto = et_monto;
    }

    public JLabel getEtiquetaMonto() {
        return et_monto;
    }

    public void setEtiquetaNumeroProducto(JLabel et_numprod) {
        this.et_numprod = et_numprod;
    }

    public JLabel getEtiquetaNumeroProducto() {
        return et_numprod;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addventa;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JLabel et_descripcionprod;
    private javax.swing.JLabel et_precio;
    private javax.swing.JLabel et_verprecio;
    private javax.swing.JPanel panelBotonAgregar;
    private javax.swing.JPanel panelBotonCancelar;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelLineBorder;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTextField tx_verprecio;
    // End of variables declaration//GEN-END:variables
}
