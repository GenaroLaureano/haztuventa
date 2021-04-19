package paq_controladores.principal;

import paq_vistas.principal.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import paq_modelos.principal.ModUsuario;
import paq_modelos.db.ModSQLogin;
import paq_utilidades.ModVentanas;

public class OyenteLogin implements ActionListener {

    private final ModSQLogin sqlLogin;
    private final PanelLogin panelLogin;

    public OyenteLogin(ModSQLogin sqlLogin, PanelLogin panelLogin) {
        this.sqlLogin = sqlLogin;
        this.panelLogin = panelLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent componente = (JComponent) e.getSource();
        switch (componente.getName()) {
            case "botonIniciarSesion":
            case "campoContrasena":
            case "campoUsuario":
                String st_nick = panelLogin.getCampoUsuario().getText();
                String st_contrasena = panelLogin.getCampoContrasena().getText();
                ModUsuario usuario = sqlLogin.validarLogin(st_nick, st_contrasena);
                if (usuario != null) {
                    ModVentanas.getVentanaPadre().setVisible(false);
                    VentanaSistema venSistema = new VentanaSistema();
                    venSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Toolkit pantalla = Toolkit.getDefaultToolkit();
                    Dimension tamañoPantalla = pantalla.getScreenSize();
                    int x = (tamañoPantalla.width / 2) - 150;
                    int y = (tamañoPantalla.height / 2) - 150;
                    venSistema.setBounds(x, y, 300, 300);
                    ModVentanas.setVentanaPadre(venSistema);
                    venSistema.add(new PanelSaldoInicial());
                    venSistema.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(panelLogin, "Contraseña o Usuario Invalido",
                            "Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }
}
