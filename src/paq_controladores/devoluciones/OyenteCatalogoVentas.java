package paq_controladores.devoluciones;

import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_vistas.devoluciones.PanelCatalogoDev;

public class OyenteCatalogoVentas implements ActionListener {

    private final PanelCatalogoDev panelCatalogoDev;
    private final ModSQLVentas sqlVentas;

    public OyenteCatalogoVentas(PanelCatalogoDev panelCatalogoDev, ModSQLVentas sqlVentas) {
        this.panelCatalogoDev = panelCatalogoDev;
        this.sqlVentas = sqlVentas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(panelCatalogoDev.getCalendario().getDate() == null)) {
            JComponent origen = (JComponent) e.getSource();
            switch (origen.getName()) {
                case "categoria":
                    int index = panelCatalogoDev.getComboDepartamentoC().getSelectedIndex();
                    Date dia = panelCatalogoDev.getCalendario().getDate();
                    long d = dia.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    Time h = new Time(0, 0, 0);
                    Time hS = new Time(23, 59, 59);
                    System.out.println("dia:" + fecha + " " + "h");
                    int columnas = sqlVentas.listarVentas(index, fecha + " " + h, fecha + " " + hS);
                    DefaultTableModel tb_modelo = new DefaultTableModel();
                    tb_modelo.addColumn("Folio Venta");
                    tb_modelo.addColumn("Productos Vendidos");
                    tb_modelo.addColumn("Total Venta");
                    tb_modelo.addColumn("Utilidad Venta");
                    panelCatalogoDev.getTablaC().setModel(tb_modelo);

                    try {
                        while (sqlVentas.getRs().next()) {
                            Object[] filas = new Object[columnas];
                            for (int i = 0; i < columnas; i++) {
                                filas[i] = sqlVentas.getRs().getObject(i + 1);
                            }
                            tb_modelo.addRow(filas);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UNA FECHA");
        }
    }
}
