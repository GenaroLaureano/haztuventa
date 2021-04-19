package paq_controladores.general;

import paq_vistas.general.*;
import paq_modelos.general.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.JFrame;
import paq_utilidades.ModVentanas;

public class OyenteAddInventario extends KeyAdapter implements ActionListener {

    private VentanaAnadir venAdd;
    private final PanelAnadir panelAdd;
    private final ModCargarProductos cargarP;
    private int max;
    private int ubicacion;

    public OyenteAddInventario(PanelAnadir panelAdd, ModCargarProductos cargarP) {
        this.panelAdd = panelAdd;
        this.cargarP = cargarP;
        ubicacion = 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component origen = (Component) e.getSource();

        switch (origen.getName()) {
            case "aceptar":
                cargarMaximo();
                valorCampo();

                break;
            case "piso":
                ubicacion = 1;
                cargarMaximo();
                break;
            case "almacen":
                ubicacion = 2;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                valorCampo();
        }
    }

    public void cargarMaximo() {
        long codigo = Long.valueOf(panelAdd.getcCodigo().getText());
        max = cargarP.maxAlmacen(codigo);
    }

    public void valorCampo() {
        long codigo = Long.valueOf(panelAdd.getcCodigo().getText());
        ModProductos producto = new ModProductos();
        producto.setId(codigo);
        producto = cargarP.verificarProducto(producto);

        JFrame venPadre = ModVentanas.getVentanaPadre();
        venAdd = new VentanaAnadir(venPadre, true, cargarP, this, max);
        venAdd.getEtiquetaCodigo().setText(String.valueOf(producto.getId()));
        venAdd.getEtiquetaNombre().setText(producto.getDescripcion());

        ModVentanas.abrirVentanaDialogo(venPadre,
                venAdd, 500, 250);
        venAdd.setVisible(true);
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public int getMax() {
        return max;
    }
}
