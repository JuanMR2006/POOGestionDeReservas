/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notificacion;

import com.mycompany.sistema.reservas.dominio.modelo.Cliente;

/** Simula una alerta enviada a la aplicación móvil del cliente. */
public class PushNotificadorService implements NotificadorService {
    @Override
    public void notificar(Cliente cliente, String mensaje) {
        System.out.println("[PUSH APP para " + cliente.getNombre() + "]: " + mensaje);
    }
}
