/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.sistema.reservas.dominio.modelo;

/** Value Object inmutable que identifica una habitación. */
public record NumeroHabitacion(String valor) {
    public NumeroHabitacion {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El número de habitación es obligatorio");
        }
        valor = valor.trim().toUpperCase();
    }
}
