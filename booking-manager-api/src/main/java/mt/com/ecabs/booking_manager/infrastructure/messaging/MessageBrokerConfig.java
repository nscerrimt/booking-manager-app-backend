package mt.com.ecabs.booking_manager.infrastructure.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBrokerConfig {

    @Bean
    @Qualifier("bookingAddQueue")
    public Queue bookingAddQueue() {
        return new Queue("BookingAddQueue");
    }
    
    @Bean
    @Qualifier("bookingEditQueue")
    public Queue bookingEditQueue() {
        return new Queue("BookingEditQueue");
    }
    
    @Bean
    @Qualifier("bookingDeleteQueue")
    public Queue bookingDeleteQueue() {
        return new Queue("BookingDeleteQueue");
    }

    @Bean
    @Qualifier("messageAuditQueue")
    public Queue messageAuditQueue() {
        return new Queue("MessageAuditQueue");
    }
    
    @Bean
    public DirectExchange bookingExchange() {
        return new DirectExchange("BookingExchange");
    }

    @Bean
    public FanoutExchange messageExchange() {
        return new FanoutExchange("MessageExchange");
    }
  
    @Bean
    public Binding bindingMessageExchangeToBookingExchange(FanoutExchange messageExchange,
            DirectExchange bookingExchange) {
        return BindingBuilder.bind(bookingExchange).to(messageExchange);
    }
    
    @Bean
    public Binding bindingBookingExchangeToBookingAddQueue(DirectExchange bookingExchange,
            Queue bookingAddQueue) {
        return BindingBuilder.bind(bookingAddQueue).to(bookingExchange).with(EventType.ADD);
    }

    @Bean
    public Binding bindingBookingExchangeToBookingEditQueue(DirectExchange bookingExchange,
            Queue bookingEditQueue) {
        return BindingBuilder.bind(bookingEditQueue).to(bookingExchange).with(EventType.EDIT);
    }   
    
    @Bean
    public Binding bindingBookingExchangeToBookingDeleteQueue(DirectExchange bookingExchange,
            Queue bookingDeleteQueue) {
        return BindingBuilder.bind(bookingDeleteQueue).to(bookingExchange).with(EventType.DELETE);
    }
    
    @Bean
    public Binding bindingMessageExchangeToMessageAuditDeleteQueue(FanoutExchange messageExchange,
            Queue messageAuditQueue) {
        return BindingBuilder.bind(messageAuditQueue).to(messageExchange);
    }
}