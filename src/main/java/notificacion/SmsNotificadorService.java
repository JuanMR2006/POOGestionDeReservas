package notificacion;

import com.mycompany.sistema.reservas.dominio.modelo.Cliente;

public class SmsNotificadorService implements NotificadorService {
    @Override
    public void notificar(Cliente cliente, String mensaje) {
        System.out.println("[Mensaje texto enviado al cliente " + cliente.getNombre() + "]: " + mensaje);
    }
}
