package repositorio;

import com.mycompany.sistema.reservas.dominio.modelo.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daferarte
 */
public class ReservaMemoriaRepository implements ReservaRepository {
    private final List<Reserva> reservas = new ArrayList<>();

    @Override
    public void guardar(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("[Repositorio] Reserva " + reserva.getId() + " guardada en memoria. Total: " + reservas.size());
    }
}
