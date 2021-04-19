package paq_controladores.clientes;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLClientes;
import paq_vistas.clientes.PanelCatalogoDevoluciones;

public class OyenteListarClientes implements ActionListener {

    private final PanelCatalogoDevoluciones panelCatalogo;
    private final ModSQLClientes sqlCliente;

    public OyenteListarClientes(ModSQLClientes cliente, PanelCatalogoDevoluciones PanelCatalogo) {
        this.panelCatalogo = PanelCatalogo;
        this.sqlCliente = cliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();

        switch (origen.getName()) {
            case "categoria":
                int index = panelCatalogo.getComboDepartamentoC().getSelectedIndex();
                int columnas = sqlCliente.listarProductos(index);
                DefaultTableModel tb_modelo = new DefaultTableModel();
                tb_modelo.addColumn("NOMBRE");
                tb_modelo.addColumn("APELLIDO PATERNO");
                tb_modelo.addColumn("APPELLIDO MATERNO");
                tb_modelo.addColumn("SEXO");
                tb_modelo.addColumn("EMAIL");
                tb_modelo.addColumn("TELEFONO");
                panelCatalogo.getTablaC().setModel(tb_modelo);
                try {
                    while (sqlCliente.getR().next()) {
                        Object[] filas = new Object[columnas];
                        for (int i = 0; i < columnas; i++) {
                            filas[i] = sqlCliente.getR().getObject(i + 1);
                        }
                        tb_modelo.addRow(filas);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
}
