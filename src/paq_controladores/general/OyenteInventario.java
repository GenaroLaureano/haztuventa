package paq_controladores.general;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import paq_modelos.general.ModCargarProductos;
import paq_vistas.general.PanelInventario;

public class OyenteInventario implements ActionListener {

    private final PanelInventario panelInv;
    private final ModCargarProductos cargarP;

    public OyenteInventario(PanelInventario panelInv) {
        this.panelInv = panelInv;
        this.cargarP = new ModCargarProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent origen = (JComponent) e.getSource();

        switch (origen.getName()) {
            case "categoria":
                int index = panelInv.getComboDepartamentoC().getSelectedIndex();

                int columnas = cargarP.listarInventario(index);

                DefaultTableModel tb_modelo = new DefaultTableModel();
                tb_modelo.addColumn("CODIGO");
                tb_modelo.addColumn("CATEGORIA");
                tb_modelo.addColumn("ENTRADAS");
                tb_modelo.addColumn("SALIDAS");
                tb_modelo.addColumn("TOTAL");
                panelInv.getTablaC().setModel(tb_modelo);
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
