package paq_controladores.usuarios;

import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.principal.ModUsuario;
import paq_modelos.db.ModSQLUsuario;
import paq_vistas.usuarios.PanelEliminarUsuario;

public class OyenteEliminarUsuario implements ActionListener, DocumentListener {

    private final ModSQLUsuario sqlUsuario;
    private final PanelEliminarUsuario panelEliminarUsuario;

    public OyenteEliminarUsuario(ModSQLUsuario sqlUsuario, PanelEliminarUsuario panelEliminarUsuario) {
        this.sqlUsuario = sqlUsuario;
        this.panelEliminarUsuario = panelEliminarUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable tb_usuario = panelEliminarUsuario.getTablaUsuario();
        int numFila = tb_usuario.getSelectedRow();
        if (numFila >= 0) {
            String st_nick = (String) tb_usuario.getValueAt(numFila, 3);
            ModUsuario cliente = sqlUsuario.getUsuario(st_nick);

            sqlUsuario.eliminarUsuario(st_nick);
            buscarUsuario();
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
        DefaultTableModel tb_modelo = (DefaultTableModel) panelEliminarUsuario.getTablaUsuario().getModel();
        String textoBuscar = panelEliminarUsuario.getCampoUsuario().getText();
        sqlUsuario.buscarUsuario(textoBuscar, tb_modelo);
    }
}
