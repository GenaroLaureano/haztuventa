package paq_controladores.principal;

import paq_vistas.principal.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import paq_modelos.db.ModSQLogin;
import paq_utilidades.ModVentanas;

public class OyenteSaldoInicial extends KeyAdapter implements ActionListener {

    private PanelSaldoInicial panelSaldo;

    public OyenteSaldoInicial(PanelSaldoInicial panelSaldo) {
        this.panelSaldo = panelSaldo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent componente = (JComponent) e.getSource();
        switch (componente.getName()) {
            case "aceptar":
                abrirVentana();
        }
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
        ModSQLogin.setFondoCaja(Float.valueOf(panelSaldo.getcCantidad().getText()));
        ModVentanas.getVentanaPadre().setVisible(false);
        VentanaSistema venSistema = new VentanaSistema();
        venSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamañoPantalla = pantalla.getScreenSize();
        int x = (tamañoPantalla.width / 2) - 400;
        int y = (tamañoPantalla.height / 2) - 300;
        venSistema.setBounds(0, 0, tamañoPantalla.width, tamañoPantalla.height - 30);
        ModVentanas.setVentanaPadre(venSistema);
        venSistema.add(new PanelSecciones());
        venSistema.setVisible(true);
    }
}
