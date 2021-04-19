package paq_vistas.general;

import paq_controladores.general.*;
import javax.swing.*;
import paq_modelos.general.ModCargarProductos;

public class VentanaAnadir extends javax.swing.JDialog {

    public VentanaAnadir(java.awt.Frame parent, boolean modal, ModCargarProductos cargarP, OyenteAddInventario ci, int max) {
        super(parent, modal);
        initComponents();
        addEventos(new OyenteVentanaAdd(this, cargarP, ci, max));
    }

    public final void addEventos(OyenteVentanaAdd e) {
        this.bt_aceptar.addActionListener(e);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdd = new javax.swing.JPanel();
        panelEtiquetaCodigo = new javax.swing.JPanel();
        panelCodigo = new javax.swing.JPanel();
        et_producto = new javax.swing.JLabel();
        et_codigo = new javax.swing.JLabel();
        panelEtiquetaNombre = new javax.swing.JPanel();
        panelDescripcion = new javax.swing.JPanel();
        et_descripcion = new javax.swing.JLabel();
        et_nombre = new javax.swing.JLabel();
        panelCantidad = new javax.swing.JPanel();
        et_cantidad = new javax.swing.JLabel();
        spinerCantidad = new javax.swing.JSpinner();
        panelBoton = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelAdd.setLayout(new java.awt.GridLayout(4, 1));

        panelCodigo.setLayout(new java.awt.GridLayout(2, 1));

        et_producto.setText("PRODUCTO:");
        panelCodigo.add(et_producto);
        panelCodigo.add(et_codigo);

        panelEtiquetaCodigo.add(panelCodigo);

        panelAdd.add(panelEtiquetaCodigo);

        panelDescripcion.setLayout(new java.awt.GridLayout(2, 1));

        et_descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_descripcion.setText("DESCRIPCIÓN DEL PRODUCTO:");
        panelDescripcion.add(et_descripcion);
        panelDescripcion.add(et_nombre);

        panelEtiquetaNombre.add(panelDescripcion);

        panelAdd.add(panelEtiquetaNombre);

        et_cantidad.setText("Cantidad Añadida:");
        panelCantidad.add(et_cantidad);

        spinerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinerCantidad.setPreferredSize(new java.awt.Dimension(60, 20));
        panelCantidad.add(spinerCantidad);

        panelAdd.add(panelCantidad);

        bt_aceptar.setText("Aceptar");
        bt_aceptar.setName("aceptar"); // NOI18N
        panelBoton.add(bt_aceptar);

        panelAdd.add(panelBoton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel et_cantidad;
    private javax.swing.JLabel et_codigo;
    private javax.swing.JLabel et_descripcion;
    private javax.swing.JLabel et_nombre;
    private javax.swing.JLabel et_producto;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCantidad;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelDescripcion;
    private javax.swing.JPanel panelEtiquetaCodigo;
    private javax.swing.JPanel panelEtiquetaNombre;
    private javax.swing.JSpinner spinerCantidad;
    // End of variables declaration//GEN-END:variables

    public JButton getBotonAceptar() {
        return bt_aceptar;
    }

    public void setBotonAceptar(JButton botonAceptar) {
        this.bt_aceptar = botonAceptar;
    }

    public JLabel getEtiquetaCodigo() {
        return et_codigo;
    }

    public void setEtiquetaCodigo(JLabel etiquetaCodigo) {
        this.et_codigo = etiquetaCodigo;
    }

    public JLabel getEtiquetaNombre() {
        return et_nombre;
    }

    public void setEtiquetaNombre(JLabel etiquetaNombre) {
        this.et_nombre = etiquetaNombre;
    }

    public JSpinner getSpinerCantidad() {
        return spinerCantidad;
    }

    public void setSpinerCantidad(JSpinner spinerCantidad) {
        this.spinerCantidad = spinerCantidad;
    }

}
