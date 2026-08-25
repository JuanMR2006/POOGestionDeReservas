package com.mycompany.sistema.reservas.dominio.modelo;
public class Habitacion {
    private final NumeroHabitacion numeroHabitacion;
    private final int capacidadMaxima;
    private EstadoHabitacion estado;

    public Habitacion(NumeroHabitacion numeroHabitacion, int capacidadMaxima) {
        if (numeroHabitacion == null) throw new IllegalArgumentException("El número de habitación es obligatorio");
        if (capacidadMaxima < 1) throw new IllegalArgumentException("La capacidad máxima debe ser mínimo de una persona");
        this.numeroHabitacion = numeroHabitacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return estado.equals(EstadoHabitacion.DISPONIBLE);
    }

    public void ocupar() {
        if (!estaDisponible()) {
            throw new IllegalStateException("Solo una habitación disponible puede ocuparse");
        }
        estado = EstadoHabitacion.OCUPADA;
    }

    public void liberar() {
        if (estado.equals(EstadoHabitacion.MANTENIMIENTO)) {
            throw new IllegalStateException("Una habitación en mantenimiento no puede liberarse");
        }
        estado = EstadoHabitacion.DISPONIBLE;
    }

    public void enviarAMantenimiento() {
        if (estado.equals(EstadoHabitacion.OCUPADA)) {
            throw new IllegalStateException("No se puede enviar a mantenimiento una habitación ocupada");
        }
        estado = EstadoHabitacion.MANTENIMIENTO;
    }

    public NumeroHabitacion getNumeroHabitacion() { return numeroHabitacion; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public EstadoHabitacion getEstado() { return estado; }
}
