package paq_vistas.ventas;

public class VentanaVales extends javax.swing.JDialog {

    public VentanaVales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentro = new javax.swing.JPanel();
        panelEtiqueta = new javax.swing.JPanel();
        et_estado = new javax.swing.JLabel();
        tx_codigo = new javax.swing.JTextField();
        panelBoton = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        panelCentro.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 30));
        panelCentro.setLayout(new java.awt.BorderLayout(0, 50));

        et_estado.setText("Codigo Barra:");
        panelEtiqueta.add(et_estado);

        tx_codigo.setColumns(20);
        panelEtiqueta.add(tx_codigo);

        panelCentro.add(panelEtiqueta, java.awt.BorderLayout.CENTER);

        bt_aceptar.setText("Aceptar");
        panelBoton.add(bt_aceptar);

        bt_cancelar.setText("Cancelar");
        panelBoton.add(bt_cancelar);

        panelCentro.add(panelBoton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelCentro);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JLabel et_estado;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelEtiqueta;
    private javax.swing.JTextField tx_codigo;
    // End of variables declaration//GEN-END:variables
}
