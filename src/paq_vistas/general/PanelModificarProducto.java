package paq_vistas.general;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import paq_modelos.general.ModCargarCategorias;

public class PanelModificarProducto extends javax.swing.JPanel {

    private ModCargarCategorias cargaC;

    public PanelModificarProducto() {
        initComponents();
    }

    public void addEvents(ActionListener e) {
        bt_guardar.addActionListener(e);
        bt_cancelar.addActionListener(e);
        bt_guardar.setName("guardar");
        bt_cancelar.setName("cancelar");
        cargaC = new ModCargarCategorias();
        cargarCategorias();
    }

    public void cargarCategorias() {
        cargaC.consultaCategorias();
        try {
            while (cargaC.getRs().next()) {
                this.getComboCategorias().addItem(cargaC.getRs().getString("NOMBRE_CATEGORIA"));
            }
            cargaC.getRs().close();

        } catch (SQLException ex) {
            System.out.println("En evento de ventana: " + ex);
        }
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
        comboCategorias = new javax.swing.JComboBox<>();
        panelSur = new javax.swing.JPanel();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new java.awt.BorderLayout());

        panelNuevoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modifica Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelNuevoProducto.setPreferredSize(new java.awt.Dimension(550,400));
        panelNuevoProducto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        panelValoresNuevos.setLayout(new java.awt.GridLayout(6, 2));

        et_codigo.setText("Código de Barras:");
        panelValoresNuevos.add(et_codigo);

        tx_codigo.setColumns(10);
        tx_codigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        panelValoresNuevos.add(tx_codigo);

        et_descripcion.setText("Descripción:");
        panelValoresNuevos.add(et_descripcion);

        tx_descripcion.setColumns(20);
        panelValoresNuevos.add(tx_descripcion);

        et_costo.setText("Precio costo:");
        panelValoresNuevos.add(et_costo);

        tx_costo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tx_costo.setToolTipText("");
        panelValoresNuevos.add(tx_costo);

        et_precio.setText("Precio venta:");
        panelValoresNuevos.add(et_precio);
        panelValoresNuevos.add(tx_precio);

        et_departamento.setText("Departamento");
        panelValoresNuevos.add(et_departamento);

        comboCategorias.setEditable(true);
        panelValoresNuevos.add(comboCategorias);

        panelNuevoProducto.add(panelValoresNuevos);

        add(panelNuevoProducto, java.awt.BorderLayout.CENTER);

        panelSur.setPreferredSize(new java.awt.Dimension(550,100));
        panelSur.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 100, 5));

        bt_guardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.setPreferredSize(new java.awt.Dimension(150, 30));
        panelSur.add(bt_guardar);

        bt_cancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setPreferredSize(new java.awt.Dimension(150, 30));
        panelSur.add(bt_cancelar);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JComboBox<String> comboCategorias;
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
    private javax.swing.JTextField tx_descripcion;
    private javax.swing.JTextField tx_precio;
    // End of variables declaration//GEN-END:variables

    public JTextField getcCodigoBarra() {
        return tx_codigo;
    }

    public void setcCodigoBarra(JTextField cCodigoBarra) {
        this.tx_codigo = cCodigoBarra;
    }

    public JTextField getcCosto() {
        return tx_costo;
    }

    public void setcCosto(JTextField cCosto) {
        this.tx_costo = cCosto;
    }

    public JTextField getcDescripcion() {
        return tx_descripcion;
    }

    public void setcDescripcion(JTextField cDescripcion) {
        this.tx_descripcion = cDescripcion;
    }

    public JTextField getcPrecio() {
        return tx_precio;
    }

    public void setcPrecio(JTextField cPrecio) {
        this.tx_precio = cPrecio;
    }

    public JComboBox<String> getComboCategorias() {
        return comboCategorias;
    }

    public void setComboCategorias(JComboBox<String> comboCategorias) {
        this.comboCategorias = comboCategorias;
    }

}
