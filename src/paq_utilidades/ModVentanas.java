package paq_utilidades;

import javax.swing.*;

public class ModVentanas {

    private static JFrame venFrame;

    public static void abrirVentanaDialogo(JFrame venFrame, JDialog venDialogo, int ancho, int alto) {
        venDialogo.setSize(ancho, alto);
        int cx = venFrame.getWidth() / 2;
        int cy = venFrame.getHeight() / 2;
        int x1 = cx - venDialogo.getWidth() / 2;
        int y1 = cy - venDialogo.getHeight() / 2;
        venDialogo.setLocation(venFrame.getX() + x1, venFrame.getY() + y1);
    }

    public static void setVentanaPadre(JFrame ventana) {
        ModVentanas.venFrame = ventana;
    }

    public static JFrame getVentanaPadre() {
        return venFrame;
    }
}
