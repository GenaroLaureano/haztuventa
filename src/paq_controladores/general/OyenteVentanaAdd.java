package paq_controladores.general;

import java.awt.event.*;
import javax.swing.*;
import paq_modelos.principal.ModInventario;
import paq_modelos.general.ModCargarProductos;
import paq_vistas.general.VentanaAnadir;

public class OyenteVentanaAdd implements ActionListener {

    private final VentanaAnadir venAdd;
    private final ModCargarProductos cargarProductos;
    private final OyenteAddInventario oyenteInv;
    private final int max;

    public OyenteVentanaAdd(VentanaAnadir venAdd, ModCargarProductos cargarProductos, OyenteAddInventario oyenteInv, int max) {
        this.cargarProductos = cargarProductos;
        this.venAdd = venAdd;
        this.oyenteInv = oyenteInv;
        this.max = max;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();
        switch (bt_origen.getName()) {
            case "aceptar":
                ModInventario inventario = cargarProductos.seleccionarInventario(Long.valueOf(venAdd.getEtiquetaCodigo().getText()), oyenteInv.getUbicacion());
                System.out.println("ubicacion" + oyenteInv.getUbicacion());
                System.out.println("max" + oyenteInv.getMax());
                if (inventario != null) {
                    if ((oyenteInv.getUbicacion() == 1) && ((int) venAdd.getSpinerCantidad().getValue() > max)) {
                        JOptionPane.showMessageDialog(null, "ESTA EXCEDIENDO LA CANTIDAD DEL ALAMACEN");
                    } else {
                        int resultado = cargarProductos.actualizarInventarioEntradas2(inventario, (int) venAdd.getSpinerCantidad().getValue());
                        if (resultado > 0) {
                            JOptionPane.showMessageDialog(null, "Se añadio correctamente al inventario");
                            venAdd.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al añadir");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "NO SE ENCONTRO INVENTARIO PARA ESE PRODUCTO");
                }
                break;
        }
    }
}
