package co.unicauca.Microservice_Notification.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // El nombre de la cola debe coincidir con el del microservicio Submission
    public static final String ANTEPROYECTO_QUEUE = "anteproyectoQueue";

    // Declara la cola para que Spring pueda escucharla
    @Bean
    public Queue anteproyectoQueue() {
        return new Queue(ANTEPROYECTO_QUEUE, true);
    }

    // Convierte automáticamente los mensajes JSON a objetos Java (y viceversa)
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
