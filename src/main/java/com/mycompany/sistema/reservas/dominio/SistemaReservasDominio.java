package com.mycompany.sistema.reservas.dominio;

import com.mycompany.sistema.reservas.dominio.modelo.Cliente;
import com.mycompany.sistema.reservas.dominio.modelo.Email;
import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import com.mycompany.sistema.reservas.dominio.modelo.RangoFechas;
import java.time.LocalDateTime;
public class SistemaReservasDominio {

    public static void main(String[] args) {
        try {
            
            Email email = new Email("juan.perez@empresa.com");
            Cliente cliente = new Cliente("Juan Pérez", email);
            System.out.println("Cliente creado: " + cliente.getNombre() + " (Activo: " + cliente.isActivo() + ")");
            
            LocalDateTime inicio = LocalDateTime.now().plusDays(1);
            LocalDateTime fin = LocalDateTime.now().plusDays(3);
            RangoFechas periodo = new RangoFechas(inicio, fin);

            Reserva reserva = new Reserva(cliente, periodo);
            System.out.println("Reserva creada con ID: " + reserva.getId() + " - Estado: " + reserva.getEstado());

            reserva.confirmar();
            System.out.println("Estado tras confirmar: " + reserva.getEstado());

            reserva.cancelar();
            System.out.println("Estado tras cancelar: " + reserva.getEstado());

            reserva.confirmar(); 

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
