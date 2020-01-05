package mt.com.ecabs.booking_manager.infrastructure.messaging;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer implements Producer {

    @Autowired
    private RabbitTemplate template;
    
    @Autowired
    private FanoutExchange fanoutexchange;
    
    @Override
    public void send(EventType eventType, String message) {
        this.template.convertAndSend(fanoutexchange.getName(), String.valueOf(eventType), message);
    }
    
}