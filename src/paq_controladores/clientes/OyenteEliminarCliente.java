package paq_controladores.clientes;

import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModCliente;
import paq_modelos.db.ModSQLClientes;
import paq_vistas.clientes.PanelEliminarCliente;

public class OyenteEliminarCliente implements ActionListener, DocumentListener {

    private final ModSQLClientes sqlClientes;
    private final PanelEliminarCliente panelEliminarCliente;

    public OyenteEliminarCliente(ModSQLClientes sqlClientes, PanelEliminarCliente panelEliminarCliente) {
        this.sqlClientes = sqlClientes;
        this.panelEliminarCliente = panelEliminarCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable tb_eliminar = panelEliminarCliente.getTablaClientes();
        int numFila = tb_eliminar.getSelectedRow();
        if (numFila >= 0) {
            long numeroTelefono = (long) tb_eliminar.getValueAt(numFila, 3);
            ModCliente cliente = sqlClientes.getCliente(numeroTelefono);
            cliente.setTelefono(numeroTelefono);
            sqlClientes.eliminarCliente(numeroTelefono);
            buscarCliente();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        buscarCliente();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buscarCliente();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buscarCliente();
    }

    public void buscarCliente() {
        DefaultTableModel tb_modelo = (DefaultTableModel) panelEliminarCliente.getTablaClientes().getModel();
        String textoBuscar = panelEliminarCliente.getCampoCliente().getText();
        sqlClientes.buscarCliente(textoBuscar, tb_modelo);
    }
}
