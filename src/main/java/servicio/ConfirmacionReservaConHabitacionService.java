/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import com.mycompany.sistema.reservas.dominio.modelo.ReservaConHabitacion;
import notificacion.NotificadorService;
import politicas.PoliticaDescuento;
import repositorio.ReservaRepository;

/** Caso de uso nuevo que depende solo de las abstracciones existentes. */
public class ConfirmacionReservaConHabitacionService {
    private final ReservaRepository repositorio;
    private final NotificadorService notificador;

    public ConfirmacionReservaConHabitacionService(
            ReservaRepository repositorio, NotificadorService notificador) {
        if (repositorio == null || notificador == null) {
            throw new IllegalArgumentException("Las dependencias son obligatorias");
        }
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public double procesar(ReservaConHabitacion reservaConHabitacion,
            PoliticaDescuento politicaDescuento, double precioBase) {
        if (reservaConHabitacion == null || politicaDescuento == null || precioBase < 0) {
            throw new IllegalArgumentException("Los datos para confirmar la reserva no son válidos");
        }
        reservaConHabitacion.confirmar();
        double precioFinal = politicaDescuento.aplicarDescuento(precioBase);
        repositorio.guardar(reservaConHabitacion.getReserva());
        notificador.notificar(reservaConHabitacion.getReserva().getCliente(),
                "Su reserva de habitación "
                + reservaConHabitacion.getHabitacion().getNumeroHabitacion().valor()
                + " ha sido confirmada. Monto final: $" + precioFinal);
        return precioFinal;
    }
}
