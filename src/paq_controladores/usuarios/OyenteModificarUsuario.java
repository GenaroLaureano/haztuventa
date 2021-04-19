package paq_controladores.usuarios;

import paq_vistas.usuarios.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModUsuario;
import paq_modelos.db.ModSQLUsuario;
import paq_utilidades.ModVentanas;

public class OyenteModificarUsuario implements ActionListener, DocumentListener {

    private final ModSQLUsuario sqlUsuario;
    private final PanelModificarUsuario panelModUser;    

    public OyenteModificarUsuario(ModSQLUsuario sqlUsuario, PanelModificarUsuario panelModUser) {
        this.sqlUsuario = sqlUsuario;
        this.panelModUser = panelModUser;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JTable tb_usuario = panelModUser.getTablaUsuario();
        int numFila = tb_usuario.getSelectedRow();
        if (numFila >= 0) {
            String st_nick = (String) tb_usuario.getValueAt(numFila, 3);
            ModUsuario cliente = sqlUsuario.getUsuario(st_nick);
            if (cliente != null) {
                JFrame venPadre = ModVentanas.getVentanaPadre();
                VentanaCamposModificarUsuario venCamposMod
                        = new VentanaCamposModificarUsuario(sqlUsuario, venPadre, true);
                ModVentanas.abrirVentanaDialogo(venPadre, venCamposMod, 450, 400);
                venCamposMod.setNick(st_nick);
                venCamposMod.setCampoUsuario(panelModUser.getCampoUsuario());
                venCamposMod.setTablaUsuario(panelModUser.getTablaUsuario());                
                venCamposMod.getCampoNombre().setText(cliente.getNombre());
                venCamposMod.getCampoApellidoP().setText(cliente.getApellidoPaterno());
                venCamposMod.getCampoApellidoM().setText(cliente.getApellidoMaterno());
                venCamposMod.getCampoNick().setText(cliente.getNick());
                venCamposMod.getCampoContrasenal().setText(cliente.getContrasena());
                venCamposMod.getComboCargo().setSelectedIndex(cliente.getIdCargo()-1);
                venCamposMod.setVisible(true);
            }
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        buscarUsuario();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buscarUsuario();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buscarUsuario();
    }

    public void buscarUsuario() {
        DefaultTableModel tb_modelo = (DefaultTableModel) panelModUser.getTablaUsuario().getModel();
        String textoBuscar = panelModUser.getCampoUsuario().getText();
        sqlUsuario.buscarUsuario(textoBuscar, tb_modelo);
    }
}
