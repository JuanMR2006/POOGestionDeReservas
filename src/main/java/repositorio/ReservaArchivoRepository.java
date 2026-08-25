/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/** Persistencia alternativa que registra una confirmación por línea de texto. */
public class ReservaArchivoRepository implements ReservaRepository {
    private final Path archivo;

    public ReservaArchivoRepository(String rutaArchivo) {
        if (rutaArchivo == null || rutaArchivo.isBlank()) {
            throw new IllegalArgumentException("La ruta del archivo es obligatoria");
        }
        this.archivo = Path.of(rutaArchivo);
    }

    @Override
    public void guardar(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva es obligatoria");
        }
        String linea = "Reserva ID: " + reserva.getId()
                + " | Cliente: " + reserva.getCliente().getNombre()
                + " | Periodo: " + reserva.getPeriodo().fechaInicio()
                + " - " + reserva.getPeriodo().fechaFin()
                + System.lineSeparator();
        try {
            Path directorio = archivo.toAbsolutePath().getParent();
            if (directorio != null) {
                Files.createDirectories(directorio);
            }
            Files.writeString(archivo, linea, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            throw new IllegalStateException("No fue posible registrar la reserva en el archivo", ex);
        }
    }
}
