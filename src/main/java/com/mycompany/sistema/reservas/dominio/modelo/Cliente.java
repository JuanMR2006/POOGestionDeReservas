package com.mycompany.sistema.reservas.dominio.modelo;
import java.util.UUID;

public class Cliente {
    private final UUID id;
    private final String nombre;
    private Email email;
    private boolean activo;
    private int penalizaciones;
    
    public Cliente(String nombre, Email email) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        if (email == null) throw new IllegalArgumentException("El email del cliente es obligatorio");
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.email = email;
        this.activo = true;
        this.penalizaciones = 0;
    }
    
    public void registrarPenalizacion() {
        penalizaciones++;
        if (penalizaciones >= 3) activo = false;
    }
    
    public void reactivar() {
        activo = true;
        penalizaciones = 0;
    }
    
    public void actualizarEmail(Email nuevoEmail) {
        if (nuevoEmail == null) throw new IllegalArgumentException("El nuevo email no puede ser nulo");
        email = nuevoEmail;
    }

    public boolean puedeRealizarReservas() {
        return this.activo;
    }
    
    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public Email getEmail() { return email; }
    public boolean isActivo() { return activo; }
    public int getPenalizaciones() { return penalizaciones; }
}
