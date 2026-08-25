package com.mycompany.sistema.reservas.dominio.modelo;

import java.util.UUID;

public class Reserva {
    private final UUID id;
    private final Cliente cliente;
    private final RangoFechas periodo;
    private EstadoReserva estado;
    
    public Reserva(Cliente cliente, RangoFechas periodo) {
        if (cliente == null) throw new IllegalArgumentException("El cliente es obligatorio");
        if (!cliente.puedeRealizarReservas()) {
            throw new IllegalStateException("El cliente '" + cliente.getNombre() + "' no está habilitado para realizar reservas");
        }
        if (periodo == null) throw new IllegalArgumentException("El periodo de la reserva es obligatorio");

        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.periodo = periodo;
        this.estado = EstadoReserva.PENDIENTE;
    }
    
    public void confirmar() {
        if (estado == EstadoReserva.CANCELADA) {
            throw new IllegalStateException("No se puede confirmar una reserva que ha sido cancelada");
        }
        estado = EstadoReserva.CONFIRMADA;
    }
    
    public void cancelar() {
        estado = EstadoReserva.CANCELADA;
    }
    
    public UUID getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public RangoFechas getPeriodo() { return periodo; }
    public EstadoReserva getEstado() { return estado; }
}
