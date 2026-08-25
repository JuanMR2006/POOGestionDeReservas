package servicio;
import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesadorReservasService {
    
    public void procesarConfirmacion(Reserva reserva, String tipoCliente, String canalNotificacion) {
        double precioBase = 100.0;
        double precioFinal = precioBase;

        if (tipoCliente.equals("VIP")) {
            precioFinal = precioBase * 0.80; // 20% descuento
        } else if (tipoCliente.equals("CORPORATIVO")) {
            precioFinal = precioBase * 0.70; // 30% descuento
        } else if (tipoCliente.equals("REGULAR")) {
            precioFinal = precioBase;
        }

        System.out.println("Precio calculado: " + precioFinal);

        reserva.confirmar();
        try (FileWriter writer = new FileWriter("reservas.txt", true)) {
            writer.write("Reserva ID: " + reserva.getId() + " - Cliente: " + reserva.getCliente().getNombre() + "\n");
        } catch (IOException e) {
            System.err.println("Error guardando en disco: " + e.getMessage());
        }

        if (canalNotificacion.equalsIgnoreCase("EMAIL")) {
            System.out.println("Enviando Email a: " + reserva.getCliente().getEmail().valor());
        } else if (canalNotificacion.equalsIgnoreCase("SMS")) {
            System.out.println("Enviando SMS al número del cliente...");
        }
    }    
}
