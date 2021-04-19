package paq_controladores.clientes;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import paq_modelos.db.ModSQLVentas;
import paq_vistas.clientes.VentanaBuscarCliente;

public class OyenteBuscarCliente extends KeyAdapter implements ActionListener, DocumentListener {

    private final ModSQLVentas sqlVentas;
    private final VentanaBuscarCliente venBuscarCliente;
    private int numFilaSeleccionada;

    public OyenteBuscarCliente(ModSQLVentas sqlVentas, VentanaBuscarCliente ventanaBuscarCliente) {
        this.sqlVentas = sqlVentas;
        this.venBuscarCliente = ventanaBuscarCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_cliente = (JButton) e.getSource();
        switch (bt_cliente.getName()) {
            case "bt_aceptar":
                agregarNombreClienteBuscado();
                break;
            case "bt_cancelar":
                venBuscarCliente.setVisible(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                agregarNombreClienteBuscado();
                break;
            case KeyEvent.VK_ESCAPE:
                venBuscarCliente.setVisible(false);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        String st_descripcion = venBuscarCliente.getCampoBuscarCliente().getText();
        sqlVentas.buscarCliente(st_descripcion);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        String st_descripcion = venBuscarCliente.getCampoBuscarCliente().getText();
        sqlVentas.buscarCliente(st_descripcion);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        String st_descripcion = venBuscarCliente.getCampoBuscarCliente().getText();
        sqlVentas.buscarCliente(st_descripcion);
    }

    public void agregarNombreClienteBuscado() {
        DefaultTableModel tb_modelo = (DefaultTableModel) venBuscarCliente.getTablaBuscarCliente().getModel();
        numFilaSeleccionada = venBuscarCliente.getTablaBuscarCliente().getSelectedRow();
        if (numFilaSeleccionada >= 0) {
            String st_nombre = tb_modelo.getValueAt(numFilaSeleccionada, 0).toString();
            venBuscarCliente.getEtiquetaNombreCliente().setText(st_nombre);
            venBuscarCliente.getCliente().setTelefono((long) tb_modelo.getValueAt(numFilaSeleccionada, 3));
            venBuscarCliente.setVisible(false);
        }
    }

}
