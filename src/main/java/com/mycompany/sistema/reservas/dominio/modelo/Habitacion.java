/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.reservas.dominio.modelo;

/** Entidad que protege las transiciones de estado de una habitación. */
public class Habitacion {
    private final NumeroHabitacion numeroHabitacion;
    private final int capacidadMaxima;
    private EstadoHabitacion estado;

    public Habitacion(NumeroHabitacion numeroHabitacion, int capacidadMaxima) {
        if (numeroHabitacion == null) {
            throw new IllegalArgumentException("El número de habitación es obligatorio");
        }
        if (capacidadMaxima < 1) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mínimo de una persona");
        }
        this.numeroHabitacion = numeroHabitacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return estado == EstadoHabitacion.DISPONIBLE;
    }

    public void ocupar() {
        if (!estaDisponible()) {
            throw new IllegalStateException("Solo una habitación disponible puede ocuparse");
        }
        estado = EstadoHabitacion.OCUPADA;
    }

    public void liberar() {
        if (estado == EstadoHabitacion.MANTENIMIENTO) {
            throw new IllegalStateException("Una habitación en mantenimiento no puede liberarse");
        }
        estado = EstadoHabitacion.DISPONIBLE;
    }

    public void enviarAMantenimiento() {
        if (estado == EstadoHabitacion.OCUPADA) {
            throw new IllegalStateException("No se puede enviar a mantenimiento una habitación ocupada");
        }
        estado = EstadoHabitacion.MANTENIMIENTO;
    }

    public NumeroHabitacion getNumeroHabitacion() { return numeroHabitacion; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public EstadoHabitacion getEstado() { return estado; }
}
