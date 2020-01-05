package mt.com.ecabs.booking_manager.application.messaging.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageAuditConsumer implements Consumer {
			
	@Override
	@RabbitListener(queues = "MessageAuditQueue")
    public void receive(String message) throws InterruptedException {
    	System.out.println("MESSAGE AUDIT QUEUE:");
		System.out.println(message);
    }
    
}