package notificacion;

import com.mycompany.sistema.reservas.dominio.modelo.Cliente;

public interface NotificadorService {
    void notificar(Cliente cliente, String mensaje);
}
