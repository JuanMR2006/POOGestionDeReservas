package com.mycompany.sistema.reservas.dominio.modelo;
public record NumeroHabitacion(String valor) {
    public NumeroHabitacion {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El número de habitación es obligatorio");
        }
        valor = valor.trim().toUpperCase();
    }
}
