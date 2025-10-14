package co.unicauca.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String ANTEPROYECTO_QUEUE = "anteproyectoQueue";

    @Bean
    public Queue pruebaQueue() {
        return new Queue(ANTEPROYECTO_QUEUE, true);
    }
    /*
        @Bean
        public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
            return new RabbitTemplate(connectionFactory);
        }
        */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
