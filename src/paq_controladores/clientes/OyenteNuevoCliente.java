package paq_controladores.clientes;

import java.awt.event.*;
import javax.swing.JButton;
import paq_modelos.principal.ModCliente;
import paq_modelos.db.ModSQLClientes;
import paq_vistas.clientes.PanelNuevoCliente;

public class OyenteNuevoCliente implements ActionListener {

    private final ModSQLClientes sqlClientes;
    private final PanelNuevoCliente panelNuevoCliente;

    public OyenteNuevoCliente(ModSQLClientes sqlClientes, PanelNuevoCliente panelNuevoCliente) {
        this.sqlClientes = sqlClientes;
        this.panelNuevoCliente = panelNuevoCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_cliente = (JButton) e.getSource();
        switch (bt_cliente.getName()) {
            case "botonGuardar":
                ModCliente cliente = new ModCliente();
                cliente.setNombre(panelNuevoCliente.getCampoNombre().getText());
                cliente.setApellidoPaterno(panelNuevoCliente.getCampoApellidoP().getText());
                cliente.setApellidoMaterno(panelNuevoCliente.getCampoApellidoM().getText());
                cliente.setSexo(panelNuevoCliente.getBotonGrupoSexo().getSelection().getActionCommand().toUpperCase());
                cliente.setEmail(panelNuevoCliente.getCampoEmail().getText());
                cliente.setTelefono(Long.parseLong(panelNuevoCliente.getCampoTelefono().getText()));
                sqlClientes.registrarCliente(cliente);
                limpiarCampos();
                break;
            case "botonCancelar":
                limpiarCampos();
        }
    }

    public void limpiarCampos() {
        panelNuevoCliente.getCampoNombre().setText("");
        panelNuevoCliente.getCampoApellidoP().setText("");
        panelNuevoCliente.getCampoApellidoM().setText("");
        panelNuevoCliente.getBotonGrupoSexo().clearSelection();
        panelNuevoCliente.getCampoEmail().setText("");
        panelNuevoCliente.getCampoTelefono().setText("");
    }
}
