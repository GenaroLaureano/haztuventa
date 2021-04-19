package paq_controladores.corte;

import paq_modelos.db.*;
import java.awt.event.*;
import javax.swing.JButton;
import paq_vistas.corte.PanelCorte;

public class OyenteCorte implements ActionListener {

    private final PanelCorte panelCorte;
    private final ModSQLUsuario sqlUsuario;
    private final ModSQLCorte sqlCorte;

    public OyenteCorte(PanelCorte panelCorte, ModSQLUsuario sqlUsuario, ModSQLCorte sqlCorte) {
        this.panelCorte = panelCorte;
        this.sqlUsuario = sqlUsuario;
        this.sqlCorte = sqlCorte;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt_origen = (JButton) e.getSource();
        switch (bt_origen.getName()) {
            case "cajero":
                String st_horaEntrada = ModSQLogin.getHoraEntrada();
                String st_horaSalida = sqlUsuario.obtenerFecha();
                String st_nombreUsuario = sqlUsuario.nombreUusario(ModSQLogin.getIdUsuario());
                panelCorte.getePersonaCorte().setText("Corte de Turno de " + st_nombreUsuario);
                panelCorte.geteFechaCorte().setText("Del día y la hora " + st_horaEntrada + " al día y la hora" + st_horaSalida);
                float totalVentas = sqlCorte.ventas(st_horaEntrada, st_horaSalida);
                String st_ventatotal = String.valueOf(totalVentas);
                panelCorte.geteResultadosVentasTotales().setText("$" + st_ventatotal);
                float totalGanancias = sqlCorte.utilidad(st_horaEntrada, st_horaSalida);
                String st_ganancia = String.valueOf(totalGanancias);
                panelCorte.geteResultadoGanancia().setText("$ " + st_ganancia);
                float fondoCaja = ModSQLogin.getFondoCaja();
                panelCorte.geteResultadoFondoCaja().setText("$ " + fondoCaja);
                float ventasEfectivo = sqlCorte.ventasEfectivo(st_horaEntrada, st_horaSalida);
                String st_ventaefectivo = String.valueOf(ventasEfectivo);
                panelCorte.geteResultadoVentasEfectivo().setText("+$ " + st_ventaefectivo);
                panelCorte.geteResultadoEfectivo().setText("$ " + ventasEfectivo);
                float devoluciones = sqlCorte.ventasCanceladas(st_horaEntrada, st_horaSalida);
                panelCorte.geteResultadoDevolucionesEfectivo().setText("-$ " + devoluciones);
                panelCorte.geteResultadoDevoluciones().setText("-$ " + devoluciones);
                float total = ventasEfectivo + fondoCaja - devoluciones;
                panelCorte.geteTotalDineroCaja().setText("$ " + total);
                float ventasTarjeta = sqlCorte.ventasTarjeta(st_horaEntrada, st_horaSalida);
                panelCorte.geteResultadoTarjetaCredito().setText("$ " + ventasTarjeta);
                float ventasVales = sqlCorte.ventasVales(st_horaEntrada, st_horaSalida);
                panelCorte.geteResultadoValesDespensa().setText("$ " + ventasVales);
                float totalV = ventasEfectivo + ventasTarjeta + ventasVales - devoluciones;
                panelCorte.geteTotalVentas().setText("$ " + totalV);
                break;
            case "dia":
                String st_horaEntrada2 = ModSQLogin.getHoraEntrada();
                String st_horaSalida2 = sqlUsuario.obtenerFecha();
                String st_nombreUsuario2 = sqlUsuario.nombreUusario(ModSQLogin.getIdUsuario());
                panelCorte.getePersonaCorte().setText("Corte de Turno del día y la hora " + st_horaEntrada2);
                panelCorte.geteFechaCorte().setText("");
                float totalVentas2 = sqlCorte.ventas(st_horaEntrada2, st_horaSalida2);
                String st_ventatotal2 = String.valueOf(totalVentas2);
                panelCorte.geteResultadosVentasTotales().setText("$" + st_ventatotal2);
                float totalGanancias2 = sqlCorte.utilidad(st_horaEntrada2, st_horaSalida2);
                String st_ganancia2 = String.valueOf(totalGanancias2);
                panelCorte.geteResultadoGanancia().setText("$ " + st_ganancia2);
                float fondoCaja2 = ModSQLogin.getFondoCaja();
                panelCorte.geteResultadoFondoCaja().setText("$ " + fondoCaja2);
                float ventasEfectivo2 = sqlCorte.ventasEfectivo(st_horaEntrada2, st_horaSalida2);
                String st_ventaefectivo2 = String.valueOf(ventasEfectivo2);
                panelCorte.geteResultadoVentasEfectivo().setText("+$ " + st_ventaefectivo2);
                panelCorte.geteResultadoEfectivo().setText("$ " + ventasEfectivo2);
                float devoluciones2 = sqlCorte.ventasCanceladas(st_horaEntrada2, st_horaSalida2);
                panelCorte.geteResultadoDevolucionesEfectivo().setText("-$ " + devoluciones2);
                panelCorte.geteResultadoDevoluciones().setText("-$ " + devoluciones2);
                float total2 = ventasEfectivo2 + fondoCaja2 - devoluciones2;
                panelCorte.geteTotalDineroCaja().setText("$ " + total2);
                float ventasTarjeta2 = sqlCorte.ventasTarjeta(st_horaEntrada2, st_horaSalida2);
                panelCorte.geteResultadoTarjetaCredito().setText("$ " + ventasTarjeta2);
                float ventasVales2 = sqlCorte.ventasVales(st_horaEntrada2, st_horaSalida2);
                panelCorte.geteResultadoValesDespensa().setText("$ " + ventasVales2);
                float totalV2 = ventasEfectivo2 + ventasTarjeta2 + ventasVales2 - devoluciones2;
                panelCorte.geteTotalVentas().setText("$ " + totalV2);
                break;

        }
    }
}
