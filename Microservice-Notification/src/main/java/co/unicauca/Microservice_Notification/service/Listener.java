package co.unicauca.Microservice_Notification.service;

import co.unicauca.Microservice_Notification.entity.AnteProyecto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Listener {

    private NotificationService notificationService;

    // Este método se ejecuta cada vez que llega un mensaje a la cola
    @RabbitListener(queues = "anteproyectoQueue")
    public void recibirMensaje(AnteProyecto anteproyecto) {
        notificationService.procesarNotificacion(anteproyecto);
    }
}
