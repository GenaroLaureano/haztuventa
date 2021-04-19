package paq_vistas.clientes;

import paq_controladores.clientes.OyenteBuscarCliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModCliente;
import paq_modelos.db.ModSQLVentas;

public class VentanaBuscarCliente extends javax.swing.JDialog {

    private JLabel et_nombrecliente;
    private ModCliente cliente;

    public VentanaBuscarCliente(ModSQLVentas sqlVentas, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sqlVentas.setDefaultModeloTablaBuscarCliente((DefaultTableModel) this.tb_buscacliente.getModel());
        addEventos(new OyenteBuscarCliente(sqlVentas, this));
    }

    public final void addEventos(OyenteBuscarCliente oyente) {
        this.tb_buscacliente.addKeyListener(oyente);
        this.bt_aceptar.addActionListener(oyente);
        this.bt_cancelar.addActionListener(oyente);
        this.tx_buscarcliente.addKeyListener(oyente);
        this.tx_buscarcliente.getDocument().addDocumentListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBuscar = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        et_buscarcliente = new javax.swing.JLabel();
        tx_buscarcliente = new javax.swing.JTextField();
        panelCentro = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        tb_buscacliente = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        panelBotonAceptar = new javax.swing.JPanel();
        bt_aceptar = new javax.swing.JButton();
        panelBotonCancelar = new javax.swing.JPanel();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 20));
        panelBuscar.setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.GridLayout(2, 0));

        et_buscarcliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        et_buscarcliente.setText("Teclee el nombre o telefono del cliente");
        panelNorte.add(et_buscarcliente);

        tx_buscarcliente.setPreferredSize(new java.awt.Dimension(10, 40));
        panelNorte.add(tx_buscarcliente);

        panelBuscar.add(panelNorte, java.awt.BorderLayout.NORTH);

        panelCentro.setLayout(new java.awt.BorderLayout());

        tb_buscacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Numero de Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(tb_buscacliente);

        panelCentro.add(panelTabla, java.awt.BorderLayout.CENTER);

        panelBuscar.add(panelCentro, java.awt.BorderLayout.CENTER);

        panelSur.setLayout(new java.awt.BorderLayout());

        panelBotonAceptar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_aceptar.setText("ENTER - Aceptar");
        bt_aceptar.setName("bt_aceptar"); // NOI18N
        bt_aceptar.setPreferredSize(new java.awt.Dimension(163, 50));
        panelBotonAceptar.add(bt_aceptar);

        panelSur.add(panelBotonAceptar, java.awt.BorderLayout.WEST);

        panelBotonCancelar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_cancelar.setText("ESC - Cancelar");
        bt_cancelar.setName("bt_cancelar"); // NOI18N
        bt_cancelar.setPreferredSize(new java.awt.Dimension(163, 50));
        panelBotonCancelar.add(bt_cancelar);

        panelSur.add(panelBotonCancelar, java.awt.BorderLayout.EAST);

        panelBuscar.add(panelSur, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelBuscar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTable getTablaBuscarCliente() {
        return tb_buscacliente;
    }

    public JTextField getCampoBuscarCliente() {
        return tx_buscarcliente;
    }

    public void setEtiquetaNombreCliente(JLabel et_nombrecliente) {
        this.et_nombrecliente = et_nombrecliente;
    }

    public JLabel getEtiquetaNombreCliente() {
        return et_nombrecliente;
    }

    public void setCliente(ModCliente cliente) {
        this.cliente = cliente;
    }

    public ModCliente getCliente() {
        return cliente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JLabel et_buscarcliente;
    private javax.swing.JPanel panelBotonAceptar;
    private javax.swing.JPanel panelBotonCancelar;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tb_buscacliente;
    private javax.swing.JTextField tx_buscarcliente;
    // End of variables declaration//GEN-END:variables
}
