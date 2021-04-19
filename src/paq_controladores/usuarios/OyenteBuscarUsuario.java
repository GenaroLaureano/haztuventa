package paq_controladores.usuarios;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_vistas.clientes.VentanaBuscarCliente;

public class OyenteBuscarUsuario extends KeyAdapter implements ActionListener, DocumentListener {

    private final ModSQLVentas sqlVentas;
    private final VentanaBuscarCliente venBuscaCliente;
    private int numFilaSeleccionada;

    public OyenteBuscarUsuario(ModSQLVentas sqlVentas, VentanaBuscarCliente venBuscaCliente) {
        this.sqlVentas = sqlVentas;
        this.venBuscaCliente = venBuscaCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_usuario = (JButton) e.getSource();
        switch (bt_usuario.getName()) {
            case "botonAceptar":
                agregarNombreClienteBuscado();
                break;
            case "botonCancelar":
                venBuscaCliente.setVisible(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                agregarNombreClienteBuscado();
                break;
            case KeyEvent.VK_ESCAPE:
                venBuscaCliente.setVisible(false);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        String st_descripcion = venBuscaCliente.getCampoBuscarCliente().getText();
        sqlVentas.buscarCliente(st_descripcion);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        String st_descripcion = venBuscaCliente.getCampoBuscarCliente().getText();
        sqlVentas.buscarCliente(st_descripcion);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        String st_descripcion = venBuscaCliente.getCampoBuscarCliente().getText();
        sqlVentas.buscarCliente(st_descripcion);
    }

    public void agregarNombreClienteBuscado() {
        DefaultTableModel tb_modelo = (DefaultTableModel) venBuscaCliente.getTablaBuscarCliente().getModel();
        numFilaSeleccionada = venBuscaCliente.getTablaBuscarCliente().getSelectedRow();
        if (numFilaSeleccionada >= 0) {
            String st_nombre = tb_modelo.getValueAt(numFilaSeleccionada, 0).toString();
            venBuscaCliente.getEtiquetaNombreCliente().setText(st_nombre);
            venBuscaCliente.getCliente().setTelefono((long) tb_modelo.getValueAt(numFilaSeleccionada, 3));
            venBuscaCliente.setVisible(false);
        }
    }
}
