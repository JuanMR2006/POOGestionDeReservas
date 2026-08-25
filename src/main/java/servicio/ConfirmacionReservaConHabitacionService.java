package servicio;

import com.mycompany.sistema.reservas.dominio.modelo.ReservaConHabitacion;
import notificacion.NotificadorService;
import politicas.PoliticaDescuento;
import repositorio.ReservaRepository;

public class ConfirmacionReservaConHabitacionService {
    private final ReservaRepository repositorio;
    private final NotificadorService notificador;

    public ConfirmacionReservaConHabitacionService(
            ReservaRepository repositorio, NotificadorService notificador) {
        if (repositorio == null || notificador == null) throw new IllegalArgumentException("Las dependencias son obligatorias");
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public double procesar(ReservaConHabitacion reservaConHabitacion,
            PoliticaDescuento politicaDescuento, double precioBase) {
        if (reservaConHabitacion == null || politicaDescuento == null || precioBase < 0) throw new IllegalArgumentException("Los datos para confirmar la reserva no son válidos");
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
