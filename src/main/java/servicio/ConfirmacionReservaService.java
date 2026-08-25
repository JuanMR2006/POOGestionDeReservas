package servicio;

import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import notificacion.NotificadorService;
import politicas.PoliticaDescuento;
import repositorio.ReservaRepository;

public class ConfirmacionReservaService {
    private final ReservaRepository repository;
    private final NotificadorService notificador;
    
    public ConfirmacionReservaService(ReservaRepository repository, NotificadorService notificador) {
        if (repository == null || notificador == null) {
            throw new IllegalArgumentException("Las dependencias no pueden ser nulas");
        }
        this.repository = repository;
        this.notificador = notificador;
    }
    
    public double procesar(Reserva reserva, PoliticaDescuento politicaDescuento, double precioBase) {
        reserva.confirmar();
        double precioFinal = politicaDescuento.aplicarDescuento(precioBase);
        repository.guardar(reserva);
        notificador.notificar(
            reserva.getCliente(),
            "Su reserva ha sido confirmada. Monto final: $" + precioFinal
        );

        return precioFinal;
    }
}
