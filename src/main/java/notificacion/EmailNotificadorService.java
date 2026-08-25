package notificacion;

import com.mycompany.sistema.reservas.dominio.modelo.Cliente;

public class EmailNotificadorService implements NotificadorService {
    @Override
    public void notificar(Cliente cliente, String mensaje) {
        System.out.println("[Correo enviado a " + cliente.getEmail().valor() + "]: " + mensaje);
    }
}
