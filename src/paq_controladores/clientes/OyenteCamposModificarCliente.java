package paq_controladores.clientes;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModCliente;
import paq_modelos.db.ModSQLClientes;
import paq_vistas.clientes.VentanaCamposModificarCliente;

public class OyenteCamposModificarCliente implements ActionListener {

    private final ModSQLClientes sqlClientes;
    private final VentanaCamposModificarCliente venCamposModificar;

    public OyenteCamposModificarCliente(ModSQLClientes sqlClientes,
            VentanaCamposModificarCliente ventanaCamposModificar) {
        this.sqlClientes = sqlClientes;
        this.venCamposModificar = ventanaCamposModificar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_cliente = (JButton) e.getSource();
        switch (bt_cliente.getName()) {
            case "botonGuardarCambios":
                ModCliente cliente = new ModCliente();
                cliente.setNombre(venCamposModificar.getCampoNombre().getText());
                cliente.setApellidoPaterno(venCamposModificar.getCampoApellidoP().getText());
                cliente.setApellidoMaterno(venCamposModificar.getCampoApellidoM().getText());
                cliente.setSexo(venCamposModificar.getGrupoSexos().getSelection().getActionCommand().toUpperCase());
                cliente.setEmail(venCamposModificar.getCampoEmail().getText());
                cliente.setTelefono(Long.parseLong(venCamposModificar.getCampoTelefono().getText()));
                long telefonoCopia = venCamposModificar.getTelefonoCopia();
                sqlClientes.modificarCliente(cliente, telefonoCopia);
                buscarCliente();
                venCamposModificar.setVisible(false);
                break;
            case "botonCancelar":
                venCamposModificar.setVisible(false);
        }
    }

    public void buscarCliente() {
        DefaultTableModel tb_modelo = (DefaultTableModel) venCamposModificar.getTablaClientes().getModel();
        String textoBuscar = venCamposModificar.getCampoCliente().getText();
        sqlClientes.buscarCliente(textoBuscar, tb_modelo);
    }
}
