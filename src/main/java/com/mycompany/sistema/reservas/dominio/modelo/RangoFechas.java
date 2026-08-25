package com.mycompany.sistema.reservas.dominio.modelo;

import java.time.LocalDateTime;

public record RangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    public RangoFechas {
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }
    }

    public boolean incluye(LocalDateTime fecha) {
        return !fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin);
    }
}
