package paq_vistas.general;

import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class PanelEliminarProducto extends javax.swing.JPanel {

    public PanelEliminarProducto() {
        initComponents();
    }

    public void addEventos(ActionListener e) {
        bt_guardar.addActionListener(e);
        bt_cancelar.addActionListener(e);

        bt_guardar.setName("guardar");
        bt_cancelar.setName("cancelar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNuevoProducto = new javax.swing.JPanel();
        panelValoresNuevos = new javax.swing.JPanel();
        et_codigo = new javax.swing.JLabel();
        tx_codigo = new javax.swing.JTextField();
        et_descripcion = new javax.swing.JLabel();
        tx_descripcion = new javax.swing.JTextField();
        et_costo = new javax.swing.JLabel();
        tx_costo = new javax.swing.JTextField();
        et_precio = new javax.swing.JLabel();
        tx_precio = new javax.swing.JTextField();
        et_departamento = new javax.swing.JLabel();
        tx_departamento = new javax.swing.JTextField();
        panelSur = new javax.swing.JPanel();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new java.awt.BorderLayout(0, 10));

        panelNuevoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelNuevoProducto.setPreferredSize(new java.awt.Dimension(550,400));
        panelNuevoProducto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        panelValoresNuevos.setLayout(new java.awt.GridLayout(5, 2));

        et_codigo.setText("Código de Barras:");
        panelValoresNuevos.add(et_codigo);

        tx_codigo.setColumns(10);
        tx_codigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        panelValoresNuevos.add(tx_codigo);

        et_descripcion.setText("Descripción:");
        panelValoresNuevos.add(et_descripcion);

        tx_descripcion.setColumns(20);
        panelValoresNuevos.add(tx_descripcion);

        et_costo.setText("Costo:");
        panelValoresNuevos.add(et_costo);

        tx_costo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tx_costo.setToolTipText("");
        panelValoresNuevos.add(tx_costo);

        et_precio.setText("Precio:");
        panelValoresNuevos.add(et_precio);
        panelValoresNuevos.add(tx_precio);

        et_departamento.setText("Departamento:");
        panelValoresNuevos.add(et_departamento);

        tx_departamento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tx_departamento.setToolTipText("");
        panelValoresNuevos.add(tx_departamento);

        panelNuevoProducto.add(panelValoresNuevos);

        add(panelNuevoProducto, java.awt.BorderLayout.CENTER);

        panelSur.setPreferredSize(new java.awt.Dimension(550,100));
        panelSur.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 100, 5));

        bt_guardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_guardar.setText("Eliminar");
        bt_guardar.setPreferredSize(new java.awt.Dimension(150, 30));
        panelSur.add(bt_guardar);

        bt_cancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setPreferredSize(new java.awt.Dimension(150, 30));
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        panelSur.add(bt_cancelar);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JLabel et_codigo;
    private javax.swing.JLabel et_costo;
    private javax.swing.JLabel et_departamento;
    private javax.swing.JLabel et_descripcion;
    private javax.swing.JLabel et_precio;
    private javax.swing.JPanel panelNuevoProducto;
    private javax.swing.JPanel panelSur;
    private javax.swing.JPanel panelValoresNuevos;
    private javax.swing.JTextField tx_codigo;
    private javax.swing.JTextField tx_costo;
    private javax.swing.JTextField tx_departamento;
    private javax.swing.JTextField tx_descripcion;
    private javax.swing.JTextField tx_precio;
    // End of variables declaration//GEN-END:variables

    public JTextField getcCodigoBarras() {
        return tx_codigo;
    }

    public void setcCodigoBarras(JTextField tx_codigo) {
        this.tx_codigo = tx_codigo;
    }

    public JTextField getcCosto() {
        return tx_costo;
    }

    public void setcCosto(JTextField tx_costo) {
        this.tx_costo = tx_costo;
    }

    public JTextField getcDepartamento() {
        return tx_departamento;
    }

    public void setcDepartamento(JTextField tx_departamento) {
        this.tx_departamento = tx_departamento;
    }

    public JTextField getcDescripcion() {
        return tx_descripcion;
    }

    public void setcDescripcion(JTextField tx_descripcion) {
        this.tx_descripcion = tx_descripcion;
    }

    public JTextField getcPrecio() {
        return tx_precio;
    }

    public void setcPrecio(JTextField tx_precio) {
        this.tx_precio = tx_precio;
    }
}
