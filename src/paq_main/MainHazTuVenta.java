package paq_main;

import paq_vistas.principal.*;
import java.awt.*;
import javax.swing.JFrame;
import paq_utilidades.ModVentanas;

public class MainHazTuVenta {

    public static void main(String[] args) {

        VentanaSistema f = new VentanaSistema();
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamañoPantalla = pantalla.getScreenSize();
        int x = (tamañoPantalla.width / 2) - 225;
        int y = (tamañoPantalla.height / 2) - 225;
        f.setBounds(x, y, 450, 450);
        f.setMinimumSize(new Dimension(450, 450));
        f.setMaximumSize(new Dimension(450, 450));
        ModVentanas.setVentanaPadre(f);
        f.add(new PanelLogin());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
