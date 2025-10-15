package co.unicauca.Microservice_Notification.service;

import co.unicauca.Microservice_Notification.entity.AnteProyecto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // o @Service, cualquiera sirve
public class Listener {

    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = "anteproyectoQueue") // reemplaza con el nombre real de tu cola
    public void recibirMensaje(AnteProyecto anteproyecto) {
        notificationService.procesarNotificacion(anteproyecto);
    }
}
