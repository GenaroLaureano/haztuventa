package paq_vistas.general;

import paq_controladores.general.OyenteCategorias;
import java.sql.SQLException;
import javax.swing.*;
import paq_modelos.general.ModCargarCategorias;

public class PanelCategoria extends javax.swing.JPanel {

    private ModCargarCategorias cargarC;

    public PanelCategoria() {
        initComponents();
    }

    public void addEventos(OyenteCategorias e) {
        this.bt_guardar.addActionListener(e);
        this.bt_cancelar.addActionListener(e);
        this.bt_eliminar.addActionListener(e);
        this.tx_busqueda.getDocument().addDocumentListener(e);
        this.bt_guardar.setName("guardar");
        this.bt_cancelar.setName("cancelar");
        this.bt_eliminar.setName("eliminar");
        cargarC = new ModCargarCategorias();
        cargarCategorias();
    }

    public void cargarCategorias() {
        cargarC.consultaCategorias();
        try {
            DefaultListModel modelo = new DefaultListModel();
            String v[] = new String[1];

            while (cargarC.getRs().next()) {
                v[0] = cargarC.getRs().getString("NOMBRE_CATEGORIA");
                modelo.addElement(v[0]);
                this.getListaInternaD().setModel(modelo);
            }
        } catch (SQLException ex) {
            System.out.println("En evento de ventana: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDepartamento = new javax.swing.JPanel();
        panelIzquierdo = new javax.swing.JPanel();
        tx_busqueda = new javax.swing.JTextField();
        panelLista = new javax.swing.JScrollPane();
        listaInternaD = new javax.swing.JList<>();
        panelDerecho = new javax.swing.JPanel();
        panelSuperiorD = new javax.swing.JPanel();
        bt_eliminar = new javax.swing.JButton();
        panelInferiorD = new javax.swing.JPanel();
        panelNombre = new javax.swing.JPanel();
        et_nombre = new javax.swing.JLabel();
        tx_nombre = new javax.swing.JTextField();
        panelOpcionesD = new javax.swing.JPanel();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 10));

        panelDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categorías", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelDepartamento.setLayout(new java.awt.GridLayout(1, 2));

        panelIzquierdo.setLayout(new java.awt.BorderLayout());

        tx_busqueda.setColumns(15);
        panelIzquierdo.add(tx_busqueda, java.awt.BorderLayout.NORTH);

        listaInternaD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaInternaD.setToolTipText("");
        panelLista.setViewportView(listaInternaD);

        panelIzquierdo.add(panelLista, java.awt.BorderLayout.CENTER);

        panelDepartamento.add(panelIzquierdo);

        panelDerecho.setLayout(new java.awt.BorderLayout());

        panelSuperiorD.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_eliminar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setPreferredSize(new java.awt.Dimension(150, 30));
        panelSuperiorD.add(bt_eliminar);

        panelDerecho.add(panelSuperiorD, java.awt.BorderLayout.NORTH);

        panelInferiorD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Categoría", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        panelInferiorD.setLayout(new java.awt.GridLayout(3, 1));

        panelNombre.setLayout(new java.awt.GridLayout(2, 1));

        et_nombre.setText("Nombre:");
        panelNombre.add(et_nombre);

        tx_nombre.setColumns(15);
        panelNombre.add(tx_nombre);

        panelInferiorD.add(panelNombre);

        bt_guardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_guardar.setText("Guardar Departamento");
        bt_guardar.setPreferredSize(new java.awt.Dimension(230, 30));
        panelOpcionesD.add(bt_guardar);

        bt_cancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setPreferredSize(new java.awt.Dimension(150, 30));
        panelOpcionesD.add(bt_cancelar);

        panelInferiorD.add(panelOpcionesD);

        panelDerecho.add(panelInferiorD, java.awt.BorderLayout.CENTER);

        panelDepartamento.add(panelDerecho);

        add(panelDepartamento);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JLabel et_nombre;
    private javax.swing.JList<String> listaInternaD;
    private javax.swing.JPanel panelDepartamento;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelInferiorD;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JScrollPane panelLista;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelOpcionesD;
    private javax.swing.JPanel panelSuperiorD;
    private javax.swing.JTextField tx_busqueda;
    private javax.swing.JTextField tx_nombre;
    // End of variables declaration//GEN-END:variables

    public JTextField getCampoBusquedaD() {
        return tx_busqueda;
    }

    public JTextField getCampoNombreD() {
        return tx_nombre;
    }

    public JList<String> getListaInternaD() {
        return listaInternaD;
    }
}
