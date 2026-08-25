package repositorio;

import com.mycompany.sistema.reservas.dominio.modelo.Reserva;

public interface ReservaRepository {
    void guardar(Reserva reserva);
}
