package paq_controladores.general;

import paq_modelos.general.*;
import paq_vistas.general.PanelCategoria;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class OyenteCategorias implements ActionListener, DocumentListener {

    private final PanelCategoria panelCategoria;
    private final ModCargarProductos cargarP;

    public OyenteCategorias(PanelCategoria panelCategoria) {
        this.panelCategoria = panelCategoria;
        cargarP = new ModCargarProductos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();
        switch (bt_origen.getName()) {
            case "guardar":
                ModCategorias categoria = new ModCategorias();
                categoria.setNombre(panelCategoria.getCampoNombreD().getText());
                int r = cargarP.registraCategoria(categoria);
                if (r > 0) {
                    panelCategoria.cargarCategorias();
                    JOptionPane.showMessageDialog(null, "La categoria se registro correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error en el registro");
                }
                break;
            case "cancelar":
                panelCategoria.getCampoNombreD().setText("");
                break;
            case "eliminar":
                ModCategorias categoria2 = new ModCategorias();
                categoria2.setNombre(panelCategoria.getListaInternaD().getSelectedValue());
                int res = cargarP.eliminarCategoria(categoria2);
                if (res > 0) {
                    panelCategoria.cargarCategorias();
                    JOptionPane.showMessageDialog(null, "La categoria se elimino Correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la categoria");
                }
        }
    }

    public void buscarCategoria() {
        DefaultListModel lista = (DefaultListModel) panelCategoria.getListaInternaD().getModel();
        String textoBuscar = panelCategoria.getCampoBusquedaD().getText();
        cargarP.buscarCategoria(textoBuscar, lista);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        buscarCategoria();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buscarCategoria();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buscarCategoria();
    }
}
