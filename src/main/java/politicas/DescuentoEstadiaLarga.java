/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package politicas;

import com.mycompany.sistema.reservas.dominio.modelo.RangoFechas;
import java.time.temporal.ChronoUnit;

/** Política OCP: descuento de 25 % si la estadía supera siete días. */
public class DescuentoEstadiaLarga implements PoliticaDescuento {
    private final RangoFechas periodo;

    public DescuentoEstadiaLarga(RangoFechas periodo) {
        if (periodo == null) {
            throw new IllegalArgumentException("El período de la reserva es obligatorio");
        }
        this.periodo = periodo;
    }

    @Override
    public double aplicarDescuento(double montoBase) {
        long dias = ChronoUnit.DAYS.between(
                periodo.fechaInicio().toLocalDate(), periodo.fechaFin().toLocalDate());
        return dias > 7 ? montoBase * 0.75 : montoBase;
    }
}
