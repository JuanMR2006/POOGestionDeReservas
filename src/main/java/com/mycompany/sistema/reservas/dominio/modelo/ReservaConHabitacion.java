/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.reservas.dominio.modelo;

/**
 * Extensión de dominio que asocia una reserva existente con una habitación,
 * sin modificar la clase Reserva original.
 */
public class ReservaConHabitacion {
    private final Reserva reserva;
    private final Habitacion habitacion;

    public ReservaConHabitacion(Reserva reserva, Habitacion habitacion) {
        if (reserva == null || habitacion == null) {
            throw new IllegalArgumentException("La reserva y la habitación son obligatorias");
        }
        if (!habitacion.estaDisponible()) {
            throw new IllegalStateException("La habitación no está disponible");
        }
        this.reserva = reserva;
        this.habitacion = habitacion;
    }

    public void confirmar() {
        reserva.confirmar();
        habitacion.ocupar();
    }

    public void cancelar() {
        reserva.cancelar();
        habitacion.liberar();
    }

    public Reserva getReserva() { return reserva; }
    public Habitacion getHabitacion() { return habitacion; }
}
