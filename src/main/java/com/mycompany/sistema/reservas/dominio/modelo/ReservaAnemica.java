package com.mycompany.sistema.reservas.dominio.modelo;

import java.time.LocalDateTime;

public class ReservaAnemica {
    private String id;
    private String cliente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado; // "PENDIENTE", "CONFIRMADA", "CANCELADA"
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
