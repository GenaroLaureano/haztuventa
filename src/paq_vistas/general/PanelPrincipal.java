package paq_vistas.general;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import paq_modelos.general.ModCargarCategorias;

public final class PanelPrincipal extends javax.swing.JPanel {

    private ModCargarCategorias cargaC;
    private final PanelNuevo panelNuevo;

    public PanelPrincipal(PanelNuevo panelNuevo) {
        initComponents();
        this.panelNuevo = panelNuevo;
        this.getPanelCentral().add(panelNuevo);
        this.bt_nuevo.setEnabled(false);
    }

    public void addEventos(ActionListener e) {
        bt_nuevo.addActionListener(e);
        bt_modificar.addActionListener(e);
        bt_eliminar.addActionListener(e);
        bt_departamento.addActionListener(e);
        bt_catalogo.addActionListener(e);
        bt_anadir.addActionListener(e);
        bt_inventario.addActionListener(e);
        bt_nuevo.setName("nuevo");
        bt_modificar.setName("modificar");
        bt_eliminar.setName("eliminar");
        bt_departamento.setName("departamento");
        bt_catalogo.setName("catalogo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelOpciones = new javax.swing.JPanel();
        bt_nuevo = new javax.swing.JButton();
        bt_modificar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        bt_departamento = new javax.swing.JButton();
        bt_catalogo = new javax.swing.JButton();
        bt_anadir = new javax.swing.JButton();
        bt_inventario = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 24))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelOpciones.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));
        panelOpciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        bt_nuevo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.setPreferredSize(new java.awt.Dimension(105, 30));
        panelOpciones.add(bt_nuevo);

        bt_modificar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_modificar.setText("Modificar");
        bt_modificar.setPreferredSize(new java.awt.Dimension(105, 30));
        panelOpciones.add(bt_modificar);

        bt_eliminar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setPreferredSize(new java.awt.Dimension(105, 30));
        panelOpciones.add(bt_eliminar);

        bt_departamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_departamento.setText("Departamento");
        bt_departamento.setPreferredSize(new java.awt.Dimension(105, 30));
        panelOpciones.add(bt_departamento);

        bt_catalogo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_catalogo.setText("Catalogo");
        bt_catalogo.setPreferredSize(new java.awt.Dimension(105, 30));
        panelOpciones.add(bt_catalogo);

        bt_anadir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_anadir.setText("Añadir a Inventario");
        bt_anadir.setName("anadir"); // NOI18N
        bt_anadir.setPreferredSize(new java.awt.Dimension(180, 30));
        panelOpciones.add(bt_anadir);

        bt_inventario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_inventario.setText("Inventario");
        bt_inventario.setName("inventario"); // NOI18N
        bt_inventario.setPreferredSize(new java.awt.Dimension(150, 30));
        panelOpciones.add(bt_inventario);

        add(panelOpciones, java.awt.BorderLayout.NORTH);

        panelCentral.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        add(panelCentral, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_anadir;
    private javax.swing.JButton bt_catalogo;
    private javax.swing.JButton bt_departamento;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_inventario;
    private javax.swing.JButton bt_modificar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelOpciones;
    // End of variables declaration//GEN-END:variables

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public JPanel getPanelOpciones() {
        return panelOpciones;
    }
}
