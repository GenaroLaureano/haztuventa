package paq_controladores.general;

import paq_modelos.general.*;
import paq_vistas.general.PanelCatalogo;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OyenteCatalogo extends WindowAdapter implements ActionListener {

    private final PanelCatalogo panelCatalogo;
    private final ModCargarProductos cargarP;

    public OyenteCatalogo(PanelCatalogo panelCatalogo) {
        this.panelCatalogo = panelCatalogo;
        cargarP = new ModCargarProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();
        switch (origen.getName()) {
            case "categoria":
                ModCategorias categoria = new ModCategorias();
                categoria.setId(panelCatalogo.getComboDepartamentoC().getSelectedIndex());
                int columnas = cargarP.listarProductos(categoria);
                DefaultTableModel tb_modelo = new DefaultTableModel();
                tb_modelo.addColumn("CODIGO");
                tb_modelo.addColumn("CATEGORIA");
                tb_modelo.addColumn("COSTO");
                tb_modelo.addColumn("PRECIO");
                tb_modelo.addColumn("GANANCIA");
                panelCatalogo.getTablaC().setModel(tb_modelo);
                try {
                    while (cargarP.getRs().next()) {
                        Object[] filas = new Object[columnas];
                        for (int i = 0; i < columnas; i++) {
                            filas[i] = cargarP.getRs().getObject(i + 1);
                        }
                        tb_modelo.addRow(filas);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
}
