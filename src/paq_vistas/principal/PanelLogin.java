package paq_vistas.principal;

import paq_controladores.principal.OyenteLogin;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import paq_modelos.db.ModSQLogin;

public class PanelLogin extends javax.swing.JPanel {

    private javax.swing.JButton bt_login;
    private javax.swing.JPasswordField tx_contrasena;
    private javax.swing.JTextField tx_usuario;

    public PanelLogin() {
        initComponents();
        addComponentes();
        addEventos(new OyenteLogin(new ModSQLogin(), this));
    }

    public final void addEventos(OyenteLogin oyente) {
        bt_login.addActionListener(oyente);
        tx_contrasena.addActionListener(oyente);
        tx_usuario.addActionListener(oyente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JPasswordField getCampoContrasena() {
        return tx_contrasena;
    }

    public javax.swing.JTextField getCampoUsuario() {
        return tx_usuario;
    }

    private void addComponentes() {

        setBounds(100, 100, 450, 450);
        setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel et_logo = new JLabel("Logo");
        et_logo.setBounds(167, 21, 125, 125);
        URL url = getClass().getResource("/paq_imagenes/logo.png");
        et_logo.setIcon(ajustaTamanoImagen(url.getPath(), et_logo));
        add(et_logo);

        JLabel et_user = new JLabel("user");
        et_user.setBounds(95, 192, 20, 25);
        url = getClass().getResource("/paq_imagenes/user.png");
        et_user.setIcon(ajustaTamanoImagen(url.getPath(), et_user));
        add(et_user);

        JLabel et_pass = new JLabel("pass");
        et_pass.setBounds(95, 267, 20, 25);
        url = getClass().getResource("/paq_imagenes/password.png");
        et_pass.setIcon(ajustaTamanoImagen(url.getPath(), et_pass));
        add(et_pass);

        tx_usuario = new JTextField();
        tx_usuario.setName("campoUsuario");
        tx_usuario.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        tx_usuario.setBounds(128, 182, 232, 45);
        tx_usuario.setBorder(null);
        add(tx_usuario);
        tx_usuario.setColumns(10);

        JLabel et_usuario = new JLabel("Usuario");
        et_usuario.setBounds(86, 182, 281, 45);
        url = getClass().getResource("/paq_imagenes/campo.png");
        et_usuario.setIcon(ajustaTamanoImagen(url.getPath(), et_usuario));
        add(et_usuario);

        tx_contrasena = new JPasswordField();
        tx_contrasena.setName("campoContrasena");
        tx_contrasena.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

        tx_contrasena.setColumns(10);
        tx_contrasena.setBounds(127, 258, 232, 45);
        tx_contrasena.setBorder(null);
        add(tx_contrasena);

        JLabel et_constrasena = new JLabel("Contrasena");
        et_constrasena.setBounds(86, 258, 281, 45);
        url = getClass().getResource("/paq_imagenes/campo.png");
        et_constrasena.setIcon(ajustaTamanoImagen(url.getPath(), et_constrasena));
        add(et_constrasena);

        bt_login = new JButton("Iniciar Sesion");
        bt_login.setName("botonIniciarSesion");
        bt_login.setBackground(new Color(0, 171, 197));
        bt_login.setBounds(250 - 30, 359 - 30, 117, 29);
        bt_login.setSize(new Dimension(150, 50));
        add(bt_login);
    }

    public static ImageIcon ajustaTamanoImagen(String ruta, JLabel et_imagen) {
        Image img = new ImageIcon(ruta).getImage();
        return new ImageIcon(img.getScaledInstance(et_imagen.getWidth(), et_imagen.getHeight(), Image.SCALE_SMOOTH));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
