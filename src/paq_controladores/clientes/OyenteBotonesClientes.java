package paq_controladores.clientes;

import paq_vistas.clientes.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import paq_modelos.db.ModSQLClientes;

public class OyenteBotonesClientes implements ActionListener {

    private final PanelClientes panelClientes;
    private final ModSQLClientes sqlClientes;
    private final PanelNuevoCliente panelNuevoCliente;
    private final PanelModificarCliente panelModificarCliente;
    private final PanelEliminarCliente panelEliminarCliente;
    private final PanelCatalogoDevoluciones panelCatalogo;

    public OyenteBotonesClientes(ModSQLClientes sqlClientes, PanelClientes panelClientes) {
        this.panelClientes = panelClientes;
        this.sqlClientes = sqlClientes;
        panelNuevoCliente = new PanelNuevoCliente(sqlClientes);
        panelModificarCliente = new PanelModificarCliente(sqlClientes);
        panelEliminarCliente = new PanelEliminarCliente(sqlClientes);
        panelCatalogo = new PanelCatalogoDevoluciones(sqlClientes);
        panelClientes.getPanelCentro().add(panelNuevoCliente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component[] botones = panelClientes.getPanelNorte().getComponents();
        JPanel panelCentro = panelClientes.getPanelCentro();
        JButton bt_cliente = (JButton) e.getSource();
        panelCentro.removeAll();
        switch (bt_cliente.getName()) {
            case "nuevoCliente":
                panelCentro.add(panelNuevoCliente);
                break;
            case "modificarCliente":
                panelCentro.add(panelModificarCliente);
                break;
            case "eliminarCliente":
                panelCentro.add(panelEliminarCliente);
                break;
            case "todosClientes":
                panelCentro.add(panelCatalogo);
        }
        bt_cliente.setEnabled(false);
        for (int i = 0; i < botones.length; i++) {
            if (!botones[i].getName().equals(bt_cliente.getName())) {
                botones[i].setEnabled(true);
            }
        }
        panelCentro.revalidate();
        panelCentro.repaint();
    }
}
