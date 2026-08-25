package com.mycompany.sistema.reservas.dominio;

import com.mycompany.sistema.reservas.dominio.modelo.Cliente;
import com.mycompany.sistema.reservas.dominio.modelo.Email;
import com.mycompany.sistema.reservas.dominio.modelo.Habitacion;
import com.mycompany.sistema.reservas.dominio.modelo.NumeroHabitacion;
import com.mycompany.sistema.reservas.dominio.modelo.RangoFechas;
import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import com.mycompany.sistema.reservas.dominio.modelo.ReservaConHabitacion;
import java.time.LocalDateTime;
import notificacion.WhatsAppNotificadorService;
import politicas.DescuentoEstadiaLarga;
import repositorio.ReservaArchivoRepository;
import servicio.ConfirmacionReservaConHabitacionService;

public class DemoExtensionDominioRico {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana Gómez", new Email("ana@correo.com"));
        RangoFechas periodo = new RangoFechas(
                LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(10));
        Reserva reservaOriginal = new Reserva(cliente, periodo);
        Habitacion habitacion = new Habitacion(new NumeroHabitacion("305"), 2);
        ReservaConHabitacion reserva = new ReservaConHabitacion(reservaOriginal, habitacion);

        ConfirmacionReservaConHabitacionService servicio
                = new ConfirmacionReservaConHabitacionService(
                        new ReservaArchivoRepository("reservas-confirmadas.txt"),
                        new WhatsAppNotificadorService());

        double total = servicio.procesar(reserva, new DescuentoEstadiaLarga(periodo), 300.0);
        System.out.println("Proceso finalizado. Total pagado: $" + total);
    }
}
