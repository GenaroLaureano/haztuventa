package paq_controladores.devoluciones;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import paq_modelos.db.ModSQLVentas;
import paq_modelos.general.ModProductos;
import paq_vistas.devoluciones.VentanaTicket;

public class OyenteTicket implements ActionListener {

    private final ModSQLVentas sqlVentas;
    private final VentanaTicket venTicket;

    public OyenteTicket(ModSQLVentas sqlVentas, VentanaTicket venTicket) {
        this.sqlVentas = sqlVentas;
        this.venTicket = venTicket;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int folio = Integer.valueOf(venTicket.getEtiquetaFolio().getText());
        sqlVentas.cancelarTicket(folio);
        sqlVentas.cancelarVenta(folio);
        ArrayList<ModProductos> al_productos = new ArrayList();
        al_productos = sqlVentas.unidadesProducto(folio);

        for (ModProductos p : al_productos) {
            sqlVentas.actualizarInventario(p.getId(), p.getExistencia());
        }

        JOptionPane.showMessageDialog(null, "LA CANCELACION SE REALIZO CON EXITO");
        venTicket.setVisible(false);
    }
}
