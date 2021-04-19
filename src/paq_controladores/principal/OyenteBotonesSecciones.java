package paq_controladores.principal;

import paq_vistas.general.*;
import paq_controladores.general.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import paq_modelos.general.ModCargarProductos;
import paq_vistas.corte.PanelCorte;
import paq_vistas.clientes.PanelClientes;
import paq_vistas.principal.PanelSecciones;
import paq_vistas.devoluciones.PanelDevolucionPrincipal;
import paq_vistas.usuarios.PanelUsuarios;
import paq_vistas.ventas.PanelVentas;

public class OyenteBotonesSecciones implements ActionListener {

    private final PanelSecciones panelSecciones;
    private final PanelVentas panelVentas;
    private final PanelClientes panelClientes;
    private final PanelUsuarios panelUsuarios;
    private final PanelCorte panelCorte;
    private final PanelDevolucionPrincipal panelDevolucion;

    public OyenteBotonesSecciones(PanelSecciones panelSecciones) {
        this.panelSecciones = panelSecciones;
        panelVentas = new PanelVentas();
        panelClientes = new PanelClientes();
        panelUsuarios = new PanelUsuarios();
        panelCorte = new PanelCorte();
        panelDevolucion = new PanelDevolucionPrincipal();
        panelSecciones.getPanelCentro().add(panelVentas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component[] arr_botones = panelSecciones.getPanelNorteBotonesSecciones().getComponents();
        JPanel panelCentro = panelSecciones.getPanelCentro();
        JButton bt_seccion = (JButton) e.getSource();
        panelCentro.removeAll();
        switch (bt_seccion.getName()) {
            case "seccionVentas":
                panelCentro.add(panelVentas);
                break;
            case "seccionClientes":
                panelCentro.add(panelClientes);
                break;
            case "seccionProductos":
                PanelNuevo panelNuevo = new PanelNuevo();
                PanelPrincipal panelPrincipal = new PanelPrincipal(panelNuevo);
                ModCargarProductos cargarProd = new ModCargarProductos();
                PanelModificar panelModificar = new PanelModificar();
                PanelModificarProducto panelModProd = new PanelModificarProducto();
                PanelCategoria panelCategoria = new PanelCategoria();
                PanelCatalogo panelCatalogo = new PanelCatalogo();
                PanelEliminar panelEliminar = new PanelEliminar();
                PanelEliminarProducto panelDelProd = new PanelEliminarProducto();
                PanelAnadir panelAñadir = new PanelAnadir(cargarProd);
                OyentePrincipal oyentePincipal = new OyentePrincipal(panelPrincipal, panelNuevo, panelModificar, panelCategoria, panelCatalogo, panelEliminar, panelAñadir, cargarProd);

                OyenteNuevoProducto oyenteNuevo = new OyenteNuevoProducto(panelNuevo);
                OyenteBuscarModificar oyenteBuscarMod = new OyenteBuscarModificar(panelModificar, panelPrincipal, panelModProd);
                OyenteCategorias oyenteCateg = new OyenteCategorias(panelCategoria);
                OyenteCatalogo oyenteCatal = new OyenteCatalogo(panelCatalogo);
                OyenteEliminarProducto oyenteEliminar = new OyenteEliminarProducto(panelDelProd, panelPrincipal, panelEliminar);
                OyenteModificarProductos oyenteMod = new OyenteModificarProductos(panelModProd, panelPrincipal, panelModificar);
                OyenteBuscarEliminar oyenteBuscarDel = new OyenteBuscarEliminar(panelEliminar, panelPrincipal, panelDelProd);

                panelPrincipal.addEventos(oyentePincipal);
                panelNuevo.addEventos(oyenteNuevo);
                panelModificar.addEventos(oyenteBuscarMod);
                panelModProd.addEvents(oyenteMod);
                panelCategoria.addEventos(oyenteCateg);
                panelCatalogo.addEventos(oyenteCatal);
                panelEliminar.addEventos(oyenteBuscarDel);
                panelDelProd.addEventos(oyenteEliminar);
                panelCentro.add(panelPrincipal);
                break;

            case "seccionInventario":
                System.out.println("inventario");
                break;
            case "seccionUsuarios":
                panelCentro.add(panelUsuarios);
                break;
            case "botonSalir":
                panelCentro.add(panelCorte);
                break;
            case "devoluciones":
                panelCentro.add(panelDevolucion);
                break;
        }
        bt_seccion.setEnabled(false);
        for (int i = 0; i < arr_botones.length; i++) {
            if (!arr_botones[i].getName().equals(bt_seccion.getName())) {
                arr_botones[i].setEnabled(true);
            }
        }
        panelCentro.revalidate();
        panelCentro.repaint();
    }
}
