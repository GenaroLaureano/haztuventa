package paq_controladores.usuarios;

import java.awt.event.*;
import javax.swing.*;
import paq_modelos.principal.ModUsuario;
import paq_modelos.db.ModSQLUsuario;
import paq_vistas.usuarios.PanelNuevoUsuario;

public class OyenteNuevoUsuario implements ActionListener {

    private final ModSQLUsuario sqlUsuario;
    private final PanelNuevoUsuario panelNuevoUsuario;

    public OyenteNuevoUsuario(ModSQLUsuario sqlUsuario, PanelNuevoUsuario panelNuevoUsuario) {
        this.sqlUsuario = sqlUsuario;
        this.panelNuevoUsuario = panelNuevoUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton bt_origen = (JButton) ae.getSource();
        switch (bt_origen.getName()) {
            case "guardar":
                agregarUsuario();
                break;
            case "cancelar":
                limpiarCampos();
                break;
        }
    }

    public void limpiarCampos() {
        panelNuevoUsuario.getCampoNombre().setText("");
        panelNuevoUsuario.getCampoApellidoP().setText("");
        panelNuevoUsuario.getCampoApellidoM().setText("");
        panelNuevoUsuario.getCampoContrseña().setText("");
        panelNuevoUsuario.getCampoUsuario().setText("");
        panelNuevoUsuario.getComboCargo().setSelectedIndex(0);
    }

    private void agregarUsuario() {
        ModUsuario usuario = new ModUsuario();
        int r;
        usuario.setNombre(panelNuevoUsuario.getCampoNombre().getText());
        usuario.setApellidoPaterno(panelNuevoUsuario.getCampoApellidoP().getText());
        usuario.setApellidoMaterno(panelNuevoUsuario.getCampoApellidoM().getText());
        usuario.setContrasena(panelNuevoUsuario.getCampoContrseña().getText());
        usuario.setNick(panelNuevoUsuario.getCampoUsuario().getText());
        usuario.setIdCargo(panelNuevoUsuario.getComboCargo().getSelectedIndex());
        r = sqlUsuario.registrarUsuario(usuario);
        if (r > 0) {
            JOptionPane.showMessageDialog(null, "El usuario se registro correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un fallo en el registro del cliente");
        }
        limpiarCampos();
    }
}
