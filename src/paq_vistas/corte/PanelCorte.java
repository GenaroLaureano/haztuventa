package paq_vistas.corte;

import paq_controladores.corte.OyenteCorte;
import javax.swing.JLabel;
import paq_modelos.db.*;

public final class PanelCorte extends javax.swing.JPanel {

    public PanelCorte() {
        initComponents();
        ModSQLUsuario sqlUsuario = new ModSQLUsuario();
        ModSQLCorte sqlCorte = new ModSQLCorte();
        addEventos(new OyenteCorte(this, sqlUsuario, sqlCorte));
    }

    public void addEventos(OyenteCorte e) {
        this.bt_cortecajero.addActionListener(e);
        this.bt_cortedia.addActionListener(e);
        this.bt_cortecajero.setName("cajero");
        this.bt_cortedia.setName("dia");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCorte = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        bt_cortecajero = new javax.swing.JButton();
        bt_cortedia = new javax.swing.JButton();
        panelResultados = new javax.swing.JPanel();
        panelRegistraCorte = new javax.swing.JPanel();
        et_personacorte = new javax.swing.JLabel();
        et_fechacorte = new javax.swing.JLabel();
        panelResultadosCorte = new javax.swing.JPanel();
        panelVentasTotales = new javax.swing.JPanel();
        panelVentasInterior = new javax.swing.JPanel();
        et_ventastotales = new javax.swing.JLabel();
        et_resultadoventatotal = new javax.swing.JLabel();
        panelGanancia = new javax.swing.JPanel();
        panelGananciaInterior = new javax.swing.JPanel();
        et_ganancia = new javax.swing.JLabel();
        et_resultadoganancia = new javax.swing.JLabel();
        panelDineroCaja = new javax.swing.JPanel();
        et_dinerocaja = new javax.swing.JLabel();
        panelDineroCajaInterior = new javax.swing.JPanel();
        et_fondocaja = new javax.swing.JLabel();
        et_resultadofondocaja = new javax.swing.JLabel();
        et_ventasefectivo = new javax.swing.JLabel();
        et_resultadoventasefectivo = new javax.swing.JLabel();
        et_devolucionefectivo = new javax.swing.JLabel();
        et_resultadodevolucionefectivo = new javax.swing.JLabel();
        et_resultadodinerocaja = new javax.swing.JLabel();
        et_totaldinerocaja = new javax.swing.JLabel();
        panelVentas = new javax.swing.JPanel();
        et_ventas = new javax.swing.JLabel();
        panelVentaInterior = new javax.swing.JPanel();
        et_efectivo = new javax.swing.JLabel();
        et_resultadoefectivo = new javax.swing.JLabel();
        et_tarjeta = new javax.swing.JLabel();
        et_resultadotarjeta = new javax.swing.JLabel();
        et_vales = new javax.swing.JLabel();
        et_resultadovales = new javax.swing.JLabel();
        et_devoluciones = new javax.swing.JLabel();
        et_resultadodevoluciones = new javax.swing.JLabel();
        et_resultadoventas = new javax.swing.JLabel();
        et_totalventas = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        panelCorte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CORTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Console", 1, 18))); // NOI18N
        panelCorte.setLayout(new java.awt.BorderLayout());

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        bt_cortecajero.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_cortecajero.setText("Hacer corte de cajero");
        bt_cortecajero.setPreferredSize(new java.awt.Dimension(220, 50));
        panelBotones.add(bt_cortecajero);

        bt_cortedia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bt_cortedia.setText("Hacer corte del día");
        bt_cortedia.setPreferredSize(new java.awt.Dimension(220, 50));
        panelBotones.add(bt_cortedia);

        panelCorte.add(panelBotones, java.awt.BorderLayout.NORTH);

        panelResultados.setLayout(new java.awt.BorderLayout());

        panelRegistraCorte.setLayout(new java.awt.GridLayout(2, 0));

        et_personacorte.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_personacorte.setText("Corte de...");
        panelRegistraCorte.add(et_personacorte);

        et_fechacorte.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_fechacorte.setText("Del día y la hora - al día y la hora-");
        panelRegistraCorte.add(et_fechacorte);

        panelResultados.add(panelRegistraCorte, java.awt.BorderLayout.NORTH);

        panelResultadosCorte.setLayout(new java.awt.GridLayout(3, 2));

        panelVentasTotales.setLayout(new java.awt.BorderLayout());

        et_ventastotales.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_ventastotales.setText("TOTAL VENTAS ");
        panelVentasInterior.add(et_ventastotales);

        et_resultadoventatotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadoventatotal.setText("$0.00");
        panelVentasInterior.add(et_resultadoventatotal);

        panelVentasTotales.add(panelVentasInterior, java.awt.BorderLayout.CENTER);

        panelResultadosCorte.add(panelVentasTotales);

        et_ganancia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_ganancia.setText("TOTAL GANANCIA ");
        panelGananciaInterior.add(et_ganancia);

        et_resultadoganancia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadoganancia.setText("$0.00");
        panelGananciaInterior.add(et_resultadoganancia);

        panelGanancia.add(panelGananciaInterior);

        panelResultadosCorte.add(panelGanancia);

        panelDineroCaja.setLayout(new java.awt.BorderLayout());

        et_dinerocaja.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_dinerocaja.setText("Dinero en Caja");
        panelDineroCaja.add(et_dinerocaja, java.awt.BorderLayout.NORTH);

        panelDineroCajaInterior.setLayout(new java.awt.GridLayout(0, 2, 0, 7));

        et_fondocaja.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_fondocaja.setText("Fondo de caja");
        panelDineroCajaInterior.add(et_fondocaja);

        et_resultadofondocaja.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadofondocaja.setText("   $0.00");
        panelDineroCajaInterior.add(et_resultadofondocaja);

        et_ventasefectivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_ventasefectivo.setText("Ventas en efectivo");
        panelDineroCajaInterior.add(et_ventasefectivo);

        et_resultadoventasefectivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadoventasefectivo.setText("+ $0.00");
        panelDineroCajaInterior.add(et_resultadoventasefectivo);

        et_devolucionefectivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_devolucionefectivo.setText("Devoluciones en efectivo");
        panelDineroCajaInterior.add(et_devolucionefectivo);

        et_resultadodevolucionefectivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadodevolucionefectivo.setText("-  $0.00");
        panelDineroCajaInterior.add(et_resultadodevolucionefectivo);

        et_resultadodinerocaja.setText("TOTAL CAJA ");
        panelDineroCajaInterior.add(et_resultadodinerocaja);

        et_totaldinerocaja.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_totaldinerocaja.setText("    $0.00");
        panelDineroCajaInterior.add(et_totaldinerocaja);

        panelDineroCaja.add(panelDineroCajaInterior, java.awt.BorderLayout.CENTER);

        panelResultadosCorte.add(panelDineroCaja);

        panelVentas.setLayout(new java.awt.BorderLayout());

        et_ventas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_ventas.setText("Ventas");
        panelVentas.add(et_ventas, java.awt.BorderLayout.NORTH);

        panelVentaInterior.setLayout(new java.awt.GridLayout(0, 2, 0, 5));

        et_efectivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_efectivo.setText("En efectivo");
        panelVentaInterior.add(et_efectivo);

        et_resultadoefectivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadoefectivo.setText("+ $0.00");
        panelVentaInterior.add(et_resultadoefectivo);

        et_tarjeta.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_tarjeta.setText("Con tarjeta de crédito");
        panelVentaInterior.add(et_tarjeta);

        et_resultadotarjeta.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadotarjeta.setText("+ $0.00");
        panelVentaInterior.add(et_resultadotarjeta);

        et_vales.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_vales.setText("Con vales de despensa");
        panelVentaInterior.add(et_vales);

        et_resultadovales.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadovales.setText("+ $0.00");
        panelVentaInterior.add(et_resultadovales);

        et_devoluciones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_devoluciones.setText("Devoluciones de ventas");
        panelVentaInterior.add(et_devoluciones);

        et_resultadodevoluciones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_resultadodevoluciones.setText("- $0.00");
        panelVentaInterior.add(et_resultadodevoluciones);

        et_resultadoventas.setText("TOTAL VENTAS ");
        panelVentaInterior.add(et_resultadoventas);

        et_totalventas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        et_totalventas.setText("$0.00");
        panelVentaInterior.add(et_totalventas);

        panelVentas.add(panelVentaInterior, java.awt.BorderLayout.CENTER);

        panelResultadosCorte.add(panelVentas);

        panelResultados.add(panelResultadosCorte, java.awt.BorderLayout.CENTER);

        panelCorte.add(panelResultados, java.awt.BorderLayout.CENTER);

        add(panelCorte, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cortecajero;
    private javax.swing.JButton bt_cortedia;
    private javax.swing.JLabel et_devolucionefectivo;
    private javax.swing.JLabel et_devoluciones;
    private javax.swing.JLabel et_dinerocaja;
    private javax.swing.JLabel et_efectivo;
    private javax.swing.JLabel et_fechacorte;
    private javax.swing.JLabel et_fondocaja;
    private javax.swing.JLabel et_ganancia;
    private javax.swing.JLabel et_personacorte;
    private javax.swing.JLabel et_resultadodevolucionefectivo;
    private javax.swing.JLabel et_resultadodevoluciones;
    private javax.swing.JLabel et_resultadodinerocaja;
    private javax.swing.JLabel et_resultadoefectivo;
    private javax.swing.JLabel et_resultadofondocaja;
    private javax.swing.JLabel et_resultadoganancia;
    private javax.swing.JLabel et_resultadotarjeta;
    private javax.swing.JLabel et_resultadovales;
    private javax.swing.JLabel et_resultadoventas;
    private javax.swing.JLabel et_resultadoventasefectivo;
    private javax.swing.JLabel et_resultadoventatotal;
    private javax.swing.JLabel et_tarjeta;
    private javax.swing.JLabel et_totaldinerocaja;
    private javax.swing.JLabel et_totalventas;
    private javax.swing.JLabel et_vales;
    private javax.swing.JLabel et_ventas;
    private javax.swing.JLabel et_ventasefectivo;
    private javax.swing.JLabel et_ventastotales;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCorte;
    private javax.swing.JPanel panelDineroCaja;
    private javax.swing.JPanel panelDineroCajaInterior;
    private javax.swing.JPanel panelGanancia;
    private javax.swing.JPanel panelGananciaInterior;
    private javax.swing.JPanel panelRegistraCorte;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JPanel panelResultadosCorte;
    private javax.swing.JPanel panelVentaInterior;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JPanel panelVentasInterior;
    private javax.swing.JPanel panelVentasTotales;
    // End of variables declaration//GEN-END:variables

    public JLabel geteFechaCorte() {
        return et_fechacorte;
    }

    public JLabel getePersonaCorte() {
        return et_personacorte;
    }

    public JLabel geteResultadoGanancia() {
        return et_resultadoganancia;
    }

    public void seteResultadoGanancia(JLabel eResultadoGanancia) {
        this.et_resultadoganancia = eResultadoGanancia;
    }

    public JLabel geteResultadosVentasTotales() {
        return et_resultadoventatotal;
    }

    public void seteResultadosVentasTotales(JLabel eResultadosVentasTotales) {
        this.et_resultadoventatotal = eResultadosVentasTotales;
    }

    public JLabel geteResultadoVentasEfectivo() {
        return et_resultadoventasefectivo;
    }

    public JLabel geteResultadoFondoCaja() {
        return et_resultadofondocaja;
    }

    public JLabel geteResultadoDevolucionesEfectivo() {
        return et_resultadodevolucionefectivo;
    }

    public JLabel geteTotalDineroCaja() {
        return et_totaldinerocaja;
    }

    public JLabel geteResultadoEfectivo() {
        return et_resultadoefectivo;
    }

    public JLabel geteResultadoTarjetaCredito() {
        return et_resultadotarjeta;
    }

    public JLabel geteResultadoValesDespensa() {
        return et_resultadovales;
    }

    public JLabel geteTotalVentas() {
        return et_totalventas;
    }

    public JLabel geteResultadoDevoluciones() {
        return et_resultadodevoluciones;
    }
}
