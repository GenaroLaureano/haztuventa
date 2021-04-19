package paq_controladores.devoluciones;

import paq_vistas.devoluciones.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_utilidades.ModVentanas;

public class OyenteDevoluciones extends KeyAdapter implements ActionListener {

    private final PanelDevolucion panelDevolucion;
    private VentanaTicket venTicket;
    private final ModSQLVentas sqlVentas;

    public OyenteDevoluciones(PanelDevolucion panelDevolucion, ModSQLVentas sqlVentas) {
        this.panelDevolucion = panelDevolucion;
        this.sqlVentas = sqlVentas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        abrirVentana();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                abrirVentana();
                break;
        }
    }

    public void abrirVentana() {
        int codigo = Integer.valueOf(panelDevolucion.getcCodigo().getText());
        JFrame venPadre = ModVentanas.getVentanaPadre();
        venTicket = new VentanaTicket(venPadre, true);
        venTicket.getEtiquetaFolio().setText(panelDevolucion.getcCodigo().getText());
        venTicket.getEtiquetaTotal().setText(String.valueOf(sqlVentas.totalVentas(codigo)));
        if (sqlVentas.verificar(codigo)) {
            agregarTabla(codigo);
            ModVentanas.abrirVentanaDialogo(venPadre,
                    venTicket, 500, 250);
            venTicket.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La venta no esta registrada o ya fue cancelada");
        }
    }

    public void agregarTabla(int codigo) {

        int columnas = sqlVentas.devolverTicket(codigo);
        DefaultTableModel tb_modelo = new DefaultTableModel();
        tb_modelo.addColumn("DESCRIPCION");
        tb_modelo.addColumn("UNIDADES");
        tb_modelo.addColumn("PRECIO");
        tb_modelo.addColumn("TOTAL");
        venTicket.getTablaTicket().setModel(tb_modelo);
        try {
            int a = 0;
            while (sqlVentas.getRs().next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = sqlVentas.getRs().getObject(i + 1);
                }
                tb_modelo.addRow(filas);
                Object unidades = tb_modelo.getValueAt(a, 1);
                Object precio = tb_modelo.getValueAt(a, 2);
                Object z = (long) unidades * (float) precio;
                tb_modelo.setValueAt(z, a, 3);
                a++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
