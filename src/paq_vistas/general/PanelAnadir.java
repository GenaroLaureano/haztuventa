package paq_vistas.general;

import paq_controladores.general.OyenteAddInventario;
import javax.swing.*;
import paq_modelos.general.ModCargarProductos;

public final class PanelAnadir extends javax.swing.JPanel {

    public PanelAnadir(ModCargarProductos c) {
        initComponents();
        addEventos(new OyenteAddInventario(this, c));
    }

    public void addEventos(OyenteAddInventario e) {
        this.bt_aceptar.addActionListener(e);
        this.tx_codigo.addKeyListener(e);
        this.bt_almacen.addActionListener(e);
        this.bt_piso.addActionListener(e);

        this.bt_almacen.setName("almacen");
        this.bt_piso.setName("piso");
        this.bt_aceptar.setName("aceptar");
        this.tx_codigo.setName("codigo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_grupoubicacion = new javax.swing.ButtonGroup();
        panelInventario = new javax.swing.JPanel();
        panelCodigo = new javax.swing.JPanel();
        et_codigo = new javax.swing.JLabel();
        tx_codigo = new javax.swing.JTextField();
        bt_aceptar = new javax.swing.JButton();
        panelBsuqueda = new javax.swing.JPanel();
        et_anadir = new javax.swing.JLabel();
        bt_piso = new javax.swing.JRadioButton();
        bt_almacen = new javax.swing.JRadioButton();

        panelInventario.setLayout(new java.awt.GridLayout(2, 1));

        et_codigo.setText("Codigo Barra:");
        panelCodigo.add(et_codigo);

        tx_codigo.setColumns(20);
        panelCodigo.add(tx_codigo);

        bt_aceptar.setText("Aceptar");
        panelCodigo.add(bt_aceptar);

        panelInventario.add(panelCodigo);

        panelBsuqueda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        et_anadir.setText("Añadir a: ");
        panelBsuqueda.add(et_anadir);

        bt_grupoubicacion.add(bt_piso);
        bt_piso.setSelected(true);
        bt_piso.setText("Piso");
        bt_piso.setName("piso"); // NOI18N
        panelBsuqueda.add(bt_piso);

        bt_grupoubicacion.add(bt_almacen);
        bt_almacen.setText("Almacen");
        bt_almacen.setName("almacen"); // NOI18N
        panelBsuqueda.add(bt_almacen);

        panelInventario.add(panelBsuqueda);

        add(panelInventario);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JRadioButton bt_almacen;
    private javax.swing.ButtonGroup bt_grupoubicacion;
    private javax.swing.JRadioButton bt_piso;
    private javax.swing.JLabel et_anadir;
    private javax.swing.JLabel et_codigo;
    private javax.swing.JPanel panelBsuqueda;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JTextField tx_codigo;
    // End of variables declaration//GEN-END:variables

    public JButton getbAceptar() {
        return bt_aceptar;
    }

    public JTextField getcCodigo() {
        return tx_codigo;
    }
}
