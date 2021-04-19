package paq_controladores.usuarios;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModUsuario;
import paq_modelos.db.ModSQLUsuario;
import paq_vistas.usuarios.VentanaCamposModificarUsuario;

public class OyenteCamposModificarUsuario implements ActionListener {

    private final ModSQLUsuario sqlUsuario;
    private final VentanaCamposModificarUsuario venCamposModificar;

    public OyenteCamposModificarUsuario(ModSQLUsuario sqlUsuario,
            VentanaCamposModificarUsuario venCamposModificar) {
        this.sqlUsuario = sqlUsuario;
        this.venCamposModificar = venCamposModificar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_usuario = (JButton) e.getSource();
        switch (bt_usuario.getName()) {
            case "botonGuardarCambios":
                ModUsuario cliente = new ModUsuario();
                cliente.setNombre(venCamposModificar.getCampoNombre().getText());
                cliente.setApellidoPaterno(venCamposModificar.getCampoApellidoP().getText());
                cliente.setApellidoMaterno(venCamposModificar.getCampoApellidoM().getText());
                cliente.setNick(venCamposModificar.getCampoNick().getText());
                cliente.setContrasena(venCamposModificar.getCampoContrasenal().getText());
                cliente.setIdCargo(venCamposModificar.getComboCargo().getSelectedIndex());
                String st_nick = venCamposModificar.getNick();
                sqlUsuario.modificarUsuario(cliente, st_nick);
                buscarUsuario();
                venCamposModificar.setVisible(false);
                break;
            case "botonCancelar":
                venCamposModificar.setVisible(false);
        }
    }

    public void buscarUsuario() {
        DefaultTableModel tb_modelo = (DefaultTableModel) venCamposModificar.getTablaUsuario().getModel();
        String st_textobuscar = venCamposModificar.getCampoUsuario().getText();
        sqlUsuario.buscarUsuario(st_textobuscar, tb_modelo);
    }
}
