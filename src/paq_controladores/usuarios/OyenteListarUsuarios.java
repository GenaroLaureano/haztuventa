package paq_controladores.usuarios;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLUsuario;
import paq_vistas.usuarios.PanelCatalogoUsuarios;

public class OyenteListarUsuarios implements ActionListener {

    private final ModSQLUsuario sqlUsuario;
    private final PanelCatalogoUsuarios panelCatUser;

    public OyenteListarUsuarios(ModSQLUsuario sqlUsuario, PanelCatalogoUsuarios panelCatUser) {
        this.sqlUsuario = sqlUsuario;
        this.panelCatUser = panelCatUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "categoria":
                int index = panelCatUser.getComboDepartamentoC().getSelectedIndex();
                int columnas = sqlUsuario.listarUsuarios(index);
                DefaultTableModel tb_modelo = new DefaultTableModel();
                tb_modelo.addColumn("NICK");
                tb_modelo.addColumn("NOMBRE");
                tb_modelo.addColumn("APELLIDO PATERNO");
                tb_modelo.addColumn("APPELLIDO MATERNO");
                panelCatUser.getTablaC().setModel(tb_modelo);

                try {
                    while (sqlUsuario.getR().next()) {
                        Object[] filas = new Object[columnas];
                        for (int i = 0; i < columnas; i++) {
                            filas[i] = sqlUsuario.getR().getObject(i + 1);
                        }
                        tb_modelo.addRow(filas);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
}
