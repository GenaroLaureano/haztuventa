package paq_controladores.usuarios;

import paq_vistas.usuarios.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import paq_modelos.db.ModSQLUsuario;

public class OyenteBotonesUsuario implements ActionListener {

    private final PanelUsuarios panelUsuario;
    private final ModSQLUsuario sqlUsuario;
    private final PanelNuevoUsuario panelNuevoUsuario;
    private final PanelModificarUsuario panelModificarUsuario;
    private final PanelEliminarUsuario panelEliminarUsuario;
    private final PanelCatalogoUsuarios panelCatalogoUsuarios;

    public OyenteBotonesUsuario(ModSQLUsuario sqlUsuario, PanelUsuarios panelUsuario) {
        this.panelUsuario = panelUsuario;
        this.sqlUsuario = sqlUsuario;
        panelNuevoUsuario = new PanelNuevoUsuario(sqlUsuario);
        panelModificarUsuario = new PanelModificarUsuario(sqlUsuario);
        panelEliminarUsuario = new PanelEliminarUsuario(sqlUsuario);
        panelCatalogoUsuarios = new PanelCatalogoUsuarios(sqlUsuario);
        panelUsuario.getPanelCentro().add(panelNuevoUsuario);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component[] botones = panelUsuario.getPanelNorte().getComponents();
        JPanel panelCentro = panelUsuario.getPanelCentro();
        JButton bt_usuario = (JButton) e.getSource();
        panelCentro.removeAll();
        switch (bt_usuario.getName()) {
            case "nuevoUsuario":
                panelCentro.add(panelNuevoUsuario);
                break;
            case "modificarUsuario":
                panelCentro.add(panelModificarUsuario);
                break;
            case "eliminarUsuario":
                panelCentro.add(panelEliminarUsuario);
                break;
            case "listarTodos":
                panelCentro.add(panelCatalogoUsuarios);
                break;
        }
        bt_usuario.setEnabled(false);
        for (int i = 0; i < botones.length; i++) {
            if (!botones[i].getName().equals(bt_usuario.getName())) {
                botones[i].setEnabled(true);
            }
        }
        panelCentro.revalidate();
        panelCentro.repaint();
    }
}
