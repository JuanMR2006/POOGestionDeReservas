package com.mycompany.sistema.reservas.dominio.modelo;
import java.util.regex.Pattern;

public record Email(String valor) {
    private static final Pattern PATRON_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    
    public Email {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!PATRON_EMAIL.matcher(valor).matches()) {
            throw new IllegalArgumentException("El formato del email no es válido: " + valor);
        }
    }
}
