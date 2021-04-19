package paq_controladores.clientes;

import paq_vistas.clientes.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModCliente;
import paq_modelos.db.ModSQLClientes;
import paq_utilidades.ModVentanas;

public class OyenteModifcarCliente implements ActionListener, DocumentListener {

    private final ModSQLClientes sqlClientes;
    private final PanelModificarCliente panelModificarCliente;

    public OyenteModifcarCliente(ModSQLClientes sqlClientes, PanelModificarCliente panelModificarCliente) {
        this.sqlClientes = sqlClientes;
        this.panelModificarCliente = panelModificarCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable tb_modificar = panelModificarCliente.getTablaClientes();
        int numFila = tb_modificar.getSelectedRow();
        if (numFila >= 0) {
            long numeroTelefono = (long) tb_modificar.getValueAt(numFila, 3);
            ModCliente cliente = sqlClientes.getCliente(numeroTelefono);
            if (cliente != null) {
                JFrame venPadre = ModVentanas.getVentanaPadre();
                VentanaCamposModificarCliente venCamposModificar
                        = new VentanaCamposModificarCliente(sqlClientes, venPadre, true);
                ModVentanas.abrirVentanaDialogo(venPadre, venCamposModificar, 450, 400);
                venCamposModificar.setTelefonoCopia(numeroTelefono);
                venCamposModificar.setCampoCliente(panelModificarCliente.getCampoCliente());
                venCamposModificar.setTablaClientes(panelModificarCliente.getTablaClientes());
                venCamposModificar.getCampoNombre().setText(cliente.getNombre());
                venCamposModificar.getCampoApellidoP().setText(cliente.getApellidoPaterno());
                venCamposModificar.getCampoApellidoM().setText(cliente.getApellidoMaterno());
                switch (cliente.getSexo()) {
                    case "M":
                        venCamposModificar.getRadioBotonM().setSelected(true);
                        break;
                    case "F":
                        venCamposModificar.getRadioBotonF().setSelected(true);
                        break;
                    case "OTRO":
                        venCamposModificar.getRadioBotonOtro().setSelected(true);

                }
                venCamposModificar.getCampoEmail().setText(cliente.getEmail());
                venCamposModificar.getCampoTelefono().setText(String.valueOf(cliente.getTelefono()));
                venCamposModificar.setVisible(true);
            }
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
        DefaultTableModel tb_modelo = (DefaultTableModel) panelModificarCliente.getTablaClientes().getModel();
        String textoBuscar = panelModificarCliente.getCampoCliente().getText();
        sqlClientes.buscarCliente(textoBuscar, tb_modelo);
    }
}
